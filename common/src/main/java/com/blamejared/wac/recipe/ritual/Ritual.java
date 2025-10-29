package com.blamejared.wac.recipe.ritual;

import com.blamejared.wac.platform.Services;
import com.blamejared.wac.recipe.WACRecipes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record Ritual(NonNullList<Ingredient> ingredients,
                     MobEffectInstance output,
                     int requiredEnchantingPower)
        implements Recipe<RitualRecipeInput> {
    
    @Override
    public boolean matches(RitualRecipeInput input, Level level) {
        
        if(input.enchantingPower() < requiredEnchantingPower) {
            return false;
        }
        final NonNullList<ItemStack> containerItems = NonNullList.create();
        int itemCount = 0;
        
        for(int i = 0; i < input.size(); ++i) {
            
            final ItemStack itemStack = input.getItem(i);
            
            if(!itemStack.isEmpty()) {
                
                itemCount++;
                containerItems.add(itemStack);
            }
            
        }
        
        if(itemCount == this.ingredients.size()) {
            
            return Services.PLATFORM.findMatches(containerItems, this.getIngredients());
        }
        return false;
    }
    
    @Override
    public ItemStack assemble(RitualRecipeInput input, HolderLookup.Provider registries) {
        
        return ItemStack.EMPTY;
    }
    
    @Override
    public boolean canCraftInDimensions(int width, int height) {
        
        return true;
    }
    
    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        
        return ItemStack.EMPTY;
    }
    
    @Override
    public RecipeSerializer<?> getSerializer() {
        
        return WACRecipes.RITUAL_SERIALIZER.get();
    }
    
    @Override
    public RecipeType<?> getType() {
        
        return WACRecipes.RITUAL_TYPE.get();
    }
    
    @Override
    public NonNullList<Ingredient> getIngredients() {
        
        return this.ingredients();
    }
    
    public static class Serializer implements RecipeSerializer<Ritual> {
        
        public static final MapCodec<Ritual> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").flatXmap(
                        list -> {
                            Ingredient[] array = list.toArray(Ingredient[]::new);
                            if(array.length == 0) {
                                return DataResult.error(() -> "No ingredients for ritual");
                            } else {
                                return array.length > 9
                                        ? DataResult.error(() -> "Too many ingredients for ritual recipe. The maximum is: %s".formatted(9))
                                        : DataResult.success(NonNullList.of(Ingredient.EMPTY, array));
                            }
                        },
                        DataResult::success
                ).forGetter(Recipe::getIngredients),
                MobEffectInstance.CODEC.fieldOf("output").forGetter(Ritual::output),
                Codec.INT.fieldOf("enchanting_power").forGetter(Ritual::requiredEnchantingPower)
        ).apply(instance, Ritual::new));
        
        public static final StreamCodec<RegistryFriendlyByteBuf, Ritual> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);
        
        @Override
        public MapCodec<Ritual> codec() {
            
            return CODEC;
        }
        
        @Override
        public StreamCodec<RegistryFriendlyByteBuf, Ritual> streamCodec() {
            
            return STREAM_CODEC;
        }
        
        private static Ritual fromNetwork(RegistryFriendlyByteBuf buf) {
            
            int size = buf.readVarInt();
            NonNullList<Ingredient> nonnulllist = NonNullList.withSize(size, Ingredient.EMPTY);
            nonnulllist.replaceAll(p_319735_ -> Ingredient.CONTENTS_STREAM_CODEC.decode(buf));
            MobEffectInstance output = MobEffectInstance.STREAM_CODEC.decode(buf);
            int enchantingPower = buf.readVarInt();
            return new Ritual(nonnulllist, output, enchantingPower);
        }
        
        private static void toNetwork(RegistryFriendlyByteBuf buf, Ritual ritual) {
            
            buf.writeVarInt(ritual.ingredients.size());
            for(Ingredient ingredient : ritual.ingredients) {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buf, ingredient);
            }
            MobEffectInstance.STREAM_CODEC.encode(buf, ritual.output);
            buf.writeVarInt(ritual.requiredEnchantingPower);
        }
        
    }
    
}

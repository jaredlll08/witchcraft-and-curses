package com.blamejared.wac.data;

import com.blamejared.wac.WAC;
import com.blamejared.wac.item.WACItems;
import com.blamejared.wac.recipe.ritual.RitualBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class WACRecipesProvider extends RecipeProvider {
    
    public WACRecipesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        
        super(output, provider);
    }
    
    @Override
    protected void buildRecipes(RecipeOutput output) {
        
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, WACItems.DEEPSLATE_BASIN.get())
                .define('D', Tags.Items.COBBLESTONES_DEEPSLATE)
                .pattern("D D")
                .pattern("D D")
                .pattern("DDD")
                .unlockedBy("has_deepslate", has(Items.COBBLED_DEEPSLATE))
                .save(output, WAC.rl("deepslate_basin"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, WACItems.MOSSY_PODIUM.get())
                .define('P', Items.POLISHED_DEEPSLATE_SLAB)
                .define('S', ItemTags.STONE_BRICKS)
                .define('D', Tags.Items.COBBLESTONES_DEEPSLATE)
                .pattern("PPP")
                .pattern(" S ")
                .pattern("DDD")
                .unlockedBy("has_deepslate", has(Items.POLISHED_DEEPSLATE_SLAB))
                .save(output, WAC.rl("mossy_podium"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, WACItems.WILTED_WOOD.get(), 3)
                .define('L', WACItems.WILTED_LOG.get())
                .pattern("LL")
                .pattern("LL")
                .unlockedBy("has_log", has(WACItems.WILTED_LOG.get()))
                .save(output, WAC.rl("wilted_wood"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, WACItems.STRIPPED_WILTED_WOOD.get(), 3)
                .define('L', WACItems.STRIPPED_WILTED_LOG.get())
                .pattern("LL")
                .pattern("LL")
                .unlockedBy("has_log", has(WACItems.STRIPPED_WILTED_LOG.get()))
                .save(output, WAC.rl("stripped_wilted_wood"));
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, WACItems.WILTED_PLANKS.get(), 4)
                .requires(WACItems.WILTED_LOG.get())
                .unlockedBy("has_log", has(WACItems.STRIPPED_WILTED_LOG.get()))
                .save(output, WAC.rl("wilted_planks"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, WACItems.WILTED_STAIRS.get(), 4)
                .define('L', WACItems.WILTED_PLANKS.get())
                .pattern("L  ")
                .pattern("LL ")
                .pattern("LLL")
                .unlockedBy("has_planks", has(WACItems.WILTED_PLANKS.get()))
                .save(output, WAC.rl("wilted_stairs"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, WACItems.WILTED_SLAB.get(), 6)
                .define('L', WACItems.WILTED_PLANKS.get())
                .pattern("LLL")
                .unlockedBy("has_planks", has(WACItems.WILTED_PLANKS.get()))
                .save(output, WAC.rl("wilted_slab"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, WACItems.WILTED_FENCE.get(), 3)
                .define('L', WACItems.WILTED_PLANKS.get())
                .define('S', Items.STICK)
                .pattern("LSL")
                .pattern("LSL")
                .unlockedBy("has_planks", has(WACItems.WILTED_PLANKS.get()))
                .save(output, WAC.rl("wilted_fence"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, WACItems.WILTED_FENCE_GATE.get(), 1)
                .define('L', WACItems.WILTED_PLANKS.get())
                .define('S', Items.STICK)
                .pattern("SLS")
                .pattern("SLS")
                .unlockedBy("has_planks", has(WACItems.WILTED_PLANKS.get()))
                .save(output, WAC.rl("wilted_gate"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, WACItems.WILTED_DOOR.get(), 3)
                .define('L', WACItems.WILTED_PLANKS.get())
                .pattern("LL")
                .pattern("LL")
                .pattern("LL")
                .unlockedBy("has_planks", has(WACItems.WILTED_PLANKS.get()))
                .save(output, WAC.rl("wilted_door"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, WACItems.WILTED_TRAPDOOR.get(), 2)
                .define('L', WACItems.WILTED_PLANKS.get())
                .pattern("LLL")
                .pattern("LLL")
                .unlockedBy("has_planks", has(WACItems.WILTED_PLANKS.get()))
                .save(output, WAC.rl("wilted_trapdoor"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, WACItems.WILTED_PRESSURE_PLATE.get(), 1)
                .define('L', WACItems.WILTED_PLANKS.get())
                .pattern("LL")
                .unlockedBy("has_planks", has(WACItems.WILTED_PLANKS.get()))
                .save(output, WAC.rl("wilted_pressure_plate"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, WACItems.WILTED_BUTTON.get(), 1)
                .define('L', WACItems.WILTED_PLANKS.get())
                .pattern("L")
                .unlockedBy("has_planks", has(WACItems.WILTED_PLANKS.get()))
                .save(output, WAC.rl("wilted_button"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, WACItems.WILTED_SIGN.get(), 3)
                .define('L', WACItems.WILTED_PLANKS.get())
                .define('S', Items.STICK)
                .pattern("LLL")
                .pattern("LLL")
                .pattern(" S ")
                .unlockedBy("has_planks", has(WACItems.WILTED_PLANKS.get()))
                .save(output, WAC.rl("wilted_sign"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, WACItems.WILTED_HANGING_SIGN.get(), 6)
                .define('L', WACItems.STRIPPED_WILTED_LOG.get())
                .define('C', Items.CHAIN)
                .pattern("C C")
                .pattern("LLL")
                .pattern("LLL")
                .unlockedBy("has_planks", has(WACItems.STRIPPED_WILTED_LOG.get()))
                .save(output, WAC.rl("wilted_hanging_sign"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, WACItems.WILTED_BOOKSHELF.get(), 1)
                .define('S', WACItems.WILTED_SLAB.get())
                .define('B', Items.BOOKSHELF)
                .pattern("S")
                .pattern("B")
                .pattern("S")
                .unlockedBy("has_slab", has(WACItems.WILTED_SLAB.get()))
                .save(output, WAC.rl("wilted_bookshelf"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, WACItems.WILTED_BOAT.get(), 1)
                .define('L', WACItems.WILTED_PLANKS.get())
                .pattern("L L")
                .pattern("LLL")
                .unlockedBy("has_planks", has(WACItems.WILTED_PLANKS.get()))
                .save(output, WAC.rl("wilted_boat"));
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, WACItems.WILTED_CHEST_BOAT.get(), 1)
                .requires(WACItems.WILTED_BOAT.get())
                .requires(Items.CHEST)
                .unlockedBy("has_boat", has(WACItems.WILTED_BOAT.get()))
                .save(output, WAC.rl("wilted_chest_boat"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, WACItems.WILTED_SHELF.get(), 1)
                .define('W', WACItems.WILTED_SLAB.get())
                .define('S', Items.STICK)
                .define('F', Items.FERN)
                .pattern("SWS")
                .pattern("SFS")
                .pattern("SWS")
                .unlockedBy("has_slab", has(WACItems.WILTED_SLAB.get()))
                .save(output, WAC.rl("wilted_shelf"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, WACItems.BOOK_STACK.get(), 3)
                .define('B', Items.BOOK)
                .pattern("B")
                .pattern("B")
                .pattern("B")
                .unlockedBy("has_book", has(Items.BOOK))
                .save(output, WAC.rl("book_stack"));
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, WACItems.WITCHY_DECOR.get(), 1)
                .requires(Items.SKELETON_SKULL)
                .requires(Items.BOOK)
                .requires(Items.CANDLE)
                .requires(Items.CANDLE)
                .requires(Items.CANDLE)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_skull", has(Items.SKELETON_SKULL))
                .save(output, WAC.rl("witchy_decor"));
        
        potionRitual(output, MobEffects.WIND_CHARGED, Items.BREEZE_ROD);
        potionRitual(output, MobEffects.OOZING, Items.SLIME_BLOCK);
        potionRitual(output, MobEffects.INFESTED, Items.STONE);
        potionRitual(output, MobEffects.WEAVING, Items.COBWEB);
        potionRitual(output, MobEffects.NIGHT_VISION, Items.GOLDEN_CARROT);
        inversePotionRitual(output, MobEffects.INVISIBILITY, Items.GOLDEN_CARROT);
        potionRitual(output, MobEffects.FIRE_RESISTANCE, Items.MAGMA_CREAM);
        potionRitual(output, MobEffects.JUMP, Items.RABBIT_FOOT);
        strongPotionRitual(output, MobEffects.JUMP, Items.RABBIT_FOOT);
        inversePotionRitual(output, MobEffects.MOVEMENT_SLOWDOWN, Items.RABBIT_FOOT);
        inverseStrongPotionRitual(output, MobEffects.MOVEMENT_SLOWDOWN, Items.RABBIT_FOOT);
        potionRitual(output, MobEffects.MOVEMENT_SPEED, Items.SUGAR);
        potionRitual(output, MobEffects.WATER_BREATHING, Items.PUFFERFISH);
        potionRitual(output, MobEffects.POISON, Items.SPIDER_EYE);
        strongPotionRitual(output, MobEffects.POISON, Items.SPIDER_EYE);
        potionRitual(output, MobEffects.REGENERATION, Items.GHAST_TEAR);
        strongPotionRitual(output, MobEffects.REGENERATION, Items.GHAST_TEAR);
        potionRitual(output, MobEffects.DAMAGE_BOOST, Items.BLAZE_POWDER);
        strongPotionRitual(output, MobEffects.DAMAGE_BOOST, Items.BLAZE_POWDER);
        potionRitual(output, MobEffects.WEAKNESS, Items.FERMENTED_SPIDER_EYE);
        potionRitual(output, MobEffects.SLOW_FALLING, Items.PHANTOM_MEMBRANE);
        // builder.potionMixes.stream().map(potionMix -> "potionRitual(output, MobEffects.%s, Items.%s);".formatted(potionMix.to.getKey().location().getPath(), "")).collect(Collectors.joining("\n"))
    }
    
    private void potionRitual(RecipeOutput output, Holder<MobEffect> effect, Item ingredient) {
        
        RitualBuilder.ritual(new MobEffectInstance(effect, 9 * 60 * 20, 0), 15)
                .requires(Items.NETHER_WART)
                .requires(ingredient)
                .requires(ingredient)
                .requires(ingredient)
                .unlockedBy("has_items", has(ingredient))
                .save(output, WAC.rl(effect.getKey().location().getPath()).withPrefix("ritual/"));
    }
    
    private void inversePotionRitual(RecipeOutput output, Holder<MobEffect> effect, Item ingredient) {
        
        RitualBuilder.ritual(new MobEffectInstance(effect, 9 * 60 * 20, 0), 15)
                .requires(Items.NETHER_WART)
                .requires(ingredient)
                .requires(ingredient)
                .requires(ingredient)
                .requires(Items.FERMENTED_SPIDER_EYE)
                .unlockedBy("has_items", has(ingredient))
                .save(output, WAC.rl(effect.getKey().location().getPath()).withPrefix("ritual/"));
    }
    
    private void strongPotionRitual(RecipeOutput output, Holder<MobEffect> effect, Item ingredient) {
        
        RitualBuilder.ritual(new MobEffectInstance(effect, 5400, 0), 15)
                .requires(Items.NETHER_WART)
                .requires(ingredient)
                .requires(ingredient)
                .requires(ingredient)
                .requires(Items.GLOWSTONE_DUST)
                .unlockedBy("has_items", has(ingredient))
                .save(output, WAC.rl(effect.getKey().location().getPath()).withPrefix("ritual/strong_"));
    }
    
    private void inverseStrongPotionRitual(RecipeOutput output, Holder<MobEffect> effect, Item ingredient) {
        
        RitualBuilder.ritual(new MobEffectInstance(effect, 5400, 0), 15)
                .requires(Items.NETHER_WART)
                .requires(ingredient)
                .requires(ingredient)
                .requires(ingredient)
                .requires(Items.GLOWSTONE_DUST)
                .requires(Items.FERMENTED_SPIDER_EYE)
                .unlockedBy("has_items", has(ingredient))
                .save(output, WAC.rl(effect.getKey().location().getPath()).withPrefix("ritual/strong_"));
    }
    
}

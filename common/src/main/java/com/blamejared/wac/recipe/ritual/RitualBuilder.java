package com.blamejared.wac.recipe.ritual;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

public class RitualBuilder implements RecipeBuilder {
    
    private final MobEffectInstance output;
    private final int enchantmentPower;
    private final NonNullList<Ingredient> ingredients = NonNullList.create();
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    
    private RitualBuilder(MobEffectInstance output, int enchantmentPower) {
        
        this.output = output;
        this.enchantmentPower = enchantmentPower;
    }
    
    public static RitualBuilder ritual(MobEffectInstance output, int enchantmentPower) {
        
        return new RitualBuilder(output, enchantmentPower);
    }
    
    
    public RitualBuilder requires(TagKey<Item> tag) {
        
        return this.requires(Ingredient.of(tag));
    }
    
    public RitualBuilder requires(ItemLike item) {
        
        return this.requires(item, 1);
    }
    
    public RitualBuilder requires(ItemLike item, int quantity) {
        
        for(int i = 0; i < quantity; i++) {
            this.requires(Ingredient.of(item));
        }
        
        return this;
    }
    
    public RitualBuilder requires(Ingredient ingredient) {
        
        return this.requires(ingredient, 1);
    }
    
    public RitualBuilder requires(Ingredient ingredient, int quantity) {
        
        for(int i = 0; i < quantity; i++) {
            this.ingredients.add(ingredient);
        }
        
        return this;
    }
    
    public RitualBuilder unlockedBy(String name, Criterion<?> criterion) {
        
        this.criteria.put(name, criterion);
        return this;
    }
    
    @Override
    public RecipeBuilder group(@Nullable String groupName) {
        
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Item getResult() {
        
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void save(RecipeOutput recipeOutput, ResourceLocation id) {
        
        this.ensureValid(id);
        Advancement.Builder advancement$builder = recipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                .rewards(AdvancementRewards.Builder.recipe(id))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancement$builder::addCriterion);
        Ritual ritual = new Ritual(this.ingredients, this.output, this.enchantmentPower);
        recipeOutput.accept(id, ritual, advancement$builder.build(id.withPrefix("recipes/")));
    }
    
    @Override
    public void save(RecipeOutput recipeOutput) {
        
        this.save(recipeOutput, BuiltInRegistries.MOB_EFFECT.getKey(output.getEffect().value()));
    }
    
    private void ensureValid(ResourceLocation id) {
        
        if(this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + id);
        }
        if(this.ingredients.isEmpty()) {
            throw new IllegalStateException("Recipe has no inputs" + id);
        }
    }
    
}

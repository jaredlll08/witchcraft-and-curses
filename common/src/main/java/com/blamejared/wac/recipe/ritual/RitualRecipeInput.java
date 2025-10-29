package com.blamejared.wac.recipe.ritual;

import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record RitualRecipeInput(NonNullList<ItemStack> items, Player player,
                                int enchantingPower) implements RecipeInput {
    
    @Override
    public ItemStack getItem(int index) {
        
        return items.get(index);
    }
    
    @Override
    public int size() {
        
        return items.size();
    }
    
}

package com.blamejared.wac.platform;

import com.google.auto.service.AutoService;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.impl.recipe.ingredient.ShapelessMatch;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.function.BiFunction;

@AutoService(com.blamejared.wac.platform.IPlatformHelper.class)
public class FabricPlatformHelper implements IPlatformHelper {
    
    @Override
    public CreativeModeTab.Builder creativeTabBuilder() {
        
        return FabricItemGroup.builder();
    }
    
    @Override
    public boolean isModLoaded(String modId) {
        
        return FabricLoader.getInstance().isModLoaded(modId);
    }
    
    @Override
    public <T extends BlockEntity> BlockEntityType.Builder<T> blockEntityBuilder(BiFunction<BlockPos, BlockState, T> factory, Block... validBlocks) {
        
        return BlockEntityType.Builder.of(factory::apply, validBlocks);
    }
    
    @Override
    public boolean findMatches(List<ItemStack> stacks, List<Ingredient> ingredients) {
        
        return ShapelessMatch.isMatch(stacks, ingredients);
    }
    
}

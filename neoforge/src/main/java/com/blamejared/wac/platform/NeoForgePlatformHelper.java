package com.blamejared.wac.platform;

import com.google.auto.service.AutoService;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.util.RecipeMatcher;

import java.util.List;
import java.util.function.BiFunction;

@AutoService(com.blamejared.wac.platform.IPlatformHelper.class)
public class NeoForgePlatformHelper implements IPlatformHelper {
    
    @Override
    public CreativeModeTab.Builder creativeTabBuilder() {
        
        return new CreativeModeTab.Builder(CreativeModeTab.Row.TOP, 0);
    }
    
    @Override
    public boolean isModLoaded(String modId) {
        
        return ModList.get().isLoaded(modId);
    }
    
    @Override
    public <T extends BlockEntity> BlockEntityType.Builder<T> blockEntityBuilder(BiFunction<BlockPos, BlockState, T> factory, Block... validBlocks) {
        
        return BlockEntityType.Builder.of(factory::apply, validBlocks);
    }
    
    @Override
    public boolean findMatches(List<ItemStack> stacks, List<Ingredient> ingredients) {
        
        return RecipeMatcher.findMatches(stacks, ingredients) != null;
    }
    
}

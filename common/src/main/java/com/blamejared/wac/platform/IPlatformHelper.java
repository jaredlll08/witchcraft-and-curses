package com.blamejared.wac.platform;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public interface IPlatformHelper {
    
    CreativeModeTab.Builder creativeTabBuilder();
    
    boolean isModLoaded(String modId);
    
    <T extends BlockEntity> BlockEntityType.Builder<T> blockEntityBuilder(BiFunction<BlockPos, BlockState, T> factory, Block... validBlocks);
    
     boolean findMatches(List<ItemStack> stacks, List<Ingredient> ingredients);
    
}

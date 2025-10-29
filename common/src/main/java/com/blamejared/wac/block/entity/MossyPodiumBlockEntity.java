package com.blamejared.wac.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MossyPodiumBlockEntity extends BlockEntity {
    
    public MossyPodiumBlockEntity(BlockPos pos, BlockState blockState) {
        
        super(WACBlockEntityTypes.MOSSY_PODIUM.get(), pos, blockState);
    }
    
}

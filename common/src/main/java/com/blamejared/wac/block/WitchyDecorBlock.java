package com.blamejared.wac.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;

public class WitchyDecorBlock extends HorizontalDirectionalBlock {
    
    public static final MapCodec<WitchyDecorBlock> CODEC = simpleCodec(WitchyDecorBlock::new);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    
    protected WitchyDecorBlock(Properties properties) {
        
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
    
    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        
        return CODEC;
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        
        builder.add(FACING);
    }
    
    @Override
    protected boolean useShapeForLightOcclusion(BlockState state) {
        
        return true;
    }
    
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    
    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }
    
    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }
    
    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        
        return false;
    }
    
}

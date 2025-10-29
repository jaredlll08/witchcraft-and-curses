package com.blamejared.wac.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WiltedShelfBlock extends HorizontalDirectionalBlock {
    
    public static final MapCodec<WiltedShelfBlock> CODEC = simpleCodec(WiltedShelfBlock::new);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    
    public static final VoxelShape SHAPE_NORTH = Block.box(2, 1, 13, 14.0, 15, 16);
    public static final VoxelShape SHAPE_SOUTH = Block.box(2, 1, 0, 14.0, 15, 3);
    
    public static final VoxelShape SHAPE_EAST = Block.box(0, 1, 2, 3, 15, 14);
    public static final VoxelShape SHAPE_WEST = Block.box(13, 1, 2, 16.0, 15, 14);
    
    protected WiltedShelfBlock(Properties properties) {
        
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
    
    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        
        return CODEC;
    }
    
    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        
        switch((Direction) state.getValue(FACING)) {
            case NORTH:
                return SHAPE_NORTH;
            case SOUTH:
                return SHAPE_SOUTH;
            case EAST:
                return SHAPE_EAST;
            case WEST:
                return SHAPE_WEST;
            default:
                return SHAPE_NORTH;
        }
    }
    
    @Override
    protected VoxelShape getOcclusionShape(BlockState state, BlockGetter level, BlockPos pos) {
        
        switch((Direction) state.getValue(FACING)) {
            case NORTH:
                return SHAPE_NORTH;
            case SOUTH:
                return SHAPE_SOUTH;
            case EAST:
                return SHAPE_EAST;
            case WEST:
                return SHAPE_WEST;
            default:
                return SHAPE_NORTH;
        }
    }
    
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        
        switch((Direction) state.getValue(FACING)) {
            case NORTH:
                return SHAPE_NORTH;
            case SOUTH:
                return SHAPE_SOUTH;
            case EAST:
                return SHAPE_EAST;
            case WEST:
                return SHAPE_WEST;
            default:
                return SHAPE_NORTH;
        }
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

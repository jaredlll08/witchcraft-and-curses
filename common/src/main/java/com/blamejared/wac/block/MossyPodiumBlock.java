package com.blamejared.wac.block;

import com.blamejared.wac.block.entity.MossyPodiumBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class MossyPodiumBlock extends BaseEntityBlock {
    
    public static final MapCodec<MossyPodiumBlock> CODEC = simpleCodec(MossyPodiumBlock::new);
    
    public static final VoxelShape SHAPE_BASE = Block.box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0);
    public static final VoxelShape SHAPE_POST = Block.box(6.0, 3.0, 6.0, 10, 9.0, 10);
    public static final VoxelShape SHAPE_TOP = Block.box(2.0, 9.0, 2.0, 14.0, 10.0, 14.0);
    public static final VoxelShape SHAPE_STAND = Block.box(4.0, 10.0, 4.0, 12.0, 15.0, 12.0);
    public static final VoxelShape SHAPE_COMMON = Shapes.or(SHAPE_BASE, SHAPE_POST, SHAPE_TOP, SHAPE_STAND);
    
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    
    @Override
    public MapCodec<MossyPodiumBlock> codec() {
        
        return CODEC;
    }
    
    public MossyPodiumBlock(Properties properties) {
        
        super(properties.mapColor(MapColor.DEEPSLATE).strength(2.5f).sound(SoundType.STONE));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        
        builder.add(FACING);
    }
    
    @Override
    protected RenderShape getRenderShape(BlockState state) {
        
        return RenderShape.MODEL;
    }
    
    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        
        return SHAPE_COMMON;
    }
    
    @Override
    protected VoxelShape getOcclusionShape(BlockState state, BlockGetter level, BlockPos pos) {
        
        return SHAPE_COMMON;
    }
    
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        
        return SHAPE_COMMON;
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
    
    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        
        return new MossyPodiumBlockEntity(pos, state);
    }
    
}

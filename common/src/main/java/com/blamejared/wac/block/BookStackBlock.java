package com.blamejared.wac.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BookStackBlock extends Block {
    
    public static final MapCodec<BookStackBlock> CODEC = simpleCodec(BookStackBlock::new);
    public static final IntegerProperty BOOKS = IntegerProperty.create("books", 1, 4);
    private static final VoxelShape ONE_AABB = Block.box(1.0, 0.0, 1.0, 15.0, 3.0, 15.0);
    private static final VoxelShape TWO_AABB = Block.box(1.0, 0.0, 1.0, 15.0, 6.0, 15.0);
    private static final VoxelShape THREE_AABB = Block.box(1.0, 0.0, 1.0, 15.0, 7.0, 15.0);
    private static final VoxelShape FOUR_AABB = Block.box(1.0, 0.0, 1.0, 15.0, 12.0, 15.0);
    
    public BookStackBlock(Properties properties) {
        
        super(properties);
    }
    
    @Override
    protected boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        
        return !useContext.isSecondaryUseActive() && useContext.getItemInHand()
                .getItem() == this.asItem() && state.getValue(BOOKS) < 4 || super.canBeReplaced(state, useContext);
    }
    
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
        if(blockstate.is(this)) {
            return blockstate.cycle(BOOKS);
        } else {
            return super.getStateForPlacement(context);
        }
    }
    
    
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        
        switch(state.getValue(BOOKS)) {
            case 1:
            default:
                return ONE_AABB;
            case 2:
                return TWO_AABB;
            case 3:
                return THREE_AABB;
            case 4:
                return FOUR_AABB;
        }
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        
        builder.add(BOOKS);
    }
    
    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        
        return Block.canSupportCenter(level, pos.below(), Direction.UP);
    }
    
    @Override
    public MapCodec<BookStackBlock> codec() {
        
        return CODEC;
    }
    
}

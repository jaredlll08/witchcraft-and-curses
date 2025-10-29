package com.blamejared.wac.block;

import com.blamejared.wac.block.entity.DeepslateBasinBlockEntity;
import com.blamejared.wac.recipe.ritual.Ritual;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EnchantingTableBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class DeepslateBasin extends BaseEntityBlock {
    
    public static final MapCodec<DeepslateBasin> CODEC = simpleCodec(DeepslateBasin::new);
    
    protected static final VoxelShape SHAPE = Shapes.join(
            Block.box(0, 0, 0, 16, 14, 16),
            box(1.0, 4.0, 1.0, 15.0, 14.0, 15.0),
            BooleanOp.ONLY_FIRST
    );
    
    public static final List<BlockPos> BOOKSHELF_OFFSETS = BlockPos.betweenClosedStream(-2, 0, -2, 2, 1, 2)
            .filter(p_341357_ -> Math.abs(p_341357_.getX()) == 2 || Math.abs(p_341357_.getZ()) == 2)
            .map(BlockPos::immutable)
            .toList();
    
    public DeepslateBasin(Properties properties) {
        
        super(properties);
    }
    
    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        
        if(level.getBlockEntity(pos) instanceof DeepslateBasinBlockEntity be) {
            if(!stack.isEmpty() && !be.isFull()) {
                be.addItem(stack.split(1));
                return ItemInteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
    
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        
        if(level.getBlockEntity(pos) instanceof DeepslateBasinBlockEntity be) {
            if(player.isShiftKeyDown()) {
                if(!be.isEmpty() && !be.isEmpty()) {
                    ItemStack itemStack = be.removeItem();
                    if(!player.getInventory().add(itemStack)) {
                        player.drop(itemStack, false);
                    }
                    be.setChanged();
                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            } else {
                int enchantmentPower = 0;
                
                for(BlockPos blockpos : EnchantingTableBlock.BOOKSHELF_OFFSETS) {
                    if(DeepslateBasin.isValidBookShelf(level, pos, blockpos)) {
                        enchantmentPower++;
                    }
                }
                Optional<RecipeHolder<Ritual>> recipe = be.checkRecipe(player, enchantmentPower);
                if(recipe.isPresent()) {
                    RecipeHolder<Ritual> ritualRecipeHolder = recipe.get();
                    Ritual value = ritualRecipeHolder.value();
                    player.addEffect(value.output());
                    be.clearContent();
                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
                
            }
        }
        return InteractionResult.PASS;
    }
    
    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        
        if(!state.is(newState.getBlock())) {
            if(level.getBlockEntity(pos) instanceof DeepslateBasinBlockEntity be && !be.isEmpty()) {
                for(ItemStack item : be.items()) {
                    Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), item);
                }
                be.clearContent();
            }
            
            super.onRemove(state, level, pos, newState, movedByPiston);
        }
    }
    
    public static boolean isValidBookShelf(Level level, BlockPos enchantingTablePos, BlockPos bookshelfPos) {
        
        return level.getBlockState(enchantingTablePos.offset(bookshelfPos)).is(BlockTags.ENCHANTMENT_POWER_PROVIDER)
                && level.getBlockState(enchantingTablePos.offset(bookshelfPos.getX() / 2, bookshelfPos.getY(), bookshelfPos.getZ() / 2))
                .is(BlockTags.ENCHANTMENT_POWER_TRANSMITTER);
    }
    
    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        
        super.animateTick(state, level, pos, random);
        
        for(BlockPos blockpos : BOOKSHELF_OFFSETS) {
            if(random.nextInt(16) == 0 && isValidBookShelf(level, pos, blockpos)) {
                level.addParticle(
                        ParticleTypes.ENCHANT,
                        (double) pos.getX() + 0.5,
                        (double) pos.getY() + 2.0,
                        (double) pos.getZ() + 0.5,
                        (double) ((float) blockpos.getX() + random.nextFloat()) - 0.5,
                        (double) ((float) blockpos.getY() - random.nextFloat() - 1.0F),
                        (double) ((float) blockpos.getZ() + random.nextFloat()) - 0.5
                );
            }
        }
    }
    
    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        
        return SHAPE;
    }
    
    @Override
    protected VoxelShape getOcclusionShape(BlockState state, BlockGetter level, BlockPos pos) {
        
        return SHAPE;
    }
    
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        
        return SHAPE;
    }
    
    @Override
    protected boolean useShapeForLightOcclusion(BlockState state) {
        
        return true;
    }
    
    @Override
    protected RenderShape getRenderShape(BlockState state) {
        
        return RenderShape.MODEL;
    }
    
    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        
        return new DeepslateBasinBlockEntity(pos, state);
    }
    
    @Override
    public MapCodec<DeepslateBasin> codec() {
        
        return CODEC;
    }
    
    
    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        
        return false;
    }
    
}

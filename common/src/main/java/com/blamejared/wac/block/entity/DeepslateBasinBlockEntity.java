package com.blamejared.wac.block.entity;

import com.blamejared.wac.recipe.WACRecipes;
import com.blamejared.wac.recipe.ritual.Ritual;
import com.blamejared.wac.recipe.ritual.RitualRecipeInput;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class DeepslateBasinBlockEntity extends BlockEntity implements WorldlyContainer {
    
    protected NonNullList<ItemStack> items = NonNullList.withSize(9, ItemStack.EMPTY);
    private final RecipeManager.CachedCheck<RitualRecipeInput, Ritual> quickCheck;
    
    public DeepslateBasinBlockEntity(BlockPos pos, BlockState blockState) {
        
        super(WACBlockEntityTypes.DEEPSLATE_BASIN.get(), pos, blockState);
        this.quickCheck = RecipeManager.createCheck(WACRecipes.RITUAL_TYPE.get());
    }
    
    
    @Override
    public int[] getSlotsForFace(Direction side) {
        
        return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
    }
    
    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack itemStack, @Nullable Direction direction) {
        
        return direction == Direction.UP;
    }
    
    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
        
        return direction == Direction.DOWN;
    }
    
    @Override
    public int getContainerSize() {
        
        return items.size();
    }
    
    public boolean isFull() {
        
        for(ItemStack item : this.items) {
            if(item.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    public Optional<RecipeHolder<Ritual>> checkRecipe(Player player, int enchantmentPower) {
        
        return quickCheck.
                getRecipeFor(new RitualRecipeInput(items, player, enchantmentPower), level);
    }
    
    public void addItem(ItemStack stack) {
        
        for(int i = 0; i < this.items.size(); i++) {
            if(getItem(i).isEmpty()) {
                setItem(i, stack);
                return;
            }
        }
    }
    
    public ItemStack removeItem() {
        
        for(int i = this.items.size() - 1; i >= 0; i--) {
            if(!getItem(i).isEmpty()) {
                return removeItem(i, 1);
            }
        }
        return ItemStack.EMPTY;
    }
    
    @Override
    public boolean isEmpty() {
        
        for(ItemStack itemstack : this.items) {
            if(!itemstack.isEmpty()) {
                return false;
            }
        }
        
        return true;
    }
    
    @Override
    public ItemStack getItem(int slot) {
        
        return this.items.get(slot);
    }
    
    @Override
    public ItemStack removeItem(int slot, int amount) {
        
        ItemStack itemstack = ContainerHelper.removeItem(this.items, slot, amount);
        if(!itemstack.isEmpty()) {
            this.setChanged();
        }
        
        return itemstack;
    }
    
    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        
        return ContainerHelper.takeItem(this.items, slot);
    }
    
    @Override
    public void setItem(int slot, ItemStack stack) {
        
        this.items.set(slot, stack);
        stack.limitSize(this.getMaxStackSize(stack));
        this.setChanged();
    }
    
    @Override
    public boolean stillValid(Player player) {
        
        return Container.stillValidBlockEntity(this, player);
    }
    
    @Override
    public void clearContent() {
        
        this.items.clear();
        this.setChanged();
    }
    
    public NonNullList<ItemStack> items() {
        
        return items;
    }
    
    
    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        
        super.saveAdditional(tag, registries);
        ContainerHelper.saveAllItems(tag, this.items, registries);
    }
    
    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        
        super.loadAdditional(tag, registries);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(tag, this.items, registries);
    }
    
    
    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        
        CompoundTag updateTag = super.getUpdateTag(registries);
        ContainerHelper.saveAllItems(updateTag, this.items, registries);
        return updateTag;
    }
    
    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        
        return ClientboundBlockEntityDataPacket.create(this);
    }
    
}

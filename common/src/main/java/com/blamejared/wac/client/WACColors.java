package com.blamejared.wac.client;

import com.blamejared.wac.block.WACBlocks;
import com.blamejared.wac.item.WACItems;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.BiConsumer;

public class WACColors {
    
    public static void registerBlocks(BiConsumer<BlockColor, Block[]> registrar) {
        
        registrar.accept((state, level, pos, tintIndex) -> 0xb2a29c, new Block[] {WACBlocks.WILTED_LEAVES.get()});
    }
    
    public static void registerItems(BlockColors bc, BiConsumer<ItemColor, Item[]> registrar) {
        
        registrar.accept((p_92687_, p_92688_) -> 0xb2a29c, new Item[] {WACItems.WILTED_LEAVES.get()});
    }
    
}

package com.blamejared.wac;

import com.blamejared.wac.block.WACBlocks;
import com.blamejared.wac.item.WACItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class WACEnumParams {
    
    public static Object getBoatTypeParam(int idx, Class<?> type) {
        
        if(idx == 5) {
            return false;
        }
        return type.cast(switch(idx) {
            case 0 -> (Supplier<Block>) () -> WACBlocks.WILTED_PLANKS.get();
            case 1 -> "wac:wilted";
            case 2 -> (Supplier<Item>) () -> WACItems.WILTED_BOAT.get();
            case 3 -> (Supplier<Item>) () -> WACItems.WILTED_CHEST_BOAT.get();
            case 4 -> (Supplier<Item>) () -> Items.STICK;
            default -> throw new IllegalArgumentException("Unexpected parameter index: " + idx);
        });
    }
    
}
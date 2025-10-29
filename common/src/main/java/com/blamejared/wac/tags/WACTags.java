package com.blamejared.wac.tags;

import com.blamejared.wac.WAC;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class WACTags {
    
    public static class Blocks {
        
        public static final TagKey<Block> WILTED_LOGS = TagKey.create(Registries.BLOCK, WAC.rl("wilted_logs"));
        
    }
    
    public static class Items {
        
        public static final TagKey<Item> WILTED_LOGS = TagKey.create(Registries.ITEM, WAC.rl("wilted_logs"));
        
    }
    
}

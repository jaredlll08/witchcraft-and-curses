package com.blamejared.wac;

import com.blamejared.wac.block.WACBlocks;
import com.blamejared.wac.item.WACItems;
import com.blamejared.wac.mixin.AxeItemAccessor;
import com.blamejared.wac.platform.IRegister;
import com.blamejared.wac.platform.Services;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.function.Consumer;

public class WAC {
    
    public static final String MODID = "wac";
    public static final Logger LOG = LogManager.getLogger(MODID);
    
    public static ResourceLocation rl(String path) {
        
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
    
    public static void init() {
        // Initialize all registry providers
        Services.loadAll(IRegister.class).forEach(ServiceLoader.Provider::get);
    }
    
    
    public static void registerStrippables() {
        
        Map<Block, Block> strippables = new HashMap<>(AxeItemAccessor.getSTRIPPABLES());
        strippables.put(WACBlocks.WILTED_LOG.get(), WACBlocks.STRIPPED_WILTED_LOG.get());
        strippables.put(WACBlocks.WILTED_WOOD.get(), WACBlocks.STRIPPED_WILTED_WOOD.get());
        
        AxeItemAccessor.setSTRIPPABLES(Collections.unmodifiableMap(strippables));
    }
    
    public static void registerCreativeTabs(Consumer<ItemLike> registrar) {
        
        registrar.accept(WACItems.DEEPSLATE_BASIN.get());
        registrar.accept(WACItems.MOSSY_PODIUM.get());
        registrar.accept(WACItems.WILTED_LOG.get());
        registrar.accept(WACItems.WILTED_WOOD.get());
        registrar.accept(WACItems.STRIPPED_WILTED_LOG.get());
        registrar.accept(WACItems.STRIPPED_WILTED_WOOD.get());
        registrar.accept(WACItems.WILTED_PLANKS.get());
        registrar.accept(WACItems.WILTED_STAIRS.get());
        registrar.accept(WACItems.WILTED_SLAB.get());
        registrar.accept(WACItems.WILTED_FENCE.get());
        registrar.accept(WACItems.WILTED_FENCE_GATE.get());
        registrar.accept(WACItems.WILTED_DOOR.get());
        registrar.accept(WACItems.WILTED_TRAPDOOR.get());
        registrar.accept(WACItems.WILTED_PRESSURE_PLATE.get());
        registrar.accept(WACItems.WILTED_BUTTON.get());
        registrar.accept(WACItems.WILTED_SAPLING.get());
        registrar.accept(WACItems.WILTED_SIGN.get());
        registrar.accept(WACItems.WILTED_HANGING_SIGN.get());
        registrar.accept(WACItems.WILTED_LEAVES.get());
        registrar.accept(WACItems.WILTED_BOOKSHELF.get());
        registrar.accept(WACItems.WILTED_BOAT.get());
        registrar.accept(WACItems.WILTED_CHEST_BOAT.get());
        registrar.accept(WACItems.WILTED_SHELF.get());
        registrar.accept(WACItems.BOOK_STACK.get());
        registrar.accept(WACItems.WITCHY_DECOR.get());
        registrar.accept(WACItems.WILTED_ALLIUM.get());
        registrar.accept(WACItems.WILTED_DANDELION.get());
        registrar.accept(WACItems.WILTED_LILY.get());
        registrar.accept(WACItems.WILTED_ORCHID.get());
        registrar.accept(WACItems.WILTED_ROSE.get());
    }
    
}

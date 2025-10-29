package com.blamejared.wac;

import com.blamejared.wac.block.WACBlocks;
import com.blamejared.wac.client.ClientEvents;
import com.blamejared.wac.client.WACColors;
import com.blamejared.wac.world.biome.WACBiomes;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterShadersEvent;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

@Mod(WAC.MODID)
public class WACNeoForge {
    
    public WACNeoForge(IEventBus modEventBus, ModContainer modContainer) {
        
        WAC.init();
        modEventBus.<RegisterShadersEvent> addListener(event -> ClientEvents.registerShaders(event.getResourceProvider(), event::registerShader));
        modEventBus.<EntityRenderersEvent.RegisterRenderers> addListener(event -> {
            ClientEvents.registerEntityRenderers(event::registerBlockEntityRenderer);
        });
        modEventBus.addListener(this::commonSetup);
        modEventBus.<RegisterColorHandlersEvent.Block> addListener(block -> WACColors.registerBlocks(block::register));
        modEventBus.<RegisterColorHandlersEvent.Item> addListener(item -> WACColors.registerItems(item.getBlockColors(), item::register));
        
        modEventBus.<BlockEntityTypeAddBlocksEvent> addListener(event -> {
            event.modify(BlockEntityType.SIGN, WACBlocks.WILTED_SIGN.get(), WACBlocks.WILTED_WALL_SIGN.get());
            event.modify(BlockEntityType.HANGING_SIGN, WACBlocks.WILTED_HANGING_SIGN.get(), WACBlocks.WILTED_WALL_HANGING_SIGN.get());
        });
    }
    
    private void commonSetup(final FMLCommonSetupEvent event) {
        
        event.enqueueWork(WACBiomes::registerRegions);
        event.enqueueWork(WAC::registerStrippables);
    }
    
}

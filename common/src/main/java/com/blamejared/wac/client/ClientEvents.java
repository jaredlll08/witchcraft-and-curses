package com.blamejared.wac.client;

import com.blamejared.wac.Util;
import com.blamejared.wac.block.entity.WACBlockEntityTypes;
import com.blamejared.wac.client.render.block.DeepslateBasinRenderer;
import com.blamejared.wac.client.render.block.MossyPodiumRenderer;
import com.blamejared.wac.client.render.shader.WACRenderTypes;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.server.packs.resources.ResourceProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.io.IOException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ClientEvents {
    
    public static void registerShaders(ResourceProvider resourceManager, BiConsumer<ShaderInstance, Consumer<ShaderInstance>> registerFunc) {
        
        try {
            for(WACRenderTypes.ShaderRenderType type : WACRenderTypes.getRenderTypes().values()) {
                type.register(resourceManager, registerFunc);
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static <T extends BlockEntity> void registerEntityRenderers(BiConsumer<BlockEntityType<T>, BlockEntityRendererProvider<T>> registrar) {
        
        registrar.accept((BlockEntityType<T>) WACBlockEntityTypes.MOSSY_PODIUM.get(), context -> Util.uncheck(new MossyPodiumRenderer(context)));
        registrar.accept((BlockEntityType<T>) WACBlockEntityTypes.DEEPSLATE_BASIN.get(), context -> Util.uncheck(new DeepslateBasinRenderer(context)));
    }
    
    
}

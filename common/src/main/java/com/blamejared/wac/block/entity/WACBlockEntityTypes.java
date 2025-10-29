package com.blamejared.wac.block.entity;

import com.blamejared.wac.WAC;
import com.blamejared.wac.block.WACBlocks;
import com.blamejared.wac.platform.IRegister;
import com.blamejared.wac.platform.Services;
import com.blamejared.wac.registry.RegistrationProvider;
import com.blamejared.wac.registry.RegistryObject;
import com.google.auto.service.AutoService;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

@SuppressWarnings("DataFlowIssue")
@AutoService(IRegister.class)
public class WACBlockEntityTypes implements IRegister {
    
    private static final RegistrationProvider<BlockEntityType<?>> BLOCK_ENTITY_TYPES = RegistrationProvider.get(Registries.BLOCK_ENTITY_TYPE, WAC.MODID);
    
    public static final RegistryObject<BlockEntityType<MossyPodiumBlockEntity>> MOSSY_PODIUM = BLOCK_ENTITY_TYPES.register("mossy_podium", () -> Services.PLATFORM.blockEntityBuilder(MossyPodiumBlockEntity::new, WACBlocks.MOSSY_PODIUM.get())
            .build(null));
    
    public static final RegistryObject<BlockEntityType<DeepslateBasinBlockEntity>> DEEPSLATE_BASIN = BLOCK_ENTITY_TYPES.register("deepslate_basin", () -> Services.PLATFORM.blockEntityBuilder(DeepslateBasinBlockEntity::new, WACBlocks.DEEPSLATE_BASIN.get())
            .build(null));
    
}

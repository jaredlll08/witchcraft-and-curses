package com.blamejared.wac.entity;

import com.blamejared.wac.WAC;
import com.blamejared.wac.platform.IRegister;
import com.blamejared.wac.registry.RegistrationProvider;
import com.google.auto.service.AutoService;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;

@AutoService(IRegister.class)
public class WACEntityTypes implements IRegister {
    
    private static final RegistrationProvider<EntityType<?>> ENTITY_TYPES = RegistrationProvider.get(Registries.ENTITY_TYPE, WAC.MODID);
    
}

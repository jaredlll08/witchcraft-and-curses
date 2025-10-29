package com.blamejared.wac.world.biome;

import com.blamejared.wac.WAC;
import com.blamejared.wac.platform.IRegister;
import com.google.auto.service.AutoService;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import terrablender.api.Regions;

@AutoService(IRegister.class)
public class WACBiomes implements IRegister {
    
    public static final ResourceKey<Biome> WILTED_WOODS = ResourceKey.create(Registries.BIOME, WAC.rl("wilted_woods"));
    
    public static void registerRegions() {
        
        Regions.register(new WACRegion(WAC.rl("overworld"), 2));
    }
    
}

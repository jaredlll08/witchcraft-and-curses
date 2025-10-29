package com.blamejared.wac.data;

import com.blamejared.wac.WAC;
import com.blamejared.wac.world.WACConfiguredFeatures;
import com.blamejared.wac.world.WACPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class WACDatapackProvider extends DatapackBuiltinEntriesProvider {
    
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.PLACED_FEATURE, WACPlacedFeatures::bootstrap)
            .add(Registries.CONFIGURED_FEATURE, WACConfiguredFeatures::bootstrap);
    
    public WACDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        
        super(output, registries, BUILDER, Set.of(WAC.MODID));
    }
    
}

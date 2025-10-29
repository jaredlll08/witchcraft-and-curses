package com.blamejared.wac.data;

import com.blamejared.wac.item.WACItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class WACDataMapProvider extends DataMapProvider {
    
    protected WACDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        
        super(packOutput, lookupProvider);
    }
    
    @Override
    protected void gather(HolderLookup.Provider provider) {
        
        builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(WACItems.WILTED_LEAVES.getId(), new Compostable(0.3f), false)
                .add(WACItems.WILTED_SAPLING.getId(), new Compostable(0.3f), false)
                .add(WACItems.WILTED_ALLIUM.getId(), new Compostable(0.65f), false)
                .add(WACItems.WILTED_DANDELION.getId(), new Compostable(0.65f), false)
                .add(WACItems.WILTED_LILY.getId(), new Compostable(0.65f), false)
                .add(WACItems.WILTED_ORCHID.getId(), new Compostable(0.65f), false)
                .add(WACItems.WILTED_ROSE.getId(), new Compostable(0.65f), false)
                .build();
    }
    
}

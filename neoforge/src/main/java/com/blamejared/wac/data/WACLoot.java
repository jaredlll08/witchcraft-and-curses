package com.blamejared.wac.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class WACLoot extends LootTableProvider {
    
    public WACLoot(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        
        super(output, Set.of(), List.of(new SubProviderEntry(WACBlockLoot::new, LootContextParamSets.BLOCK)), lookup);
    }
    
}

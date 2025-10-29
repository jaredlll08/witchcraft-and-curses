package com.blamejared.wac.data;

import com.blamejared.wac.WAC;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = WAC.MODID)
public class WACData {
    
    @SubscribeEvent
    public static void gatherClient(GatherDataEvent event) {
        
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        
        generator.addProvider(event.includeServer(), new WACLoot(output, lookupProvider));
        WACBlockTags provider = new WACBlockTags(output, lookupProvider, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), provider);
        generator.addProvider(event.includeServer(), new WACItemTags(output, lookupProvider, provider.contentsGetter(), event.getExistingFileHelper()));
        
        generator.addProvider(event.includeServer(), new WACRecipesProvider(output, lookupProvider));
        generator.addProvider(
                event.includeClient(),
                new WACLangProvider(output)
        );
        generator.addProvider(event.includeClient(), new WACBlockStatesProvider(output, event.getExistingFileHelper()));
        generator.addProvider(
                event.includeClient(),
                new WACItemModelProvider(output, event.getExistingFileHelper())
        );
        
        generator.addProvider(event.includeServer(), new WACDatapackProvider(output, lookupProvider));
        
        generator.addProvider(event.includeServer(), new WACDataMapProvider(output, lookupProvider));
    }
    
}

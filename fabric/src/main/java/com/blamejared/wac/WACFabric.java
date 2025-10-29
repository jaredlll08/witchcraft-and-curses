package com.blamejared.wac;

import net.fabricmc.api.ModInitializer;

public class WACFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        WAC.init();
    }
    
}

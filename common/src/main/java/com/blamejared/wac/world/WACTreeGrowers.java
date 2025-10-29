package com.blamejared.wac.world;

import com.blamejared.wac.WAC;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class WACTreeGrowers {
    
    public static final TreeGrower WILTED_WOOD = new TreeGrower(WAC.MODID + ":wilted_wood",
            Optional.empty(), Optional.of(WACConfiguredFeatures.WILTED_WOOD), Optional.empty());
    
}

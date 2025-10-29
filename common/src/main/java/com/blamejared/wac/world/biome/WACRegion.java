package com.blamejared.wac.world.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static terrablender.api.ParameterUtils.Continentalness;
import static terrablender.api.ParameterUtils.Depth;
import static terrablender.api.ParameterUtils.Erosion;
import static terrablender.api.ParameterUtils.Humidity;
import static terrablender.api.ParameterUtils.ParameterPointListBuilder;
import static terrablender.api.ParameterUtils.Temperature;
import static terrablender.api.ParameterUtils.Weirdness;

public class WACRegion extends Region {
    
    public WACRegion(ResourceLocation name, int weight) {
        
        super(name, RegionType.OVERWORLD, weight);
    }
    
    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
        new ParameterPointListBuilder()
                .temperature(Temperature.FULL_RANGE)
                .humidity(Humidity.FULL_RANGE)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FULL_RANGE)
                .weirdness(Weirdness.FULL_RANGE)
                .build()
                .forEach(point -> builder.add(point, WACBiomes.WILTED_WOODS));
        
        builder.build().forEach(mapper);
    }
    
}

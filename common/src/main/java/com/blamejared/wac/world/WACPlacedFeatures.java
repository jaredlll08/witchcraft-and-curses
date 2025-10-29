package com.blamejared.wac.world;

import com.blamejared.wac.WAC;
import com.blamejared.wac.block.WACBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import java.util.List;

public class WACPlacedFeatures {
    
    public static final ResourceKey<PlacedFeature> WILTED_WOOD_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, WAC.rl("wilted_wood_placed"));
    public static final ResourceKey<PlacedFeature> WILTED_ALLIUM_PATCH_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, WAC.rl("wilted_allium_patch_placed"));
    public static final ResourceKey<PlacedFeature> WILTED_DANDELION_PATCH_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, WAC.rl("wilted_dandelion_patch_placed"));
    public static final ResourceKey<PlacedFeature> WILTED_LILY_PATCH_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, WAC.rl("wilted_lily_patch_placed"));
    public static final ResourceKey<PlacedFeature> WILTED_ORCHID_PATCH_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, WAC.rl("wilted_orchid_patch_placed"));
    public static final ResourceKey<PlacedFeature> WILTED_ROSE_PATCH_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, WAC.rl("wilted_rose_patch_placed"));
    
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        
        register(context, WILTED_WOOD_PLACED, configuredFeatures.getOrThrow(WACConfiguredFeatures.WILTED_WOOD), VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2), WACBlocks.WILTED_SAPLING.get()));
        register(context, WILTED_ALLIUM_PATCH_PLACED, configuredFeatures.getOrThrow(WACConfiguredFeatures.WILTED_ALLIUM_PATCH), List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, WILTED_DANDELION_PATCH_PLACED, configuredFeatures.getOrThrow(WACConfiguredFeatures.WILTED_DANDELION_PATCH), List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, WILTED_LILY_PATCH_PLACED, configuredFeatures.getOrThrow(WACConfiguredFeatures.WILTED_LILY_PATCH), List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, WILTED_ORCHID_PATCH_PLACED, configuredFeatures.getOrThrow(WACConfiguredFeatures.WILTED_ORCHID_PATCH), List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, WILTED_ROSE_PATCH_PLACED, configuredFeatures.getOrThrow(WACConfiguredFeatures.WILTED_ROSE_PATCH), List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    }
    
    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
    
}

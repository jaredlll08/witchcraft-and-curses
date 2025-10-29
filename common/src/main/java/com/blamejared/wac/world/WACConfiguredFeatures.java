package com.blamejared.wac.world;

import com.blamejared.wac.WAC;
import com.blamejared.wac.block.WACBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;

public class WACConfiguredFeatures {
    
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILTED_WOOD = ResourceKey.create(Registries.CONFIGURED_FEATURE, WAC.rl("wilted_wood"));
    
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILTED_ALLIUM_PATCH = ResourceKey.create(Registries.CONFIGURED_FEATURE, WAC.rl("wilted_allium_patch"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILTED_DANDELION_PATCH = ResourceKey.create(Registries.CONFIGURED_FEATURE, WAC.rl("wilted_dandelion_patch"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILTED_LILY_PATCH = ResourceKey.create(Registries.CONFIGURED_FEATURE, WAC.rl("wilted_lily_patch"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILTED_ORCHID_PATCH = ResourceKey.create(Registries.CONFIGURED_FEATURE, WAC.rl("wilted_orchid_patch"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILTED_ROSE_PATCH = ResourceKey.create(Registries.CONFIGURED_FEATURE, WAC.rl("wilted_rose_patch"));
    
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        
        
        register(context, WILTED_WOOD, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(WACBlocks.WILTED_LOG.get()),
                new GiantTrunkPlacer(4, 1, 4),
                
                BlockStateProvider.simple(WACBlocks.WILTED_LEAVES.get()),
                new AcaciaFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0)),
                new TwoLayersFeatureSize(81, 0, 2)).build());
        
        register(context, WILTED_ALLIUM_PATCH, Feature.FLOWER, FeatureUtils.simpleRandomPatchConfiguration(
                64, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(WACBlocks.WILTED_ALLIUM.get())))
        ));
        register(context, WILTED_DANDELION_PATCH, Feature.FLOWER, FeatureUtils.simpleRandomPatchConfiguration(
                64, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(WACBlocks.WILTED_DANDELION.get())))
        ));
        register(context, WILTED_LILY_PATCH, Feature.FLOWER, FeatureUtils.simpleRandomPatchConfiguration(
                64, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(WACBlocks.WILTED_LILY.get())))
        ));
        register(context, WILTED_ORCHID_PATCH, Feature.FLOWER, FeatureUtils.simpleRandomPatchConfiguration(
                64, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(WACBlocks.WILTED_ORCHID.get())))
        ));
        register(context, WILTED_ROSE_PATCH, Feature.FLOWER, FeatureUtils.simpleRandomPatchConfiguration(
                64, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(WACBlocks.WILTED_ROSE.get())))
        ));
        
    }
    
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
    
}

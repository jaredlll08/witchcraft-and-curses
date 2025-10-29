package com.blamejared.wac.block;

import com.blamejared.wac.WAC;
import com.blamejared.wac.platform.IRegister;
import com.blamejared.wac.registry.RegistrationProvider;
import com.blamejared.wac.registry.RegistryObject;
import com.blamejared.wac.world.WACTreeGrowers;
import com.google.auto.service.AutoService;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

@SuppressWarnings("deprecation")
@AutoService(IRegister.class)
public class WACBlocks implements IRegister {
    
    public static final RegistrationProvider<Block> BLOCKS = RegistrationProvider.get(Registries.BLOCK, WAC.MODID);
    public static final BlockSetType WILTED_SET_TYPE = BlockSetType.register(new BlockSetType("wilted"));
    public static final WoodType WILTED_WOOD_TYPE = WoodType.register(new WoodType("wac:wilted", WILTED_SET_TYPE));
    
    public static final RegistryObject<Block> MOSSY_PODIUM = BLOCKS.block("mossy_podium", MossyPodiumBlock::new);
    
    public static final RegistryObject<RotatedPillarBlock> WILTED_LOG = BLOCKS.block("wilted_log", properties -> new RotatedPillarBlock(
            properties
                    .mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.WOOD : MapColor.PODZOL)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
    ));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_WILTED_LOG = BLOCKS.block("stripped_wilted_log", properties -> new RotatedPillarBlock(
            properties
                    .mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.WOOD : MapColor.PODZOL)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
    ));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_WILTED_WOOD = BLOCKS.block("stripped_wilted_wood", properties -> new RotatedPillarBlock(
            properties
                    .mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.WOOD : MapColor.PODZOL)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
    ));
    public static final RegistryObject<Block> WILTED_PLANKS = BLOCKS.block("wilted_planks", properties -> new Block(properties.mapColor(MapColor.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F, 3.0F)
            .sound(SoundType.WOOD)
            .ignitedByLava()));
    
    public static final RegistryObject<RotatedPillarBlock> WILTED_WOOD = BLOCKS.block("wilted_wood", properties -> new RotatedPillarBlock(properties.mapColor(MapColor.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .sound(SoundType.WOOD)
            .ignitedByLava()));
    
    public static final RegistryObject<StandingSignBlock> WILTED_SIGN = BLOCKS.block("wilted_sign", properties -> new StandingSignBlock(WILTED_WOOD_TYPE, properties.mapColor(MapColor.WOOD)
            .forceSolidOn()
            .instrument(NoteBlockInstrument.BASS)
            .noCollission()
            .strength(1.0F)
            .ignitedByLava()));
    
    public static final RegistryObject<CeilingHangingSignBlock> WILTED_HANGING_SIGN = BLOCKS.block("wilted_hanging_sign", properties -> new CeilingHangingSignBlock(
            WILTED_WOOD_TYPE,
            BlockBehaviour.Properties.of()
                    .mapColor(WILTED_LOG.get().defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.0F)
                    .ignitedByLava()
    ));
    
    public static final RegistryObject<WallHangingSignBlock> WILTED_WALL_HANGING_SIGN = BLOCKS.block("wilted_wall_hanging_sign", properties -> new WallHangingSignBlock(
            WILTED_WOOD_TYPE,
            BlockBehaviour.Properties.of()
                    .mapColor(WILTED_LOG.get().defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.0F)
                    .ignitedByLava()
                    .dropsLike(WILTED_HANGING_SIGN.get())
    ));
    
    public static final RegistryObject<DoorBlock> WILTED_DOOR = BLOCKS.block("wilted_door", properties -> new DoorBlock(WILTED_SET_TYPE, properties.mapColor(WILTED_PLANKS.get()
                    .defaultMapColor())
            .instrument(NoteBlockInstrument.BASS)
            .strength(3.0F)
            .noOcclusion()
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY)));
    
    public static final RegistryObject<StairBlock> WILTED_STAIRS = BLOCKS.block("wilted_stairs", properties -> new StairBlock(WILTED_PLANKS.get()
            .defaultBlockState(), BlockBehaviour.Properties.ofLegacyCopy(WILTED_PLANKS.get())));
    
    public static final RegistryObject<WallSignBlock> WILTED_WALL_SIGN = BLOCKS.block("wilted_wall_sign", properties -> new WallSignBlock(WILTED_WOOD_TYPE, properties.mapColor(MapColor.WOOD)
            .forceSolidOn()
            .instrument(NoteBlockInstrument.BASS)
            .noCollission()
            .strength(1.0F)
            .dropsLike(WILTED_SIGN.get())
            .ignitedByLava()));
    
    public static final RegistryObject<PressurePlateBlock> WILTED_PRESSURE_PLATE = BLOCKS.block("wilted_pressure_plate", properties -> new PressurePlateBlock(WILTED_SET_TYPE, properties.mapColor(WILTED_PLANKS.get()
                    .defaultMapColor())
            .forceSolidOn()
            .instrument(NoteBlockInstrument.BASS)
            .noCollission()
            .strength(0.5F)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY)));
    
    public static final RegistryObject<FenceBlock> WILTED_FENCE = BLOCKS.block("wilted_fence", properties -> new FenceBlock(properties.mapColor(WILTED_PLANKS.get()
                    .defaultMapColor())
            .forceSolidOn()
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F, 3.0F)
            .sound(SoundType.WOOD)
            .ignitedByLava()));
    
    public static final RegistryObject<TrapDoorBlock> WILTED_TRAPDOOR = BLOCKS.block("wilted_trapdoor", properties -> new TrapDoorBlock(WILTED_SET_TYPE, properties.mapColor(MapColor.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(3.0F)
            .noOcclusion()
            .isValidSpawn((state, level, pos, value) -> false)
            .ignitedByLava()));
    
    public static final RegistryObject<FenceGateBlock> WILTED_FENCE_GATE = BLOCKS.block("wilted_fence_gate", properties -> new FenceGateBlock(WILTED_WOOD_TYPE, properties.mapColor(WILTED_PLANKS.get()
                    .defaultMapColor())
            .forceSolidOn()
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F, 3.0F)
            .ignitedByLava()));
    
    public static final RegistryObject<ButtonBlock> WILTED_BUTTON = BLOCKS.block("wilted_button", properties -> new ButtonBlock(WILTED_SET_TYPE, 30, properties.noCollission()
            .strength(0.5F)
            .pushReaction(PushReaction.DESTROY)));
    
    
    public static final RegistryObject<SaplingBlock> WILTED_SAPLING = BLOCKS.block("wilted_sapling", properties -> new SaplingBlock(WACTreeGrowers.WILTED_WOOD, BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.GRASS)
            .pushReaction(PushReaction.DESTROY)));
    
    public static final RegistryObject<LeavesBlock> WILTED_LEAVES = BLOCKS.block("wilted_leaves", properties -> new LeavesBlock(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .strength(0.2F)
                    .randomTicks()
                    .sound(SoundType.GRASS)
                    .noOcclusion()
                    .isValidSpawn((state, level, pos, value) -> value == EntityType.OCELOT || value == EntityType.PARROT)
                    .isSuffocating((state, level, pos) -> false)
                    .isViewBlocking((state, level, pos) -> false)
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
                    .isRedstoneConductor((state, level, pos) -> false)
    ));
    
    public static final RegistryObject<Block> WILTED_BOOKSHELF = BLOCKS.block("wilted_bookshelf", properties -> new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(1.5F)
            .sound(SoundType.WOOD)
            .ignitedByLava()));
    
    
    public static final RegistryObject<SlabBlock> WILTED_SLAB = BLOCKS.block("wilted_slab", properties -> new SlabBlock(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
    ));
    
    public static final RegistryObject<WiltedShelfBlock> WILTED_SHELF = BLOCKS.block("wilted_shelf", WiltedShelfBlock::new);
    public static final RegistryObject<BookStackBlock> BOOK_STACK = BLOCKS.block("book_stack", properties -> new BookStackBlock(properties.noCollission()));
    public static final RegistryObject<WitchyDecorBlock> WITCHY_DECOR = BLOCKS.block("witchy_decor", properties -> new WitchyDecorBlock(properties.noOcclusion()));
    
    public static final RegistryObject<FlowerBlock> WILTED_ALLIUM = BLOCKS.block("wilted_allium", properties -> new FlowerBlock(MobEffects.FIRE_RESISTANCE, 4.0F, BlockBehaviour.Properties.ofFullCopy(Blocks.ALLIUM)));
    public static final RegistryObject<FlowerBlock> WILTED_DANDELION = BLOCKS.block("wilted_dandelion", properties -> new FlowerBlock(MobEffects.SATURATION, 0.35F, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final RegistryObject<FlowerBlock> WILTED_LILY = BLOCKS.block("wilted_lily", properties -> new FlowerBlock(MobEffects.POISON, 12F, BlockBehaviour.Properties.ofFullCopy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<FlowerBlock> WILTED_ORCHID = BLOCKS.block("wilted_orchid", properties -> new FlowerBlock(MobEffects.SATURATION, 0.35F, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ORCHID)));
    public static final RegistryObject<FlowerBlock> WILTED_ROSE = BLOCKS.block("wilted_rose", properties -> new FlowerBlock(MobEffects.WITHER, 8.0F, BlockBehaviour.Properties.ofFullCopy(Blocks.WITHER_ROSE)));
    
    public static final RegistryObject<Block> DEEPSLATE_BASIN = BLOCKS.block("deepslate_basin", properties -> new DeepslateBasin(properties.noOcclusion()));
    
}

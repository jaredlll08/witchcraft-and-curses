package com.blamejared.wac.data;

import com.blamejared.wac.WAC;
import com.blamejared.wac.block.BookStackBlock;
import com.blamejared.wac.block.WACBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class WACBlockStatesProvider extends BlockStateProvider {
    
    public WACBlockStatesProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        
        super(output, WAC.MODID, exFileHelper);
    }
    
    @Override
    protected void registerStatesAndModels() {
        
        this.horizontalBlock(WACBlocks.MOSSY_PODIUM.get(), this.models().getExistingFile(modLoc("mossy_podium")));
        this.logBlock(WACBlocks.WILTED_LOG.get());
        this.axisBlock(WACBlocks.STRIPPED_WILTED_LOG.get(), modLoc("block/stripped_wilted_log_horizontal"), modLoc("block/stripped_wilted_log_top"));
        this.axisBlock(WACBlocks.STRIPPED_WILTED_WOOD.get(), modLoc("block/stripped_wilted_log_horizontal"), modLoc("block/stripped_wilted_log_horizontal"));
        
        axisBlock(WACBlocks.WILTED_WOOD.get(), blockTexture(WACBlocks.WILTED_LOG.get()), blockTexture(WACBlocks.WILTED_LOG.get()));
        this.simpleBlock(WACBlocks.WILTED_PLANKS.get());
        this.doorBlockWithRenderType(WACBlocks.WILTED_DOOR.get(), modLoc("block/wilted_door_bottom"), modLoc("block/wilted_door_top"), "cutout");
        ResourceLocation planks = modLoc("block/wilted_planks");
        this.stairsBlock(WACBlocks.WILTED_STAIRS.get(), planks);
        this.pressurePlateBlock(WACBlocks.WILTED_PRESSURE_PLATE.get(), planks);
        this.fenceBlock(WACBlocks.WILTED_FENCE.get(), planks);
        this.fenceGateBlock(WACBlocks.WILTED_FENCE_GATE.get(), planks);
        this.trapdoorBlockWithRenderType(WACBlocks.WILTED_TRAPDOOR.get(), this.modLoc("block/wilted_trapdoor"), true, "cutout");
        this.buttonBlock(WACBlocks.WILTED_BUTTON.get(), planks);
        this.simpleBlock(WACBlocks.WILTED_SAPLING.get(), this.models()
                .cross("wilted_sapling", this.modLoc("block/wilted_sapling")).renderType("cutout"));
        this.simpleBlock(WACBlocks.WILTED_LEAVES.get(), models().leaves("wilted_leaves", modLoc("block/wilted_leaves"))
                .renderType("cutout_mipped"));
        
        this.simpleBlock(WACBlocks.WILTED_BOOKSHELF.get(), models().cubeColumn("block/wilted_bookshelf", modLoc("block/wilted_bookshelf"), modLoc("block/wilted_planks")));
        this.slabBlock(WACBlocks.WILTED_SLAB.get(), modLoc("block/wilted_planks"), modLoc("block/wilted_planks"));
        
        this.signBlock(WACBlocks.WILTED_SIGN.get(), WACBlocks.WILTED_WALL_SIGN.get(), modLoc("block/wilted_planks"));
        this.hangingSignBlock(WACBlocks.WILTED_HANGING_SIGN.get(), WACBlocks.WILTED_WALL_HANGING_SIGN.get(), modLoc("block/wilted_planks"));
        this.horizontalBlock(WACBlocks.WILTED_SHELF.get(), models().getExistingFile(modLoc("block/wilted_shelf")));
        VariantBlockStateBuilder variantBuilder = this.getVariantBuilder(WACBlocks.BOOK_STACK.get());
        variantBuilder.forAllStates(state -> {
            Integer value = state.getValue(BookStackBlock.BOOKS);
            return ConfiguredModel.allYRotations(models().getExistingFile(modLoc("book_stack_" + value)), 0, false);
        });
        
        this.horizontalBlock(WACBlocks.WITCHY_DECOR.get(), models().getExistingFile(modLoc("block/witchy_decor")));
        this.simpleBlock(WACBlocks.WILTED_ALLIUM.get(), this.models()
                
                .cross("wilted_allium", this.modLoc("block/wilted_allium")).renderType("cutout"));
        this.simpleBlock(WACBlocks.WILTED_DANDELION.get(), this.models()
                .cross("wilted_dandelion", this.modLoc("block/wilted_dandelion")).renderType("cutout"));
        this.simpleBlock(WACBlocks.WILTED_LILY.get(), this.models()
                .cross("wilted_lily", this.modLoc("block/wilted_lily")).renderType("cutout"));
        this.simpleBlock(WACBlocks.WILTED_ORCHID.get(), this.models()
                .cross("wilted_orchid", this.modLoc("block/wilted_orchid")).renderType("cutout"));
        this.simpleBlock(WACBlocks.WILTED_ROSE.get(), this.models()
                .cross("wilted_rose", this.modLoc("block/wilted_rose")).renderType("cutout"));
        
        this.simpleBlock(WACBlocks.DEEPSLATE_BASIN.get(), this.models().getExistingFile(modLoc("deepslate_basin")));
        
    }
    
}

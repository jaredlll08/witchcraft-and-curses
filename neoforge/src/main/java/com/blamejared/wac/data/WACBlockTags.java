package com.blamejared.wac.data;

import com.blamejared.wac.WAC;
import com.blamejared.wac.block.WACBlocks;
import com.blamejared.wac.tags.WACTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class WACBlockTags extends BlockTagsProvider {
    
    public WACBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, ExistingFileHelper helper) {
        
        super(output, lookup, WAC.MODID, helper);
    }
    
    @Override
    protected void addTags(HolderLookup.Provider provider) {
        
        tag(BlockTags.PLANKS).add(WACBlocks.WILTED_PLANKS.get());
        tag(BlockTags.WOODEN_BUTTONS).add(WACBlocks.WILTED_BUTTON.get());
        tag(BlockTags.BUTTONS).add(WACBlocks.WILTED_BUTTON.get());
        tag(BlockTags.WOODEN_DOORS).add(WACBlocks.WILTED_DOOR.get());
        tag(BlockTags.MOB_INTERACTABLE_DOORS).add(WACBlocks.WILTED_DOOR.get());
        tag(BlockTags.WOODEN_STAIRS).add(WACBlocks.WILTED_STAIRS.get());
        tag(BlockTags.WOODEN_SLABS).add(WACBlocks.WILTED_SLAB.get());
        tag(BlockTags.WOODEN_FENCES).add(WACBlocks.WILTED_FENCE.get());
        tag(BlockTags.PRESSURE_PLATES).add(WACBlocks.WILTED_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(WACBlocks.WILTED_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_TRAPDOORS).add(WACBlocks.WILTED_TRAPDOOR.get());
        tag(BlockTags.DOORS).add(WACBlocks.WILTED_DOOR.get());
        tag(BlockTags.SAPLINGS).add(WACBlocks.WILTED_SAPLING.get());
        tag(BlockTags.LOGS_THAT_BURN)
                .add(WACBlocks.STRIPPED_WILTED_LOG.get())
                .add(WACBlocks.STRIPPED_WILTED_WOOD.get())
                .add(WACBlocks.WILTED_WOOD.get())
                .add(WACBlocks.WILTED_LOG.get());
        tag(BlockTags.OVERWORLD_NATURAL_LOGS).add(WACBlocks.WILTED_LOG.get());
        tag(BlockTags.LOGS)
                .add(WACBlocks.STRIPPED_WILTED_LOG.get())
                .add(WACBlocks.STRIPPED_WILTED_WOOD.get())
                .add(WACBlocks.WILTED_WOOD.get())
                .add(WACBlocks.WILTED_LOG.get());
        tag(BlockTags.STAIRS).add(WACBlocks.WILTED_STAIRS.get());
        tag(BlockTags.SLABS).add(WACBlocks.WILTED_SLAB.get());
        tag(BlockTags.LEAVES).add(WACBlocks.WILTED_LEAVES.get());
        tag(BlockTags.TRAPDOORS).add(WACBlocks.WILTED_TRAPDOOR.get());
        tag(BlockTags.SMALL_FLOWERS)
                .add(WACBlocks.WILTED_ALLIUM.get())
                .add(WACBlocks.WILTED_DANDELION.get())
                .add(WACBlocks.WILTED_LILY.get())
                .add(WACBlocks.WILTED_ORCHID.get())
                .add(WACBlocks.WILTED_ROSE.get());
        tag(BlockTags.FENCES).add(WACBlocks.WILTED_FENCE.get());
        tag(BlockTags.FLOWERS)
                .add(WACBlocks.WILTED_ALLIUM.get())
                .add(WACBlocks.WILTED_DANDELION.get())
                .add(WACBlocks.WILTED_LILY.get())
                .add(WACBlocks.WILTED_ORCHID.get())
                .add(WACBlocks.WILTED_ROSE.get());
        tag(BlockTags.ENDERMAN_HOLDABLE)
                .add(WACBlocks.WILTED_ALLIUM.get())
                .add(WACBlocks.WILTED_DANDELION.get())
                .add(WACBlocks.WILTED_LILY.get())
                .add(WACBlocks.WILTED_ORCHID.get())
                .add(WACBlocks.WILTED_ROSE.get());
        tag(BlockTags.STANDING_SIGNS).add(WACBlocks.WILTED_SIGN.get());
        tag(BlockTags.WALL_SIGNS).add(WACBlocks.WILTED_WALL_SIGN.get());
        tag(BlockTags.CEILING_HANGING_SIGNS).add(WACBlocks.WILTED_HANGING_SIGN.get());
        tag(BlockTags.WALL_HANGING_SIGNS).add(WACBlocks.WILTED_WALL_HANGING_SIGN.get());
        tag(BlockTags.FENCE_GATES).add(WACBlocks.WILTED_FENCE_GATE.get());
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(WACBlocks.WILTED_SHELF.get())
                .add(WACBlocks.WILTED_BOOKSHELF.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(WACBlocks.DEEPSLATE_BASIN.get())
                .add(WACBlocks.MOSSY_PODIUM.get());
        
        tag(BlockTags.ENCHANTMENT_POWER_PROVIDER)
                .add(WACBlocks.MOSSY_PODIUM.get())
                .add(WACBlocks.WITCHY_DECOR.get())
                .add(WACBlocks.WILTED_SHELF.get())
                .add(WACBlocks.BOOK_STACK.get())
                .add(WACBlocks.WILTED_BOOKSHELF.get());
        
        tag(WACTags.Blocks.WILTED_LOGS)
                .add(WACBlocks.STRIPPED_WILTED_LOG.get())
                .add(WACBlocks.STRIPPED_WILTED_WOOD.get())
                .add(WACBlocks.WILTED_WOOD.get())
                .add(WACBlocks.WILTED_LOG.get());
    }
    
}

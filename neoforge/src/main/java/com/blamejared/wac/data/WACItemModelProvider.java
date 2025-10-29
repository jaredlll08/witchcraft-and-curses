package com.blamejared.wac.data;

import com.blamejared.wac.WAC;
import com.blamejared.wac.block.WACBlocks;
import com.blamejared.wac.item.WACItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class WACItemModelProvider extends ItemModelProvider {
    
    public WACItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        
        super(output, WAC.MODID, existingFileHelper);
    }
    
    @Override
    protected void registerModels() {
        
        ResourceLocation planks = WAC.rl("block/wilted_planks");
        
        this.simpleBlockItem(WACBlocks.MOSSY_PODIUM.get());
        this.simpleBlockItem(WACBlocks.WILTED_LOG.get());
        this.simpleBlockItem(WACBlocks.STRIPPED_WILTED_LOG.get());
        this.simpleBlockItem(WACBlocks.STRIPPED_WILTED_WOOD.get());
        this.simpleBlockItem(WACBlocks.WILTED_WOOD.get());
        this.simpleBlockItem(WACBlocks.WILTED_PLANKS.get());
        this.basicItem(WACItems.WILTED_DOOR.get());
        this.stairs("wilted_stairs", planks, planks, planks);
        this.fenceInventory("wilted_fence", planks);
        this.buttonInventory("wilted_button", planks);
        this.fenceGate("wilted_fence_gate", planks);
        this.withExistingParent("wilted_trapdoor", modLoc("block/wilted_trapdoor_bottom"));
        this.pressurePlate("wilted_pressure_plate", planks);
        this.singleTexture("wilted_sapling", mcLoc("item/generated"), "layer0", this.modLoc("block/wilted_sapling"));
        this.simpleBlockItem(WACBlocks.WILTED_LEAVES.get());
        this.simpleBlockItem(WACBlocks.WILTED_BOOKSHELF.get());
        this.simpleBlockItem(WACBlocks.WILTED_SLAB.get());
        this.basicItem(WACItems.WILTED_BOAT.get());
        this.basicItem(WACItems.WILTED_CHEST_BOAT.get());
        this.basicItem(WACItems.WILTED_SIGN.get());
        this.basicItem(WACItems.WILTED_HANGING_SIGN.get());
        this.simpleBlockItem(WACBlocks.WILTED_SHELF.get());
        this.withExistingParent("book_stack", modLoc("block/book_stack_1"));
        this.simpleBlockItem(WACBlocks.WITCHY_DECOR.get());
        
        this.singleTexture("wilted_allium", mcLoc("item/generated"), "layer0", this.modLoc("block/wilted_allium"));
        this.singleTexture("wilted_dandelion", mcLoc("item/generated"), "layer0", this.modLoc("block/wilted_dandelion"));
        this.singleTexture("wilted_lily", mcLoc("item/generated"), "layer0", this.modLoc("block/wilted_lily"));
        this.singleTexture("wilted_orchid", mcLoc("item/generated"), "layer0", this.modLoc("block/wilted_orchid"));
        this.singleTexture("wilted_rose", mcLoc("item/generated"), "layer0", this.modLoc("block/wilted_rose"));
        
        this.simpleBlockItem(WACBlocks.DEEPSLATE_BASIN.get());
    }
    
}

package com.blamejared.wac.data;

import com.blamejared.wac.WAC;
import com.blamejared.wac.block.WACBlocks;
import com.blamejared.wac.item.WACItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class WACLangProvider extends LanguageProvider {
    
    public WACLangProvider(PackOutput output) {
        
        super(output, WAC.MODID, "en_us");
    }
    
    @Override
    protected void addTranslations() {
        
        this.add("itemGroup.wac", "Witchery And Curses");
        this.addItem(WACItems.WILTED_BOAT, "Wilted Boat");
        this.addItem(WACItems.WILTED_CHEST_BOAT, "Wilted Chest Boat");
        this.addBlock(WACBlocks.MOSSY_PODIUM, "Mossy Podium");
        this.addBlock(WACBlocks.WILTED_LOG, "Wilted Log");
        this.addBlock(WACBlocks.STRIPPED_WILTED_LOG, "Stripped Wilted Log");
        this.addBlock(WACBlocks.STRIPPED_WILTED_WOOD, "Stripped Wilted Wood");
        this.addBlock(WACBlocks.WILTED_PLANKS, "Wilted Planks");
        this.addBlock(WACBlocks.WILTED_WOOD, "Wilted Wood");
        this.addBlock(WACBlocks.WILTED_SIGN, "Wilted Sign");
        this.addBlock(WACBlocks.WILTED_HANGING_SIGN, "Wilted Hanging Sign");
        this.addBlock(WACBlocks.WILTED_DOOR, "Wilted Door");
        this.addBlock(WACBlocks.WILTED_STAIRS, "Wilted Stairs");
        this.addBlock(WACBlocks.WILTED_PRESSURE_PLATE, "Wilted Pressure Plate");
        this.addBlock(WACBlocks.WILTED_FENCE, "Wilted Fence");
        this.addBlock(WACBlocks.WILTED_FENCE_GATE, "Wilted Fence Gate");
        this.addBlock(WACBlocks.WILTED_TRAPDOOR, "Wilted Trapdoor");
        this.addBlock(WACBlocks.WILTED_BUTTON, "Wilted Button");
        this.addBlock(WACBlocks.WILTED_SAPLING, "Wilted Sapling");
        this.addBlock(WACBlocks.WILTED_LEAVES, "Wilted Leaves");
        this.addBlock(WACBlocks.WILTED_BOOKSHELF, "Wilted Bookshelf");
        this.addBlock(WACBlocks.WILTED_SLAB, "Wilted Slab");
        this.addBlock(WACBlocks.WILTED_SHELF, "Wilted Shelf");
        this.addBlock(WACBlocks.BOOK_STACK, "Book Stack");
        this.addBlock(WACBlocks.WITCHY_DECOR, "Witchy Decor");
        this.addBlock(WACBlocks.WILTED_ALLIUM, "Wilted Allium");
        this.addBlock(WACBlocks.WILTED_DANDELION, "Wilted Dandelion");
        this.addBlock(WACBlocks.WILTED_LILY, "Wilted Lily");
        this.addBlock(WACBlocks.WILTED_ORCHID, "Wilted Orchid");
        this.addBlock(WACBlocks.WILTED_ROSE, "Wilted Rose");
        this.addBlock(WACBlocks.DEEPSLATE_BASIN, "Deepslate Basin");
        
        this.add("gui.jei.category.wac.ritual", "Ritual");
        this.add("gui.jei.category.wac.enchantment_power", "%s Enchantment Power");
        this.add("wac.enchantment_power_provider", "Provides enchantment power");
    }
    
}

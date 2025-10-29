package com.blamejared.wac.item;

import com.blamejared.wac.WAC;
import com.blamejared.wac.block.WACBlocks;
import com.blamejared.wac.platform.IRegister;
import com.blamejared.wac.platform.Services;
import com.blamejared.wac.registry.RegistrationProvider;
import com.blamejared.wac.registry.RegistryObject;
import com.google.auto.service.AutoService;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.component.ItemLore;

import java.util.List;

@AutoService(IRegister.class)
public class WACItems implements IRegister {
    
    public static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(Registries.ITEM, WAC.MODID);
    private static final RegistrationProvider<CreativeModeTab> TABS = RegistrationProvider.get(Registries.CREATIVE_MODE_TAB, WAC.MODID);
    
    public static final RegistryObject<CreativeModeTab> TAB = TABS.register(WAC.MODID, () -> Services.PLATFORM.creativeTabBuilder()
            .displayItems((parameters, output) -> WAC.registerCreativeTabs(output::accept))
            .icon(WACItems.DEEPSLATE_BASIN.get()::getDefaultInstance)
            .title(Component.translatable("itemGroup.wac"))
            .build());
    
    public static final RegistryObject<Item> MOSSY_PODIUM = ITEMS.blockItem("mossy_podium", WACBlocks.MOSSY_PODIUM, properties -> properties.component(DataComponents.LORE, new ItemLore(List.of(Component.translatable("wac.enchantment_power_provider")))));
    public static final RegistryObject<Item> WILTED_LOG = ITEMS.blockItem("wilted_log", WACBlocks.WILTED_LOG, properties -> properties);
    public static final RegistryObject<Item> STRIPPED_WILTED_LOG = ITEMS.blockItem("stripped_wilted_log", WACBlocks.STRIPPED_WILTED_LOG, properties -> properties);
    public static final RegistryObject<Item> STRIPPED_WILTED_WOOD = ITEMS.blockItem("stripped_wilted_wood", WACBlocks.STRIPPED_WILTED_WOOD, properties -> properties);
    public static final RegistryObject<Item> WILTED_PLANKS = ITEMS.blockItem("wilted_planks", WACBlocks.WILTED_PLANKS, properties -> properties);
    public static final RegistryObject<Item> WILTED_WOOD = ITEMS.blockItem("wilted_wood", WACBlocks.WILTED_WOOD, properties -> properties);
    public static final RegistryObject<Item> WILTED_SIGN = ITEMS.item("wilted_sign", properties -> new SignItem(properties.stacksTo(16), WACBlocks.WILTED_SIGN.get(), WACBlocks.WILTED_WALL_SIGN.get()));
    public static final RegistryObject<Item> WILTED_HANGING_SIGN = ITEMS.item("wilted_hanging_sign", properties -> new HangingSignItem(WACBlocks.WILTED_HANGING_SIGN.get(), WACBlocks.WILTED_WALL_HANGING_SIGN.get(), properties.stacksTo(16)));
    public static final RegistryObject<Item> WILTED_DOOR = ITEMS.blockItem("wilted_door", WACBlocks.WILTED_DOOR, properties -> properties);
    public static final RegistryObject<Item> WILTED_STAIRS = ITEMS.blockItem("wilted_stairs", WACBlocks.WILTED_STAIRS, properties -> properties);
    public static final RegistryObject<Item> WILTED_PRESSURE_PLATE = ITEMS.blockItem("wilted_pressure_plate", WACBlocks.WILTED_PRESSURE_PLATE, properties -> properties);
    public static final RegistryObject<Item> WILTED_FENCE = ITEMS.blockItem("wilted_fence", WACBlocks.WILTED_FENCE, properties -> properties);
    public static final RegistryObject<Item> WILTED_TRAPDOOR = ITEMS.blockItem("wilted_trapdoor", WACBlocks.WILTED_TRAPDOOR, properties -> properties);
    public static final RegistryObject<Item> WILTED_FENCE_GATE = ITEMS.blockItem("wilted_fence_gate", WACBlocks.WILTED_FENCE_GATE, properties -> properties);
    public static final RegistryObject<Item> WILTED_BUTTON = ITEMS.blockItem("wilted_button", WACBlocks.WILTED_BUTTON, properties -> properties);
    public static final RegistryObject<Item> WILTED_SAPLING = ITEMS.blockItem("wilted_sapling", WACBlocks.WILTED_SAPLING, properties -> properties);
    public static final RegistryObject<Item> WILTED_LEAVES = ITEMS.blockItem("wilted_leaves", WACBlocks.WILTED_LEAVES, properties -> properties);
    public static final RegistryObject<Item> WILTED_BOOKSHELF = ITEMS.blockItem("wilted_bookshelf", WACBlocks.WILTED_BOOKSHELF, properties -> properties);
    public static final RegistryObject<Item> WILTED_SLAB = ITEMS.blockItem("wilted_slab", WACBlocks.WILTED_SLAB, properties -> properties);
    public static final RegistryObject<Item> WILTED_BOAT = ITEMS.item("wilted_boat", properties -> new BoatItem(false, Boat.Type.valueOf("WAC_WILTED"), properties.stacksTo(1)));
    public static final RegistryObject<Item> WILTED_CHEST_BOAT = ITEMS.item("wilted_chest_boat", properties -> new BoatItem(true, Boat.Type.valueOf("WAC_WILTED"), properties.stacksTo(1)));
    public static final RegistryObject<Item> WILTED_SHELF = ITEMS.blockItem("wilted_shelf", WACBlocks.WILTED_SHELF, properties -> properties.component(DataComponents.LORE, new ItemLore(List.of(Component.translatable("wac.enchantment_power_provider")))));
    public static final RegistryObject<Item> BOOK_STACK = ITEMS.blockItem("book_stack", WACBlocks.BOOK_STACK, properties -> properties.component(DataComponents.LORE, new ItemLore(List.of(Component.translatable("wac.enchantment_power_provider")))));
    public static final RegistryObject<Item> WITCHY_DECOR = ITEMS.blockItem("witchy_decor", WACBlocks.WITCHY_DECOR, properties -> properties.component(DataComponents.LORE, new ItemLore(List.of(Component.translatable("wac.enchantment_power_provider")))));
    
    public static final RegistryObject<Item> WILTED_ALLIUM = ITEMS.blockItem("wilted_allium", WACBlocks.WILTED_ALLIUM, properties -> properties);
    public static final RegistryObject<Item> WILTED_DANDELION = ITEMS.blockItem("wilted_dandelion", WACBlocks.WILTED_DANDELION, properties -> properties);
    public static final RegistryObject<Item> WILTED_LILY = ITEMS.blockItem("wilted_lily", WACBlocks.WILTED_LILY, properties -> properties);
    public static final RegistryObject<Item> WILTED_ORCHID = ITEMS.blockItem("wilted_orchid", WACBlocks.WILTED_ORCHID, properties -> properties);
    public static final RegistryObject<Item> WILTED_ROSE = ITEMS.blockItem("wilted_rose", WACBlocks.WILTED_ROSE, properties -> properties);
    
    public static final RegistryObject<Item> DEEPSLATE_BASIN = ITEMS.blockItem("deepslate_basin", WACBlocks.DEEPSLATE_BASIN, properties -> properties);
    
}

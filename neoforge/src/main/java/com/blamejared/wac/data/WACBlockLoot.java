package com.blamejared.wac.data;

import com.blamejared.wac.block.BookStackBlock;
import com.blamejared.wac.block.WACBlocks;
import com.blamejared.wac.registry.RegistryObject;
import it.unimi.dsi.fastutil.objects.ReferenceOpenHashSet;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.List;
import java.util.Set;

public class WACBlockLoot extends BlockLootSubProvider {
    
    private final Set<Block> knownBlocks = new ReferenceOpenHashSet<>();
    
    public WACBlockLoot(HolderLookup.Provider provider) {
        
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }
    
    @Override
    protected void generate() {
        
        List<RegistryObject<? extends Block>> dropsSelf = List.of(
                WACBlocks.MOSSY_PODIUM,
                WACBlocks.WILTED_LOG,
                WACBlocks.STRIPPED_WILTED_WOOD,
                WACBlocks.STRIPPED_WILTED_WOOD,
                WACBlocks.WILTED_PLANKS,
                WACBlocks.WILTED_WOOD,
                WACBlocks.WILTED_SIGN,
                WACBlocks.WILTED_HANGING_SIGN,
                WACBlocks.WILTED_DOOR,
                WACBlocks.WILTED_STAIRS,
                WACBlocks.WILTED_PRESSURE_PLATE,
                WACBlocks.WILTED_FENCE,
                WACBlocks.WILTED_TRAPDOOR,
                WACBlocks.WILTED_FENCE_GATE,
                WACBlocks.WILTED_BUTTON,
                WACBlocks.WILTED_SAPLING,
                WACBlocks.WILTED_SLAB,
                WACBlocks.WILTED_SHELF,
                WACBlocks.WITCHY_DECOR,
                WACBlocks.WILTED_ALLIUM,
                WACBlocks.WILTED_DANDELION,
                WACBlocks.WILTED_LILY,
                WACBlocks.WILTED_ORCHID,
                WACBlocks.WILTED_ROSE,
                WACBlocks.DEEPSLATE_BASIN
        );
        for(RegistryObject<? extends Block> entry : dropsSelf) {
            this.dropSelf(entry.get());
        }
        
        this.add(WACBlocks.WILTED_LEAVES.get(), block -> this.createOakLeavesDrops(block, WACBlocks.WILTED_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(WACBlocks.WILTED_BOOKSHELF.get(), block -> this.createSingleItemTableWithSilkTouch(block, Items.BOOK, ConstantValue.exactly(3.0F)));
        this.add(WACBlocks.BOOK_STACK.get(), this::createBookStack);
    }
    
    @Override
    protected void add(Block block, LootTable.Builder table) {
        
        super.add(block, table);
        knownBlocks.add(block);
    }
    
    @Override
    protected Iterable<Block> getKnownBlocks() {
        
        return knownBlocks;
    }
    
    protected LootTable.Builder createBookStack(Block block) {
        return LootTable.lootTable()
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(
                                        this.applyExplosionDecay(
                                                block,
                                                LootItem.lootTableItem(block)
                                                        .apply(
                                                                List.of(2, 3, 4),
                                                                num -> SetItemCountFunction.setCount(ConstantValue.exactly((float) num))
                                                                        .when(
                                                                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                                                        .setProperties(
                                                                                                StatePropertiesPredicate.Builder.properties().hasProperty(BookStackBlock.BOOKS, num)
                                                                                        )
                                                                        )
                                                        )
                                        )
                                )
                );
    }
    
}

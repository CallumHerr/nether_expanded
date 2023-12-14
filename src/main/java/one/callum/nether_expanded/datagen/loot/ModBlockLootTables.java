package one.callum.nether_expanded.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.worldgen.VillagePools;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import one.callum.nether_expanded.block.ModBlocks;
import one.callum.nether_expanded.item.ModItems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.add(ModBlocks.NETHER_IRON_ORE.get(),
                block -> createNetherOre(ModBlocks.NETHER_IRON_ORE, Items.IRON_NUGGET));
        this.add(ModBlocks.NETHER_COPPER_ORE.get(),
                block -> createNetherOre(ModBlocks.NETHER_COPPER_ORE, ModItems.COPPER_NUGGET.get()));
        this.dropSelf(ModBlocks.LAVA_CANE.get());

        Map<Block, Block> saplingMap = new HashMap<>(){{
           put(Blocks.ACACIA_LEAVES, Blocks.ACACIA_SAPLING);
           put(Blocks.SPRUCE_LEAVES, Blocks.SPRUCE_SAPLING);
           put(Blocks.OAK_LEAVES, Blocks.OAK_SAPLING);
           put(Blocks.BIRCH_LEAVES, Blocks.BIRCH_SAPLING);
           put(Blocks.MANGROVE_LEAVES, Blocks.MANGROVE_PROPAGULE);
           put(Blocks.JUNGLE_LEAVES, Blocks.JUNGLE_SAPLING);
           put(Blocks.CHERRY_LEAVES, Blocks.CHERRY_SAPLING);
           put(Blocks.FLOWERING_AZALEA_LEAVES, Blocks.FLOWERING_AZALEA);
           put(Blocks.DARK_OAK_LEAVES, Blocks.DARK_OAK_SAPLING);
           put(Blocks.AZALEA_LEAVES, Blocks.AZALEA);
        }};

        ModBlocks.WAXED_BLOCKS.entrySet().forEach(entry -> {
            if (entry.getKey().getName().toString().contains("leaves")) {
                this.dropWhenSilkTouch(entry.getValue().get());
                this.createLeavesDrops(entry.getValue().get(), saplingMap.get(entry.getKey()), NORMAL_LEAVES_SAPLING_CHANCES);
            } else if (entry.getKey().getName().toString().contains("_door")) {
                this.add(entry.getValue().get(), this::createDoorTable);
            } else this.dropSelf(entry.getValue().get());
        });

        this.add(ModBlocks.NETHER_ANCIENT_CACHE.get(),
                block -> LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0f, 2.0f))
                        .add(LootItem.lootTableItem(Items.NETHERITE_INGOT)
                                .setWeight(1).apply(SetItemCountFunction.setCount(
                                        ConstantValue.exactly(1.0f))
                                ))
                        .add(LootItem.lootTableItem(Items.NETHERITE_SCRAP)
                                .setWeight(5).apply(SetItemCountFunction.setCount(
                                        UniformGenerator.between(1.0f, 4.0f))
                                ))
                        .add(LootItem.lootTableItem(Items.GOLD_INGOT)
                                .setWeight(25).apply(SetItemCountFunction.setCount(
                                        UniformGenerator.between(1.0f, 10.0f))
                                ))
                        .add(LootItem.lootTableItem(Items.COPPER_INGOT)
                                .setWeight(15).apply(SetItemCountFunction.setCount(
                                        UniformGenerator.between(1.0f, 4.0f)
                                )))
                        .add(LootItem.lootTableItem(Items.DIAMOND)
                                .setWeight(5).apply(SetItemCountFunction.setCount(
                                        UniformGenerator.between(2, 7)
                                )))
                        .add(LootItem.lootTableItem(ModItems.GOLD_ALLOY_SWORD.get())
                                .setWeight(5)
                                .apply(EnchantWithLevelsFunction
                                        .enchantWithLevels(UniformGenerator.between(25f, 40f))
                                        .allowTreasure()))
                        .add(LootItem.lootTableItem(ModItems.GOLD_ALLOY_PICKAXE.get())
                                .setWeight(5)
                                .apply(EnchantWithLevelsFunction
                                        .enchantWithLevels(UniformGenerator.between(25f, 40f))
                                        .allowTreasure()))
                        .add(LootItem.lootTableItem(ModItems.GOLD_ALLOY_CHESTPLATE.get())
                                .setWeight(5)
                                .apply(EnchantWithLevelsFunction
                                        .enchantWithLevels(UniformGenerator.between(25f, 40f))
                                        .allowTreasure()))
                        .add(LootItem.lootTableItem(ModItems.GOLD_ALLOY_LEGGINGS.get())
                                .setWeight(5)
                                .apply(EnchantWithLevelsFunction
                                        .enchantWithLevels(UniformGenerator.between(25f, 40f))
                                        .allowTreasure()))
                        .add(LootItem.lootTableItem(ModItems.GOLD_ALLOY_BOOTS.get())
                                .setWeight(5)
                                .apply(EnchantWithLevelsFunction
                                        .enchantWithLevels(UniformGenerator.between(25f, 40f))
                                        .allowTreasure()))
                        .add(LootItem.lootTableItem(ModItems.GOLD_ALLOY_HELMET.get())
                                .setWeight(5)
                                .apply(EnchantWithLevelsFunction
                                        .enchantWithLevels(UniformGenerator.between(25f, 40f))
                                        .allowTreasure()))));
    }

    private LootTable.Builder createNetherOre(RegistryObject<Block> block, Item item) {
        return createSilkTouchDispatchTable(block.get(),
                this.applyExplosionDecay(block.get(),
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 6.0f)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

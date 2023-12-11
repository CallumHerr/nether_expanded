package one.callum.nether_expanded.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import one.callum.nether_expanded.datagen.loot.ModBlockLootTables;
import one.callum.nether_expanded.datagen.loot.ModEntityLootTables;

import java.util.List;
import java.util.Set;

public class ModLootTablesProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(ModEntityLootTables::new, LootContextParamSets.ENTITY)
        ));
    }
}
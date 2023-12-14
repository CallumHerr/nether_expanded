package one.callum.nether_expanded.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.entity.ModEntities;
import one.callum.nether_expanded.util.ModTags;

import java.util.List;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_NETHER_COPPER_ORE =
            registerKey("add_nether_copper_ore");

    public static final ResourceKey<BiomeModifier> ADD_NETHER_IRON_ORE =
            registerKey("add_nether_iron_ore");

    public static final ResourceKey<BiomeModifier> ADD_NETHER_ANCIENT_CACHE =
            registerKey("add_nether_ancient_cache");

    public static final ResourceKey<BiomeModifier> NETHER_COW_SPAWN =
            registerKey("nether_cow_spawn");

    public static final ResourceKey<BiomeModifier> ADD_LAVA_CANE =
            registerKey("add_lava_cane");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(NETHER_COW_SPAWN, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(ModTags.Biomes.NETHER_FORESTS),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.NETHER_COW.get(),
                        50,
                        2,
                        4))
        ));

        context.register(ADD_LAVA_CANE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LAVA_CANE_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_NETHER_COPPER_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_COPPER_ORE_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_NETHER_IRON_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_IRON_ORE_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_NETHER_ANCIENT_CACHE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_ANCIENT_CACHE_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
                new ResourceLocation(NetherExpanded.MODID, name));
    }
}

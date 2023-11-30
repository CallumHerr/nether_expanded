package one.callum.nether_expanded.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import one.callum.nether_expanded.NetherExpanded;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_NETHER_COPPER_ORE =
            registerKey("add_nether_copper_ore");

    public static final ResourceKey<BiomeModifier> ADD_NETHER_IRON_ORE =
            registerKey("add_nether_iron_ore");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_NETHER_COPPER_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_COPPER_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_DECORATION
        ));

        context.register(ADD_NETHER_IRON_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_IRON_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_DECORATION
        ));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
                new ResourceLocation(NetherExpanded.MODID, name));
    }
}

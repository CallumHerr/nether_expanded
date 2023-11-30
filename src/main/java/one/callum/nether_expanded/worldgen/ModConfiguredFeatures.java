package one.callum.nether_expanded.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.block.ModBlocks;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_COPPER_ORE = registerKey("nether_copper_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_IRON_ORE = registerKey("nether_iron_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);

        register(context, NETHER_COPPER_ORE, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.NETHER_COPPER_ORE.get().defaultBlockState(),
                9));

        register(context, NETHER_IRON_ORE, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.NETHER_IRON_ORE.get().defaultBlockState(),
                9));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(NetherExpanded.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>>
        void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                      ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {

        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}

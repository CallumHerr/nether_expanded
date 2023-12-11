package one.callum.nether_expanded.worldgen;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.Tags;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.block.ModBlocks;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_COPPER_ORE =
            registerKey("nether_copper_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_IRON_ORE =
            registerKey("nether_iron_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_ANCIENT_CACHE =
            registerKey("nether_ancient_cache");

    public static final ResourceKey<ConfiguredFeature<?, ?>> LAVA_CANE =
            registerKey("lava_cane");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest netherrackTest = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest netherBaseStoneTest = new TagMatchTest(BlockTags.BASE_STONE_NETHER);

        register(context, LAVA_CANE, ModFeatures.LAVA_CANE.get(),
                new NetherForestVegetationConfig(new WeightedStateProvider(
                        SimpleWeightedRandomList.<BlockState>builder()
                                .add(ModBlocks.LAVA_CANE.get().defaultBlockState(), 100)),
                        3, 1));

        register(context, NETHER_COPPER_ORE, Feature.ORE, new OreConfiguration(netherrackTest,
                ModBlocks.NETHER_COPPER_ORE.get().defaultBlockState(),
                9));

        register(context, NETHER_IRON_ORE, Feature.ORE, new OreConfiguration(netherrackTest,
                ModBlocks.NETHER_IRON_ORE.get().defaultBlockState(),
                9));

        register(context, NETHER_ANCIENT_CACHE, Feature.SCATTERED_ORE, new OreConfiguration(netherBaseStoneTest,
                ModBlocks.NETHER_ANCIENT_CACHE.get().defaultBlockState(), 1, 1.0f));
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

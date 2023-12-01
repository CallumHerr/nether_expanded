package one.callum.nether_expanded.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import one.callum.nether_expanded.NetherExpanded;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> NETHER_COPPER_ORE_PLACED =
            registerKey("nether_copper_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_IRON_ORE_PLACED =
            registerKey("nether_iron_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_ANCIENT_CACHE_PLACED =
            registerKey("nether_ancient_cache_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, NETHER_COPPER_ORE_PLACED,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_COPPER_ORE),
                ModOrePlacement.commonOrePlacement(12,
                        PlacementUtils.RANGE_10_10));

        register(context, NETHER_IRON_ORE_PLACED,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_IRON_ORE),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(8),
                                VerticalAnchor.absolute(50))));

        register(context, NETHER_ANCIENT_CACHE_PLACED,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_ANCIENT_CACHE),
                ModOrePlacement.rareOrePlacement(5,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(8),
                                VerticalAnchor.absolute(24))));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE,
                new ResourceLocation(NetherExpanded.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}

package one.callum.nether_expanded.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import one.callum.nether_expanded.NetherExpanded;

import java.util.List;

public class ModToolTiers {
    public static final Tier GOLD_ALLOY = TierSortingRegistry.registerTier(
            new ForgeTier(1, 250, 12f, 0, 22,
                    BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.GOLD_INGOT)),
                    new ResourceLocation(NetherExpanded.MODID, "gold_alloy_tier"),
                    List.of(Tiers.STONE), List.of(Tiers.IRON)
            );

}

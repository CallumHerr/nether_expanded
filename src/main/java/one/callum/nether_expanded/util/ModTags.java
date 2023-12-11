package one.callum.nether_expanded.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import one.callum.nether_expanded.NetherExpanded;

import javax.swing.text.html.HTML;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> SOUL_FLAME_BLOCKS = newTag("soul_flame_blocks");
        public static final TagKey<Block> LAVA_CANE_BLOCKS = newTag("lava_cane_blocks");

        private static TagKey<Block> newTag(String name) {
            return BlockTags.create(new ResourceLocation(NetherExpanded.MODID, name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> NETHER_FORESTS = newTag("nether_forests");

        private static TagKey<Biome> newTag(String name) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(NetherExpanded.MODID, name));
        }
    }
}

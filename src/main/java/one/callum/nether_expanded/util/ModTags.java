package one.callum.nether_expanded.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import one.callum.nether_expanded.NetherExpanded;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> SOUL_FLAME_BLOCKS = tag("soul_flame_blocks");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(NetherExpanded.MODID, name));
        }
    }
}

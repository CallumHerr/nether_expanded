package one.callum.nether_expanded.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.block.ModBlocks;
import one.callum.nether_expanded.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NetherExpanded.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.SOUL_FLAME_BLOCKS)
                .add(Blocks.SOUL_TORCH,
                        Blocks.SOUL_WALL_TORCH,
                        Blocks.SOUL_LANTERN);

        this.tag(ModTags.Blocks.LAVA_CANE_BLOCKS)
                .add(Blocks.MAGMA_BLOCK)
                .addTags(BlockTags.SOUL_SPEED_BLOCKS,
                        BlockTags.NYLIUM);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.NETHER_ANCIENT_CACHE.get(),
                        ModBlocks.NETHER_IRON_ORE.get(),
                        ModBlocks.NETHER_COPPER_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NETHER_ANCIENT_CACHE.get());

        this.tag(Tags.Blocks.ORES_IN_GROUND_NETHERRACK)
                .add(ModBlocks.NETHER_IRON_ORE.get(),
                        ModBlocks.NETHER_COPPER_ORE.get());

        this.tag(BlockTags.COPPER_ORES)
                .add(ModBlocks.NETHER_COPPER_ORE.get());

        this.tag(BlockTags.IRON_ORES)
                        .add(ModBlocks.NETHER_IRON_ORE.get());

        ModBlocks.WAXED_BLOCKS.values().forEach(value -> {
            String key = value.getKey().toString();
            if (key.contains("stairs")) {
                this.tag(BlockTags.STAIRS).add(value.get());
                this.tag(BlockTags.WOODEN_STAIRS).add(value.get());
            } else if (key.contains("planks")) {
                this.tag(BlockTags.PLANKS).add(value.get());
            } else if (key.contains("wood") || key.contains("log")) {
                this.tag(BlockTags.LOGS).add(value.get());
            } else if (key.contains("carpet")) {
                this.tag(BlockTags.WOOL_CARPETS).add(value.get());
            } else if (key.contains("wool")) {
                this.tag(BlockTags.WOOL).add(value.get());
            } else if (key.contains("leaves")) {
                this.tag(BlockTags.LEAVES).add(value.get());
                this.tag(BlockTags.MINEABLE_WITH_HOE).add(value.get());
            } else if (key.contains("trapdoor")) {
                this.tag(BlockTags.TRAPDOORS).add(value.get());
                this.tag(BlockTags.WOODEN_TRAPDOORS).add(value.get());
            } else if (key.contains("gate")) {
                this.tag(BlockTags.FENCE_GATES).add(value.get());
            } else if (key.contains("fence")) {
                this.tag(BlockTags.FENCES).add(value.get());
                this.tag(BlockTags.WOODEN_FENCES).add(value.get());
            } else if (key.contains("door")) {
                this.tag(BlockTags.DOORS).add(value.get());
                this.tag(BlockTags.WOODEN_DOORS).add(value.get());
            } else if (key.contains("slab")) {
                this.tag(BlockTags.SLABS).add(value.get());
                this.tag(BlockTags.WOODEN_SLABS).add(value.get());
            }
        });
    }
}

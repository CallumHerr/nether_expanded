package one.callum.nether_expanded.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.block.ModBlocks;
import one.callum.nether_expanded.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, NetherExpanded.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.PIGLIN_LOVED)
                .add(ModItems.COPPER_GOLD_ALLOY_ITEM.getKey());
        this.tag(ItemTags.IGNORED_BY_PIGLIN_BABIES)
                .add(ModItems.COPPER_GOLD_ALLOY_ITEM.get());

        this.tag(ItemTags.PICKAXES).add(ModItems.GOLD_ALLOY_PICKAXE.get());
        this.tag(ItemTags.SHOVELS).add(ModItems.GOLD_ALLOY_SHOVEL.get());
        this.tag(ItemTags.SWORDS).add(ModItems.GOLD_ALLOY_SWORD.get());
        this.tag(ItemTags.HOES).add(ModItems.GOLD_ALLOY_HOE.get());
        this.tag(ItemTags.AXES).add(ModItems.GOLD_ALLOY_AXE.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.GOLD_PLATED_HELMET.get(),
                        ModItems.GOLD_ALLOY_HELMET.get(),
                        ModItems.GOLD_ALLOY_CHESTPLATE.get(),
                        ModItems.GOLD_PLATED_CHESTPLATE.get(),
                        ModItems.GOLD_ALLOY_LEGGINGS.get(),
                        ModItems.GOLD_PLATED_LEGGINGS.get(),
                        ModItems.GOLD_PLATED_BOOTS.get(),
                        ModItems.GOLD_ALLOY_BOOTS.get());

        this.tag(ItemTags.COPPER_ORES)
                .add(ModBlocks.NETHER_COPPER_ORE.get().asItem());
        this.tag(ItemTags.IRON_ORES)
                .add(ModBlocks.NETHER_IRON_ORE.get().asItem());

        ModBlocks.WAXED_BLOCKS.values().forEach(entry -> {
            String name = entry.getId().getPath();
            Item item = entry.get().asItem();

            if (name.contains("planks")) {
                this.tag(ItemTags.NON_FLAMMABLE_WOOD).add(item);
                this.tag(ItemTags.PLANKS).add(item);
            } else if (name.contains("log") || name.contains("wood")) {
                this.tag(ItemTags.NON_FLAMMABLE_WOOD).add(item);
                this.tag(ItemTags.LOGS).add(item);
            } else if (name.contains("stairs")) {
                this.tag(ItemTags.NON_FLAMMABLE_WOOD).add(item);
                this.tag(ItemTags.STAIRS).add(item);
            } else if (name.contains("wool")) {
                this.tag(ItemTags.WOOL).add(item);
            } else if (name.contains("carpet")) {
                this.tag(ItemTags.WOOL_CARPETS).add(item);
            } else if (name.contains("leaves")) {
                this.tag(ItemTags.LEAVES).add(item);
            }
        });
    }
}

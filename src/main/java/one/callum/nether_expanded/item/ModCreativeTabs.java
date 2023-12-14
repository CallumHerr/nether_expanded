package one.callum.nether_expanded.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.block.ModBlocks;
import one.callum.nether_expanded.util.ModTags;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NetherExpanded.MODID);

    public static final RegistryObject<CreativeModeTab> WAXED_BLOCKS_TAB =
            CREATIVE_TABS.register("waxed_blocks",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LAVA_WAX.get()))
                            .title(Component.translatable("creativetab.waxed_items"))
                            .displayItems((params, output) -> {
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.OAK_LOG).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.OAK_WOOD).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.STRIPPED_OAK_LOG).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.STRIPPED_OAK_WOOD).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.OAK_STAIRS).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.OAK_SLAB).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.OAK_FENCE).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.OAK_FENCE_GATE).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.OAK_DOOR).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.OAK_TRAPDOOR).get());

                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.SPRUCE_LOG).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.SPRUCE_WOOD).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.STRIPPED_SPRUCE_LOG).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.STRIPPED_SPRUCE_WOOD).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.SPRUCE_STAIRS).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.SPRUCE_SLAB).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.SPRUCE_FENCE).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.SPRUCE_FENCE_GATE).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.SPRUCE_DOOR).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.SPRUCE_TRAPDOOR).get());

                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.BIRCH_LOG).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.BIRCH_WOOD).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.STRIPPED_BIRCH_LOG).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.STRIPPED_BIRCH_WOOD).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.BIRCH_STAIRS).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.BIRCH_SLAB).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.BIRCH_FENCE).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.BIRCH_FENCE_GATE).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.BIRCH_DOOR).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.BIRCH_TRAPDOOR).get());

                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.JUNGLE_LOG).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.JUNGLE_WOOD).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.STRIPPED_JUNGLE_LOG).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.STRIPPED_JUNGLE_WOOD).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.JUNGLE_STAIRS).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.JUNGLE_SLAB).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.JUNGLE_FENCE).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.JUNGLE_FENCE_GATE).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.JUNGLE_DOOR).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.JUNGLE_TRAPDOOR).get());

                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.ACACIA_LOG).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.ACACIA_WOOD).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.STRIPPED_ACACIA_LOG).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.STRIPPED_ACACIA_WOOD).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.ACACIA_STAIRS).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.ACACIA_SLAB).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.ACACIA_FENCE).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.ACACIA_FENCE_GATE).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.ACACIA_DOOR).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.ACACIA_TRAPDOOR).get());

                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.DARK_OAK_LOG).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.DARK_OAK_WOOD).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.STRIPPED_DARK_OAK_LOG).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.STRIPPED_DARK_OAK_WOOD).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.DARK_OAK_STAIRS).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.DARK_OAK_SLAB).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.DARK_OAK_FENCE).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.DARK_OAK_FENCE_GATE).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.DARK_OAK_DOOR).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.DARK_OAK_TRAPDOOR).get());

                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.MANGROVE_LOG).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.MANGROVE_WOOD).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.STRIPPED_MANGROVE_LOG).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.STRIPPED_MANGROVE_WOOD).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.MANGROVE_STAIRS).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.MANGROVE_SLAB).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.MANGROVE_FENCE).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.MANGROVE_FENCE_GATE).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.MANGROVE_DOOR).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.MANGROVE_TRAPDOOR).get());

                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.CHERRY_LOG).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.CHERRY_WOOD).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.STRIPPED_CHERRY_LOG).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.STRIPPED_CHERRY_WOOD).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.CHERRY_STAIRS).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.CHERRY_SLAB).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.CHERRY_FENCE).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.CHERRY_FENCE_GATE).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.CHERRY_DOOR).get());
                                output.accept(ModBlocks.WAXED_BLOCKS.get(Blocks.CHERRY_TRAPDOOR).get());
                            })
                            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}

package one.callum.nether_expanded.block;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.block.custom.WaxedBlock;
import one.callum.nether_expanded.block.custom.WaxedRotatableBlock;
import one.callum.nether_expanded.item.ModItems;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, NetherExpanded.MODID);

    //Ores
    public static final RegistryObject<Block> NETHER_COPPER_ORE = newBlock("nether_copper_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE)));
    public static final RegistryObject<Block> NETHER_IRON_ORE = newBlock("nether_iron_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE).explosionResistance(100f)));

//    public static final RegistryObject<Block> WAXED_OAK_LOG =
//            waxedWood(Blocks.OAK_LOG);
//    public static final RegistryObject<Block> WAXED_SPRUCE_LOG =
//            waxedWood(Blocks.SPRUCE_LOG);
//    public static final RegistryObject<Block> WAXED_BIRCH_LOG =
//            waxedWood(Blocks.BIRCH_LOG);
//    public static final RegistryObject<Block> WAXED_JUNGLE_LOG =
//            waxedWood(Blocks.JUNGLE_LOG);
//    public static final RegistryObject<Block> WAXED_ACACIA_LOG =
//            waxedWood(Blocks.ACACIA_LOG);
//    public static final RegistryObject<Block> WAXED_CHERRY_LOG =
//            waxedWood(Blocks.CHERRY_LOG);
//    public static final RegistryObject<Block> WAXED_DARK_OAK_LOG =
//            waxedWood(Blocks.DARK_OAK_LOG);
//    public static final RegistryObject<Block> WAXED_MANGROVE_LOG =
//            waxedWood(Blocks.MANGROVE_LOG);
//    public static final RegistryObject<Block> WAXED_STRIPPED_OAK_LOG =
//            waxedWood(Blocks.STRIPPED_OAK_LOG);
//    public static final RegistryObject<Block> WAXED_STRIPPED_SPRUCE_LOG =
//            waxedWood(Blocks.STRIPPED_SPRUCE_LOG);
//    public static final RegistryObject<Block> WAXED_STRIPPED_BIRCH_LOG =
//            waxedWood(Blocks.STRIPPED_BIRCH_LOG);
//    public static final RegistryObject<Block> WAXED_STRIPPED_JUNGLE_LOG =
//            waxedWood(Blocks.STRIPPED_JUNGLE_LOG);
//    public static final RegistryObject<Block> WAXED_STRIPPED_ACACIA_LOG =
//            waxedWood(Blocks.STRIPPED_ACACIA_LOG);
//    public static final RegistryObject<Block> WAXED_STRIPPED_CHERRY_LOG =
//            waxedWood(Blocks.STRIPPED_CHERRY_LOG);
//    public static final RegistryObject<Block> WAXED_STRIPPED_DARK_OAK_LOG =
//            waxedWood(Blocks.STRIPPED_DARK_OAK_LOG);
//    public static final RegistryObject<Block> WAXED_STRIPPED_MANGROVE_LOG =
//            waxedWood(Blocks.STRIPPED_MANGROVE_LOG);
//    public static final RegistryObject<Block> WAXED_OAK_WOOD =
//            waxedWood(Blocks.OAK_WOOD);
//    public static final RegistryObject<Block> WAXED_SPRUCE_WOOD =
//            waxedWood(Blocks.SPRUCE_WOOD);
//    public static final RegistryObject<Block> WAXED_BIRCH_WOOD =
//            waxedWood(Blocks.BIRCH_WOOD);
//    public static final RegistryObject<Block> WAXED_JUNGLE_WOOD =
//            waxedWood(Blocks.JUNGLE_WOOD);
//    public static final RegistryObject<Block> WAXED_ACACIA_WOOD =
//            waxedWood(Blocks.ACACIA_WOOD);
//    public static final RegistryObject<Block> WAXED_CHERRY_WOOD =
//            waxedWood(Blocks.CHERRY_WOOD);
//    public static final RegistryObject<Block> WAXED_DARK_OAK_WOOD =
//            waxedWood(Blocks.DARK_OAK_WOOD);
//    public static final RegistryObject<Block> WAXED_MANGROVE_WOOD =
//            waxedWood(Blocks.MANGROVE_WOOD);
//    public static final RegistryObject<Block> WAXED_STRIPPED_OAK_WOOD =
//            waxedWood(Blocks.STRIPPED_OAK_WOOD);
//    public static final RegistryObject<Block> WAXED_STRIPPED_SPRUCE_WOOD =
//            waxedWood(Blocks.STRIPPED_SPRUCE_WOOD);
//    public static final RegistryObject<Block> WAXED_STRIPPED_BIRCH_WOOD =
//            waxedWood(Blocks.STRIPPED_BIRCH_WOOD);
//    public static final RegistryObject<Block> WAXED_STRIPPED_JUNGLE_WOOD =
//            waxedWood(Blocks.STRIPPED_JUNGLE_WOOD);
//    public static final RegistryObject<Block> WAXED_STRIPPED_ACACIA_WOOD =
//            waxedWood(Blocks.STRIPPED_ACACIA_WOOD);
//    public static final RegistryObject<Block> WAXED_STRIPPED_CHERRY_WOOD =
//            waxedWood(Blocks.STRIPPED_CHERRY_WOOD);
//    public static final RegistryObject<Block> WAXED_STRIPPED_DARK_OAK_WOOD =
//            waxedWood(Blocks.STRIPPED_DARK_OAK_WOOD);
//    public static final RegistryObject<Block> WAXED_STRIPPED_MANGROVE_WOOD =
//            waxedWood(Blocks.STRIPPED_MANGROVE_WOOD);
//    public static final RegistryObject<Block> WAXED_WHITE_WOOL =
//            waxedWool(Blocks.WHITE_WOOL);
//    public static final RegistryObject<Block> WAXED_RED_WOOL =
//            waxedWool(Blocks.RED_WOOL);
//    public static final RegistryObject<Block> WAXED_BLUE_WOOL =
//            waxedWool(Blocks.BLUE_WOOL);
//    public static final RegistryObject<Block> WAXED_LIGHT_BLUE_WOOL =
//            waxedWool(Blocks.LIGHT_BLUE_WOOL);
//    public static final RegistryObject<Block> WAXED_CYAN_WOOL =
//            waxedWool(Blocks.CYAN_WOOL);
//    public static final RegistryObject<Block> WAXED_GREEN_WOOL =
//            waxedWool(Blocks.GREEN_WOOL);
//    public static final RegistryObject<Block> WAXED_LIME_WOOL =
//            waxedWool(Blocks.LIME_WOOL);
//    public static final RegistryObject<Block> WAXED_BLACK_WOOL =
//            waxedWool(Blocks.BLACK_WOOL);
//    public static final RegistryObject<Block> WAXED_BROWN_WOOL =
//            waxedWool(Blocks.BROWN_WOOL);
//    public static final RegistryObject<Block> WAXED_GRAY_WOOL =
//            waxedWool(Blocks.GRAY_WOOL);
//    public static final RegistryObject<Block> WAXED_LIGHT_GRAY_WOOL =
//            waxedWool(Blocks.LIGHT_GRAY_WOOL);
//    public static final RegistryObject<Block> WAXED_ORANGE_WOOL =
//            waxedWool(Blocks.ORANGE_WOOL);
//    public static final RegistryObject<Block> WAXED_PINK_WOOL =
//            waxedWool(Blocks.PINK_WOOL);
//    public static final RegistryObject<Block> WAXED_MAGENTA_WOOL =
//            waxedWool(Blocks.MAGENTA_WOOL);
//    public static final RegistryObject<Block> WAXED_PURPLE_WOOL =
//            waxedWool(Blocks.PURPLE_WOOL);
//    public static final RegistryObject<Block> WAXED_YELLOW_WOOL =
//            waxedWool(Blocks.YELLOW_WOOL);
//    public static final RegistryObject<Block> WAXED_OAK_PLANKS =
//        waxedPlank(Blocks.OAK_PLANKS, SoundType.WOOD);
//    public static final RegistryObject<Block> WAXED_SPRUCE_PLANKS =
//            waxedPlank(Blocks.SPRUCE_PLANKS, SoundType.WOOD);
//    public static final RegistryObject<Block> WAXED_BIRCH_PLANKS =
//            waxedPlank(Blocks.BIRCH_PLANKS, SoundType.WOOD);
//    public static final RegistryObject<Block> WAXED_JUNGLE_PLANKS =
//            waxedPlank(Blocks.JUNGLE_PLANKS, SoundType.WOOD);
//    public static final RegistryObject<Block> WAXED_ACACIA_PLANKS =
//            waxedPlank(Blocks.ACACIA_PLANKS, SoundType.WOOD);
//    public static final RegistryObject<Block> WAXED_CHERRY_PLANKS =
//            waxedPlank(Blocks.CHERRY_PLANKS, SoundType.CHERRY_WOOD);
//    public static final RegistryObject<Block> WAXED_DARK_OAK_PLANKS =
//            waxedPlank(Blocks.DARK_OAK_PLANKS, SoundType.WOOD);
//    public static final RegistryObject<Block> WAXED_MANGROVE_PLANK =
//            waxedPlank(Blocks.MANGROVE_PLANKS, SoundType.WOOD);
    public static final Map<Block, RegistryObject<Block>> WAXED_BLOCKS = new HashMap<>(){{
        put(Blocks.WHITE_WOOL, waxedWool(Blocks.WHITE_WOOL));
        put(Blocks.RED_WOOL, waxedWool(Blocks.RED_WOOL));
        put(Blocks.BLUE_WOOL, waxedWool(Blocks.BLUE_WOOL));
        put(Blocks.LIGHT_BLUE_WOOL, waxedWool(Blocks.LIGHT_BLUE_WOOL));
        put(Blocks.CYAN_WOOL, waxedWool(Blocks.CYAN_WOOL));
        put(Blocks.GREEN_WOOL, waxedWool(Blocks.GREEN_WOOL));
        put(Blocks.LIME_WOOL, waxedWool(Blocks.LIME_WOOL));
        put(Blocks.BLACK_WOOL, waxedWool(Blocks.BLACK_WOOL));
        put(Blocks.BROWN_WOOL, waxedWool(Blocks.BROWN_WOOL));
        put(Blocks.GRAY_WOOL, waxedWool(Blocks.GRAY_WOOL));
        put(Blocks.LIGHT_GRAY_WOOL, waxedWool(Blocks.LIGHT_GRAY_WOOL));
        put(Blocks.ORANGE_WOOL, waxedWool(Blocks.ORANGE_WOOL));
        put(Blocks.PINK_WOOL, waxedWool(Blocks.PINK_WOOL));
        put(Blocks.MAGENTA_WOOL, waxedWool(Blocks.MAGENTA_WOOL));
        put(Blocks.PURPLE_WOOL, waxedWool(Blocks.PURPLE_WOOL));
        put(Blocks.YELLOW_WOOL, waxedWool(Blocks.YELLOW_WOOL));
        put(Blocks.OAK_PLANKS, waxedPlank(Blocks.OAK_PLANKS));
        put(Blocks.SPRUCE_PLANKS, waxedPlank(Blocks.SPRUCE_PLANKS));
        put(Blocks.BIRCH_PLANKS, waxedPlank(Blocks.BIRCH_PLANKS));
        put(Blocks.JUNGLE_PLANKS, waxedPlank(Blocks.JUNGLE_PLANKS));
        put(Blocks.ACACIA_PLANKS, waxedPlank(Blocks.ACACIA_PLANKS));
        put(Blocks.CHERRY_PLANKS, waxedBlock(Blocks.CHERRY_PLANKS, 2.0f, 3.0f, SoundType.CHERRY_WOOD));
        put(Blocks.DARK_OAK_PLANKS, waxedPlank(Blocks.DARK_OAK_PLANKS));
        put(Blocks.MANGROVE_PLANKS, waxedPlank(Blocks.MANGROVE_PLANKS));
        put(Blocks.OAK_LOG, waxedWood(Blocks.OAK_LOG));
        put(Blocks.SPRUCE_LOG, waxedWood(Blocks.SPRUCE_LOG));
        put(Blocks.BIRCH_LOG, waxedWood(Blocks.BIRCH_LOG));
        put(Blocks.JUNGLE_LOG, waxedWood(Blocks.JUNGLE_LOG));
        put(Blocks.ACACIA_LOG, waxedWood(Blocks.ACACIA_LOG));
        put(Blocks.CHERRY_LOG, waxedWood(Blocks.CHERRY_LOG));
        put(Blocks.DARK_OAK_LOG, waxedWood(Blocks.DARK_OAK_LOG));
        put(Blocks.MANGROVE_LOG, waxedWood(Blocks.MANGROVE_LOG));
        put(Blocks.STRIPPED_OAK_LOG, waxedWood(Blocks.STRIPPED_OAK_LOG));
        put(Blocks.STRIPPED_SPRUCE_LOG, waxedWood(Blocks.STRIPPED_SPRUCE_LOG));
        put(Blocks.STRIPPED_BIRCH_LOG, waxedWood(Blocks.STRIPPED_BIRCH_LOG));
        put(Blocks.STRIPPED_JUNGLE_LOG, waxedWood(Blocks.STRIPPED_JUNGLE_LOG));
        put(Blocks.STRIPPED_ACACIA_LOG, waxedWood(Blocks.STRIPPED_ACACIA_LOG));
        put(Blocks.STRIPPED_CHERRY_LOG, waxedWood(Blocks.STRIPPED_CHERRY_LOG));
        put(Blocks.STRIPPED_DARK_OAK_LOG, waxedWood(Blocks.STRIPPED_DARK_OAK_LOG));
        put(Blocks.STRIPPED_MANGROVE_LOG, waxedWood(Blocks.STRIPPED_MANGROVE_LOG));
        put(Blocks.OAK_WOOD, waxedWood(Blocks.OAK_WOOD));
        put(Blocks.SPRUCE_WOOD, waxedWood(Blocks.SPRUCE_WOOD));
        put(Blocks.BIRCH_WOOD, waxedWood(Blocks.BIRCH_WOOD));
        put(Blocks.JUNGLE_WOOD, waxedWood(Blocks.JUNGLE_WOOD));
        put(Blocks.ACACIA_WOOD, waxedWood(Blocks.ACACIA_WOOD));
        put(Blocks.CHERRY_WOOD, waxedWood(Blocks.CHERRY_WOOD));
        put(Blocks.DARK_OAK_WOOD, waxedWood(Blocks.DARK_OAK_WOOD));
        put(Blocks.MANGROVE_WOOD, waxedWood(Blocks.MANGROVE_WOOD));
        put(Blocks.STRIPPED_OAK_WOOD, waxedWood(Blocks.STRIPPED_OAK_WOOD));
        put(Blocks.STRIPPED_SPRUCE_WOOD, waxedWood(Blocks.STRIPPED_SPRUCE_WOOD));
        put(Blocks.STRIPPED_BIRCH_WOOD, waxedWood(Blocks.STRIPPED_BIRCH_WOOD));
        put(Blocks.STRIPPED_JUNGLE_WOOD, waxedWood(Blocks.STRIPPED_JUNGLE_WOOD));
        put(Blocks.STRIPPED_ACACIA_WOOD, waxedWood(Blocks.STRIPPED_ACACIA_WOOD));
        put(Blocks.STRIPPED_CHERRY_WOOD, waxedWood(Blocks.STRIPPED_CHERRY_WOOD));
        put(Blocks.STRIPPED_DARK_OAK_WOOD, waxedWood(Blocks.STRIPPED_DARK_OAK_WOOD));
        put(Blocks.STRIPPED_MANGROVE_WOOD, waxedWood(Blocks.STRIPPED_MANGROVE_WOOD));
    }};

    private static RegistryObject<Block> waxedWood(Block block) {
        ResourceLocation key = ForgeRegistries.BLOCKS.getKey(block);
        return newBlock("waxed_" + key.getPath(), () -> new WaxedRotatableBlock(block));
    }

    private static RegistryObject<Block> waxedPlank(Block block) {
        return waxedBlock(block, 2.0f, 3.0f, SoundType.WOOD);
    }

    private static RegistryObject<Block> waxedWool(Block block) {
        return waxedBlock(block, 0.8f, 0f, SoundType.WOOL);
    }

    private static RegistryObject<Block> waxedBlock(Block block, float strength, float expResist, SoundType sound) {
        ResourceLocation key = ForgeRegistries.BLOCKS.getKey(block);
        return newBlock("waxed_" + key.getPath(), () -> new WaxedBlock(block, strength, expResist, sound));
    }

    private static <T extends Block> RegistryObject<T> newBlock(String name, Supplier<T> blockInfo) {
        RegistryObject<T> block = BLOCKS.register(name, blockInfo);
        newBlockItem(name, block);
        return block;
    }

    private static <T extends Block> void newBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

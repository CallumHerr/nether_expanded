package one.callum.nether_expanded.block;

import net.minecraft.client.animation.definitions.FrogAnimation;
import net.minecraft.client.model.PhantomModel;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.block.custom.*;
import one.callum.nether_expanded.item.ModItems;

import java.lang.ref.PhantomReference;
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
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE)));

    public static final RegistryObject<Block> NETHER_ANCIENT_CACHE = newBlock("nether_ancient_cache",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS)
                    .explosionResistance(1200)));

    /* Plants */
    public static final RegistryObject<Block> LAVA_CANE = BLOCKS.register("lava_cane",
            () -> new LavaCaneBlock(BlockBehaviour.Properties.copy(Blocks.SUGAR_CANE)));


    /* Waxed blocks*/
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
        put(Blocks.WHITE_CARPET, waxedWoolCarpet(Blocks.WHITE_CARPET, DyeColor.WHITE));
        put(Blocks.RED_CARPET, waxedWoolCarpet(Blocks.RED_CARPET, DyeColor.RED));
        put(Blocks.BLUE_CARPET, waxedWoolCarpet(Blocks.BLUE_CARPET, DyeColor.BLUE));
        put(Blocks.LIGHT_BLUE_CARPET, waxedWoolCarpet(Blocks.LIGHT_BLUE_CARPET, DyeColor.LIGHT_BLUE));
        put(Blocks.CYAN_CARPET, waxedWoolCarpet(Blocks.CYAN_CARPET, DyeColor.CYAN));
        put(Blocks.GREEN_CARPET, waxedWoolCarpet(Blocks.GREEN_CARPET, DyeColor.GREEN));
        put(Blocks.LIME_CARPET, waxedWoolCarpet(Blocks.LIME_CARPET, DyeColor.LIME));
        put(Blocks.BLACK_CARPET, waxedWoolCarpet(Blocks.BLACK_CARPET, DyeColor.BLACK));
        put(Blocks.BROWN_CARPET, waxedWoolCarpet(Blocks.BROWN_CARPET, DyeColor.BROWN));
        put(Blocks.GRAY_CARPET, waxedWoolCarpet(Blocks.GRAY_CARPET, DyeColor.GRAY));
        put(Blocks.LIGHT_GRAY_CARPET, waxedWoolCarpet(Blocks.LIGHT_GRAY_CARPET, DyeColor.LIGHT_GRAY));
        put(Blocks.ORANGE_CARPET, waxedWoolCarpet(Blocks.ORANGE_CARPET, DyeColor.ORANGE));
        put(Blocks.PINK_CARPET, waxedWoolCarpet(Blocks.PINK_CARPET, DyeColor.PINK));
        put(Blocks.MAGENTA_CARPET, waxedWoolCarpet(Blocks.MAGENTA_CARPET, DyeColor.MAGENTA));
        put(Blocks.PURPLE_CARPET, waxedWoolCarpet(Blocks.PURPLE_CARPET, DyeColor.PURPLE));
        put(Blocks.YELLOW_CARPET, waxedWoolCarpet(Blocks.YELLOW_CARPET, DyeColor.YELLOW));
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
        put(Blocks.OAK_STAIRS, waxedStair(Blocks.OAK_STAIRS));
        put(Blocks.SPRUCE_STAIRS, waxedStair(Blocks.SPRUCE_STAIRS));
        put(Blocks.BIRCH_STAIRS, waxedStair(Blocks.BIRCH_STAIRS));
        put(Blocks.JUNGLE_STAIRS, waxedStair(Blocks.JUNGLE_STAIRS));
        put(Blocks.ACACIA_STAIRS, waxedStair(Blocks.ACACIA_STAIRS));
        put(Blocks.CHERRY_STAIRS, waxedStair(Blocks.CHERRY_STAIRS));
        put(Blocks.DARK_OAK_STAIRS, waxedStair(Blocks.DARK_OAK_STAIRS));
        put(Blocks.MANGROVE_STAIRS, waxedStair(Blocks.MANGROVE_STAIRS));
        put(Blocks.ACACIA_LEAVES, waxedLeaves(Blocks.ACACIA_LEAVES));
        put(Blocks.AZALEA_LEAVES, waxedLeaves(Blocks.AZALEA_LEAVES));
        put(Blocks.BIRCH_LEAVES, waxedLeaves(Blocks.BIRCH_LEAVES));
        put(Blocks.CHERRY_LEAVES, waxedLeaves(Blocks.CHERRY_LEAVES));
        put(Blocks.DARK_OAK_LEAVES, waxedLeaves(Blocks.DARK_OAK_LEAVES));
        put(Blocks.FLOWERING_AZALEA_LEAVES, waxedLeaves(Blocks.FLOWERING_AZALEA_LEAVES));
        put(Blocks.JUNGLE_LEAVES, waxedLeaves(Blocks.JUNGLE_LEAVES));
        put(Blocks.MANGROVE_LEAVES, waxedLeaves(Blocks.MANGROVE_LEAVES));
        put(Blocks.OAK_LEAVES, waxedLeaves(Blocks.OAK_LEAVES));
        put(Blocks.SPRUCE_LEAVES, waxedLeaves(Blocks.SPRUCE_LEAVES));
        put(Blocks.BOOKSHELF, waxedBlock(Blocks.BOOKSHELF, 1.5f, 0f, SoundType.WOOD));
    }};

    private static RegistryObject<Block> waxedWood(Block block) {
        ResourceLocation key = ForgeRegistries.BLOCKS.getKey(block);
        return newBlock("waxed_" + key.getPath(), () -> new WaxedRotatableBlock(block));
    }

    private static RegistryObject<Block> waxedLeaves(Block block) {
        ResourceLocation key = ForgeRegistries.BLOCKS.getKey(block);
        return newBlock("waxed_" + key.getPath(), () -> new WaxedLeavesBlock(block));
    }

    private static RegistryObject<Block> waxedStair(Block block) {
        ResourceLocation key = ForgeRegistries.BLOCKS.getKey(block);
        return newBlock("waxed_" + key.getPath(), () -> new WaxedStairBlock(block));
    }

    private static RegistryObject<Block> waxedPlank(Block block) {
        return waxedBlock(block, 2.0f, 3.0f, SoundType.WOOD);
    }

    private static RegistryObject<Block> waxedWoolCarpet(Block block, DyeColor color) {
        ResourceLocation key = ForgeRegistries.BLOCKS.getKey(block);
        return newBlock("waxed_" + key.getPath(), () -> new WaxedWoolCarpetBlock(block, color));
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

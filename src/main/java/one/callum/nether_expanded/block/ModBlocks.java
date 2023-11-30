package one.callum.nether_expanded.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.block.custom.WaxedRotatableBlock;
import one.callum.nether_expanded.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, NetherExpanded.MODID);

    //Ores
    public static final RegistryObject<Block> NETHER_COPPER_ORE = newBlock("nether_copper_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE)));
    public static final RegistryObject<Block> NETHER_IRON_ORE = newBlock("nether_iron_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE).explosionResistance(100f)));

    //Waxed woods
//    public static final RegistryObject<Block> WAXED_OAK_WOOD = newBlock("waxed_oak_wood",
//            () -> new WaxedRotatableBlock(Blocks.OAK_WOOD));
//    public static final RegistryObject<Block> WAXED_SPRUCE_WOOD = newBlock("waxed_spruce_wood",
//            () -> new WaxedRotatableBlock(Blocks.SPRUCE_WOOD));

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

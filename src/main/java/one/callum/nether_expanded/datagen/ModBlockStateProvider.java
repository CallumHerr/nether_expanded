package one.callum.nether_expanded.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NetherExpanded.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.NETHER_COPPER_ORE);
        blockWithItem(ModBlocks.NETHER_IRON_ORE);
//        logBlockFromVanilla(ModBlocks.WAXED_OAK_WOOD, Blocks.OAK_WOOD);
//        logBlockFromVanilla(ModBlocks.WAXED_SPRUCE_WOOD, Blocks.SPRUCE_WOOD);
    }

    private void blockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }

    private void logBlockFromVanilla(RegistryObject<Block> block, Block vanillaBlock) {
        axisBlock((RotatedPillarBlock) block.get(), blockTexture(vanillaBlock), extend(blockTexture(vanillaBlock), "_top"));
    }
}

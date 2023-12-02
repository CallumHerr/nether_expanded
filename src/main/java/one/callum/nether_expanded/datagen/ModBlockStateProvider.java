package one.callum.nether_expanded.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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

        ModBlocks.WAXED_BLOCKS.forEach((key, value) -> {
            String name = key.getName().toString();
            if (name.contains("log")) {
                logBlockFromVanilla(value, key);
            } else if (name.contains("wood")) {
                axisBlockFromVanilla(value, key);
            } else if (name.contains("stair")) {
                stairBlockFromVanilla(value, key);
            } else {
                blockWithItemVanilla(value, key);
            }
        });
    }

    private void blockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    private void blockWithItemVanilla(RegistryObject<Block> block, Block vanillaBlock) {
        simpleBlockWithItem(block.get(), cubeAll(vanillaBlock));
    }

    private void stairBlockFromVanilla(RegistryObject<Block> block, Block vanillaBlock) {
        ResourceLocation rl = ForgeRegistries.BLOCKS.getKey(vanillaBlock);
        ResourceLocation texture = new ResourceLocation(rl.getNamespace(),
                "block/" + rl.getPath().replace("stairs", "planks"));

        stairsBlock((StairBlock) block.get(), texture);
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(blockTexture(vanillaBlock)));
    }


    private ResourceLocation extend(ResourceLocation rl) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + "_top");
    }

    private void logBlockFromVanilla(RegistryObject<Block> block, Block vanillaBlock) {
        axisBlock((RotatedPillarBlock) block.get(), blockTexture(vanillaBlock), extend(blockTexture(vanillaBlock)));
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(blockTexture(vanillaBlock)));
    }

    private void axisBlockFromVanilla(RegistryObject<Block> block, Block vanillaBlock) {
        ResourceLocation rl = ForgeRegistries.BLOCKS.getKey(vanillaBlock);
        ResourceLocation texture = new ResourceLocation(rl.getNamespace(),
                "block/" + rl.getPath().replace("wood", "log"));

        axisBlock((RotatedPillarBlock) block.get(), texture, texture);
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(blockTexture(vanillaBlock)));
    }
}

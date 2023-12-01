package one.callum.nether_expanded.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.block.ModBlocks;
import one.callum.nether_expanded.block.custom.WaxedBlock;
import one.callum.nether_expanded.block.custom.WaxedRotatableBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NetherExpanded.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.NETHER_COPPER_ORE);
        blockWithItem(ModBlocks.NETHER_IRON_ORE);
        ModBlocks.WAXED_BLOCKS.entrySet().forEach((entry) -> {
            String name = entry.getKey().getName().toString();
            if (name.contains("log")) {
                logBlockFromVanilla(entry.getValue(), entry.getKey());
            } else if (name.contains("wood")) {
                axisBlockFromVanilla(entry.getValue(), entry.getKey());
            } else if (entry.getValue().get() instanceof WaxedBlock) {
                blockWithItemVanilla(entry.getValue(), entry.getKey());
            } else System.out.println(name);
        });
    }

    private void blockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    private void blockWithItemVanilla(RegistryObject<Block> block, Block vanillaBlock) {
        simpleBlockWithItem(block.get(), cubeAll(vanillaBlock));
    }

    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }

    private void logBlockFromVanilla(RegistryObject<Block> block, Block vanillaBlock) {
        axisBlock((RotatedPillarBlock) block.get(), blockTexture(vanillaBlock), extend(blockTexture(vanillaBlock), "_top"));
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(blockTexture(vanillaBlock)));
    }

    private void axisBlockFromVanilla(RegistryObject<Block> block, Block vanillaBlock) {
        ResourceLocation rl = ForgeRegistries.BLOCKS.getKey(vanillaBlock);
        ResourceLocation texture = new ResourceLocation(rl.getNamespace(),
                "block/" + rl.getPath().replace("wood", "log"));
        axisBlock((RotatedPillarBlock) block.get(), texture, texture);
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(texture));
    }
}

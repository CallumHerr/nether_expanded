package one.callum.nether_expanded.datagen;

import com.google.gson.JsonObject;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
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
        blockWithItem(ModBlocks.NETHER_ANCIENT_CACHE);
        cropBlock(ModBlocks.LAVA_CANE);


        ModBlocks.WAXED_BLOCKS.forEach((key, value) -> {
            String name = key.getName().toString();
            if (name.contains("log")) {
                logBlockFromVanilla(value, key);
            } else if (name.contains("wood")) {
                axisBlockFromVanilla(value, key);
            } else if (name.contains("stair")) {
                stairBlockFromVanilla(value, key);
            } else if (name.contains("carpet")) {
                carpetBlockFromVanilla(value, key);
            } else if (name.contains("leaves")) {
                leavesWithItemVanilla(value, key);
            }  else if (name.contains("wool") || name.contains("planks")) {
                blockWithItemVanilla(value, key);
            } else if (name.contains("trapdoor")) {
                trapDoorBlockFromVanilla(value, key);
            } else if (name.contains("gate")) {
                fenceGateFromVanilla(value, key);
            } else if (name.contains("fence")) {
                fenceBlockFromVanilla(value, key);
            } else if (name.contains("door")) {
                doorBlockFromVanilla(value, key);
            } else if (name.contains("slab")) {
                slabFromVanilla(value, key);
            }
        });
    }

    private void trapDoorBlockFromVanilla(RegistryObject<Block> block, Block vanillaBlock) {
        ResourceLocation rl = ForgeRegistries.BLOCKS.getKey(vanillaBlock);
        trapdoorBlockWithRenderType((TrapDoorBlock) block.get(),
                rl.toString(),
                new ResourceLocation(rl.getNamespace(), "block/" + rl.getPath()),
                true, "cutout");
    }

    private void slabFromVanilla(RegistryObject<Block> block, Block vanilla) {
        ResourceLocation rl = ForgeRegistries.BLOCKS.getKey(vanilla);
        ResourceLocation slabLoc = new ResourceLocation(
                rl.getNamespace(), "block/" + rl.getPath().replace("slab", "planks"));

        slabBlock((SlabBlock) block.get(), slabLoc, slabLoc);
    }

    private void fenceGateFromVanilla(RegistryObject<Block> block, Block vanillaBlock) {
        ResourceLocation rl = ForgeRegistries.BLOCKS.getKey(vanillaBlock);
        fenceGateBlock((FenceGateBlock) block.get(),
                rl.toString(),
                new ResourceLocation(rl.getNamespace(), "block/" + rl.getPath().replace("fence_gate", "planks")));
    }

    private void fenceBlockFromVanilla(RegistryObject<Block> block, Block vanillaBlock) {
        ResourceLocation rl = ForgeRegistries.BLOCKS.getKey(vanillaBlock);
        fenceBlock((FenceBlock) block.get(),
                rl.toString().replace("_fence", ""),
                new ResourceLocation(rl.getNamespace(), "block/" + rl.getPath().replace("fence", "planks")));
    }

    private void blockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    private void cropBlock(RegistryObject<Block> block) {
        simpleBlock(block.get(), models().withExistingParent(block.getId().getPath(),
                new ResourceLocation("block/tinted_cross")).texture("cross",
                new ResourceLocation(NetherExpanded.MODID, "block/" + block.getId().getPath()))
                .renderType("cutout"));
    }

    private void carpetBlockFromVanilla(RegistryObject<Block> block, Block vanillaBlock) {
        ResourceLocation rl = ForgeRegistries.BLOCKS.getKey(vanillaBlock);
        simpleBlockWithItem(block.get(), models().withExistingParent(block.getId().getPath(),
                new ResourceLocation("block/carpet")).texture("wool",
                new ResourceLocation(rl.getNamespace(),
                        "block/" + rl.getPath().replace("carpet", "wool"))
        ));
    }

    private void doorBlockFromVanilla(RegistryObject<Block> block, Block vanillaBlock) {
        ResourceLocation rl = ForgeRegistries.BLOCKS.getKey(vanillaBlock);
        String path = "block/" + rl.getPath();
        doorBlockWithRenderType((DoorBlock) block.get(),
                new ResourceLocation(rl.getNamespace(), path + "_bottom"),
                new ResourceLocation(rl.getNamespace(), path + "_top"), "cutout");
    }

    private void blockWithItemVanilla(RegistryObject<Block> block, Block vanillaBlock) {
        simpleBlockWithItem(block.get(), cubeAll(vanillaBlock));
    }

    private void leavesWithItemVanilla(RegistryObject<Block> block, Block vanillaBlock) {
        ResourceLocation rl = ForgeRegistries.BLOCKS.getKey(vanillaBlock);
        simpleBlockWithItem(block.get(), models().singleTexture(rl.getPath(),
                new ResourceLocation("block/leaves"),
                "all", new ResourceLocation(rl.getNamespace(), "block/" + rl.getPath()) ));
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

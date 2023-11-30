package one.callum.nether_expanded.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.item.ModItems;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NetherExpanded.MODID, existingFileHelper);
    }

    /**
     * Register the items that need json files created for them in data gen
     */
    @Override
    protected void registerModels() {
        simpleItem(ModItems.COPPER_GOLD_ALLOY_ITEM);

        simpleItem(ModItems.GOLD_ALLOY_HELMET);
        simpleItem(ModItems.GOLD_ALLOY_CHESTPLATE);
        simpleItem(ModItems.GOLD_ALLOY_LEGGINGS);
        simpleItem(ModItems.GOLD_ALLOY_BOOTS);

        basicTool(ModItems.GOLD_ALLOY_PICKAXE);
        basicTool(ModItems.GOLD_ALLOY_AXE);
        basicTool(ModItems.GOLD_ALLOY_SWORD);
        basicTool(ModItems.GOLD_ALLOY_SHOVEL);
        basicTool(ModItems.GOLD_ALLOY_HOE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(NetherExpanded.MODID,"item/" + item.getId().getPath()));
    }

    //Basic tool data gen
    private ItemModelBuilder basicTool(RegistryObject<Item> tool) {
        return withExistingParent(tool.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(NetherExpanded.MODID, "item/" + tool.getId().getPath()));
    }
}

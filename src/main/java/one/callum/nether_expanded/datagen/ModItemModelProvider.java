package one.callum.nether_expanded.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.entity.client.model.NetherCowModel;
import one.callum.nether_expanded.item.ModItems;

import java.util.LinkedHashMap;
import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NetherExpanded.MODID, existingFileHelper);
    }

    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1f);
        trimMaterials.put(TrimMaterials.IRON, 0.2f);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3f);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4f);
        trimMaterials.put(TrimMaterials.COPPER, 0.5f);
        trimMaterials.put(TrimMaterials.GOLD, 0.6f);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7f);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8f);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9f);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0f);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.COPPER_GOLD_ALLOY_ITEM);
        simpleItem(ModItems.COPPER_NUGGET);
        simpleItem(ModItems.GOLD_PLATING_SMITHING_TEMPLATE);
        simpleItem(ModItems.LAVA_CANE);

        trimmedArmorItem(ModItems.GOLD_ALLOY_HELMET, Items.GOLDEN_HELMET);
        trimmedArmorItem(ModItems.GOLD_ALLOY_CHESTPLATE, Items.GOLDEN_CHESTPLATE);
        trimmedArmorItem(ModItems.GOLD_ALLOY_LEGGINGS, Items.GOLDEN_LEGGINGS);
        trimmedArmorItem(ModItems.GOLD_ALLOY_BOOTS, Items.GOLDEN_BOOTS);

        trimmedArmorItem(ModItems.GOLD_PLATED_HELMET, Items.NETHERITE_HELMET);
        trimmedArmorItem(ModItems.GOLD_PLATED_CHESTPLATE, Items.NETHERITE_CHESTPLATE);
        trimmedArmorItem(ModItems.GOLD_PLATED_LEGGINGS, Items.NETHERITE_LEGGINGS);
        trimmedArmorItem(ModItems.GOLD_PLATED_BOOTS, Items.NETHERITE_BOOTS);

        basicTool(ModItems.GOLD_ALLOY_PICKAXE);
        basicTool(ModItems.GOLD_ALLOY_AXE);
        basicTool(ModItems.GOLD_ALLOY_SWORD);
        basicTool(ModItems.GOLD_ALLOY_SHOVEL);
        basicTool(ModItems.GOLD_ALLOY_HOE);
        basicTool(ModItems.LAVA_WAX);
    }


    /* Helper methods */
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(NetherExpanded.MODID,"item/" + item.getId().getPath()));
    }

    private void simpleItemFromVanilla(RegistryObject<Item> item, Item vanillaItem) {
        ResourceLocation itemLocal = ForgeRegistries.ITEMS.getKey(vanillaItem);
        withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(itemLocal.getNamespace(), "item/" + itemLocal.getPath()));
    }

    //Basic tool data gen
    private ItemModelBuilder basicTool(RegistryObject<Item> tool) {
        return withExistingParent(tool.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(NetherExpanded.MODID, "item/" + tool.getId().getPath()));
    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject, Item vanillaItem) {
        ResourceLocation vanillaRL = ForgeRegistries.ITEMS.getKey(vanillaItem);
        final String MOD_ID = NetherExpanded.MODID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(vanillaRL.getNamespace(),
                        "item/" + vanillaRL.getPath());
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(vanillaRL.getNamespace(),
                                        "item/" + vanillaRL.getPath()));
            });
        }
    }

}

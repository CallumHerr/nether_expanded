package one.callum.nether_expanded.item;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.block.ModBlocks;
import one.callum.nether_expanded.entity.ModEntities;
import one.callum.nether_expanded.item.custom.GoldAlloyArmorItem;
import one.callum.nether_expanded.item.custom.LavaWaxItem;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NetherExpanded.MODID);

    public static final RegistryObject<Item> COPPER_GOLD_ALLOY_ITEM = ITEMS.register("copper_gold_alloy",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LAVA_CANE = ITEMS.register("lava_cane",
            () -> new ItemNameBlockItem(ModBlocks.LAVA_CANE.get(), new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> GOLD_PLATING_SMITHING_TEMPLATE = ITEMS.register("gold_plating_smithing_template",
            () -> new SmithingTemplateItem(
                    Component.translatable(Util.makeDescriptionId("item",
                            new ResourceLocation(NetherExpanded.MODID,"smithing_template.gold_plated_upgrade.applies_to")))
                            .withStyle(ChatFormatting.BLUE),
                    Component.translatable(Util.makeDescriptionId("item",
                            new ResourceLocation(NetherExpanded.MODID,"smithing_template.gold_plated_upgrade.ingrediants")))
                            .withStyle(ChatFormatting.BLUE),
                    Component.translatable(Util.makeDescriptionId("upgrade",
                            new ResourceLocation(NetherExpanded.MODID,"gold_plated_upgrade")))
                            .withStyle(ChatFormatting.GRAY),
                    Component.translatable(Util.makeDescriptionId("item",
                            new ResourceLocation("smithing_template_netherite_upgrade.base_slot_description"))),
                    Component.translatable(Util.makeDescriptionId("item",
                            new ResourceLocation("smithing_template_netherite_upgrade.additions_slot_description"))),
                    List.of(new ResourceLocation("item/empty_armor_slot_helmet"),
                            new ResourceLocation("item/empty_armor_slot_chestplate"),
                            new ResourceLocation("item/empty_armor_slot_leggings"),
                            new ResourceLocation("item/empty_armor_slot_boots")),
                    List.of(new ResourceLocation("item/empty_slot_ingot"))
            ));

    public static final RegistryObject<Item> LAVA_WAX = ITEMS.register("lava_wax",
            () -> new LavaWaxItem(new Item.Properties()));

    public static final RegistryObject<Item> NETHER_COW_SPAWN_EGG = ITEMS.register("nether_cow_egg",
            () -> new ForgeSpawnEggItem(
                    ModEntities.NETHER_COW, 0x620802, 0xD25E16, new Item.Properties()
            ));

    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLD_ALLOY_HELMET = ITEMS.register("gold_alloy_helmet",
            () -> new GoldAlloyArmorItem(ArmorMaterials.IRON, ArmorItem.Type.HELMET));

    public static final RegistryObject<Item> GOLD_ALLOY_CHESTPLATE = ITEMS.register("gold_alloy_chestplate",
            () -> new GoldAlloyArmorItem(ArmorMaterials.IRON, ArmorItem.Type.CHESTPLATE));

    public static final RegistryObject<Item> GOLD_ALLOY_LEGGINGS = ITEMS.register("gold_alloy_leggings",
            () -> new GoldAlloyArmorItem(ArmorMaterials.IRON, ArmorItem.Type.LEGGINGS));

    public static final RegistryObject<Item> GOLD_ALLOY_BOOTS = ITEMS.register("gold_alloy_boots",
            () -> new GoldAlloyArmorItem(ArmorMaterials.IRON, ArmorItem.Type.BOOTS));

    public static final RegistryObject<Item> GOLD_PLATED_HELMET = ITEMS.register("gold_plated_helmet",
            () -> new GoldAlloyArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET));

    public static final RegistryObject<Item> GOLD_PLATED_CHESTPLATE = ITEMS.register("gold_plated_chestplate",
            () -> new GoldAlloyArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.CHESTPLATE));

    public static final RegistryObject<Item> GOLD_PLATED_LEGGINGS = ITEMS.register("gold_plated_leggings",
            () -> new GoldAlloyArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.LEGGINGS));

    public static final RegistryObject<Item> GOLD_PLATED_BOOTS = ITEMS.register("gold_plated_boots",
            () -> new GoldAlloyArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.BOOTS));

    public static final RegistryObject<Item> GOLD_ALLOY_PICKAXE = ITEMS.register("gold_alloy_pickaxe",
            () -> new PickaxeItem(ModToolTiers.GOLD_ALLOY,
                    1,
                    -2.8f,
                    new Item.Properties()
            ));

    public static final RegistryObject<Item> GOLD_ALLOY_SWORD = ITEMS.register("gold_alloy_sword",
            () -> new SwordItem(
                    ModToolTiers.GOLD_ALLOY, 3, -2.4f, new Item.Properties()
            ));

    public static final RegistryObject<Item> GOLD_ALLOY_AXE = ITEMS.register("gold_alloy_axe",
            () -> new AxeItem(
                    ModToolTiers.GOLD_ALLOY, 6, 3.1f, new Item.Properties()
            ));

    public static final RegistryObject<Item> GOLD_ALLOY_SHOVEL = ITEMS.register("gold_alloy_shovel",
            () -> new ShovelItem(
                    ModToolTiers.GOLD_ALLOY, 1.5f, -3.0f, new Item.Properties()
            ));

    public static final RegistryObject<Item> GOLD_ALLOY_HOE = ITEMS.register("gold_alloy_hoe",
            () -> new HoeItem(
                    ModToolTiers.GOLD_ALLOY, -2, 1.0f, new Item.Properties()
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

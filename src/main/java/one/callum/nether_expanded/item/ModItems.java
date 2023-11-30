package one.callum.nether_expanded.item;

import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.item.custom.GoldAlloyArmorItem;
import one.callum.nether_expanded.item.custom.LavaWaxItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NetherExpanded.MODID);

    public static final RegistryObject<Item> COPPER_GOLD_ALLOY_ITEM = ITEMS.register("copper_gold_alloy",
            () -> new Item(
                    new Item.Properties()
            ));

    public static final RegistryObject<Item> LAVA_WAX = ITEMS.register("lava_wax",
            () -> new LavaWaxItem(new Item.Properties()));

    public static final RegistryObject<Item> GOLD_ALLOY_HELMET = ITEMS.register("gold_alloy_helmet",
            () -> new ArmorItem(
                    ArmorMaterials.IRON, ArmorItem.Type.HELMET, new Item.Properties()
            ));

    public static final RegistryObject<Item> GOLD_ALLOY_CHESTPLATE = ITEMS.register("gold_alloy_chestplate",
            () -> new GoldAlloyArmorItem(
                    ArmorMaterials.IRON, ArmorItem.Type.CHESTPLATE, new Item.Properties()
            ));

    public static final RegistryObject<Item> GOLD_ALLOY_LEGGINGS = ITEMS.register("gold_alloy_leggings",
            () -> new GoldAlloyArmorItem(
                    ArmorMaterials.IRON, ArmorItem.Type.LEGGINGS, new Item.Properties()
            ));

    public static final RegistryObject<Item> GOLD_ALLOY_BOOTS = ITEMS.register("gold_alloy_boots",
            () -> new GoldAlloyArmorItem(ArmorMaterials.IRON,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties()
            ));

    public static final RegistryObject<Item> GOLD_ALLOY_PICKAXE = ITEMS.register("gold_alloy_pickaxe",
            () -> new PickaxeItem(ModToolTiers.GOLD_ALLOY,
                    1,
                    -2.8f,
                    new Item.Properties()
            ));

    public static final RegistryObject<Item> GOLD_ALLOY_SWORD = ITEMS.register("gold_alloy_sword",
            () -> new SwordItem(
                    ModToolTiers.GOLD_ALLOY, 1, 1, new Item.Properties()
            ));

    public static final RegistryObject<Item> GOLD_ALLOY_AXE = ITEMS.register("gold_alloy_axe",
            () -> new AxeItem(
                    ModToolTiers.GOLD_ALLOY, 1, 1, new Item.Properties()
            ));

    public static final RegistryObject<Item> GOLD_ALLOY_SHOVEL = ITEMS.register("gold_alloy_shovel",
            () -> new ShovelItem(
                    ModToolTiers.GOLD_ALLOY, 1, 1, new Item.Properties()
            ));

    public static final RegistryObject<Item> GOLD_ALLOY_HOE = ITEMS.register("gold_alloy_hoe",
            () -> new HoeItem(
                    ModToolTiers.GOLD_ALLOY, 1, 1, new Item.Properties()
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

package one.callum.nether_expanded;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.PhantomRenderer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import one.callum.nether_expanded.block.ModBlocks;
import one.callum.nether_expanded.entity.ModEntities;
import one.callum.nether_expanded.entity.client.renderer.NetherCowRenderer;
import one.callum.nether_expanded.entity.custom.NetherCow;
import one.callum.nether_expanded.item.ModCreativeTabs;
import one.callum.nether_expanded.item.ModItems;
import one.callum.nether_expanded.loot.ModLootModifiers;
import one.callum.nether_expanded.worldgen.ModFeatures;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NetherExpanded.MODID)
public class NetherExpanded {
    public static final String MODID = "nether_expanded";

    public NetherExpanded() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModFeatures.register(modEventBus);
        ModCreativeTabs.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey().equals(CreativeModeTabs.TOOLS_AND_UTILITIES)) {
            event.accept(ModItems.GOLD_ALLOY_PICKAXE);
            event.accept(ModItems.GOLD_ALLOY_AXE);
            event.accept(ModItems.GOLD_ALLOY_SHOVEL);
            event.accept(ModItems.GOLD_ALLOY_HOE);
            event.accept(ModItems.LAVA_WAX);
        } else if (event.getTabKey().equals(CreativeModeTabs.COMBAT)) {
            event.accept(ModItems.GOLD_ALLOY_SWORD);
            event.accept(ModItems.GOLD_ALLOY_HELMET);
            event.accept(ModItems.GOLD_ALLOY_CHESTPLATE);
            event.accept(ModItems.GOLD_ALLOY_LEGGINGS);
            event.accept(ModItems.GOLD_ALLOY_BOOTS);
            event.accept(ModItems.GOLD_PLATED_HELMET);
            event.accept(ModItems.GOLD_PLATED_CHESTPLATE);
            event.accept(ModItems.GOLD_PLATED_BOOTS);
            event.accept(ModItems.GOLD_PLATED_LEGGINGS);
        } else if (event.getTabKey().equals(CreativeModeTabs.INGREDIENTS)) {
            event.accept(ModItems.COPPER_GOLD_ALLOY_ITEM);
            event.accept(ModItems.COPPER_NUGGET);
            event.accept(ModItems.GOLD_PLATING_SMITHING_TEMPLATE);
        } else if (event.getTabKey().equals(CreativeModeTabs.NATURAL_BLOCKS)) {
            event.accept(ModItems.LAVA_CANE);
        } else if (event.getTabKey().equals(CreativeModeTabs.SPAWN_EGGS)) {
            event.accept(ModItems.NETHER_COW_SPAWN_EGG);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.NETHER_COW.get(), NetherCowRenderer::new);
        }
    }
}

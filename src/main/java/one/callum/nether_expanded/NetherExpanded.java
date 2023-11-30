package one.callum.nether_expanded;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
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
import one.callum.nether_expanded.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NetherExpanded.MODID)
public class NetherExpanded {
    public static final String MODID = "nether_expanded";
    private static final Logger LOGGER = LogUtils.getLogger();

    public NetherExpanded() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
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
        } else if (event.getTabKey().equals(CreativeModeTabs.COMBAT)) {
            event.accept(ModItems.GOLD_ALLOY_SWORD);
            event.accept(ModItems.GOLD_ALLOY_HELMET);
            event.accept(ModItems.GOLD_ALLOY_CHESTPLATE);
            event.accept(ModItems.GOLD_ALLOY_LEGGINGS);
            event.accept(ModItems.GOLD_ALLOY_BOOTS);
        } else if (event.getTabKey().equals(CreativeModeTabs.INGREDIENTS)) {
            event.accept(ModItems.COPPER_GOLD_ALLOY_ITEM);
        }
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}

package one.callum.nether_expanded.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import one.callum.nether_expanded.NetherExpanded;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = NetherExpanded.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        gen.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, helper));
        gen.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, helper));

        gen.addProvider(event.includeServer(), new ModWorldGenProvider(packOutput, lookupProvider));
        gen.addProvider(event.includeServer(), new ModBlockTagProvider(packOutput, lookupProvider, helper));
        gen.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
    }
}

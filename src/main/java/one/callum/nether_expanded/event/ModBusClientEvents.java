package one.callum.nether_expanded.event;

import net.minecraft.client.model.PhantomModel;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.block.ModBlocks;
import one.callum.nether_expanded.entity.client.ModModelLayers;
import one.callum.nether_expanded.entity.client.model.NetherCowModel;

@Mod.EventBusSubscriber(modid = NetherExpanded.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModBusClientEvents {

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register((state, blockAndTintGetter, pos, tintIndex) ->
                FoliageColor.getEvergreenColor(),
                ModBlocks.WAXED_BLOCKS.get(Blocks.SPRUCE_LEAVES).get());

        event.register((state, blockAndTintGetter, pos, tintIndex) ->
                FoliageColor.getBirchColor(),
                ModBlocks.WAXED_BLOCKS.get(Blocks.BIRCH_LEAVES).get());

        event.register((state, blockAndTintGetter, pos, tintIndex) ->
                blockAndTintGetter != null && pos != null ? BiomeColors.getAverageFoliageColor(blockAndTintGetter, pos) : FoliageColor.getDefaultColor(),
                ModBlocks.WAXED_BLOCKS.get(Blocks.OAK_LEAVES).get(),
                ModBlocks.WAXED_BLOCKS.get(Blocks.JUNGLE_LEAVES).get(),
                ModBlocks.WAXED_BLOCKS.get(Blocks.ACACIA_LEAVES).get(),
                ModBlocks.WAXED_BLOCKS.get(Blocks.DARK_OAK_LEAVES).get(),
                ModBlocks.WAXED_BLOCKS.get(Blocks.MANGROVE_LEAVES).get());
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.getItemColors().register((p_92687_, p_92688_) -> {
            BlockState blockstate = ((BlockItem)p_92687_.getItem()).getBlock().defaultBlockState();
            return event.getBlockColors().getColor(blockstate, (BlockAndTintGetter)null, (BlockPos)null, p_92688_);
        }, ModBlocks.WAXED_BLOCKS.get(Blocks.OAK_LEAVES).get(),
                ModBlocks.WAXED_BLOCKS.get(Blocks.SPRUCE_LEAVES).get(),
                ModBlocks.WAXED_BLOCKS.get(Blocks.BIRCH_LEAVES).get(),
                ModBlocks.WAXED_BLOCKS.get(Blocks.JUNGLE_LEAVES).get(),
                ModBlocks.WAXED_BLOCKS.get(Blocks.ACACIA_LEAVES).get(),
                ModBlocks.WAXED_BLOCKS.get(Blocks.DARK_OAK_LEAVES).get());

        event.getItemColors().register((p_92696_, p_92697_) -> {
            return FoliageColor.getMangroveColor();
        }, ModBlocks.WAXED_BLOCKS.get(Blocks.MANGROVE_LEAVES).get());
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.WARPED_COW, NetherCowModel::createBodyLayer);
    }
}

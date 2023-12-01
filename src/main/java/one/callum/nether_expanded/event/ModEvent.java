package one.callum.nether_expanded.event;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.block.custom.WaxedBlock;

//@Mod.EventBusSubscriber(modid = NetherExpanded.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
//public class ModEvent {

//    @SubscribeEvent
//    public static void blockSpawns(MobSpawnEvent.SpawnPlacementCheck event) {
//        for (int i = -4; i <= 4; i++) {
//            for (int j = -4; j <= 4; j++) {
//                BlockPos pos = new BlockPos(
//                        event.getPos().getX() + i,
//                        event.getPos().getY(),
//                        event.getPos().getZ() + j);
//
//                BlockState state = event.getLevel().getBlockState(pos);
//                if (state.getBlock() instanceof WaxedBlock) {
//                    System.out.println("waxed block at: " + pos);
//                }
//            }
//        }
//    }
//}

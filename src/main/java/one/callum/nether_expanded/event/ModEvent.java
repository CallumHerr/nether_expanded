package one.callum.nether_expanded.event;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.IModBusEvent;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.block.custom.WaxedBlock;
import one.callum.nether_expanded.util.ModTags;

@Mod.EventBusSubscriber(modid = NetherExpanded.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvent {

    @SubscribeEvent
    public static void blockSpawns(MobSpawnEvent.FinalizeSpawn event) {
        BlockPos spawnPos = new BlockPos((int) event.getX(), (int) event.getY(), (int) event.getZ());
        if (!event.getLevel().isAreaLoaded(spawnPos, 8)) return;

        for (int y = -1; y <= 4; y++) {
            for (int i = -4; i <= 4; i++) {
                for (int j = -4; j <= 4; j++) {
                    BlockPos pos = spawnPos.offset(i, y, j);

                    BlockState state = event.getLevel().getBlockState(pos);
                    if (state.is(ModTags.Blocks.SOUL_FLAME_BLOCKS)) {
                        System.out.println("Cancelled at: " + spawnPos);
                        event.setSpawnCancelled(true);
                        return;
                    }
                }
            }
        }
    }
}

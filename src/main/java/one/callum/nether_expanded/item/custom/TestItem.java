package one.callum.nether_expanded.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import one.callum.nether_expanded.block.custom.WaxedBlock;

public class TestItem extends Item {
    public TestItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        for (int y = -2; y <= 2; y++) {
            for (int i = -4; i <= 4; i++) {
                for (int j = -4; j <= 4; j++) {
                    BlockPos pos = new BlockPos(
                            pContext.getClickedPos().getX() + i,
                            pContext.getClickedPos().getY() + y,
                            pContext.getClickedPos().getZ() + j);

                    BlockState state = pContext.getLevel().getBlockState(pos);
                    if (state.getBlock() instanceof WaxedBlock) {
                        System.out.println("waxed block at: " + pos);
                    }
                }
            }
        }

        return super.useOn(pContext);
    }
}

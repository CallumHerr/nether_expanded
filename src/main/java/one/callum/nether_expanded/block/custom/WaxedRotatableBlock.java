package one.callum.nether_expanded.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolActions;

public class WaxedRotatableBlock extends RotatedPillarBlock {
    private final Block regularBlock;

    public WaxedRotatableBlock(Block regularBlock) {
        super(BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sound(SoundType.WOOD)
                .mapColor(regularBlock.defaultMapColor()));
        this.regularBlock = regularBlock;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);
        if (itemStack.canPerformAction(ToolActions.AXE_WAX_OFF)) {
            if (!pLevel.isClientSide()) {
                pLevel.setBlock(pPos, this.regularBlock.defaultBlockState(), 7);
                itemStack.hurtAndBreak(1, pPlayer, (e) -> e.broadcastBreakEvent(pHand));
                pLevel.gameEvent(pPlayer, GameEvent.BLOCK_CHANGE, pPos);
                pPlayer.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
            }

            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        } else {
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        }
    }
}

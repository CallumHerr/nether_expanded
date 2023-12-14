package one.callum.nether_expanded.block.custom.waxed;

import com.mojang.logging.LogUtils;
import com.sun.jdi.connect.spi.TransportService;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolActions;

public class WaxedDoorBlock extends DoorBlock {
    private final Block regularBlock;
    public WaxedDoorBlock(Block block, BlockSetType pType) {
        super(BlockBehaviour.Properties.of()
                .mapColor(block.defaultMapColor())
                .instrument(NoteBlockInstrument.BASS)
                .strength(3.0F).noOcclusion()
                .noOcclusion()
                .pushReaction(PushReaction.DESTROY), pType);
        this.regularBlock = block;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);
        if (itemStack.canPerformAction(ToolActions.AXE_WAX_OFF)) {
            if (!pLevel.isClientSide()) {
                WaxedDoorBlock.setBlock(pLevel, pPos, this.regularBlock.withPropertiesOf(pState));
                itemStack.hurtAndBreak(1, pPlayer, (e) -> e.broadcastBreakEvent(pHand));

                pLevel.gameEvent(pPlayer, GameEvent.BLOCK_CHANGE, pPos);
                pPlayer.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
            }
            ParticleUtils.spawnParticlesOnBlockFace(pLevel, pPos, ParticleTypes.WAX_OFF,
                    UniformInt.of(3, 5), pHit.getDirection(),
                    () -> WaxedBlock.getRandomSpeedRanges(pLevel.random), 0.55D);


            pLevel.playSound(pPlayer, pPos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        } else {
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        }
    }

    public static void setBlock(Level pLevel, BlockPos pPos, BlockState pState) {
        if (pLevel.getBlockState(pPos.above()).is(Blocks.AIR)) {
            pLevel.setBlock(pPos.below(),
                    Blocks.AIR.defaultBlockState(),
                    3);
            pLevel.setBlock(pPos.below(),
                    pState.setValue(HALF, DoubleBlockHalf.LOWER),
                    3);
            pLevel.setBlock(pPos,
                    pState.setValue(HALF, DoubleBlockHalf.UPPER),
                    3);
        } else {
            pLevel.setBlock(pPos,
                    Blocks.AIR.defaultBlockState(),
                    3);
            pLevel.setBlock(pPos,
                    pState.setValue(HALF, DoubleBlockHalf.LOWER),
                    3);
            pLevel.setBlock(pPos.above(),
                    pState.setValue(HALF, DoubleBlockHalf.UPPER),
                    3);
        }
    }
}

package one.callum.nether_expanded.block.custom.waxed;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolActions;

import java.util.List;

public class WaxedRotatableBlock extends RotatedPillarBlock {
    private final Block regularBlock;

    public WaxedRotatableBlock(Block regularBlock) {
        super(BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sound(List.of(Blocks.CHERRY_WOOD,
                        Blocks.STRIPPED_CHERRY_WOOD,
                        Blocks.CHERRY_LOG,
                        Blocks.STRIPPED_CHERRY_LOG).contains(regularBlock)
                        ? SoundType.CHERRY_WOOD : SoundType.WOOD)
                .mapColor(regularBlock.defaultMapColor()));
        this.regularBlock = regularBlock;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);
        if (itemStack.canPerformAction(ToolActions.AXE_WAX_OFF)) {
            if (!pLevel.isClientSide()) {
                pLevel.setBlock(pPos, this.regularBlock.withPropertiesOf(pState), 7);
                itemStack.hurtAndBreak(1, pPlayer, (e) -> e.broadcastBreakEvent(pHand));

                pLevel.levelEvent(pPlayer, 3004, pPos, 0);
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
}

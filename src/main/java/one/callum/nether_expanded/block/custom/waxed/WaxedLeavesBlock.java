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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolActions;

public class WaxedLeavesBlock extends LeavesBlock {
    private final Block regularBlock;

    public WaxedLeavesBlock(Block regularBlock) {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                .strength(0.2F)
                .randomTicks()
                .sound(sound(regularBlock))
                .noOcclusion()
                .isValidSpawn(WaxedLeavesBlock::ocelotOrParrot)
                .isSuffocating(WaxedLeavesBlock::never)
                .isViewBlocking(WaxedLeavesBlock::never)
                .pushReaction(PushReaction.DESTROY)
                .isRedstoneConductor(WaxedLeavesBlock::never));
        this.regularBlock = regularBlock;
    }

    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    private static Boolean ocelotOrParrot(BlockState p_50822_, BlockGetter p_50823_, BlockPos p_50824_, EntityType<?> p_50825_) {
        return (boolean) (p_50825_ == EntityType.OCELOT || p_50825_ == EntityType.PARROT);
    }

    private static SoundType sound(Block block) {
        if (block == Blocks.CHERRY_LEAVES) {
            return SoundType.CHERRY_LEAVES;
        } else if (block == Blocks.AZALEA_LEAVES || block == Blocks.FLOWERING_AZALEA_LEAVES) {
            return SoundType.AZALEA_LEAVES;
        } else return SoundType.GRASS;
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

            pLevel.playSound(pPlayer, pPos, SoundEvents.GRASS_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        } else {
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        }
    }
}

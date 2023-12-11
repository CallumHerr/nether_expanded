package one.callum.nether_expanded.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChiseledBookShelfBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolActions;

public class WaxedChiseledBookshelfBlock extends Block {
    private final Block regularBlock;

    public WaxedChiseledBookshelfBlock() {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOD)
                .instrument(NoteBlockInstrument.BASS)
                .strength(1.5F)
                .sound(SoundType.CHISELED_BOOKSHELF));
        this.regularBlock = Blocks.CHISELED_BOOKSHELF;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);
        if (itemStack.canPerformAction(ToolActions.AXE_WAX_OFF)) {
            if (!pLevel.isClientSide()) {
                pLevel.setBlock(pPos, this.regularBlock.withPropertiesOf(pState), 7);
                itemStack.hurtAndBreak(1, pPlayer, (e) -> e.broadcastBreakEvent(pHand));

                pLevel.gameEvent(pPlayer, GameEvent.BLOCK_CHANGE, pPos);
                pPlayer.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
            }
            ParticleUtils.spawnParticlesOnBlockFace(pLevel, pPos, ParticleTypes.WAX_OFF,
                    UniformInt.of(3, 5), pHit.getDirection(),
                    () -> getRandomSpeedRanges(pLevel.random), 0.55D);


            pLevel.playSound(pPlayer, pPos, SoundEvents.BOOK_PUT, SoundSource.BLOCKS, 1.0F, 1.0F);
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        } else {
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        }
    }

    private static Vec3 getRandomSpeedRanges(RandomSource pRandom) {
        return new Vec3(Mth.nextDouble(pRandom, -0.5D, 0.5D), Mth.nextDouble(pRandom, -0.5D, 0.5D), Mth.nextDouble(pRandom, -0.5D, 0.5D));
    }
}

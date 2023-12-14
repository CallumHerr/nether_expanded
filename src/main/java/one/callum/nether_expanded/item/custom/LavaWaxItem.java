package one.callum.nether_expanded.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.registries.RegistryObject;
import one.callum.nether_expanded.block.ModBlocks;
import one.callum.nether_expanded.block.custom.waxed.WaxedDoorBlock;
import one.callum.nether_expanded.item.ModItems;

public class LavaWaxItem extends Item {
    public LavaWaxItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();

        BlockState state = level.getBlockState(pos);
        RegistryObject<Block> waxedBlock = ModBlocks.WAXED_BLOCKS.get(state.getBlock());
        if (waxedBlock == null) return InteractionResult.FAIL;

        if (!level.isClientSide) {
            if (state.is(BlockTags.DOORS)) {
                WaxedDoorBlock.setBlock(level, pos, waxedBlock.get().withPropertiesOf(state));
            } else level.setBlock(pos, waxedBlock.get().withPropertiesOf(state), 7);
        }

        ParticleUtils.spawnParticlesOnBlockFace(pContext.getLevel(), pContext.getClickedPos(),
                ParticleTypes.WAX_OFF,
                UniformInt.of(3, 5), pContext.getClickedFace(),
                () -> getRandomSpeedRanges(pContext.getLevel().random), 0.55D);
        level.playSound(pContext.getPlayer(), pos, SoundEvents.HONEYCOMB_WAX_ON, SoundSource.BLOCKS, 1.0F, 1.0F);


        ItemStack stack = pContext.getItemInHand();
        stack.shrink(1);
        if (!pContext.getPlayer().getInventory().add(new ItemStack(Items.GLASS_BOTTLE))) {
            pContext.getPlayer().drop(new ItemStack(Items.GLASS_BOTTLE), false);
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    private static Vec3 getRandomSpeedRanges(RandomSource pRandom) {
        return new Vec3(Mth.nextDouble(pRandom, -0.5D, 0.5D), Mth.nextDouble(pRandom, -0.5D, 0.5D), Mth.nextDouble(pRandom, -0.5D, 0.5D));
    }
}

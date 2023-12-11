package one.callum.nether_expanded.block.custom;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.DebugBuffer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import one.callum.nether_expanded.util.ModTags;

import java.util.logging.Logger;

public class LavaCaneBlock extends SugarCaneBlock {
    public LavaCaneBlock(Properties pProperties) {
        super(BlockBehaviour.Properties.copy(Blocks.SUGAR_CANE).noOcclusion());
        LogUtils.getLogger().debug(BlockBehaviour.Properties.copy(Blocks.SUGAR_CANE).toString());
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockState plantedBlock = pLevel.getBlockState(pPos.below());

        if (plantedBlock.is(this) || plantedBlock.is(Blocks.MAGMA_BLOCK)) {
            return true;
        }

        if (plantedBlock.is(ModTags.Blocks.LAVA_CANE_BLOCKS)) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                FluidState fluidState = pLevel.getFluidState(pPos.below().relative(direction));
                if (fluidState.is(Fluids.LAVA) || fluidState.is(Fluids.FLOWING_LAVA)) return true;
            }
        }
        return false;
    }
}

package one.callum.nether_expanded.worldgen.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NetherForestVegetationConfig;
import one.callum.nether_expanded.util.ModTags;

public class LavaCaneFeature extends Feature<NetherForestVegetationConfig> {
    public LavaCaneFeature(Codec<NetherForestVegetationConfig> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NetherForestVegetationConfig> pContext) {
        WorldGenLevel worldgenlevel = pContext.level();
        BlockPos blockpos = pContext.origin();
        BlockState blockstate = worldgenlevel.getBlockState(blockpos.below());
        NetherForestVegetationConfig netherforestvegetationconfig = pContext.config();
        RandomSource randomsource = pContext.random();
        if (!blockstate.is(ModTags.Blocks.LAVA_CANE_BLOCKS)) {
            return false;
        } else {
            int y = blockpos.getY();
            if (y >= worldgenlevel.getMinBuildHeight() + 1 && y + 1 < worldgenlevel.getMaxBuildHeight()) {
                int j = 0;

                for(int k = 0; k < netherforestvegetationconfig.spreadWidth * netherforestvegetationconfig.spreadWidth; ++k) {
                    BlockPos blockpos1 = blockpos.offset(randomsource.nextInt(netherforestvegetationconfig.spreadWidth) - randomsource.nextInt(netherforestvegetationconfig.spreadWidth), randomsource.nextInt(netherforestvegetationconfig.spreadHeight) - randomsource.nextInt(netherforestvegetationconfig.spreadHeight), randomsource.nextInt(netherforestvegetationconfig.spreadWidth) - randomsource.nextInt(netherforestvegetationconfig.spreadWidth));
                    BlockState blockstate1 = netherforestvegetationconfig.stateProvider.getState(randomsource, blockpos1);
                    if (worldgenlevel.isEmptyBlock(blockpos1) && blockpos1.getY() > worldgenlevel.getMinBuildHeight() && blockstate1.canSurvive(worldgenlevel, blockpos1)) {
                        worldgenlevel.setBlock(blockpos1, blockstate1, 2);
                        ++j;
                    }
                }

                return j > 0;
            } else {
                return false;
            }
        }
    }
}

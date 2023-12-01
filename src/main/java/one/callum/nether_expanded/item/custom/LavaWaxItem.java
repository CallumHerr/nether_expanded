package one.callum.nether_expanded.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.registries.RegistryObject;
import one.callum.nether_expanded.block.ModBlocks;

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
            level.setBlock(pos, waxedBlock.get().withPropertiesOf(state), 7);
        }

        ItemStack stack = pContext.getItemInHand();
        stack.setCount(stack.getCount()-1);
        level.playSound(pContext.getPlayer(), pos, SoundEvents.HONEYCOMB_WAX_ON, SoundSource.BLOCKS, 1.0F, 1.0F);

        return InteractionResult.sidedSuccess(level.isClientSide());
    }
}

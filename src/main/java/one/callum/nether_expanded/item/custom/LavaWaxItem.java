package one.callum.nether_expanded.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;
import one.callum.nether_expanded.block.ModBlocks;

public class LavaWaxItem extends Item {
    public LavaWaxItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        if (!level.isClientSide) {
            Block block = level.getBlockState(pContext.getClickedPos()).getBlock();
            RegistryObject<Block> waxedBlock = ModBlocks.WAXED_BLOCKS.get(block);
            if (waxedBlock == null) return super.useOn(pContext);

            level.setBlock(pContext.getClickedPos(), waxedBlock.get().defaultBlockState(), 7);
            ItemStack stack = pContext.getItemInHand();
            stack.setCount(stack.getCount()-1);

            return InteractionResult.sidedSuccess(level.isClientSide());
        }
        return super.useOn(pContext);
    }
}

package one.callum.nether_expanded.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;

public class GoldAlloyArmorItem extends ArmorItem {
    public GoldAlloyArmorItem(ArmorMaterials mat, Type pType) {
        super(mat, pType, new Properties());
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }
}

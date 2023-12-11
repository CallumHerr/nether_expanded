package one.callum.nether_expanded.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.item.ModItems;
import one.callum.nether_expanded.loot.AddItemModifier;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, NetherExpanded.MODID);
    }

    @Override
    protected void start() {

        //MAKE SURE THE RESOURCE LOCATION IS CORRECT
        this.add("gold_plating_template_from_bastion", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/bastion_treasure")).build()
        }, ModItems.GOLD_PLATING_SMITHING_TEMPLATE.get()));
    }
}

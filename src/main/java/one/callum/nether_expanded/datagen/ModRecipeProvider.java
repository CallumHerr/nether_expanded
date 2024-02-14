package one.callum.nether_expanded.datagen;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SmithingRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.block.ModBlocks;
import one.callum.nether_expanded.item.ModItems;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        goldPlatedUpgrade(Items.NETHERITE_HELMET, ModItems.GOLD_PLATED_HELMET, pRecipeOutput);
        goldPlatedUpgrade(Items.NETHERITE_CHESTPLATE, ModItems.GOLD_PLATED_CHESTPLATE, pRecipeOutput);
        goldPlatedUpgrade(Items.NETHERITE_LEGGINGS, ModItems.GOLD_PLATED_LEGGINGS, pRecipeOutput);
        goldPlatedUpgrade(Items.NETHERITE_BOOTS, ModItems.GOLD_PLATED_BOOTS, pRecipeOutput);

        oneToOneConversionRecipe(pRecipeOutput, Items.SUGAR, ModItems.LAVA_CANE.get(), "sugar");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.COPPER_INGOT)
                .requires(ModItems.COPPER_NUGGET.get(), 9)
                .unlockedBy("has_copper",
                        has(ModItems.COPPER_NUGGET.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COPPER_NUGGET.get(), 9)
                .requires(Items.COPPER_INGOT)
                .unlockedBy("has_copper",
                        has(Items.COPPER_INGOT)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.PAPER, 3)
                .pattern("###")
                .define('#', ModItems.LAVA_CANE.get())
                .unlockedBy("has_reeds", has(ModItems.LAVA_CANE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLD_PLATING_SMITHING_TEMPLATE.get())
                .pattern("GTG")
                .pattern("GNG")
                .pattern("GGG")
                .define('G', Items.GOLD_INGOT)
                .define('N', Items.NETHERRACK)
                .define('T', ModItems.GOLD_PLATING_SMITHING_TEMPLATE.get())
                .unlockedBy("has_gold_plating_template",
                        has(ModItems.GOLD_PLATING_SMITHING_TEMPLATE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPER_GOLD_ALLOY_ITEM.get())
                .pattern("GGG")
                .pattern("GCC")
                .pattern("CCC")
                .define('G', Items.GOLD_INGOT)
                .define('C', Items.COPPER_INGOT)
                .unlockedBy("has_gold",
                        has(Items.GOLD_INGOT))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLD_ALLOY_PICKAXE.get())
                .pattern("GGG")
                .pattern(" S ")
                .pattern(" S ")
                .define('G', ModItems.COPPER_GOLD_ALLOY_ITEM.get())
                .define('S', Items.STICK)
                .unlockedBy("has_gold_alloy", has(ModItems.COPPER_GOLD_ALLOY_ITEM.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLD_ALLOY_AXE.get())
                .pattern("GG ")
                .pattern("GS ")
                .pattern(" S ")
                .define('G', ModItems.COPPER_GOLD_ALLOY_ITEM.get())
                .define('S', Items.STICK)
                .unlockedBy("has_gold_alloy", has(ModItems.COPPER_GOLD_ALLOY_ITEM.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLD_ALLOY_SHOVEL.get())
                .pattern(" G ")
                .pattern(" S ")
                .pattern(" S ")
                .define('G', ModItems.COPPER_GOLD_ALLOY_ITEM.get())
                .define('S', Items.STICK)
                .unlockedBy("has_gold_alloy", has(ModItems.COPPER_GOLD_ALLOY_ITEM.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLD_ALLOY_HOE.get())
                .pattern("GG ")
                .pattern(" S ")
                .pattern(" S ")
                .define('G', ModItems.COPPER_GOLD_ALLOY_ITEM.get())
                .define('S', Items.STICK)
                .unlockedBy("has_gold_alloy", has(ModItems.COPPER_GOLD_ALLOY_ITEM.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GOLD_ALLOY_SWORD.get())
                .pattern(" G ")
                .pattern(" G ")
                .pattern(" S ")
                .define('G', ModItems.COPPER_GOLD_ALLOY_ITEM.get())
                .define('S', Items.STICK)
                .unlockedBy("has_gold_alloy", has(ModItems.COPPER_GOLD_ALLOY_ITEM.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GOLD_ALLOY_HELMET.get())
                .pattern("GGG")
                .pattern("G G")
                .define('G', ModItems.COPPER_GOLD_ALLOY_ITEM.get())
                .unlockedBy("has_gold_alloy", has(ModItems.COPPER_GOLD_ALLOY_ITEM.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GOLD_ALLOY_CHESTPLATE.get())
                .pattern("G G")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModItems.COPPER_GOLD_ALLOY_ITEM.get())
                .unlockedBy("has_gold_alloy", has(ModItems.COPPER_GOLD_ALLOY_ITEM.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GOLD_ALLOY_LEGGINGS.get())
                .pattern("GGG")
                .pattern("G G")
                .pattern("G G")
                .define('G', ModItems.COPPER_GOLD_ALLOY_ITEM.get())
                .unlockedBy("has_gold_alloy", has(ModItems.COPPER_GOLD_ALLOY_ITEM.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GOLD_ALLOY_BOOTS.get())
                .pattern("G G")
                .pattern("G G")
                .define('G', ModItems.COPPER_GOLD_ALLOY_ITEM.get())
                .unlockedBy("has_gold_alloy", has(ModItems.COPPER_GOLD_ALLOY_ITEM.get()))
                .save(pRecipeOutput);

        ModBlocks.WAXED_BLOCKS.forEach((key, value) -> {
            String name = value.getKey().location().getPath();

            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,
                    key).requires(value.get()).unlockedBy(
                    "has_" + name, has(value.get())).save(pRecipeOutput);
        });
    }

    protected static Criterion<InventoryChangeTrigger.TriggerInstance> has(ItemLike... itemLike) {
        ItemPredicate pred = ItemPredicate.Builder.item().of(itemLike).build();
        return CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(
                Optional.empty(),
                MinMaxBounds.Ints.ANY,
                MinMaxBounds.Ints.ANY,
                MinMaxBounds.Ints.ANY,
                List.of(pred)));
    }

    private void goldPlatedUpgrade(Item input, RegistryObject<Item> output, RecipeOutput pWriter) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.GOLD_PLATING_SMITHING_TEMPLATE.get()),
                Ingredient.of(input),
                Ingredient.of(ModItems.COPPER_GOLD_ALLOY_ITEM.get()),
                RecipeCategory.COMBAT,
                output.get())
                .unlocks("has_gold_alloy", has(ModItems.COPPER_GOLD_ALLOY_ITEM.get()))
                .save(pWriter,output.getId().getPath() + "_smithing");
    }

}

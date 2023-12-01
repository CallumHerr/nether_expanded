package one.callum.nether_expanded.datagen;

import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.SmithingRecipe;
import one.callum.nether_expanded.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPER_GOLD_ALLOY_ITEM.get())
                .pattern("GGG")
                .pattern("GCC")
                .pattern("CCC")
                .define('G', Items.GOLD_INGOT)
                .define('C', Items.COPPER_INGOT)
                .unlockedBy("has_gold",
                        inventoryTrigger(ItemPredicate.Builder.item().of(Items.GOLD_INGOT).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLD_ALLOY_PICKAXE.get())
                .pattern("GGG")
                .pattern(" S ")
                .pattern(" S ")
                .define('G', ModItems.COPPER_GOLD_ALLOY_ITEM.get())
                .define('S', Items.STICK)
                .unlockedBy("has_gold_alloy", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.COPPER_GOLD_ALLOY_ITEM.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLD_ALLOY_AXE.get())
                .pattern("GG ")
                .pattern("GS ")
                .pattern(" S ")
                .define('G', ModItems.COPPER_GOLD_ALLOY_ITEM.get())
                .define('S', Items.STICK)
                .unlockedBy("has_gold_alloy", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.COPPER_GOLD_ALLOY_ITEM.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLD_ALLOY_SHOVEL.get())
                .pattern(" G ")
                .pattern(" S ")
                .pattern(" S ")
                .define('G', ModItems.COPPER_GOLD_ALLOY_ITEM.get())
                .define('S', Items.STICK)
                .unlockedBy("has_gold_alloy", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.COPPER_GOLD_ALLOY_ITEM.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLD_ALLOY_HOE.get())
                .pattern("GG ")
                .pattern(" S ")
                .pattern(" S ")
                .define('G', ModItems.COPPER_GOLD_ALLOY_ITEM.get())
                .define('S', Items.STICK)
                .unlockedBy("has_gold_alloy", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.COPPER_GOLD_ALLOY_ITEM.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GOLD_ALLOY_SWORD.get())
                .pattern(" G ")
                .pattern(" G ")
                .pattern(" S ")
                .define('G', ModItems.COPPER_GOLD_ALLOY_ITEM.get())
                .define('S', Items.STICK)
                .unlockedBy("has_gold_alloy", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.COPPER_GOLD_ALLOY_ITEM.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GOLD_ALLOY_HELMET.get())
                .pattern("GGG")
                .pattern("G G")
                .define('G', ModItems.COPPER_GOLD_ALLOY_ITEM.get())
                .unlockedBy("has_gold_alloy", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.COPPER_GOLD_ALLOY_ITEM.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GOLD_ALLOY_CHESTPLATE.get())
                .pattern("G G")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModItems.COPPER_GOLD_ALLOY_ITEM.get())
                .unlockedBy("has_gold_alloy", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.COPPER_GOLD_ALLOY_ITEM.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GOLD_ALLOY_LEGGINGS.get())
                .pattern("GGG")
                .pattern("G G")
                .pattern("G G")
                .define('G', ModItems.COPPER_GOLD_ALLOY_ITEM.get())
                .unlockedBy("has_gold_alloy", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.COPPER_GOLD_ALLOY_ITEM.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GOLD_ALLOY_BOOTS.get())
                .pattern("G G")
                .pattern("G G")
                .define('G', ModItems.COPPER_GOLD_ALLOY_ITEM.get())
                .unlockedBy("has_gold_alloy", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.COPPER_GOLD_ALLOY_ITEM.get()).build()))
                .save(pWriter);

    }

}

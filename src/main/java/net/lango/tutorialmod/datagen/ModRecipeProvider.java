package net.lango.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.lango.tutorialmod.TutorialMod;
import net.lango.tutorialmod.block.ModBlocks;
import net.lango.tutorialmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> AMBER_SMELTABLES = List.of(ModBlocks.AMBER_ORE, ModBlocks.DEEPSLATE_AMBER_ORE);

        offerSmelting(recipeExporter, AMBER_SMELTABLES, RecipeCategory.MISC, ModItems.AMBER, 0.5f, 200, "amber");
        offerBlasting(recipeExporter, AMBER_SMELTABLES, RecipeCategory.MISC, ModItems.AMBER, 0.5f, 100, "amber");

        //offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.AMBER, RecipeCategory.DECORATIONS, ModBlocks.AMBER_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMBER_BLOCK)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .input('A', ModItems.AMBER)
                .criterion(hasItem(ModItems.AMBER), conditionsFromItem(ModItems.AMBER))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AMBER, 9)
                .input(ModBlocks.AMBER_BLOCK)
                .criterion(hasItem(ModBlocks.AMBER_BLOCK), conditionsFromItem(ModBlocks.AMBER_BLOCK))
                .offerTo(recipeExporter, Identifier.of(TutorialMod.MOD_ID, "amber_from_amber_block"));
        //no necesario la parte del identifier en este caso, pero se emplea para que no hayan dos recetas con el mismo nombre

        createStairsRecipe(ModBlocks.AMBER_STAIRS, Ingredient.ofItems(ModItems.AMBER))
                .criterion(hasItem(ModItems.AMBER), conditionsFromItem(ModItems.AMBER))
                        .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMBER_SLAB, 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("AAA")
                .input('A', ModItems.AMBER)
                .criterion(hasItem(ModItems.AMBER), conditionsFromItem(ModItems.AMBER))
                .offerTo(recipeExporter);

        createFenceRecipe(ModBlocks.AMBER_FENCE, Ingredient.ofItems(ModItems.AMBER))
                .criterion(hasItem(ModItems.AMBER), conditionsFromItem(ModItems.AMBER))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMBER_WALL, 6)
                .pattern("   ")
                .pattern("BAB")
                .pattern("BAB")
                .input('A', ModItems.AMBER)
                .input('B', ModBlocks.AMBER_BLOCK)
                .criterion(hasItem(ModItems.AMBER), conditionsFromItem(ModItems.AMBER))
                .offerTo(recipeExporter);

        createDoorRecipe(ModBlocks.AMBER_DOOR, Ingredient.ofItems(ModItems.AMBER))
                .criterion(hasItem(ModItems.AMBER), conditionsFromItem(ModItems.AMBER))
                .offerTo(recipeExporter);

        createTrapdoorRecipe(ModBlocks.AMBER_TRAPDOOR, Ingredient.ofItems(ModItems.AMBER))
                .criterion(hasItem(ModItems.AMBER), conditionsFromItem(ModItems.AMBER))
                .offerTo(recipeExporter);

        createFenceGateRecipe(ModBlocks.AMBER_FENCE_GATE, Ingredient.ofItems(ModItems.AMBER))
                .criterion(hasItem(ModItems.AMBER), conditionsFromItem(ModItems.AMBER))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.AMBER_PRESSURE_PLATE)
                .pattern("   ")
                .pattern("   ")
                .pattern(" AA")
                .input('A', ModItems.AMBER)
                .criterion(hasItem(ModItems.AMBER), conditionsFromItem(ModItems.AMBER))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.AMBER_BUTTON)
                .input(ModItems.AMBER)
                .criterion(hasItem(ModItems.AMBER), conditionsFromItem(ModItems.AMBER))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.AMBER_LANTERN)
                .pattern("AAA")
                .pattern("ARA")
                .pattern("AAA")
                .input('R', Items.REDSTONE)
                .input('A', ModItems.AMBER)
                .criterion(hasItem(ModItems.AMBER), conditionsFromItem(ModItems.AMBER))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ROCK_POWDER, 2)
                .input(ModItems.ROCK)
                .criterion(hasItem(ModItems.ROCK), conditionsFromItem(ModItems.ROCK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.AMBER_SWORD)
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" S ")
                .input('A', ModItems.AMBER)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.AMBER), conditionsFromItem(ModItems.AMBER))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.AMBER_PICKAXE)
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .input('A', ModItems.AMBER)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.AMBER), conditionsFromItem(ModItems.AMBER))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.AMBER_SHOVEL)
                .pattern(" A ")
                .pattern(" S ")
                .pattern(" S ")
                .input('A', ModItems.AMBER)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.AMBER), conditionsFromItem(ModItems.AMBER))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.AMBER_AXE)
                .pattern(" AA")
                .pattern(" SA")
                .pattern(" S ")
                .input('A', ModItems.AMBER)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.AMBER), conditionsFromItem(ModItems.AMBER))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter, Identifier.of(TutorialMod.MOD_ID, "axe_right_craft"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.AMBER_HOE)
                .pattern(" AA")
                .pattern(" S ")
                .pattern(" S ")
                .input('A', ModItems.AMBER)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.AMBER), conditionsFromItem(ModItems.AMBER))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);
    }
}

package com.slomaxonical.croptopia.chocolaterie.datagen;

import me.thonk.croptopia.registry.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.WorldGenLevel;

import java.util.function.Consumer;

import static com.slomaxonical.croptopia.chocolaterie.registry.ItemRegistry.*;
import static me.thonk.croptopia.registry.ItemRegistry.foodPress;
import static me.thonk.croptopia.registry.ItemRegistry.cookingPot;
import static me.thonk.croptopia.registry.ItemRegistry.caramel;
import static me.thonk.croptopia.registry.ItemRegistry.milkBottle;
import static me.thonk.croptopia.registry.ItemRegistry.coconut;
import static me.thonk.croptopia.registry.ItemRegistry.butter;
import static me.thonk.croptopia.registry.ItemRegistry.almond;
import static me.thonk.croptopia.registry.ItemRegistry.pecan;
import static me.thonk.croptopia.registry.ItemRegistry.walnut;
import static me.thonk.croptopia.registry.ItemRegistry.vanilla;

public class CacaoRecipes extends RecipeProvider {
    public CacaoRecipes(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> exporter) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.COCOA_BEANS),CACAO_NIBS.get(),0.35F,200).unlockedBy("has_cocoa_beans",has(Items.COCOA_BEANS)).save(exporter);

        ShapelessRecipeBuilder.shapeless(CACAO_BUTTER_BOTTLE.get()).requires(CACAO_MASS_BOTTLE.get()).requires(FILTER_CLOTH.get()).requires(foodPress).requires(CACAO_MASS_BOTTLE.get()).unlockedBy("has_cacao_mass", has(CACAO_MASS_BUCKET.get())).save(exporter);
        ShapedRecipeBuilder.shaped(CACAO_BUTTER_BOTTLE.get(),8).define('1', CACAO_MASS_FILLED_CLOTH.get()).define('2', foodPress).define('3',Items.GLASS).pattern(" 1 ").pattern("323").pattern(" 3 ").unlockedBy("has_press",has(foodPress)).save(exporter,"cacao:cacao_butter_shaped");
        ShapedRecipeBuilder.shaped(CACAO_MASS_BOTTLE.get(),16).define('1', CACAO_MASS_BUCKET.get()).define('2',Items.GLASS).pattern("212").pattern(" 2 ").unlockedBy("has_cacao_mass",has(CACAO_MASS_BUCKET.get())).save(exporter);
        ShapedRecipeBuilder.shaped(CACAO_MASS_BUCKET.get()).define('1', MANUAL_FOOD_GRINDER.get()).define('2',Items.BUCKET).define('3', CACAO_NIBS.get()).pattern("323").pattern("313").pattern("333").unlockedBy("has_nibs",has(CACAO_NIBS.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(COCOA_POWDER.get(),2).requires(MANUAL_FOOD_GRINDER.get()).requires(PRESSED_COCOA_CONE.get()).requires(Items.SUGAR).unlockedBy("has_grinder", has(MANUAL_FOOD_GRINDER.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(SILICON_DUST.get(),2).requires(Items.QUARTZ).requires(Items.SAND).requires(Items.QUARTZ).unlockedBy("has_quartz", has(Items.QUARTZ)).save(exporter);
        ShapelessRecipeBuilder.shapeless(CACAO_MASS_FILLED_CLOTH.get()).requires(FILTER_CLOTH.get()).requires(CACAO_MASS_BUCKET.get()).unlockedBy("has_cacao_mass", has(CACAO_MASS_BUCKET.get())).save(exporter);
        ShapedRecipeBuilder.shaped(SILICON_MOLD.get()).define('1', Items.SLIME_BALL).define('2', SILICON_DUST.get()).pattern(" 2 ").pattern("212").pattern(" 2 ").unlockedBy("has_silicon",has(SILICON_DUST.get())).save(exporter);
        ShapedRecipeBuilder.shaped(FILTER_CLOTH.get()).define('1', Items.PAPER).define('2', Items.STRING).pattern("121").pattern("212").pattern("121").unlockedBy("has_paper",has(Items.PAPER)).save(exporter);
        ShapedRecipeBuilder.shaped(MANUAL_FOOD_GRINDER.get()).define('0', Items.IRON_INGOT).define('1', Items.GLASS).define('2', ItemTags.PLANKS).pattern("101").pattern("000").pattern("222").unlockedBy("has_iron_ingot",has(Items.IRON_INGOT)).save(exporter);

        ShapelessRecipeBuilder.shapeless(DARK_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_MASS_BOTTLE.get(),4).requires(Items.SUGAR).unlockedBy("has_cacao_bottle",has(CACAO_MASS_BOTTLE.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(CARAMEL_DARK_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_MASS_BOTTLE.get(),4).requires(Items.SUGAR).requires(caramel).unlockedBy("has_cacao_bottle",has(CACAO_MASS_BOTTLE.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(COCONUT_DARK_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_MASS_BOTTLE.get(),4).requires(Items.SUGAR).requires(coconut).unlockedBy("has_cacao_bottle",has(CACAO_MASS_BOTTLE.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(PRALINE_DARK_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_MASS_BOTTLE.get(),4).requires(Items.SUGAR).requires(ItemRegistry.almond).unlockedBy("has_cacao_bottle",has(CACAO_MASS_BOTTLE.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(COOKIE_CREAM_DARK_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_MASS_BOTTLE.get(),4).requires(Items.SUGAR).requires(CacaoItemTags.COOKIES).requires(CacaoItemTags.MILKS).unlockedBy("has_cacao_bottle",has(CACAO_MASS_BOTTLE.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(STRAWBERRY_CREAM_DARK_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_MASS_BOTTLE.get(),4).requires(Items.SUGAR).requires(ItemRegistry.strawberry).requires(CacaoItemTags.MILKS).unlockedBy("has_cacao_bottle",has(CACAO_MASS_BOTTLE.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(MIXED_NUTS_DARK_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_MASS_BOTTLE.get(),4).requires(Items.SUGAR).requires(almond).requires(pecan).requires(walnut).unlockedBy("has_cacao_bottle",has(CACAO_MASS_BOTTLE.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(PEANUT_BUTTER_DARK_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_MASS_BOTTLE.get(),4).requires(Items.SUGAR).requires(almond).requires(pecan).requires(walnut).unlockedBy("has_cacao_bottle",has(CACAO_MASS_BOTTLE.get())).save(exporter);

        ShapelessRecipeBuilder.shapeless(MILK_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_MASS_BOTTLE.get(),2).requires(milkBottle,2).requires(Items.SUGAR).unlockedBy("has_milk_bottle",has(milkBottle)).save(exporter);
        ShapelessRecipeBuilder.shapeless(CARAMEL_MILK_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_MASS_BOTTLE.get(),2).requires(milkBottle,2).requires(Items.SUGAR).requires(caramel).unlockedBy("has_milk_bottle",has(milkBottle)).save(exporter);
        ShapelessRecipeBuilder.shapeless(COCONUT_MILK_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_MASS_BOTTLE.get(),2).requires(milkBottle,2).requires(Items.SUGAR).requires(coconut).unlockedBy("has_milk_bottle",has(milkBottle)).save(exporter);
        ShapelessRecipeBuilder.shapeless(PRALINE_MILK_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_MASS_BOTTLE.get(),2).requires(milkBottle,2).requires(Items.SUGAR).requires(ItemRegistry.almond).unlockedBy("has_milk_bottle",has(milkBottle)).save(exporter);
        ShapelessRecipeBuilder.shapeless(COOKIE_CREAM_MILK_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_MASS_BOTTLE.get(),2).requires(milkBottle,2).requires(Items.SUGAR).requires(CacaoItemTags.COOKIES).requires(CacaoItemTags.MILKS).unlockedBy("has_milk_bottle",has(milkBottle)).save(exporter);
        ShapelessRecipeBuilder.shapeless(STRAWBERRY_CREAM_MILK_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_MASS_BOTTLE.get(),2).requires(milkBottle,2).requires(Items.SUGAR).requires(ItemRegistry.strawberry).requires(CacaoItemTags.MILKS).unlockedBy("has_milk_bottle",has(milkBottle)).save(exporter);
        ShapelessRecipeBuilder.shapeless(MIXED_NUTS_MILK_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_MASS_BOTTLE.get(),2).requires(milkBottle,2).requires(Items.SUGAR).requires(almond).requires(pecan).requires(walnut).unlockedBy("has_milk_bottle",has(milkBottle)).save(exporter);
        ShapelessRecipeBuilder.shapeless(PEANUT_BUTTER_MILK_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_MASS_BOTTLE.get(),2).requires(milkBottle,2).requires(Items.SUGAR).requires(almond).requires(pecan).requires(walnut).unlockedBy("has_milk_bottle",has(milkBottle)).save(exporter);

        ShapelessRecipeBuilder.shapeless(WHITE_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_BUTTER_BOTTLE.get(),2).requires(milkBottle,2).requires(Items.SUGAR).unlockedBy("has_cacao_butter_bottle",has(CACAO_BUTTER_BOTTLE.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(CARAMEL_WHITE_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_BUTTER_BOTTLE.get(),2).requires(milkBottle,2).requires(Items.SUGAR).requires(caramel).unlockedBy("has_cacao_butter_bottle",has(CACAO_BUTTER_BOTTLE.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(COCONUT_WHITE_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_BUTTER_BOTTLE.get(),2).requires(milkBottle,2).requires(Items.SUGAR).requires(coconut).unlockedBy("has_cacao_butter_bottle",has(CACAO_BUTTER_BOTTLE.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(PRALINE_WHITE_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_BUTTER_BOTTLE.get(),2).requires(milkBottle,2).requires(Items.SUGAR).requires(ItemRegistry.almond).unlockedBy("has_cacao_butter_bottle",has(CACAO_BUTTER_BOTTLE.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(COOKIE_CREAM_WHITE_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_BUTTER_BOTTLE.get(),2).requires(milkBottle,2).requires(Items.SUGAR).requires(CacaoItemTags.COOKIES).requires(CacaoItemTags.MILKS).unlockedBy("has_cacao_butter_bottle",has(CACAO_BUTTER_BOTTLE.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(STRAWBERRY_CREAM_WHITE_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_BUTTER_BOTTLE.get(),2).requires(milkBottle,2).requires(Items.SUGAR).requires(ItemRegistry.strawberry).requires(CacaoItemTags.MILKS).unlockedBy("has_cacao_butter_bottle",has(CACAO_BUTTER_BOTTLE.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(MIXED_NUTS_WHITE_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_BUTTER_BOTTLE.get(),2).requires(milkBottle,2).requires(Items.SUGAR).requires(almond).requires(pecan).requires(walnut).unlockedBy("has_cacao_butter_bottle",has(CACAO_BUTTER_BOTTLE.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(PEANUT_BUTTER_WHITE_CHOCOLATE.get(),4).requires(SILICON_MOLD.get()).requires(CACAO_BUTTER_BOTTLE.get(),2).requires(milkBottle,2).requires(Items.SUGAR).requires(ItemRegistry.peanutButter).unlockedBy("has_cacao_butter_bottle",has(CACAO_BUTTER_BOTTLE.get())).save(exporter);

        ShapelessRecipeBuilder.shapeless(DARK_CHIPS_CHOCOLATE_COOKIE.get(),2).requires(CacaoItemTags.FLOUR).requires(COCOA_POWDER.get()).requires(butter).requires(DARK_CHOCOLATE.get()).unlockedBy("has_cocoa",has(COCOA_POWDER.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(WHITE_CHIPS_CHOCOLATE_COOKIE.get(),2).requires(CacaoItemTags.FLOUR).requires(COCOA_POWDER.get()).requires(butter).requires(WHITE_CHOCOLATE.get()).unlockedBy("has_cocoa",has(COCOA_POWDER.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(WHITE_CHIPS_COOKIE.get(),2).requires(CacaoItemTags.FLOUR).requires(Items.SUGAR).requires(butter).requires(WHITE_CHOCOLATE.get()).unlockedBy("has_cocoa",has(COCOA_POWDER.get())).save(exporter);
        chocolateCoveredAppleRecipe(exporter, DARK_CHOCOLATE_COVERED_APPLE.get(),DARK_CHOCOLATE.get());
        chocolateCoveredAppleRecipe(exporter, MILK_CHOCOLATE_COVERED_APPLE.get(),MILK_CHOCOLATE.get());
        chocolateCoveredAppleRecipe(exporter, WHITE_CHOCOLATE_COVERED_APPLE.get(),WHITE_CHOCOLATE.get());
        ShapelessRecipeBuilder.shapeless(NUTELLA.get()).requires(MILK_CHOCOLATE.get(),3).requires(vanilla).requires(Items.SUGAR).requires(CacaoItemTags.NUTS).requires(cookingPot).unlockedBy("has_cooking_pot",has(cookingPot)).save(exporter);
        ShapedRecipeBuilder.shaped(CHOCOLATE_CAKE.get()).define('0',CacaoItemTags.MILKS).define('1', Items.EGG).define('2', COCOA_POWDER.get()).define('3', CacaoItemTags.FLOUR).pattern("000").pattern("212").pattern("333").unlockedBy("has_cocoa",has(COCOA_POWDER.get())).save(exporter);
        ShapedRecipeBuilder.shaped(GOLDEN_CHOCOLATE.get()).define('0',Items.GOLD_INGOT).define('1', CacaoItemTags.CHOCOLATES).pattern("000").pattern("010").pattern("000").unlockedBy("has_chocolates",has(CacaoItemTags.CHOCOLATES)).save(exporter);

        ShapedRecipeBuilder.shaped(Items.CAKE).define('0',CacaoItemTags.MILKS).define('1', Items.EGG).define('2', Items.SUGAR).define('3', CacaoItemTags.FLOUR).pattern("000").pattern("212").pattern("333").unlockedBy("has_butter",has(butter)).save(exporter);
        ShapelessRecipeBuilder.shapeless(Items.COOKIE,2).requires(CacaoItemTags.FLOUR).requires(Items.SUGAR).requires(butter).requires(DARK_CHOCOLATE.get()).unlockedBy("has_butter",has(butter)).save(exporter);
    }
    public static void chocolateCoveredAppleRecipe(Consumer<FinishedRecipe> exporter,Item apple, Item choco){
        ShapedRecipeBuilder.shaped(apple).define('0',choco).define('1', Items.APPLE).define('2', cookingPot).pattern("010").pattern(" 2 ").unlockedBy("has_apple",has(Items.APPLE)).save(exporter);
    }
}

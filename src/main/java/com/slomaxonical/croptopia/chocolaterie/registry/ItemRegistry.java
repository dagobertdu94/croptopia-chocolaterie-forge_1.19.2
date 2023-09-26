package com.slomaxonical.croptopia.chocolaterie.registry;

import com.slomaxonical.croptopia.chocolaterie.CroptopiaChocolaterie;
import com.epherical.croptopia.items.*;
import com.epherical.croptopia.util.FoodConstructor;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.slomaxonical.croptopia.chocolaterie.CroptopiaChocolaterie.createGroup;
import static com.epherical.croptopia.util.FoodConstructor.*;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CroptopiaChocolaterie.MOD_ID);
    public static RegistryObject<Item> CACAO_NIBS = ITEMS.register("cacao_nibs",() -> new Item(createGroup()));
    public static RegistryObject<Item> CACAO_MASS_BUCKET = ITEMS.register("cacao_mass_bucket",() -> new Item(createGroup().craftRemainder(Items.BUCKET)));
    public static RegistryObject<Item> CACAO_MASS_BOTTLE = ITEMS.register("cacao_mass_bottle",() -> new Item(createGroup()));
    public static RegistryObject<Item> CACAO_BUTTER_BOTTLE = ITEMS.register("cacao_butter_bottle",() -> new Item(createGroup()));

    public static RegistryObject<Item> PRESSED_COCOA_CONE = ITEMS.register("pressed_cocoa_cone",() -> new Item(createGroup()));
    public static RegistryObject<Item> COCOA_POWDER = ITEMS.register("cocoa_powder",() -> new Item(createGroup()));
    public static RegistryObject<Item> FILTER_CLOTH = ITEMS.register("filter_cloth",() -> new Item(createGroup()));
    public static RegistryObject<Item> CACAO_MASS_FILLED_CLOTH = ITEMS.register("cacao_mass_filled_cloth",() -> new Item(createGroup().stacksTo(1).craftRemainder(PRESSED_COCOA_CONE.get())));
    public static RegistryObject<Item> SILICON_DUST = ITEMS.register("silicon_dust",() -> new Item(createGroup()));
    public static RegistryObject<Item> SILICON_MOLD = ITEMS.register("silicon_mold",() -> new CookingUtensil(createGroup().stacksTo(1)));
    public static RegistryObject<Item> MANUAL_FOOD_GRINDER = ITEMS.register("manual_food_grinder",() -> new CookingUtensil(createGroup().stacksTo(1)));

    public static RegistryObject<Item> DARK_CHOCOLATE = ITEMS.register("dark_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_3))));
    public static RegistryObject<Item> CARAMEL_DARK_CHOCOLATE = ITEMS.register("caramel_dark_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_5))));
    public static RegistryObject<Item> PRALINE_DARK_CHOCOLATE = ITEMS.register("praline_dark_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_3))));
    public static RegistryObject<Item> STRAWBERRY_CREAM_DARK_CHOCOLATE = ITEMS.register("strawberry_cream_dark_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_3))));
    public static RegistryObject<Item> COOKIE_CREAM_DARK_CHOCOLATE = ITEMS.register("cookie_cream_dark_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_3))));
    public static RegistryObject<Item> MIXED_NUTS_DARK_CHOCOLATE = ITEMS.register("mixed_nuts_dark_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_3))));
    public static RegistryObject<Item> COCONUT_DARK_CHOCOLATE = ITEMS.register("coconut_dark_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_3))));
    public static RegistryObject<Item> PEANUT_BUTTER_DARK_CHOCOLATE = ITEMS.register("peanut_butter_dark_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_3))));

    public static RegistryObject<Item> MILK_CHOCOLATE = ITEMS.register("milk_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_5))));
    public static RegistryObject<Item> CARAMEL_MILK_CHOCOLATE = ITEMS.register("caramel_milk_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_7))));
    public static RegistryObject<Item> PRALINE_MILK_CHOCOLATE = ITEMS.register("praline_milk_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_5))));
    public static RegistryObject<Item> STRAWBERRY_CREAM_MILK_CHOCOLATE = ITEMS.register("strawberry_cream_milk_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_5))));
    public static RegistryObject<Item> COOKIE_CREAM_MILK_CHOCOLATE = ITEMS.register("cookie_cream_milk_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_5))));
    public static RegistryObject<Item> MIXED_NUTS_MILK_CHOCOLATE = ITEMS.register("mixed_nuts_milk_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_5))));
    public static RegistryObject<Item> COCONUT_MILK_CHOCOLATE = ITEMS.register("coconut_milk_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_5))));
    public static RegistryObject<Item> PEANUT_BUTTER_MILK_CHOCOLATE = ITEMS.register("peanut_butter_milk_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_5))));

    public static RegistryObject<Item> WHITE_CHOCOLATE = ITEMS.register("white_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_7))));
    public static RegistryObject<Item> CARAMEL_WHITE_CHOCOLATE = ITEMS.register("caramel_white_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_9))));
    public static RegistryObject<Item> PRALINE_WHITE_CHOCOLATE = ITEMS.register("praline_white_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_7))));
    public static RegistryObject<Item> STRAWBERRY_CREAM_WHITE_CHOCOLATE = ITEMS.register("strawberry_cream_white_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_7))));
    public static RegistryObject<Item> COOKIE_CREAM_WHITE_CHOCOLATE = ITEMS.register("cookie_cream_white_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_7))));
    public static RegistryObject<Item> MIXED_NUTS_WHITE_CHOCOLATE = ITEMS.register("mixed_nuts_white_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_7))));
    public static RegistryObject<Item> COCONUT_WHITE_CHOCOLATE = ITEMS.register("coconut_white_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_7))));
    public static RegistryObject<Item> PEANUT_BUTTER_WHITE_CHOCOLATE = ITEMS.register("peanut_butter_white_chocolate",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_7))));

    public static RegistryObject<Item> GOLDEN_CHOCOLATE = ITEMS.register("golden_chocolate",() -> new Item(createGroup().food(new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(0.75f)
            .effect(()-> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 1), 0.65f)
            .effect(()-> new MobEffectInstance(MobEffects.REGENERATION, 120, 2), 0.8f)
            .alwaysEat()
            .build())));
    public static RegistryObject<Item> DARK_CHOCOLATE_COVERED_APPLE = ITEMS.register("dark_chocolate_covered_apple",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_5))));
    public static RegistryObject<Item> MILK_CHOCOLATE_COVERED_APPLE = ITEMS.register("milk_chocolate_covered_apple",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_7))));
    public static RegistryObject<Item> WHITE_CHOCOLATE_COVERED_APPLE = ITEMS.register("white_chocolate_covered_apple",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_7))));
    public static RegistryObject<Item> WHITE_CHIPS_COOKIE = ITEMS.register("white_chips_cookie",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_5))));
    public static RegistryObject<Item> WHITE_CHIPS_CHOCOLATE_COOKIE = ITEMS.register("white_chips_chocolate_cookie",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_5))));
    public static RegistryObject<Item> DARK_CHIPS_CHOCOLATE_COOKIE = ITEMS.register("dark_chips_chocolate_cookie",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_5))));
    public static RegistryObject<Item> NUTELLA = ITEMS.register("nutella",() -> new Item(createGroup().food(FoodConstructor.createFood(REG_9))));

    public static RegistryObject<Item> CHOCOLATE_CAKE = ITEMS.register("chocolate_cake",() -> new BlockItem(BlockRegistry.CHOCOLATE_CAKE.get(), createGroup().stacksTo(1)));
}

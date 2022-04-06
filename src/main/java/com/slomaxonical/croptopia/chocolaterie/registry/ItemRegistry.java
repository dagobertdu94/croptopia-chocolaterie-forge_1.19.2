package com.slomaxonical.croptopia.chocolaterie.registry;

import com.slomaxonical.croptopia.chocolaterie.CroptopiaChocolaterie;
import me.thonk.croptopia.items.CookingUtensil;
import me.thonk.croptopia.registry.FoodRegistry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.slomaxonical.croptopia.chocolaterie.CroptopiaChocolaterie.createGroup;
import static com.slomaxonical.croptopia.chocolaterie.CroptopiaChocolaterie.registerItem;
import static me.thonk.croptopia.registry.FoodRegistry.*;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CroptopiaChocolaterie.MOD_ID);
    public static RegistryObject<Item> cacaoNibs = ITEMS.register("cacao_nibs",() -> new Item(createGroup()));
    public static RegistryObject<Item> cacaoMassBucket = ITEMS.register("cacao_mass_bucket",() -> new Item(createGroup().craftRemainder(Items.BUCKET)));
    public static RegistryObject<Item> cacaoMassBottle = ITEMS.register("cacao_mass_bottle",() -> new Item(createGroup()));
    public static RegistryObject<Item> cacaoButterBottle = ITEMS.register("cacao_butter_bottle",() -> new Item(createGroup()));
    public static RegistryObject<Item> pressedCocoaCone = ITEMS.register("pressed_cocoa_cone",() -> new Item(createGroup()));
    public static RegistryObject<Item> cocoaPowder = ITEMS.register("cocoa_powder",() -> new Item(createGroup()));
    public static RegistryObject<Item> filterCloth = ITEMS.register("filter_cloth",() -> new Item(createGroup()));
    public static RegistryObject<Item> cacaoMassFilledCloth = ITEMS.register("cacao_mass_filled_cloth",() -> new Item(createGroup().stacksTo(1).craftRemainder(pressedCocoaCone.get())));
    public static RegistryObject<Item> siliconDust = ITEMS.register("silicon_dust",() -> new Item(createGroup()));
    public static RegistryObject<Item> siliconMold = ITEMS.register("silicon_mold",() -> new CookingUtensil(createGroup().stacksTo(1)));
    public static RegistryObject<Item> manualFoodGrinder = ITEMS.register("manual_food_grinder",() -> new CookingUtensil(createGroup().stacksTo(1)));

    public static RegistryObject<Item> darkChocolate = ITEMS.register("dark_chocolate",() -> new Item(createGroup().food(EDIBLE_3)));
    public static RegistryObject<Item> caramelDarkChocoalte = ITEMS.register("caramel_dark_chocolate",() -> new Item(createGroup().food(EDIBLE_5)));
    public static RegistryObject<Item> pralineDarkChocoalte = ITEMS.register("praline_dark_chocolate",() -> new Item(createGroup().food(EDIBLE_3)));
    public static RegistryObject<Item> strawberryCreamDarkChocolate = ITEMS.register("strawberry_cream_dark_chocolate",() -> new Item(createGroup().food(EDIBLE_3)));
    public static RegistryObject<Item> cookieCreamDarkChocolate = ITEMS.register("cookie_cream_dark_chocolate",() -> new Item(createGroup().food(EDIBLE_3)));
    public static RegistryObject<Item> mixedNutsDarkChocolate = ITEMS.register("mixed_nuts_dark_chocolate",() -> new Item(createGroup().food(EDIBLE_3)));
    public static RegistryObject<Item> coconutDarkChocolate = ITEMS.register("coconut_dark_chocolate",() -> new Item(createGroup().food(EDIBLE_3)));
    public static RegistryObject<Item> peanutButterDarkChocolate = ITEMS.register("peanut_butter_dark_chocolate",() -> new Item(createGroup().food(EDIBLE_3)));

    public static RegistryObject<Item> milkChocolate = ITEMS.register("milk_chocolate",() -> new Item(createGroup().food(EDIBLE_5)));
    public static RegistryObject<Item> caramelMilkChocolate = ITEMS.register("caramel_milk_chocolate",() -> new Item(createGroup().food(EDIBLE_7)));
    public static RegistryObject<Item> pralineMilkChocolate = ITEMS.register("praline_milk_chocolate",() -> new Item(createGroup().food(EDIBLE_5)));
    public static RegistryObject<Item> strawberryCreamMilkChocolate = ITEMS.register("strawberry_cream_milk_chocolate",() -> new Item(createGroup().food(EDIBLE_5)));
    public static RegistryObject<Item> cookieCreamMilkChocolate = ITEMS.register("cookie_cream_milk_chocolate",() -> new Item(createGroup().food(EDIBLE_5)));
    public static RegistryObject<Item> mixedNutsMilkChocolate = ITEMS.register("mixed_nuts_milk_chocolate",() -> new Item(createGroup().food(EDIBLE_5)));
    public static RegistryObject<Item> coconutMilkChocolate = ITEMS.register("coconut_milk_chocolate",() -> new Item(createGroup().food(EDIBLE_5)));
    public static RegistryObject<Item> peanutButterMilkChocolate = ITEMS.register("peanut_butter_milk_chocolate",() -> new Item(createGroup().food(EDIBLE_5)));

    public static RegistryObject<Item> whiteChocolate = ITEMS.register("white_chocolate",() -> new Item(createGroup().food(EDIBLE_7)));
    public static RegistryObject<Item> caramelWhiteChocolate = ITEMS.register("caramel_white_chocolate",() -> new Item(createGroup().food(EDIBLE_9)));
    public static RegistryObject<Item> pralineWhiteChocolate = ITEMS.register("praline_white_chocolate",() -> new Item(createGroup().food(EDIBLE_7)));
    public static RegistryObject<Item> strawberryCreamWhiteChocolate = ITEMS.register("strawberry_cream_white_chocolate",() -> new Item(createGroup().food(EDIBLE_7)));
    public static RegistryObject<Item> cookieCreamWhiteChocolate = ITEMS.register("cookie_cream_white_chocolate",() -> new Item(createGroup().food(EDIBLE_7)));
    public static RegistryObject<Item> mixedNutsWhiteChocolate = ITEMS.register("mixed_nuts_white_chocolate",() -> new Item(createGroup().food(EDIBLE_7)));
    public static RegistryObject<Item> coconutWhiteChocolate = ITEMS.register("coconut_white_chocolate",() -> new Item(createGroup().food(EDIBLE_7)));
    public static RegistryObject<Item> peanutButterWhiteChocolate = ITEMS.register("peanut_butter_white_chocolate",() -> new Item(createGroup().food(EDIBLE_7)));

    public static RegistryObject<Item> goldenChocolate = ITEMS.register("golden_chocolate",() -> new Item(createGroup().food(new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(0.75f)
            .effect(()-> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 1), 0.65f)
            .effect(()-> new MobEffectInstance(MobEffects.REGENERATION, 120, 2), 0.8f)
            .alwaysEat()
            .build())));
    public static RegistryObject<Item> darkChocolateCoveredApple = ITEMS.register("dark_chocolate_covered_apple",() -> new Item(createGroup().food(EDIBLE_5)));
    public static RegistryObject<Item> milkChocolateCoveredApple = ITEMS.register("milk_chocolate_covered_apple",() -> new Item(createGroup().food(EDIBLE_7)));
    public static RegistryObject<Item> whiteChocolateCoveredApple = ITEMS.register("white_chocolate_covered_apple",() -> new Item(createGroup().food(EDIBLE_7)));
    public static RegistryObject<Item> whiteChipsCookie = ITEMS.register("white_chips_cookie",() -> new Item(createGroup().food(EDIBLE_5)));
    public static RegistryObject<Item> whiteChipsChocolateCookie = ITEMS.register("white_chips_chocolate_cookie",() -> new Item(createGroup().food(EDIBLE_5)));
    public static RegistryObject<Item> darkChipsChocolateCookie = ITEMS.register("dark_chips_chocolate_cookie",() -> new Item(createGroup().food(EDIBLE_5)));
    public static RegistryObject<Item> nutella = ITEMS.register("nutella",() -> new Item(createGroup().food(EDIBLE_9)));

    public static RegistryObject<Item> chocolatecake = ITEMS.register("chocolate_cake",() -> new BlockItem(BlockRegistry.CHOCOLATE_CAKE.get(), createGroup().stacksTo(1)));



    public static void init(RegistryEvent.Register<Item> itemRegister) {
}


}

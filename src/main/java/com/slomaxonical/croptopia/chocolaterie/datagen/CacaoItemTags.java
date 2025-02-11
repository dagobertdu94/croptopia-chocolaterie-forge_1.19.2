package com.slomaxonical.croptopia.chocolaterie.datagen;

import com.slomaxonical.croptopia.chocolaterie.CroptopiaChocolaterie;
import com.slomaxonical.croptopia.chocolaterie.registry.ItemRegistry;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.concurrent.CompletableFuture;

import com.epherical.croptopia.register.Content;
//import static me.thonk.croptopia.registry.ItemRegistry.oatmealCookie;
//import static me.thonk.croptopia.registry.ItemRegistry.nuttyCookie;

public class CacaoItemTags extends ItemTagsProvider {
    public CacaoItemTags(PackOutput generator, CompletableFuture<Provider> provider, CompletableFuture<TagLookup<Block>> lookup, ExistingFileHelper existingFileHelper) {
    	super(generator, provider, lookup, CroptopiaChocolaterie.MOD_ID, existingFileHelper);
    }
    public static final TagKey<Item> MILKS = forgeTag("milks");
    public static final TagKey<Item> FLOUR = forgeTag("flour");
    public static final TagKey<Item> NUTS = forgeTag("nuts");
    public static final TagKey<Item> COOKIES = modTag("cookies");
    public static final TagKey<Item> CHOCOLATES = modTag("chocolates");

    private static TagKey<Item> forgeTag(String name) {
        return TagKey.create(ForgeRegistries.ITEMS.getRegistryKey(),new ResourceLocation("forge", name));
    }

    private static TagKey<Item> tag(String name) {
        return TagKey.create(ForgeRegistries.ITEMS.getRegistryKey(),new ResourceLocation(name));
    }

    private static TagKey<Item> modTag(String name) {
        return TagKey.create(ForgeRegistries.ITEMS.getRegistryKey(),new ResourceLocation(CroptopiaChocolaterie.MOD_ID,name));
    }
    @Override
    protected void addTags(Provider p){
        tag(COOKIES).add(Items.COOKIE,Content.NUTTY_COOKIE,Content.OATMEAL_COOKIE, ItemRegistry.WHITE_CHIPS_CHOCOLATE_COOKIE.get(),ItemRegistry.WHITE_CHIPS_COOKIE.get(),ItemRegistry.DARK_CHIPS_CHOCOLATE_COOKIE.get());
        tag(CHOCOLATES).add(ItemRegistry.DARK_CHOCOLATE.get(),ItemRegistry.MILK_CHOCOLATE.get(),ItemRegistry.WHITE_CHOCOLATE.get());
    }
}

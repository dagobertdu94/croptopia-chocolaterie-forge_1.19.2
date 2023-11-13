package com.slomaxonical.croptopia.chocolaterie.datagen;

import com.slomaxonical.croptopia.chocolaterie.CroptopiaChocolaterie;
import com.slomaxonical.croptopia.chocolaterie.registry.ItemRegistry;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Set;
import java.util.function.Supplier;

import com.epherical.croptopia.register.Content;
//import static me.thonk.croptopia.registry.ItemRegistry.oatmealCookie;
//import static me.thonk.croptopia.registry.ItemRegistry.nuttyCookie;

public class CacaoItemTags extends ItemTagsProvider {
    public CacaoItemTags(DataGenerator generator, BlockTagsProvider provider, ExistingFileHelper existingFileHelper) {
        super(generator, provider, CroptopiaChocolaterie.MOD_ID, existingFileHelper);
    }
    public static final TagKey<Item> MILKS = forgeTag("milks");
    public static final TagKey<Item> FLOUR = forgeTag("flour");
    public static final TagKey<Item> NUTS = forgeTag("nuts");
    public static final TagKey<Item> COOKIES = modTag("cookies");
    public static final TagKey<Item> CHOCOLATES = modTag("chocolates");

    private static TagKey<Item> forgeTag(String name) {
        return TagKey.create(Registry.ITEM_REGISTRY,new ResourceLocation("forge", name));
    }

    private static TagKey<Item> tag(String name) {
        return TagKey.create(Registry.ITEM_REGISTRY,new ResourceLocation(name));
    }

    private static TagKey<Item> modTag(String name) {
        return TagKey.create(Registry.ITEM_REGISTRY,new ResourceLocation(CroptopiaChocolaterie.MOD_ID,name));
    }
    @Override
    protected void addTags(){
        tag(COOKIES).add(Items.COOKIE,Content.NUTTY_COOKIE,Content.OATMEAL_COOKIE, ItemRegistry.WHITE_CHIPS_CHOCOLATE_COOKIE.get(),ItemRegistry.WHITE_CHIPS_COOKIE.get(),ItemRegistry.DARK_CHIPS_CHOCOLATE_COOKIE.get());
        tag(CHOCOLATES).add(ItemRegistry.DARK_CHOCOLATE.get(),ItemRegistry.MILK_CHOCOLATE.get(),ItemRegistry.WHITE_CHOCOLATE.get());
    }
}

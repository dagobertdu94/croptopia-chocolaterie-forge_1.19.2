package com.slomaxonical.croptopia.chocolaterie.datagen;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.VanillaBlockTagsProvider;
import net.minecraft.tags.BlockTags;

import static com.slomaxonical.croptopia.chocolaterie.registry.BlockRegistry.*;

import java.util.concurrent.CompletableFuture;

public class CacaoBlockTags extends VanillaBlockTagsProvider {
    public CacaoBlockTags(PackOutput p_126511_, CompletableFuture<Provider> prov) {
    	super(p_126511_, prov);
    }
    @Override
    protected void addTags(Provider prov) {
        tag(BlockTags.CANDLE_CAKES).add(
                CANDLE_CHOCOLATE_CAKE.get(),
                BLACK_CANDLE_CHOCOLATE_CAKE.get(),
                GRAY_CANDLE_CHOCOLATE_CAKE.get(),
                LIGHT_GRAY_CANDLE_CHOCOLATE_CAKE.get(),
                WHITE_CANDLE_CHOCOLATE_CAKE.get(),
                LIGHT_BLUE_CANDLE_CHOCOLATE_CAKE.get(),
                BLUE_CANDLE_CHOCOLATE_CAKE.get(),
                CYAN_CANDLE_CHOCOLATE_CAKE.get(),
                GREEN_CANDLE_CHOCOLATE_CAKE.get(),
                LIME_CANDLE_CHOCOLATE_CAKE.get(),
                YELLOW_CANDLE_CHOCOLATE_CAKE.get(),
                ORANGE_CANDLE_CHOCOLATE_CAKE.get(),
                RED_CANDLE_CHOCOLATE_CAKE.get(),
                PINK_CANDLE_CHOCOLATE_CAKE.get(),
                PURPLE_CANDLE_CHOCOLATE_CAKE.get(),
                MAGENTA_CANDLE_CHOCOLATE_CAKE.get(),
                BROWN_CANDLE_CHOCOLATE_CAKE.get()
        );
    }
}

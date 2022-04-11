package com.slomaxonical.croptopia.chocolaterie.datagen;

import com.slomaxonical.croptopia.chocolaterie.CroptopiaChocolaterie;
import com.slomaxonical.croptopia.chocolaterie.registry.BlockRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import static com.slomaxonical.croptopia.chocolaterie.registry.BlockRegistry.*;

public class CacaoBlockTags extends BlockTagsProvider {
    public CacaoBlockTags(DataGenerator p_126511_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126511_, CroptopiaChocolaterie.MOD_ID, existingFileHelper);
    }
    @Override
    protected void addTags() {
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

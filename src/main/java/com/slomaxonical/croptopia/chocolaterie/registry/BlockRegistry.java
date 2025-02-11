package com.slomaxonical.croptopia.chocolaterie.registry;

import com.slomaxonical.croptopia.chocolaterie.CroptopiaChocolaterie;
import com.slomaxonical.croptopia.chocolaterie.blocks.CandleChocolateCakeBlock;
import com.slomaxonical.croptopia.chocolaterie.blocks.ChocolateCakeBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.ToIntFunction;


public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CroptopiaChocolaterie.MOD_ID);

    public static final RegistryObject<Block> CHOCOLATE_CAKE = BLOCKS.register("chocolate_cake",()-> new ChocolateCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).strength(0.5F).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> CANDLE_CHOCOLATE_CAKE = BLOCKS.register("candle_chocolate_cake", ()-> new CandleChocolateCakeBlock(Blocks.CANDLE, BlockBehaviour.Properties.copy(CHOCOLATE_CAKE.get()).lightLevel(litBlockEmission(3))));

    public static final RegistryObject<Block> BLACK_CANDLE_CHOCOLATE_CAKE = BLOCKS.register("black_candle_chocolate_cake", ()-> new CandleChocolateCakeBlock(Blocks.BLACK_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CHOCOLATE_CAKE.get())));
    public static final RegistryObject<Block> GRAY_CANDLE_CHOCOLATE_CAKE = BLOCKS.register("gray_candle_chocolate_cake", ()-> new CandleChocolateCakeBlock(Blocks.GRAY_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CHOCOLATE_CAKE.get())));
    public static final RegistryObject<Block> LIGHT_GRAY_CANDLE_CHOCOLATE_CAKE = BLOCKS.register("light_gray_candle_chocolate_cake", ()-> new CandleChocolateCakeBlock(Blocks.LIGHT_GRAY_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CHOCOLATE_CAKE.get())));
    public static final RegistryObject<Block> WHITE_CANDLE_CHOCOLATE_CAKE = BLOCKS.register("white_candle_chocolate_cake", ()-> new CandleChocolateCakeBlock(Blocks.WHITE_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CHOCOLATE_CAKE.get())));
    public static final RegistryObject<Block> LIGHT_BLUE_CANDLE_CHOCOLATE_CAKE = BLOCKS.register("light_blue_candle_chocolate_cake", ()-> new CandleChocolateCakeBlock(Blocks.LIGHT_BLUE_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CHOCOLATE_CAKE.get())));
    public static final RegistryObject<Block> BLUE_CANDLE_CHOCOLATE_CAKE = BLOCKS.register("blue_candle_chocolate_cake", ()-> new CandleChocolateCakeBlock(Blocks.BLUE_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CHOCOLATE_CAKE.get())));
    public static final RegistryObject<Block> CYAN_CANDLE_CHOCOLATE_CAKE  = BLOCKS.register("cyan_candle_chocolate_cake", ()-> new CandleChocolateCakeBlock(Blocks.CYAN_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CHOCOLATE_CAKE.get())));
    public static final RegistryObject<Block> GREEN_CANDLE_CHOCOLATE_CAKE = BLOCKS.register("green_candle_chocolate_cake", ()-> new CandleChocolateCakeBlock(Blocks.GREEN_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CHOCOLATE_CAKE.get())));
    public static final RegistryObject<Block> LIME_CANDLE_CHOCOLATE_CAKE = BLOCKS.register("lime_candle_chocolate_cake", ()-> new CandleChocolateCakeBlock(Blocks.LIME_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CHOCOLATE_CAKE.get())));
    public static final RegistryObject<Block> YELLOW_CANDLE_CHOCOLATE_CAKE = BLOCKS.register("yellow_candle_chocolate_cake", ()-> new CandleChocolateCakeBlock(Blocks.YELLOW_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CHOCOLATE_CAKE.get())));
    public static final RegistryObject<Block> ORANGE_CANDLE_CHOCOLATE_CAKE = BLOCKS.register("orange_candle_chocolate_cake", ()-> new CandleChocolateCakeBlock(Blocks.ORANGE_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CHOCOLATE_CAKE.get())));
    public static final RegistryObject<Block> RED_CANDLE_CHOCOLATE_CAKE = BLOCKS.register("red_candle_chocolate_cake", ()-> new CandleChocolateCakeBlock(Blocks.RED_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CHOCOLATE_CAKE.get())));
    public static final RegistryObject<Block> PINK_CANDLE_CHOCOLATE_CAKE = BLOCKS.register("pink_candle_chocolate_cake", ()-> new CandleChocolateCakeBlock(Blocks.PINK_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CHOCOLATE_CAKE.get())));
    public static final RegistryObject<Block> PURPLE_CANDLE_CHOCOLATE_CAKE = BLOCKS.register("purple_candle_chocolate_cake", ()-> new CandleChocolateCakeBlock(Blocks.PURPLE_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CHOCOLATE_CAKE.get())));
    public static final RegistryObject<Block> MAGENTA_CANDLE_CHOCOLATE_CAKE = BLOCKS.register("magenta_candle_chocolate_cake", ()-> new CandleChocolateCakeBlock(Blocks.MAGENTA_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CHOCOLATE_CAKE.get())));
    public static final RegistryObject<Block> BROWN_CANDLE_CHOCOLATE_CAKE = BLOCKS.register("brown_candle_chocolate_cake", ()-> new CandleChocolateCakeBlock(Blocks.BROWN_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CHOCOLATE_CAKE.get())));

    private static ToIntFunction<BlockState> litBlockEmission(int lightLevel) {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightLevel : 0;
    }
}

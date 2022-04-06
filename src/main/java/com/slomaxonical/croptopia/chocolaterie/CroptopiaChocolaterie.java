package com.slomaxonical.croptopia.chocolaterie;

import com.mojang.logging.LogUtils;
import com.slomaxonical.croptopia.chocolaterie.registry.BlockRegistry;
import com.slomaxonical.croptopia.chocolaterie.registry.ItemRegistry;
import me.thonk.common.MiscNames;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

import java.util.stream.Collectors;

import static me.thonk.croptopia.CroptopiaForge.cropBlocks;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("cacao")
public class CroptopiaChocolaterie
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static String MOD_ID = "cacao";
    public static CreativeModeTab CHOCOLATERIE_ITEM_GROUP;


    public CroptopiaChocolaterie(){
        BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        CHOCOLATERIE_ITEM_GROUP = new CreativeModeTab("cacao") {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(ItemRegistry.caramelMilkChocolate.get());
            }
        };
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent){
            // Register a new block here
        }
        @SubscribeEvent
        public static void onItemRegister(final RegistryEvent.Register<Item> itemRegister) {
            // Register a new item here
        }
    }

    public static ResourceLocation createIdentifier(String name) {
        return new ResourceLocation(MOD_ID, name);
    }

    public static Item registerItem(RegistryEvent.Register<Item> itemRegister, String itemName, Item item) {
        item.setRegistryName(createIdentifier(itemName));
        itemRegister.getRegistry().register(item);
        return item;
    }
    public static Block registerBlock(String blockName, Block block) {
        block.setRegistryName(createIdentifier(blockName));
        ForgeRegistries.BLOCKS.register(block);
        return block;
    }
    public static Item.Properties createGroup() {
        return new Item.Properties().tab(CHOCOLATERIE_ITEM_GROUP);
    }
}

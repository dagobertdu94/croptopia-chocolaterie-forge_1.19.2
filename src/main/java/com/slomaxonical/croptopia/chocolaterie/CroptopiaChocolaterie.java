package com.slomaxonical.croptopia.chocolaterie;

import com.mojang.logging.LogUtils;
import com.slomaxonical.croptopia.chocolaterie.datagen.CacaoBlockTags;
import com.slomaxonical.croptopia.chocolaterie.datagen.CacaoItemTags;
import com.slomaxonical.croptopia.chocolaterie.datagen.CacaoRecipes;
import com.slomaxonical.croptopia.chocolaterie.registry.BlockRegistry;
import com.slomaxonical.croptopia.chocolaterie.registry.ItemRegistry;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.data.event.GatherDataEvent;
import org.slf4j.Logger;

@Mod("cacao")
public class CroptopiaChocolaterie {

    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "cacao";
    public static CreativeModeTab CHOCOLATERIE_ITEM_GROUP;


    public CroptopiaChocolaterie(){
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockRegistry.BLOCKS.register(modBus);
        ItemRegistry.ITEMS.register(modBus);
        modBus.addListener(this::gatherData);

        MinecraftForge.EVENT_BUS.register(this);
        CHOCOLATERIE_ITEM_GROUP = new CreativeModeTab("cacao") {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(ItemRegistry.CARAMEL_MILK_CHOCOLATE.get());
            }
        };
    }
    public void gatherData(GatherDataEvent event){
        BlockTagsProvider provider = new CacaoBlockTags(event.getGenerator(), event.getExistingFileHelper());
        
        event.getGenerator().addProvider(true, provider);
        event.getGenerator().addProvider(true, new CacaoRecipes(event.getGenerator()));
        event.getGenerator().addProvider(true, new CacaoItemTags(event.getGenerator(),provider, event.getExistingFileHelper()));
    }
    @SubscribeEvent
   // public void onServerStarting(ServerStartingEvent event){}//Do something when the server starts

    public static Item.Properties createGroup() {
        return new Item.Properties().tab(CHOCOLATERIE_ITEM_GROUP);
    }
}

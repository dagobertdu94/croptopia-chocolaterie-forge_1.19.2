package com.slomaxonical.croptopia.chocolaterie;

import com.mojang.logging.LogUtils;
import com.slomaxonical.croptopia.chocolaterie.datagen.CacaoBlockTags;
import com.slomaxonical.croptopia.chocolaterie.datagen.CacaoItemTags;
import com.slomaxonical.croptopia.chocolaterie.datagen.CacaoRecipes;
import com.slomaxonical.croptopia.chocolaterie.registry.BlockRegistry;
import com.slomaxonical.croptopia.chocolaterie.registry.ItemRegistry;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.VanillaBlockTagsProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.data.event.GatherDataEvent;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import org.slf4j.Logger;

@Mod("cacao")
public class CroptopiaChocolaterie {

    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "cacao";
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_MODE_TABS.register("cacao", () -> CreativeModeTab.builder()
    		.withTabsBefore(CreativeModeTabs.COMBAT).displayItems((param, out) -> ItemRegistry.ITEMS.getEntries().forEach((obj) -> obj.ifPresent(out::accept)))
    		.title(Component.translatable("cacao")).icon(() -> new ItemStack(ItemRegistry.CARAMEL_MILK_CHOCOLATE.get())).build());
    
    public CroptopiaChocolaterie(){
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockRegistry.BLOCKS.register(modBus);
        ItemRegistry.ITEMS.register(modBus);
        modBus.addListener(this::gatherData);

        MinecraftForge.EVENT_BUS.register(this);
    }
    public void gatherData(GatherDataEvent event){
    	VanillaBlockTagsProvider provider = new CacaoBlockTags(event.getGenerator().getPackOutput(), event.getLookupProvider());
    	
        event.getGenerator().addProvider(true, provider);
        event.getGenerator().addProvider(true, new CacaoRecipes(event.getGenerator().getPackOutput()));
        event.getGenerator().addProvider(true, new CacaoItemTags(event.getGenerator().getPackOutput(),CompletableFuture.completedFuture(Provider.create(Stream.empty())),provider.contentsGetter(), event.getExistingFileHelper()));
    }
    //@SubscribeEvent
   // public void onServerStarting(ServerStartingEvent event){}//Do something when the server starts
    
    public static Item.Properties createGroup() {
    	return new Item.Properties();
    }
}

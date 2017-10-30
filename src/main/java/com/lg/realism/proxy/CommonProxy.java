package com.lg.realism.proxy;

import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import com.lg.realism.Realism;
import com.lg.realism.RegBlocks;
import com.lg.realism.RegItems;
import com.lg.realism.WorldGenRegistry;
import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBar;
import com.lg.realism.Capability.CapabilitiesSA.WaterLevelStorage;
import com.lg.realism.Config.ConfigManager;
import com.lg.realism.Craft.RealismCrafts;
import com.lg.realism.PSystem.NetworkHandler;
import com.lg.realism.fire.BlockFireGuiHandler;

public class CommonProxy {
    public void registerColouring() {}
    public void preInit(FMLPreInitializationEvent event) {
    	ConfigManager.register(event);
    	RegBlocks.register();
    	RegItems.register();
    	NetworkHandler.INSTANCE.init();
		CapabilityManager.INSTANCE.register(IBarLevel.class, new WaterLevelStorage(), WaterBar.class);

    
    }
    public void init(FMLInitializationEvent event) {
    	NetworkRegistry.INSTANCE.registerGuiHandler(Realism.INSTANCE, new BlockFireGuiHandler());
    	RealismCrafts.recipesRegister();
    	WorldGenRegistry.registry();
    }
    public void postInit(FMLPostInitializationEvent event) {}
}
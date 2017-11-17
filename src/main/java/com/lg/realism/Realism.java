package com.lg.realism;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lg.realism.Config.ConfigManager;
import com.lg.realism.CreativeTabs.DevRealism;
import com.lg.realism.CreativeTabs.MainRealism;
import com.lg.realism.World.Biome.BiomeInit;
import com.lg.realism.event.registration.RegEvents;
import com.lg.realism.fire.BlockFireTileEntity;
import com.lg.realism.proxy.CommonProxy;

@Mod(modid = Realism.MODID, version = Realism.VERSION)
public class Realism
{
    public static final String MODID = "realism";
    public static final String VERSION = "1.0";
    public static final String NAME = "Realism Mod";
    public static final Logger LOGGER = LogManager.getLogger();
    public static CreativeTabs tabMain = new MainRealism("tabMain");
    public static CreativeTabs tabDev = new DevRealism("tabDev");
    @SidedProxy(clientSide = "com.lg.realism.proxy.ClientProxy", serverSide = "com.lg.realism.proxy.CommonProxy")
   	public static CommonProxy proxy;
    @Mod.Instance
    public static Realism INSTANCE;
  
    //Materials
    public static Item.ToolMaterial StoneMaterial = EnumHelper.addToolMaterial("realism:StoneMaterial", 4, 74, 1.0F, 0.1F, 0);
    public static Item.ToolMaterial CopperMaterial = EnumHelper.addToolMaterial("realism:CopperMaterial", 4, 256, 2.0F, 0.4F, 0);
    public static Item.ToolMaterial IronMaterial = EnumHelper.addToolMaterial("realism:IronMaterial", 4, 600, 3.0F, 0.8F, 0);
    public static Item.ToolMaterial GoldenMaterial = EnumHelper.addToolMaterial("realism:GoldenMaterial", 4, 800, 4.0F, 1.3F, 0);
    public static Item.ToolMaterial DiamondMaterial = EnumHelper.addToolMaterial("realism:DiamondMaterial", 4, 2600, 8.0F, 4.0F, 0);
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	GameRegistry.registerTileEntity(BlockFireTileEntity.class, "BlockFireTileEntity");
    	BiomeInit.registerBiomes();
    	  proxy.preInit(event);
    	  RegEvents.register();
    	LOGGER.info("[MOD] Realism Mod enabled and loaded");
    	if(ConfigManager.debugGeneration) {
    	LOGGER.info("Generation debug enable");
    	}
    	if(!ConfigManager.debugGeneration){
        LOGGER.info("Generation debug disable");
        }
    }
    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	   proxy.postInit(event);
    }
}

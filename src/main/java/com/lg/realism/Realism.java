package com.lg.realism;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lg.realism.Config.ConfigManager;
import com.lg.realism.CreativeTabs.DevRealism;
import com.lg.realism.CreativeTabs.MainRealism;
import com.lg.realism.World.Biome.BiomeInit;
import com.lg.realism.event.registration.RegEvents;
import com.lg.realism.fire.BlockFireTileEntity;
import com.lg.realism.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Realism.MODID, version = Realism.VERSION)
public class Realism
{
	public static final String MODID = "realism";
	public static final String VERSION = "1.0";
	public static final String NAME = "Realism Mod";
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String[] AUTHORS = new String[] {"LegendGamer"};
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

		
		
		MinecraftForge.EVENT_BUS.register(this);
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



	/*
	 * Timer seasons\days\months etc
	 */


/*
 * it's a hell of a crutch: a method WorldTick for some reason I triggered three times, and so I had to build a crutch that divides the ticks for three
 */
	int counter = 0;
	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent e) {
		if (e.phase != e.phase.END) {
			return;
		}
		
		counter++;
		TimeTicker wsd = TimeTicker.get(e.world);
		int getTicks = (int)e.world.getTotalWorldTime();

	
		if(getTicks % ConfigManager.timeOneSec == 0 && counter % 3 == 0) {
			wsd.sec++;
		}
		if(getTicks % ConfigManager.timeOneMin == 0 && counter % 3 == 0) {
			wsd.min++;
		}
		if(getTicks % ConfigManager.timeOneHour == 0 && counter % 3 == 0) {
			wsd.hour++;
		}
		if(getTicks % ConfigManager.timeOneDay == 0 && counter % 3 == 0) {
			wsd.day++;
		}
		if(getTicks % ConfigManager.timeOneMonth == 0 && counter % 3 == 0) {
			wsd.month++;
		}
		if(getTicks % ConfigManager.timeOneSeason == 0 && counter % 3 == 0) {
			wsd.season++;
		}
		if(getTicks % ConfigManager.timeOneYear == 0 && counter % 3 == 0) {
			wsd.year++;
		}
		
		wsd.markDirty();

	}
	public static class TimeTicker extends WorldSavedData {
		private static final String name = "wsdName";

		public long century  = 0;
		public int year  = 0;
		public int month = 0;
		public int day   = 0;
		public int sec   = 0;
		public int min   = 0;
		public int hour  = 0;
		
		public int season = 0;

		public TimeTicker(String name) {
			super(name);
		}

		@Override
		public void readFromNBT(NBTTagCompound nbt) {
			sec = nbt.getInteger("sec");
			min = nbt.getInteger("min");
			day = nbt.getInteger("day");
			month = nbt.getInteger("month");
			year = nbt.getInteger("year");
			season = nbt.getInteger("season");
	//		century = nbt.getLong("century");
		}

		@Override
		public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
			nbt.setInteger("min", min);
			nbt.setInteger("sec", sec);
			nbt.setInteger("day", day);
			nbt.setInteger("month", month);
			nbt.setInteger("season", season);
			nbt.setInteger("year", year);
	//		nbt.setLong("century", century);
			return nbt;
		}

		public static TimeTicker get(World world) {
			MapStorage storage = world.getMapStorage();
			TimeTicker instance = (TimeTicker) storage.getOrLoadData(TimeTicker.class, name);
			if (instance == null) {
				instance = new TimeTicker(name);
				storage.setData(name, instance);
				instance.markDirty();

			}
			return instance;
		}
	}

}

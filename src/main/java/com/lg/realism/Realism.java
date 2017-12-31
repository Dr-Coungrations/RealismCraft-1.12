package com.lg.realism;

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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@Mod(modid = Realism.MODID, name = "Realism Mod", version = "1.0")
public final class Realism
{
	private int counter = 0;
	public static final String MODID = "realism";
	public static final Logger LOGGER = LogManager.getLogger();
	public static CreativeTabs tabMain = new MainRealism("tabMain"), tabDev = new DevRealism("tabDev");

	@Mod.Instance
	public static Realism INSTANCE;

	@SidedProxy(clientSide = "com.lg.realism.proxy.ClientProxy", serverSide = "com.lg.realism.proxy.CommonProxy")
	public static CommonProxy proxy;

	//Materials
	public static Item.ToolMaterial
			StoneMaterial = EnumHelper.addToolMaterial("realism:StoneMaterial", 4, 74, 1.0F, 0.1F, 0),
			CopperMaterial = EnumHelper.addToolMaterial("realism:CopperMaterial", 4, 256, 2.0F, 0.4F, 0),
			IronMaterial = EnumHelper.addToolMaterial("realism:IronMaterial", 4, 600, 3.0F, 0.8F, 0),
			GoldenMaterial = EnumHelper.addToolMaterial("realism:GoldenMaterial", 4, 800, 4.0F, 1.3F, 0),
			DiamondMaterial = EnumHelper.addToolMaterial("realism:DiamondMaterial", 4, 2600, 8.0F, 4.0F, 0);

	@EventHandler
	public void pre(FMLPreInitializationEvent e)
	{
		GameRegistry.registerTileEntity(BlockFireTileEntity.class, "BlockFireTileEntity");
		new BiomeInit();
		proxy.preInit(e);

		MinecraftForge.EVENT_BUS.register(this);
		LOGGER.info("[MOD] Realism Mod enabled and loaded");

        LOGGER.info(ConfigManager.debugGeneration ? "Generation debug enable" : "Generation debug disable");
	}

	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		proxy.init(e);
	}

	@EventHandler
	public void post(FMLPostInitializationEvent e)
	{
		proxy.postInit(e);
	}

	/*
	 * Timer seasons\days\months etc
	 */
	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent e)
	{
		if (e.phase == e.phase.END)
		{
			counter++;
			TimeTicker wsd = TimeTicker.get(e.world);
			int getTicks = (int) e.world.getTotalWorldTime();

			if (getTicks % ConfigManager.timeOneSec == 0 && counter % 3 == 0)
			{
				wsd.sec++;
			}

			if (getTicks % ConfigManager.timeOneMin == 0 && counter % 3 == 0)
			{
				wsd.min++;
			}

			if (getTicks % ConfigManager.timeOneHour == 0 && counter % 3 == 0)
			{
				wsd.hour++;
			}

			if (getTicks % ConfigManager.timeOneDay == 0 && counter % 3 == 0)
			{
				wsd.day++;
			}

			if (getTicks % ConfigManager.timeOneMonth == 0 && counter % 3 == 0)
			{
				wsd.month++;
			}

			if (getTicks % ConfigManager.timeOneSeason == 0 && counter % 3 == 0)
			{
				wsd.season++;
			}

			if (getTicks % ConfigManager.timeOneYear == 0 && counter % 3 == 0)
			{
				wsd.year++;
			}

			wsd.markDirty();
		}
	}

	public static class TimeTicker extends WorldSavedData
    {
		private static final String name = "wsdName";

		public long century  = 0;
		public int year = 0, month = 0, day = 0, sec = 0, min = 0, hour = 0;
		
		public int season = 0;

		TimeTicker(String name)
        {
			super(name);
		}

		@Override
		public void readFromNBT(NBTTagCompound nbt)
        {
			sec = nbt.getInteger("sec");
			min = nbt.getInteger("min");
			day = nbt.getInteger("day");
			month = nbt.getInteger("month");
			year = nbt.getInteger("year");
			season = nbt.getInteger("season");
            //century = nbt.getLong("century");
		}

		@Override
		public NBTTagCompound writeToNBT(NBTTagCompound nbt)
        {
			nbt.setInteger("min", min);
			nbt.setInteger("sec", sec);
			nbt.setInteger("day", day);
			nbt.setInteger("month", month);
			nbt.setInteger("season", season);
			nbt.setInteger("year", year);
            //nbt.setLong("century", century);
			return nbt;
		}

		public static TimeTicker get(World world)
        {
			MapStorage storage = world.getMapStorage();
			TimeTicker instance = (TimeTicker) storage.getOrLoadData(TimeTicker.class, name);

			if (instance == null)
			{
				instance = new TimeTicker(name);
				storage.setData(name, instance);
				instance.markDirty();
			}
			return instance;
		}
	}
}
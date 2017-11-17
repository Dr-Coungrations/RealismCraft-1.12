package com.lg.realism.API.WorldAPI;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class TimeHundler {

	public static final	Minecraft mc = Minecraft.getMinecraft();
	public static final World CLIENT_WORLD = mc.getMinecraft().world;
	int day;
	public int hour;
	@SubscribeEvent
	public void converterTime(TickEvent.WorldTickEvent event) {
		WorldSavedData storage = event.world.loadData(TimeTicker.class, "day");
		hour = (int)event.world.getTotalWorldTime()/24000;
		

	}
	
	public class TimeTicker extends WorldSavedData{

		public TimeTicker(String name) {
			super(name);
		}

		@Override
		public void readFromNBT(NBTTagCompound nbt) {
			nbt.getInteger("hour");
			
		}

		@Override
		public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
			nbt.setInteger("hour",hour);
			return nbt;
		}

	}

	
}



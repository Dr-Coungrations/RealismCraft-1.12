package com.lg.realism.event;

import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WorldResetTime {
	@SubscribeEvent
	public void resetTime(WorldEvent event){
		if(event.getWorld().getWorldTime() >= 24001){
			event.getWorld().setWorldTime(0);
		}
	}
}

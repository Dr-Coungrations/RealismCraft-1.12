package com.lg.realism.event;

import com.lg.realism.Config.ConfigManager;
import com.lg.realism.Realism.TimeTicker;

import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class SeasonEventer {
	int counter;
	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		World world = event.world;
		TimeTicker wsd = TimeTicker.get(world);
		counter++;
		if(wsd.season % 3 == 0 && counter % 3 == 0) {
			
			
			
			
		}
		
	}
	
}

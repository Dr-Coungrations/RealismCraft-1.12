package com.lg.realism.event.registration;

import com.lg.realism.API.WorldAPI.TimeHundler;
import com.lg.realism.Diseaces.Cold;
import com.lg.realism.Diseaces.Grippe;
import com.lg.realism.event.AmfRenderEvent;
import com.lg.realism.event.CapEventHandler;
import com.lg.realism.event.ClearDropsEvent;
import com.lg.realism.event.ClonePlayer;
import com.lg.realism.event.DropDeadHorse;
import com.lg.realism.event.EventDrinkBar;
import com.lg.realism.event.EventHandThirstUpdate;
import com.lg.realism.event.EventJoinToWorld;
import com.lg.realism.event.EventNewLevelPickaxe;
import com.lg.realism.event.EventSaveWaterLevel;
import com.lg.realism.event.EventThirstUpdate;
import com.lg.realism.event.EventToolMode;
import com.lg.realism.event.FilledJar;
import com.lg.realism.event.PlaceOnBlock;
import com.lg.realism.event.RenderTextEvent;
import com.lg.realism.event.ShovelEvent;
import com.lg.realism.event.TempEventHundler;
import com.lg.realism.event.UnbreakBlock;
import com.lg.realism.event.VisualTempBody;
import com.lg.realism.event.WorldResetTime;

import net.minecraftforge.common.MinecraftForge;

public class RegEvents {
		public static void register(){
	    	register(new UnbreakBlock());
	    	register(new ShovelEvent());
	    	register(new PlaceOnBlock());
	    	register(new ClearDropsEvent());
	    	register(new CapEventHandler());
	    	register(new ClonePlayer());
	    	register(new EventNewLevelPickaxe());
	    	register(new EventDrinkBar());
	    	register(new EventJoinToWorld());
	    	register(new EventSaveWaterLevel());
	    	register(new EventHandThirstUpdate());
	    	register(new EventThirstUpdate());
	    	register(new TempEventHundler());
	    	register(new DropDeadHorse());
	    	register(new Cold());
	    	register(new RenderTextEvent());
	    	register(new Grippe());
	    	register(new VisualTempBody());
	       	register(new FilledJar());
	    	//register(new DelRecipesHundler());
	     	register(new WorldResetTime());
	     	register(new AmfRenderEvent());
	     	register(new EventToolMode());
	     	register(new TimeHundler());
		}
		
		static void register(Object object) {
			MinecraftForge.EVENT_BUS.register(object);
		}
}

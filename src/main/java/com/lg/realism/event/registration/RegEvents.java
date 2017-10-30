package com.lg.realism.event.registration;

import net.minecraftforge.common.MinecraftForge;

import com.lg.realism.Diseaces.Cold;
import com.lg.realism.Diseaces.Grippe;
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
import com.lg.realism.event.FilledJar;
import com.lg.realism.event.PlaceOnBlock;
import com.lg.realism.event.RenderTextEvent;
import com.lg.realism.event.ShovelEvent;
import com.lg.realism.event.TempEventHundler;
import com.lg.realism.event.UnbreakBlock;
import com.lg.realism.event.VisualTempBody;
import com.lg.realism.event.WorldResetTime;
import com.lg.realism.event.DelRecipesEvent.DelRecipesHundler;

public class RegEvents {
	public static void register(){
    	MinecraftForge.EVENT_BUS.register(new UnbreakBlock());
    	MinecraftForge.EVENT_BUS.register(new ShovelEvent());
    	MinecraftForge.EVENT_BUS.register(new PlaceOnBlock());
    	MinecraftForge.EVENT_BUS.register(new ClearDropsEvent());
    	MinecraftForge.EVENT_BUS.register(new CapEventHandler());
    	MinecraftForge.EVENT_BUS.register(new ClonePlayer());
    	MinecraftForge.EVENT_BUS.register(new EventNewLevelPickaxe());
    	MinecraftForge.EVENT_BUS.register(new EventDrinkBar());
    	MinecraftForge.EVENT_BUS.register(new EventJoinToWorld());
    	MinecraftForge.EVENT_BUS.register(new EventSaveWaterLevel());
    	MinecraftForge.EVENT_BUS.register(new EventHandThirstUpdate());
    	MinecraftForge.EVENT_BUS.register(new EventThirstUpdate());
    	MinecraftForge.EVENT_BUS.register(new TempEventHundler());
    	MinecraftForge.EVENT_BUS.register(new DropDeadHorse());
    	MinecraftForge.EVENT_BUS.register(new Cold());
    	MinecraftForge.EVENT_BUS.register(new RenderTextEvent());
    	MinecraftForge.EVENT_BUS.register(new Grippe());
    	MinecraftForge.EVENT_BUS.register(new VisualTempBody());
       	MinecraftForge.EVENT_BUS.register(new FilledJar());
    	//MinecraftForge.EVENT_BUS.register(new DelRecipesHundler());
     	MinecraftForge.EVENT_BUS.register(new WorldResetTime());
	}
}

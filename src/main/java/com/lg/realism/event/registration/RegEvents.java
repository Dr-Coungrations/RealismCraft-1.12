package com.lg.realism.event.registration;

import com.lg.realism.Particle.ParticleEvent;
import com.lg.realism.event.BurnTorchEvent;
import com.lg.realism.event.CanceledVanillaInv;
import com.lg.realism.event.ClearDropsEvent;
import com.lg.realism.event.DropDeadHorse;
import com.lg.realism.event.EventHandThirstUpdate;
import com.lg.realism.event.EventJoinToWorld;
import com.lg.realism.event.EventNewLevelPickaxe;
import com.lg.realism.event.EventToolMode;
import com.lg.realism.event.PlaceOnBlock;
import com.lg.realism.event.RenderTextEvent;
import com.lg.realism.event.SeasonEventer;
import com.lg.realism.event.ShovelEvent;
import com.lg.realism.event.TempEventHundler;
import com.lg.realism.event.UnbreakBlock;
import com.lg.realism.event.VisualTempBody;
import com.lg.realism.event.WorldResetTime;
import com.lg.realism.event.Diseaces.Cold;
import com.lg.realism.event.Diseaces.Grippe;
import com.lg.realism.event.SystemWeight.EventWeight;
import com.lg.realism.event.WaterBarEvent.CapEventHandler;
import com.lg.realism.event.WaterBarEvent.ClonePlayer;
import com.lg.realism.event.WaterBarEvent.EventDrinkBar;
import com.lg.realism.event.WaterBarEvent.EventSaveWaterLevel;
import com.lg.realism.event.WaterBarEvent.EventThirstUpdate;
import com.lg.realism.event.WaterBarEvent.FilledJar;

import net.minecraftforge.common.MinecraftForge;

public class RegEvents {
	public static class Server
	{
		public Server()
		{

			register(new UnbreakBlock());
			register(new ShovelEvent());
			register(new PlaceOnBlock());
			register(new ClearDropsEvent());
			register(new CapEventHandler());
			register(new ClonePlayer());
			register(new EventNewLevelPickaxe());

			register(new EventJoinToWorld());
			register(new EventSaveWaterLevel());
			register(new EventHandThirstUpdate());
			register(new EventThirstUpdate());
			register(new TempEventHundler());
			register(new DropDeadHorse());
			register(new Cold());

			register(new Grippe());


			register(new CanceledVanillaInv());
			register(new WorldResetTime());
			// 	register(new AmfRenderEvent());

			register(new BurnTorchEvent());
			register(new SeasonEventer());
			register(new EventWeight());
		
			 	
			// 	register(new SeasonEventer());
			//  	register(new EventPermPickup());

		}
	}
	public static class Client
	{
		public Client()
		{
			register(new EventDrinkBar());
			register(new RenderTextEvent());
			register(new VisualTempBody());
			register(new FilledJar());
			register(new ParticleEvent());
			register(new EventToolMode());
		}
	}
	static void register(Object object) {
		MinecraftForge.EVENT_BUS.register(object);
	}
}

package com.lg.realism.event.registration;

import com.lg.realism.Diseaces.Cold;
import com.lg.realism.Diseaces.Grippe;
import com.lg.realism.event.*;
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
	     	register(new BurnTorchEvent());
	   //  	register(new NewTimeHundler());
	     //	register(new PickingUpEvent());
		}
		
		static void register(Object object) {
			MinecraftForge.EVENT_BUS.register(object);
		}
}

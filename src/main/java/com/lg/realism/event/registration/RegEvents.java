package com.lg.realism.event.registration;

import com.lg.realism.Diseaces.Cold;
import com.lg.realism.Diseaces.Grippe;
import com.lg.realism.event.*;
import net.minecraftforge.common.MinecraftForge;

public final class RegEvents
{
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
            //register(new DelRecipesHundler());
            register(new WorldResetTime());
            register(new AmfRenderEvent());
            register(new BurnTorchEvent());
            //  	register(new NewTimeHundler());
            //	register(new PickingUpEvent());
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
            register(new EventToolMode());
        }
    }

    private static void register(Object object)
    {
        MinecraftForge.EVENT_BUS.register(object);
    }
}
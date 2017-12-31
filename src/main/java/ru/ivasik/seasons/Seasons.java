package ru.ivasik.seasons;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;

@Mod(modid = "seasons", name = "Seasons", version = "1.0", dependencies = "required-after:realism;")
public final class Seasons
{
    @Mod.Instance("seasons")
    public static Seasons INSTANCE;

    public static final ResourceLocation DATE = new ResourceLocation("seasons","date");

    @Mod.EventHandler
    public void pre(FMLPreInitializationEvent e)
    {
        new EventsHandler();
    }

    @Mod.EventHandler
    public void server(FMLServerStartedEvent e)
    {
        MinecraftServer instance = FMLCommonHandler.instance().getMinecraftServerInstance();

        World w = instance.getEntityWorld();
    }

    public static int getHour()
    {
        Long time = Minecraft.getMinecraft().world.getWorldTime();
        return (int) (time / 1000L + 6L) % 24;
    }

    public static int getMinutes()
    {
        Long time = Minecraft.getMinecraft().world.getWorldTime();
        return (int) ((float) time / 16.666666F % 60.0F);
    }
}
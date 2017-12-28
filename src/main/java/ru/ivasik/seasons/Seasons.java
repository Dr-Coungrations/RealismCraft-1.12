package ru.ivasik.seasons;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
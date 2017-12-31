package ru.ivasik.seasons;

import net.minecraft.init.Biomes;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.ivasik.seasons.api.IDate;
import ru.ivasik.seasons.data.DateProvider;
import ru.ivasik.seasons.data.DateStorage;

public final class EventsHandler
{
    EventsHandler()
    {
        MinecraftForge.EVENT_BUS.register(this);
        CapabilityManager.INSTANCE.register(IDate.class, DateStorage.INSTANCE, DateStorage.INSTANCE);
    }

    @SubscribeEvent
    public void onWorldDate(AttachCapabilitiesEvent<World> e)
    {
        if (e.getObject() != null)
            e.addCapability(Seasons.DATE, new DateProvider());
    }

    @SubscribeEvent
    public void onWorldTick(TickEvent.WorldTickEvent e)
    {
        if (e.world != null)
        {
            IDate date = e.world.getCapability(DateProvider.DATE, null);
        }
    }

    @SubscribeEvent
    public void onBiomeColor(BiomeEvent.BiomeColor e)
    {
        //THIS IS BULLSHIT
        /*for (Biome biome : BiomeProvider.allowedBiomes)
        {
            if (biome != Biomes.DESERT || biome != Biomes.DESERT_HILLS)
            {
                //e.setNewColor(0x000000);
            }
        }*/
    }

    @SubscribeEvent
    public void onBiome(BiomeEvent e)
    {
        if (e.getBiome() == Biomes.DESERT || e.getBiome() == Biomes.FOREST)
        {
            e.getBiome().temperature = 0.0F;
            e.getBiome().enableRain = false;
            e.getBiome().enableSnow = true;
            e.getBiome().waterColor = 0xFF3235;
        }
    }
}
package com.lg.realism;

import com.lg.realism.API.WorldAPI.DateProvider;
import com.lg.realism.API.WorldAPI.DateStorage;
import com.lg.realism.API.WorldAPI.IDate;

import net.minecraft.init.Biomes;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public final class SeasonEventer
{
	SeasonEventer()
    {
        MinecraftForge.EVENT_BUS.register(this);
        CapabilityManager.INSTANCE.register(IDate.class, DateStorage.INSTANCE, DateStorage.INSTANCE);
    }

    @SubscribeEvent
    public void onWorldDate(AttachCapabilitiesEvent<World> e)
    {
        if (e.getObject() != null)
            e.addCapability(Realism.DATE, new DateProvider());
    }

    @SubscribeEvent
    public void onWorldTick(TickEvent.WorldTickEvent e)
    {
        if (e.world != null)
        {
            IDate date = e.world.getCapability(DateProvider.DATE, null);
        }
    }




}
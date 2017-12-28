package ru.ivasik.seasons;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = "seasons", name = "Seasons", version = "1.0", dependencies = "required-after:realism;")
public final class Seasons
{
    @Mod.Instance("seasons")
    public static Seasons INSTANCE;

    @Mod.EventHandler
    public void pre(FMLPreInitializationEvent e)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onBiomeColor(BiomeEvent.BiomeColor e)
    {
        for (Biome biome : BiomeProvider.allowedBiomes)
        {
            if (biome != Biomes.DESERT || biome != Biomes.DESERT_HILLS)
            {
                //e.setNewColor(0x000000);
            }
        }
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
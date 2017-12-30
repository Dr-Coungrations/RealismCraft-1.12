package com.lg.realism.event;

import com.lg.realism.Realism.TimeTicker;

import net.minecraft.init.Biomes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SeasonEventer {
	
	MinecraftServer ws = FMLCommonHandler.instance().getMinecraftServerInstance();
	World world = ws.worlds[0];
	
	@SubscribeEvent
	public void biomeColorGrass(BiomeEvent.GetGrassColor e) {	

		for (Biome biome : BiomeProvider.allowedBiomes)
        {
				if (biome != Biomes.DESERT || biome != Biomes.DESERT_HILLS)
				{
					TimeTicker wsd = TimeTicker.get(world);
					if(wsd.season == 0)e.setNewColor(0xFFFFFF);
					//0xDDDD55 - ����
					//0x89FF8F - �����
					//0xBECE0F - �����
					//0xFFFFFF - ����
					e.setNewColor(0xBECE0F);
				
				}
        }
	}

	@SubscribeEvent
	public void biomeColorWater(BiomeEvent.GetWaterColor e) {
		
		
		for (Biome biome : BiomeProvider.allowedBiomes)
        {
            if (biome != Biomes.DESERT || biome != Biomes.DESERT_HILLS)
            {
            	//0xDDDD55 - ����
                e.setNewColor(0xDDDD55);
                
            }
        }
	}
    @SubscribeEvent
    public void onBiome(BiomeEvent e)
    {
        if (e.getBiome() == Biomes.FOREST_HILLS || e.getBiome() == Biomes.FOREST || e.getBiome() == Biomes.BEACH || e.getBiome() == Biomes.RIVER)
        {
            e.getBiome().temperature = 0.0F;
            e.getBiome().enableRain = false;
            e.getBiome().enableSnow = true;
         //   e.getBiome().waterColor = 0xFF3235;
        }
    }
	@SubscribeEvent
	public void biomeColorFoliage(BiomeEvent.GetFoliageColor e) {
		
		
		for (Biome biome : BiomeProvider.allowedBiomes)
        {
		
            if (biome != Biomes.DESERT || biome != Biomes.DESERT_HILLS)
            {
            
            	//0xDDDD55 - ����
            	//0x700400 - ������� ������
            	//0xEE9200 - ��������� ������
            	//0xFFE269 - ������ ������ 
            	//0x00FF0D - �����
            	//0xFFFFFF - ����(�� ���� ������ ������ ���������)
                e.setNewColor(0x700400);
                
            }
			}
	}

}

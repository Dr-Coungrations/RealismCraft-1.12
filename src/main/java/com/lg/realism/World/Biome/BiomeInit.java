package com.lg.realism.World.Biome;

import com.lg.realism.World.Biome.Biomes.BiomeDeadForest;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit
{
	private final Biome DEADFOREST = new BiomeDeadForest();

	public BiomeInit()
    {
        initBiome(DEADFOREST,"deadforest", BiomeType.WARM, Type.HILLS, Type.FOREST, Type.DRY);
    }

	private Biome initBiome(Biome biome, String name, BiomeType biometype, Type... types)
    {
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biometype, new BiomeEntry(biome, 10));
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.isTypeListModded(biometype);
		
		return biome;
	}
}
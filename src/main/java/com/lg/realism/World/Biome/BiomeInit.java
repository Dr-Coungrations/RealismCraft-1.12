package com.lg.realism.World.Biome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import com.lg.realism.World.Biome.Biomes.BiomeDeadForest;

public class BiomeInit{
	
	public static final Biome DEADFOREST = new BiomeDeadForest();
	
	public static void registerBiomes(){
		initBiome(DEADFOREST,"deadforest", BiomeType.WARM, Type.HILLS, Type.FOREST, Type.DRY);
	}
	public static Biome initBiome(Biome biome, String name, BiomeType biometype, Type... types){
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biometype, new BiomeEntry(biome, 10));
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.isTypeListModded(biometype);
		
		return biome;
		
	}
		
	


}

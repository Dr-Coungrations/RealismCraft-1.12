package com.lg.realism.World.Biome;

import java.util.Random;

import net.minecraft.util.ObjectIntIdentityMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.NoiseGeneratorPerlin;

public class BiomeRegistry extends Biome{
	
	public BiomeRegistry(BiomeProperties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	public static Biome newswamp;
	public static final int newswampID = 87;

	public static void registry(){
		
	}


}

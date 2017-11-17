package com.lg.realism.World;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.lg.realism.World.Biome.WorldGenThisBiome.WorldGenAsh;
import com.lg.realism.World.GenFallingWood.BreakBirchGen;
import com.lg.realism.World.GenFallingWood.BreakOakGen;

public class WorldGeneratorOne implements IWorldGenerator {


	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		
		switch (world.provider.getDimension()){
		case 0:
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
			break;
			
		}
	}
		public void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider){		
		
			generateBreakWood(world, random, chunkX, chunkZ);
			generateBreakWoodBirch(world, random, chunkX, chunkZ);
			
			generateAsh(world, random, chunkX, chunkZ);
		
			
		}
		private void generateBreakWood(World world, Random random, int chunkX, int chunkZ){
			
			int x = (chunkX << 4) + random.nextInt(16) + 8;
			int y = random.nextInt(128);
			int z = (chunkZ << 4) + random.nextInt(16) + 8;
			
			new BreakOakGen().generate(world, random, new BlockPos(x, y, z));
			
		}
		private void generateAsh(World world, Random random, int chunkX, int chunkZ){
			
			int x = (chunkX << 4) + random.nextInt(16) + 8;
			int y = random.nextInt(128);
			int z = (chunkZ << 4) + random.nextInt(16) + 8;

			new WorldGenAsh().generate(world, random, new BlockPos(x, y, z));
			
		}
		private void generateBreakWoodBirch(World world, Random random, int chunkX, int chunkZ){
			
			int x = (chunkX << 4) + random.nextInt(16) + 8;
			int y = random.nextInt(128);
			int z = (chunkZ << 4) + random.nextInt(16) + 8;

			new BreakBirchGen().generate(world, random, new BlockPos(x, y, z));
			
		}
		
	}
package com.lg.realism.World;

import com.lg.realism.World.GenCactus.WorldGenNewCactus;
import com.lg.realism.World.WorldGenOasis.WorldGenOasis;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGeneratorFour implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{

		switch (world.provider.getDimension()){
		case 0:
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
			break;

		}
	}
	public void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider){		


		generateNewCactus(world, random, chunkX, chunkZ);

		generateOasis(world, random, chunkX, chunkZ);
	}
	private void generateOasis(World world, Random random, int chunkX, int chunkZ){


		int x = (chunkX << 4) + random.nextInt(16) + 8;
		int y = random.nextInt(128);
		int z = (chunkZ << 4) + random.nextInt(16) + 8;
		BlockPos pos = new BlockPos(x,y,z);

		if((world.getBiome(pos) == Biomes.DESERT || world.getBiome(pos) == Biomes.DESERT_HILLS) && world.isAirBlock(pos) && world.getBlockState(pos.down()) == Blocks.SAND.getDefaultState()){
			new WorldGenOasis().generate(world, random, new BlockPos(x, y, z));
		}

	}



	private void generateNewCactus(World world, Random random, int chunkX, int chunkZ){


		int x = (chunkX) + random.nextInt(8);
		int y = random.nextInt(128);
		int z = (chunkZ) + random.nextInt(8);
		BlockPos pos = new BlockPos(x,y,z);
		if((world.getBiome(pos) == Biomes.DESERT || world.getBiome(pos) == Biomes.DESERT_HILLS) && world.isAirBlock(pos) && world.getBlockState(pos.down()) == Blocks.SAND.getDefaultState()){
			new WorldGenNewCactus().generate(world, random, new BlockPos(x, y, z));
		}
		//�������� ������� ��������� ���������� � ��������. � ����� ���������� ����������, ����������� �������� ������������������� ��������!
	}

}

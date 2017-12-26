package com.lg.realism.World;

import com.lg.realism.World.GenFallingWood.BreakAcaciaGen;
import com.lg.realism.World.GenFallingWood.BreakSpruceGen;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGeneratorTwo implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.getDimension())
		{
			case 0:
				generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
				break;
		}
	}

	public void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		generateBreakWoodSpruce(world, random, chunkX, chunkZ);
		generateBreakWoodAcacia(world, random, chunkX, chunkZ);
	}

	private void generateBreakWoodSpruce(World world, Random random, int chunkX, int chunkZ)
	{
		int
				x = (chunkX << 4) + random.nextInt(16) + 8,
				y = random.nextInt(128),
				z = (chunkZ << 4) + random.nextInt(16) + 8;

		new BreakSpruceGen().generate(world, random, new BlockPos(x, y, z));
	}

	private void generateBreakWoodAcacia(World world, Random random, int chunkX, int chunkZ)
	{
		int
				x = (chunkX << 4) + random.nextInt(16) + 8,
				y = random.nextInt(128),
				z = (chunkZ << 4) + random.nextInt(16) + 8;

		new BreakAcaciaGen().generate(world, random, new BlockPos(x, y, z));
	}
}
package com.lg.realism.World;

import com.lg.realism.World.GenSalt.WorldGenSalt;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGeneratorThree implements IWorldGenerator
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
		generateSalt(world, random, chunkX, chunkZ);
	}

	private void generateSalt(World world, Random random, int chunkX, int chunkZ)
	{
		int
				x = (chunkX << 4) + random.nextInt(16) + 8,
				y = random.nextInt(128),
				z = (chunkZ << 4) + random.nextInt(16) + 8;

		new WorldGenSalt().generate(world, random, new BlockPos(x, y, z));
	}
}
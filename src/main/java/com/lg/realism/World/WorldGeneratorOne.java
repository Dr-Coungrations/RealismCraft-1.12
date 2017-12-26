package com.lg.realism.World;

import com.lg.realism.RegBlocks;
import com.lg.realism.World.Biome.WorldGenThisBiome.WorldGenDeadTree;
import com.lg.realism.World.GenFallingWood.BreakBirchGen;
import com.lg.realism.World.GenFallingWood.BreakOakGen;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGeneratorOne implements IWorldGenerator
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
		generateBreakWood(world, random, chunkX, chunkZ);
		generateBreakWoodBirch(world, random, chunkX, chunkZ);
		generateDeadTree(world, random, chunkX, chunkZ);
		generateAsh(world, random, chunkX, chunkZ);
	}

	private void generateDeadTree(World world, Random random, int chunkX, int chunkZ)
	{
		int
				x = (chunkX<< 4)+ random.nextInt(16) + 8,
				y = random.nextInt(128),
				z = (chunkZ<< 4) + random.nextInt(16) + 8;

		new WorldGenDeadTree().generate(world, random, new BlockPos(x, y, z));
	}

	private void generateBreakWood(World world, Random random, int chunkX, int chunkZ)
	{
		int
				x = (chunkX << 4) + random.nextInt(16) + 8,
				y = random.nextInt(128),
				z = (chunkZ << 4) + random.nextInt(16) + 8;

		new BreakOakGen().generate(world, random, new BlockPos(x, y, z));
	}

	private void generateAsh(World world, Random random, int chunkX, int chunkZ)
	{
		int
				x = (chunkX << 4) + random.nextInt(16) + 8,
				y = random.nextInt(128),
				z = (chunkZ << 4) + random.nextInt(16) + 8;

		for ( y = 1; y < world.getHeight(); ++y)
		{
			for (int x1 = x; x1 < x + 16; ++x1)
			{
				for (int z1 = z; z1 < z + 16; ++z1)
				{
					if (world.getBlockState(new BlockPos(x1, y - 1, z1)).getBlock() == Blocks.GRASS)
						world.setBlockState(new BlockPos(x1, y, z1), RegBlocks.ash.getDefaultState());
				}
			}
		}
	}

	private void generateBreakWoodBirch(World world, Random random, int chunkX, int chunkZ)
	{
		int
				x = (chunkX << 4) + random.nextInt(16) + 8,
				y = random.nextInt(128),
				z = (chunkZ << 4) + random.nextInt(16) + 8;

		new BreakBirchGen().generate(world, random, new BlockPos(x, y, z));
	}
}
package com.lg.realism.World.Biome.WorldGenThisBiome;

import java.util.Random;

import com.lg.realism.RegBlocks;
import com.lg.realism.World.Biome.BiomeInit;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenAsh extends WorldGenerator
{
	private final IBlockState ash;

	public WorldGenAsh()
	{
		this.ash = RegBlocks.ash.getDefaultState();
	}

	public boolean generate(World worldIn, Random rand, BlockPos position)
	{
		for (IBlockState iblockstate = worldIn.getBlockState(position); (iblockstate.getBlock().isAir(iblockstate, worldIn, position) || iblockstate.getBlock().isLeaves(iblockstate, worldIn, position)) && position.getY() > 0; iblockstate = worldIn.getBlockState(position))
		{
			position = position.down();
		}

		for (int i = 0; i < 128; ++i)
		{
				BlockPos blockpos = position.add(rand.nextInt(10) - rand.nextInt(10), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
				if(worldIn.getBiome(position) == BiomeInit.DEADFOREST){
					if (worldIn.isAirBlock(blockpos) && worldIn.getBlockState(blockpos.down()) != Blocks.AIR  && worldIn.getBlockState(blockpos.down()) != Blocks.WATER)
					{
						worldIn.setBlockState(blockpos, this.ash, 2);
					}
				}
		}

		return true;
	}
}

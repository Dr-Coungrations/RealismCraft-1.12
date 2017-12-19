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
	@Override
	public boolean generate(World world, Random rand, BlockPos pos)
	{
		for (IBlockState iblockstate = world.getBlockState(pos); (iblockstate.getBlock().isAir(iblockstate, world, pos) || iblockstate.getBlock().isLeaves(iblockstate, world, pos))
				&& pos.getY() > 0; iblockstate = world.getBlockState(pos))
		{
			pos = pos.down();
		}


		for (int i = 0; i < 64; ++i)
		{
			for (int j = 0; j < 64; ++j)
			{
				for (int k = 0; k < 64; ++k)
				{
					BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

					if (world.isAirBlock(blockpos) && world.getBlockState(blockpos.down()).getBlock() == RegBlocks.blockburntgrass)
					{
						world.setBlockState(blockpos, RegBlocks.ash.getDefaultState(), 2);
					}
				}
			}
		}
		return true;
	}

}
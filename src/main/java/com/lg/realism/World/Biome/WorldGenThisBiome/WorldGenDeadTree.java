package com.lg.realism.World.Biome.WorldGenThisBiome;

import java.util.Random;

import com.lg.realism.RegBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDeadTree extends WorldGenerator {
	@Override
	public boolean generate(World world, Random rand, BlockPos pos)
	{
		for (IBlockState iblockstate = world.getBlockState(pos); (iblockstate.getBlock().isAir(iblockstate, world, pos) || iblockstate.getBlock().isLeaves(iblockstate, world, pos))
				&& pos.getY() > 0; iblockstate = world.getBlockState(pos))
		{
			pos = pos.down();
		}


		for (int i = 0; i < 128; ++i)
		{

	

					BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

					if (world.isAirBlock(blockpos) && world.getBlockState(blockpos.down()) == Blocks.GRASS)
					{
						int randomBranch = rand.nextInt(5);
						for(int height = 0; height < 5; ++height) {
							world.setBlockState(new BlockPos(blockpos.getX(),blockpos.getY(),blockpos.getZ()), RegBlocks.blockdeadtree.getDefaultState(), 2);
						}
						if(randomBranch != 1 || randomBranch != 0) {
							world.setBlockState(new BlockPos(blockpos.getX() + 1,blockpos.getY() + randomBranch,blockpos.getZ()), RegBlocks.blockdeadtree.getDefaultState(), 2);
							world.setBlockState(new BlockPos(blockpos.getX() - 1,blockpos.getY() + randomBranch,blockpos.getZ()), RegBlocks.blockdeadtree.getDefaultState(), 2);
							world.setBlockState(new BlockPos(blockpos.getX(),blockpos.getY() + randomBranch,blockpos.getZ()-1), RegBlocks.blockdeadtree.getDefaultState(), 2);
							world.setBlockState(new BlockPos(blockpos.getX(),blockpos.getY() + randomBranch,blockpos.getZ()+1), RegBlocks.blockdeadtree.getDefaultState(), 2);
						}
				
			}
		}
		return true;
	}

}

/*

				BlockPos pos = position.add(position.getX(), position.getY(), position.getZ());
				if(worldIn.getBiome(position) == BiomeInit.DEADFOREST){
					if (worldIn.isAirBlock(pos) && worldIn.getBlockState(pos.down()) != Blocks.AIR  && worldIn.getBlockState(pos.down()) != Blocks.WATER)
					{
						int randomBranch = rand.nextInt(5);
						for(int height = 0; height < 5; ++height) {
						worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY(),pos.getZ()), RegBlocks.blockdeadtree.getDefaultState(), 2);
						}
						if(randomBranch != 1 || randomBranch != 0) {
						worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + randomBranch,pos.getZ()), RegBlocks.blockdeadtree.getDefaultState(), 2);
						worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + randomBranch,pos.getZ()), RegBlocks.blockdeadtree.getDefaultState(), 2);
						worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY() + randomBranch,pos.getZ()-1), RegBlocks.blockdeadtree.getDefaultState(), 2);
						worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY() + randomBranch,pos.getZ()+1), RegBlocks.blockdeadtree.getDefaultState(), 2);
						}
						}
				}
 */
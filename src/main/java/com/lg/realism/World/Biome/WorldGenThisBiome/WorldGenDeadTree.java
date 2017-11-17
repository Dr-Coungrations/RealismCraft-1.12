package com.lg.realism.World.Biome.WorldGenThisBiome;

import java.util.Random;

import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.lg.realism.RegBlocks;
import com.lg.realism.World.LayerGenerator.ALayerGen;

public class WorldGenDeadTree extends ALayerGen {
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	static final int[][][] MATRIX = new int[][][] {

		{
			{0, 2, 0},
			{2, 1, 2},
			{0, 2, 0},
		},
		{
			{0, 0, 0},
			{0, 1, 0},
			{0, 2, 0},
		},
		{
			{0, 0, 0},
			{2, 1, 0},
			{0, 0, 0},
		},
		{
			{0, 2, 0},
			{0, 1, 2},
			{0, 2, 0},
		},

	};


	@Override
	protected int[][][] get3LayerMatrix()
	{
		return MATRIX;
	}

	@Override
	public void generateBlock(World world, Random random, int x, int y, int z, int matrixValue)
	{

		BlockPos pos = new BlockPos(x, y, z);
		int variator = random.nextInt(3);
		switch(matrixValue) {

		case 0:
			world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()),Blocks.AIR.getDefaultState()); 
			break;
		case 1:
			world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()),RegBlocks.blockdeadtree.getDefaultState()); 
			break;
		case 2:
			world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()),RegBlocks.deadbranch.getDefaultState()); 
			break;


		}
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
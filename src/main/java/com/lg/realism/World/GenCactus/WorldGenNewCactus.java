package com.lg.realism.World.GenCactus;

import com.lg.realism.RegBlocks;
import com.lg.realism.World.LayerGenerator.ALayerGen;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class WorldGenNewCactus extends ALayerGen{
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	static final int[][][] MATRIX = {

		{
			{0, 2, 0},
			{5, 1, 3},
			{0, 4, 0},
		},
		{
			{0, 2, 0},
			{5, 1, 3},
			{0, 4, 0},
		},
		{
			{0, 2, 0},
			{5, 1, 3},
			{0, 4, 0},
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
			world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()),Blocks.CACTUS.getDefaultState()); 
			break;
		case 2:
			if(variator == 3){
				world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()),RegBlocks.cactusside.getDefaultState().withProperty(FACING, EnumFacing.EAST), 2); 
			}
			break;
		case 4:
			if(variator == 2){
			world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()),RegBlocks.cactusside.getDefaultState().withProperty(FACING, EnumFacing.WEST), 2); 
			}
			break;
		case 5:
			if(variator == 0){
			world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()),RegBlocks.cactusside.getDefaultState().withProperty(FACING, EnumFacing.SOUTH), 2); 
			}
			break;
		case 3:
			if(variator == 1){
			world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()),RegBlocks.cactusside.getDefaultState().withProperty(FACING, EnumFacing.NORTH), 2); 
			}
			break;
		}
	}
}
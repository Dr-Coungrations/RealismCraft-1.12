package com.lg.realism.World.WorldGenOasis;

import java.util.Random;

import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.lg.realism.RegBlocks;
import com.lg.realism.World.LayerGenerator.ALayerGen;

public class WorldGenOasis extends ALayerGen
{
	public static final PropertyEnum<BlockLog.EnumAxis> LOG_AXIS = PropertyEnum.<BlockLog.EnumAxis>create("axis", BlockLog.EnumAxis.class);
	  public static final PropertyEnum<EnumFacing.Axis> AXIS = PropertyEnum.<EnumFacing.Axis>create("axis", EnumFacing.Axis.class);
	static final int[][][] MATRIX = new int[][][] {
		{
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 0, 0, 0, 0, 0, 1, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
			{0, 1, 0, 0, 0, 6, 0, 1, 1, 0},
			{0, 1, 0, 6, 6, 6, 6, 0, 1, 0},
			{0, 1, 2, 0, 6, 2, 0, 0, 1, 0},
			{0, 0, 0, 2, 0, 0, 1, 1, 1, 0},
			{0, 1, 0, 0, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		},
		{
			{0, 1, 0, 1, 1, 0, 1, 0, 1, 1},
			{1, 1, 0, 1, 1, 2, 1, 2, 0, 1},
			{0, 1, 2, 2, 2, 2, 2, 2, 1, 0},
			{1, 1, 2, 2, 2, 2, 2, 1, 1, 1},
			{0, 1, 2, 2, 2, 2, 2, 2, 1, 0},
			{1, 1, 2, 2, 2, 2, 2, 2, 1, 1},
			{1, 2, 2, 2, 2, 2, 1, 1, 1, 0},
			{0, 0, 2, 2, 2, 2, 2, 1, 1, 0},
			{0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
		},
		{
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{3, 3, 3, 5, 5, 3, 7, 3, 3, 3},
			{3, 4, 3, 3, 3, 3, 3, 3, 3, 3},
			{3, 3, 3, 3, 3, 3, 3, 3, 4, 3},
			{3, 4, 3, 3, 3, 3, 3, 3, 3, 3},
			{3, 3, 3, 3, 3, 3, 3, 3, 4, 3},
			{3, 4, 3, 3, 3, 3, 4, 3, 4, 3},
			{3, 3, 3, 3, 3, 3, 3, 4, 3, 3},
			{3, 3, 3, 3 ,3, 3, 3, 3, 3, 3},

		},
	};
	@Override
	public void generateBlock(World world, Random random, int x, int y, int z, int matrixValue)
	{
		BlockPos pos = new BlockPos(x, y - 2, z);
	
		switch(matrixValue) {
		case 0:
			world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()),Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.SAND)); 
			break;
		case 1:
			world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()),Blocks.GRASS.getDefaultState()); 
			break;

		case 2:
			world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()),Blocks.WATER.getDefaultState()); 
			break;

		case 3:
			world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()),Blocks.AIR.getDefaultState()); 
			break;
		case 4:
			world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()),Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS)); 
			break;
		case 5:
			world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(LOG_AXIS, BlockLog.EnumAxis.Z)); 
			world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()),RegBlocks.mossblock.getDefaultState());
			break;
		case 6:
			world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()),Blocks.BONE_BLOCK.getDefaultState().withProperty(AXIS, EnumFacing.Axis.X)); 
			break;
		case 7:
			world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
			world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
			world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 2, pos.getZ()),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
			world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 3, pos.getZ()),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE));
			world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 3, pos.getZ() + 1),Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE));
			world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 4, pos.getZ()),Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE));
			world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 3, pos.getZ() - 1),Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE));
			world.setBlockState(new BlockPos(pos.getX() - 1, pos.getY() + 3, pos.getZ()),Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE));
			world.setBlockState(new BlockPos(pos.getX() + 1, pos.getY() + 3, pos.getZ()),Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE));
			break;
		
		}
	}
	@Override
	protected int[][][] get3LayerMatrix()
	{
		return MATRIX;
	}

}


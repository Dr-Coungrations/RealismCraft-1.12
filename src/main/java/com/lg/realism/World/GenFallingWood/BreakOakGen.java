package com.lg.realism.World.GenFallingWood;

import com.lg.realism.Config.ConfigManager;
import com.lg.realism.Realism;
import com.lg.realism.RegBlocks;
import com.lg.realism.World.WorldGeneratorOne;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BreakOakGen extends WorldGeneratorOne {
	public static final PropertyEnum<BlockLog.EnumAxis> LOG_AXIS = PropertyEnum.<BlockLog.EnumAxis>create("axis", BlockLog.EnumAxis.class);
	public boolean generate(World world, Random rand, BlockPos position) {
		for (int i = 0; i < 64; ++i) {
			BlockPos pos = position.add(rand.nextInt(16) - rand.nextInt(16), rand.nextInt(8) - rand.nextInt(8), rand.nextInt(16) - rand.nextInt(16));
			int variator = rand.nextInt(3);
			if(ConfigManager.debugGeneration){
				Realism.LOGGER.info("Block Oak generate on: " + "x: " + pos.getX() + " " + "y: " + pos.getY()+ " " + "z: " + pos.getZ());
			}
			if(world.getBiome(new BlockPos(pos.getX() , world.getActualHeight(), pos.getZ() )) == Biomes.FOREST 
					|| world.getBiome(new BlockPos(pos.getX(), world.getActualHeight(), pos.getZ() )) == Biomes.FOREST_HILLS){
				if (world.isAirBlock(pos) && world.getBlockState(pos.down()).getBlock() == Blocks.GRASS) {
					if(variator == 0) {
						world.setBlockState(new BlockPos(pos),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
						for(int k = 2; k < rand.nextInt(6); ++k){
							world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + k),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK).withProperty(LOG_AXIS, BlockLog.EnumAxis.Z));
							world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() + k),RegBlocks.mossblock.getDefaultState());
						}
					}
					if(variator == 1) {
						world.setBlockState(new BlockPos(pos),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
						for(int k = 2; k < rand.nextInt(6); ++k){
							world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - k),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK).withProperty(LOG_AXIS, BlockLog.EnumAxis.Z));
							world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() - k),RegBlocks.mossblock.getDefaultState());
						}
					}
					if(variator == 2) {
						world.setBlockState(new BlockPos(pos),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
						for(int k = 2; k < rand.nextInt(6); ++k){
							world.setBlockState(new BlockPos(pos.getX() + k, pos.getY(), pos.getZ()),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK).withProperty(LOG_AXIS, BlockLog.EnumAxis.X));
							world.setBlockState(new BlockPos(pos.getX() + k, pos.getY() + 1, pos.getZ()),RegBlocks.mossblock.getDefaultState());
						}
					}
					if(variator == 3) {
						world.setBlockState(new BlockPos(pos),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
						for(int k = 2; k < rand.nextInt(6); ++k){
							world.setBlockState(new BlockPos(pos.getX() - k, pos.getY(), pos.getZ()),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK).withProperty(LOG_AXIS, BlockLog.EnumAxis.X));
							world.setBlockState(new BlockPos(pos.getX() - k, pos.getY() + 1, pos.getZ()),RegBlocks.mossblock.getDefaultState());
						}
					}
				}
			}
		

		}

		return true;
	}
}
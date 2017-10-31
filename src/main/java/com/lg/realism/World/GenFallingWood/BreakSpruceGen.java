package com.lg.realism.World.GenFallingWood;

import java.util.Random;

import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.lg.realism.Realism;
import com.lg.realism.RegBlocks;
import com.lg.realism.Config.ConfigManager;
import com.lg.realism.World.WorldGeneratorTwo;

public class BreakSpruceGen extends WorldGeneratorTwo {
	public static final PropertyEnum<BlockLog.EnumAxis> LOG_AXIS = PropertyEnum.<BlockLog.EnumAxis>create("axis", BlockLog.EnumAxis.class);
	public boolean generate(World world, Random rand, BlockPos position) {
		for (int i = 0; i < 64; ++i) {
			BlockPos pos = position.add(rand.nextInt(16) - rand.nextInt(16), rand.nextInt(8) - rand.nextInt(8), rand.nextInt(16) - rand.nextInt(16));
			int variator = rand.nextInt(3);
			if(ConfigManager.debugGeneration){
				Realism.LOGGER.info("Block Spruce generate on: " + "x: " + pos.getX() + " " + "y: " + pos.getY()+ " " + "z: " + pos.getZ());
			}
			if(world.getBiome(new BlockPos(pos.getX() << 4, world.getActualHeight(), pos.getZ() << 4)) == Biomes.TAIGA 
					|| world.getBiome(new BlockPos(pos.getX() << 4, world.getActualHeight(), pos.getZ() << 4)) == Biomes.TAIGA_HILLS
					|| world.getBiome(new BlockPos(pos.getX() << 4, world.getActualHeight(), pos.getZ() << 4)) == Biomes.COLD_TAIGA
					|| world.getBiome(new BlockPos(pos.getX() << 4, world.getActualHeight(), pos.getZ() << 4)) == Biomes.COLD_TAIGA_HILLS){
				if (world.isAirBlock(pos) && world.getBlockState(pos.down()).getBlock() == Blocks.GRASS)
				{
					if(variator == 0){
						world.setBlockState(new BlockPos(pos),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
						for(i = 2; i < rand.nextInt(8); ++i){
							world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + i),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(LOG_AXIS, BlockLog.EnumAxis.Z));
							world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() + i),RegBlocks.mossblock.getDefaultState());
						}
					}
					if(variator == 1){
						world.setBlockState(new BlockPos(pos),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
						for(i = 2; i < rand.nextInt(8); ++i){
							world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - i),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(LOG_AXIS, BlockLog.EnumAxis.Z));
							world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() - i),RegBlocks.mossblock.getDefaultState());
						}
					}
					if(variator == 2){
						world.setBlockState(new BlockPos(pos),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
						for(i = 2; i < rand.nextInt(8); ++i){
							world.setBlockState(new BlockPos(pos.getX() + i, pos.getY(), pos.getZ()),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(LOG_AXIS, BlockLog.EnumAxis.X));
							world.setBlockState(new BlockPos(pos.getX() + i, pos.getY() + 1, pos.getZ()),RegBlocks.mossblock.getDefaultState());
						}						
					}
					if(variator == 3){
						world.setBlockState(new BlockPos(pos),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
						for(i = 2; i < rand.nextInt(8); ++i){
							world.setBlockState(new BlockPos(pos.getX() - i, pos.getY(), pos.getZ()),Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(LOG_AXIS, BlockLog.EnumAxis.X));
							world.setBlockState(new BlockPos(pos.getX() - i, pos.getY() + 1, pos.getZ()),RegBlocks.mossblock.getDefaultState());
						}
					}
				}
			}
		}
		return true;
	}
}

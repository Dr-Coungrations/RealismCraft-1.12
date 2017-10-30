package com.lg.realism.World.GenSalt;

import java.util.Random;

import net.minecraft.block.BlockSand;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.lg.realism.Realism;
import com.lg.realism.RegBlocks;
import com.lg.realism.Config.ConfigManager;
import com.lg.realism.World.WorldGeneratorThree;

public class WorldGenSalt extends WorldGeneratorThree {
	
	public boolean generate(World world, Random rand, BlockPos position) {
		for (int i = 0; i < 64; ++i) {
			BlockPos pos = position.add(rand.nextInt(6) - rand.nextInt(6), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(6) - rand.nextInt(6));
			if( world.getBlockState(pos.down()) == Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.SAND) 
					&&  world.getBlockState(pos) == Blocks.WATER.getDefaultState()) {
				world.setBlockState(pos, RegBlocks.saltblock.getDefaultState());
				if(ConfigManager.debugGeneration){
					Realism.LOGGER.info("Block Salt generate on: " + "x: " + pos.getX() + " " + "y: " + pos.getY()+ " " + "z: " + pos.getZ());
				}
			}

		}
		return true;
	}

}

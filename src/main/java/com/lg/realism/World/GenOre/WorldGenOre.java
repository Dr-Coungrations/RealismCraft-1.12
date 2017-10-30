package com.lg.realism.World.GenOre;

import java.util.Random;

import com.lg.realism.RegBlocks;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenOre implements IWorldGenerator {
	private final WorldGenMinable oreGenNether;


	public WorldGenOre() {
		oreGenNether = new WorldGenMinable(RegBlocks.kaolinit.getDefaultState(), 20, BlockMatcher.forBlock(Blocks.STONE));
	}

	@Override
	public void generate(final Random random, final int chunkX, final int chunkZ, final World world, final IChunkGenerator chunkGenerator, final IChunkProvider chunkProvider) {
		final BlockPos chunkPos = new BlockPos(chunkX * 16, 0, chunkZ * 16);

		switch (world.provider.getDimensionType()) {
			case OVERWORLD:
				for (int i = 0; i < 16; i++) {
					oreGenNether.generate(world, random, chunkPos.add(random.nextInt(16), random.nextInt(108) + 10, random.nextInt(16)));
				}
				break;
		default:
			break;
	
			
		}
	}
}

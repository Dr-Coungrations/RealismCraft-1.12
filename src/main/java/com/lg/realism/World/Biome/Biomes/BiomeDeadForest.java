package com.lg.realism.World.Biome.Biomes;

import com.lg.realism.RegBlocks;
import net.minecraft.block.BlockDirt;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeDeadForest extends Biome
{
	public BiomeDeadForest()
	{
		super(new BiomeProperties("DEADFOREST").setBaseHeight(0.2F).setHeightVariation(0.05F).setTemperature(0.6F).setWaterColor(658944));
		topBlock = RegBlocks.blockburntgrass.getDefaultState();
		fillerBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT);
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
	}

	@Override
	@SideOnly (Side.CLIENT) 
	public int getSkyColorByTemp(float temp)
	{
		return 658944;
	}
}
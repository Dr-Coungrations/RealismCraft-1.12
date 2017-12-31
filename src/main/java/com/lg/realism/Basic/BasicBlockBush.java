package com.lg.realism.Basic;

import com.lg.realism.Realism;
import net.minecraft.block.SoundType;
/**
 * Basics API class by block bush
 * @author LegendGamer
 */
public class BasicBlockBush extends CustomBlockBush
{
	public BasicBlockBush(final String name)
	{
		setRegistryName(name);
		setUnlocalizedName(name);
		setHardness(0.2F);
		this.setSoundType(SoundType.PLANT);
		setCreativeTab(Realism.tabMain);
	}
}
package com.lg.realism.Basic.BasicBlock;

import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import com.lg.realism.Realism;
/**
 * Basics API class by block bush
 * @author LegendGamer
 */
public class BasicBlockBush extends CustomBlockBush {
	public BasicBlockBush(final Material materialIn, final String name)
	{
		setRegistryName(name);
		setUnlocalizedName(name);
		setHardness(0.2F);
		this.setSoundType(SoundType.PLANT);
		setCreativeTab(Realism.tabMain);
	}
}
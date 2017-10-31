package com.lg.realism.Basic;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import com.lg.realism.Realism;

/**
 * Basics API class by block
 * @author LegendGamer
 */
public class BasicBlock extends Block {

	public BasicBlock(final Material materialIn, final String name, float hardness,float resistanse, SoundType soundtype) {
		super(materialIn);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setSoundType(soundtype);
		this.setHardness(hardness);
		this.setResistance(resistanse);
		this.setCreativeTab(Realism.tabMain);
	}
}
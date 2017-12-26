package com.lg.realism.Basic;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.List;
/**
 * Basics API class by Block With drops blocks
 * @author LegendGamer
 */
public class BasicBlockWithDropsBlock extends BasicBlock
{
	private Block drop;
	private int valueDrops;

	public BasicBlockWithDropsBlock(final Material materialIn, final String name, float hardness, float resistanse, SoundType soundtype, Block drop, int valueDrops)
    {
		super(materialIn,name,hardness, resistanse, soundtype);
		this.drop = drop;
		this.valueDrops = valueDrops;
	}
	
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
		List<ItemStack> ret = super.getDrops(world, pos, state, fortune);
		ret.add(new ItemStack(drop, valueDrops, 0));			 	    
		return ret;
	}
}
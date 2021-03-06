package com.lg.realism.Items.ItemsLog;

import com.lg.realism.Basic.BasicItem.BasicItem;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BirchSapling extends BasicItem{

	public BirchSapling(String name, int maxStackSize) {
		super(name, maxStackSize);
		// TODO Auto-generated constructor stub
	}
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (world.getBlockState(pos).getBlock() == Blocks.GRASS || world.getBlockState(pos).getBlock() == Blocks.DIRT) {
			//crutch Block set in PlaceOnBlock Event
			player.getHeldItem(EnumHand.MAIN_HAND).shrink(1);
		}
		return EnumActionResult.PASS;
	}

}


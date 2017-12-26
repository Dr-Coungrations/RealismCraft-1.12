package com.lg.realism.Items;

import com.lg.realism.Basic.BasicItem;
import com.lg.realism.RegItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Stonehand extends BasicItem{

	public Stonehand(String name, int maxStackSize) {
		super(name, maxStackSize);
	}
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (world.getBlockState(pos).getBlock() == Blocks.STONE) {
			player.inventory.addItemStackToInventory(new ItemStack(RegItems.pointedstone));
			player.getHeldItem(EnumHand.MAIN_HAND).shrink(1);
		}
		return EnumActionResult.PASS;
	}

}

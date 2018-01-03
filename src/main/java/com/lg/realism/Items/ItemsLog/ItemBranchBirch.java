package com.lg.realism.Items.ItemsLog;

import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.lg.realism.RegBlocks;
import com.lg.realism.Basic.BasicItem.BasicItem;

public class ItemBranchBirch extends BasicItem{
	 public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public ItemBranchBirch(String name, int maxStackSize) {
		super(name, maxStackSize);
		
	}
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(facing == EnumFacing.UP || facing == EnumFacing.DOWN){
			world.setBlockState(pos.offset(facing),RegBlocks.connectblock.getDefaultState());
		} else {
		world.setBlockState(pos.offset(facing),RegBlocks.connectblock.getDefaultState().withProperty(FACING, facing), 2);
		}
		player.getHeldItem(EnumHand.MAIN_HAND).shrink(1);	

		return EnumActionResult.PASS;
	}

}

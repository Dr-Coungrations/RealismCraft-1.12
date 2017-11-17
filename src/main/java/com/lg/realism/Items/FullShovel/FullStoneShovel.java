package com.lg.realism.Items.FullShovel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.lg.realism.Realism;
import com.lg.realism.Basic.DevBasicItem;

public class FullStoneShovel extends DevBasicItem{

	public FullStoneShovel(String name, int maxStackSize) {
		super(name, maxStackSize);
		this.setCreativeTab(Realism.tabDev);
	}
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		world.setBlockState(pos.offset(facing),Blocks.DIRT.getDefaultState());
	
		player.getHeldItem(EnumHand.MAIN_HAND).shrink(1);	
		player.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(Items.STONE_SHOVEL));

		return EnumActionResult.PASS;
	}

}

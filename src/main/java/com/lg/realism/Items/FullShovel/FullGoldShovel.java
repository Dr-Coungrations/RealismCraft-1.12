package com.lg.realism.Items.FullShovel;

import com.lg.realism.Basic.DevBasicItem;
import com.lg.realism.Realism;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FullGoldShovel extends DevBasicItem{

	public FullGoldShovel(String name, int maxStackSize) {
		super(name, maxStackSize);
		this.setCreativeTab(Realism.tabDev);
	}
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		world.setBlockState(pos.offset(facing),Blocks.DIRT.getDefaultState());
	
		player.getHeldItem(EnumHand.MAIN_HAND).shrink(1);	
		player.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(Items.GOLDEN_SHOVEL));

		return EnumActionResult.PASS;
	}

}

package com.lg.realism.event;

import com.lg.realism.RegBlocks;
import com.lg.realism.RegItems;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class PlaceOnBlock
{
	public static final PropertyEnum<BlockLog.EnumAxis> LOG_AXIS = PropertyEnum.create("axis", BlockLog.EnumAxis.class);

	@SubscribeEvent
	public void placeble(RightClickBlock.RightClickBlock e)
    {
		ItemStack is = e.getEntityPlayer().getHeldItem(EnumHand.MAIN_HAND);

		if (is.getItem() == RegItems.wetvineitem)
		{
			if (e.getWorld().getBlockState(e.getPos()) == Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK).withProperty(LOG_AXIS, BlockLog.EnumAxis.Z)
					|| e.getWorld().getBlockState(e.getPos()) == Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK).withProperty(LOG_AXIS, BlockLog.EnumAxis.X))
			{
				e.getWorld().setBlockState(e.getPos().up(),RegBlocks.wetvine.getDefaultState());
			}
		}

		if (is.getItem() == RegItems.oaksapling)
		{
			if (e.getWorld().getBlockState(e.getPos()) == Blocks.GRASS.getDefaultState() || e.getWorld().getBlockState(e.getPos()) == Blocks.DIRT.getDefaultState())
			{
				e.getWorld().setBlockState(e.getPos().up(),RegBlocks.growtreeone.getDefaultState());
			}
		}

		if (is.getItem() == RegItems.birchsapling)
		{
			if (e.getWorld().getBlockState(e.getPos()) == Blocks.GRASS.getDefaultState() || e.getWorld().getBlockState(e.getPos()) == Blocks.DIRT.getDefaultState())
			{
				e.getWorld().setBlockState(e.getPos().up(),RegBlocks.growtreeonebirch.getDefaultState());
			}
		}

		if (is.getItem() == RegItems.sprucesapling)
		{
			if (e.getWorld().getBlockState(e.getPos()) == Blocks.GRASS.getDefaultState() || e.getWorld().getBlockState(e.getPos()) == Blocks.DIRT.getDefaultState())
			{
				e.getWorld().setBlockState(e.getPos().up(),RegBlocks.growtreeonespruce.getDefaultState());
			}
		}
	}
}
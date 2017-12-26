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

public class PlaceOnBlock {
	public static final PropertyEnum<BlockLog.EnumAxis> LOG_AXIS = PropertyEnum.<BlockLog.EnumAxis>create("axis", BlockLog.EnumAxis.class);	
	@SubscribeEvent
	public void placeble(RightClickBlock.RightClickBlock event){

		ItemStack is = event.getEntityPlayer().getHeldItem(EnumHand.MAIN_HAND);

		if (is != null && ( is.getItem() == RegItems.wetvineitem)) {
			if (event.getWorld().getBlockState(event.getPos()) == Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK).withProperty(LOG_AXIS, BlockLog.EnumAxis.Z)
					|| event.getWorld().getBlockState(event.getPos()) == Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK).withProperty(LOG_AXIS, BlockLog.EnumAxis.X)) {		
				event.getWorld().setBlockState(event.getPos().up(),RegBlocks.wetvine.getDefaultState());
			}
		}
		if (is != null && (is.getItem() == RegItems.oaksapling)) {
			if (event.getWorld().getBlockState(event.getPos()) == Blocks.GRASS.getDefaultState() || event.getWorld().getBlockState(event.getPos()) == Blocks.DIRT.getDefaultState()){
				event.getWorld().setBlockState(event.getPos().up(),RegBlocks.growtreeone.getDefaultState());
			}
		}
		if (is != null && (is.getItem() == RegItems.birchsapling)) {
			if (event.getWorld().getBlockState(event.getPos()) == Blocks.GRASS.getDefaultState() || event.getWorld().getBlockState(event.getPos()) == Blocks.DIRT.getDefaultState()){
				event.getWorld().setBlockState(event.getPos().up(),RegBlocks.growtreeonebirch.getDefaultState());
			}
		}

		if (is != null && (is.getItem() == RegItems.sprucesapling)) {
			if (event.getWorld().getBlockState(event.getPos()) == Blocks.GRASS.getDefaultState() || event.getWorld().getBlockState(event.getPos()) == Blocks.DIRT.getDefaultState()){
				event.getWorld().setBlockState(event.getPos().up(),RegBlocks.growtreeonespruce.getDefaultState());
			}
		}
	}

}

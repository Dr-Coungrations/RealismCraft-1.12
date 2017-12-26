package com.lg.realism.event;

import com.lg.realism.RegItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ShovelEvent {
	@SubscribeEvent
	public void planteble(BlockEvent.BreakEvent event){

		ItemStack is = event.getPlayer().getHeldItem(EnumHand.MAIN_HAND);	
			if(event.getPlayer() != null) {
				if (is != null && is.getItem() == Items.STONE_SHOVEL) {
					if (event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.GRASS_PATH) ||
							event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.FARMLAND) || 
							event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.DIRT) ||
							event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.GRASS)) {
						event.getPlayer().getHeldItem(EnumHand.MAIN_HAND).shrink(1);
						event.getPlayer().setHeldItem(EnumHand.MAIN_HAND, new ItemStack(RegItems.fullstoneshovel));

					}
				}
				if (is != null && is.getItem() == Items.WOODEN_SHOVEL) {
					if (event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.GRASS_PATH) ||
							event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.FARMLAND) || 
							event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.DIRT) ||
							event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.GRASS)) {
						event.getPlayer().getHeldItem(EnumHand.MAIN_HAND).shrink(1);
						event.getPlayer().setHeldItem(EnumHand.MAIN_HAND, new ItemStack(RegItems.fullwoodshovel));

					}
				}
				if (is != null && is.getItem() == Items.GOLDEN_SHOVEL) {
					if (event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.GRASS_PATH) ||
							event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.FARMLAND) || 
							event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.DIRT) ||
							event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.GRASS)) {
						event.getPlayer().getHeldItem(EnumHand.MAIN_HAND).shrink(1);
						event.getPlayer().setHeldItem(EnumHand.MAIN_HAND, new ItemStack(RegItems.fullgoldshovel));

					}
				}
				if (is != null && is.getItem() == Items.IRON_SHOVEL) {
					if (event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.GRASS_PATH) ||
							event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.FARMLAND) || 
							event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.DIRT) ||
							event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.GRASS)) {
						event.getPlayer().getHeldItem(EnumHand.MAIN_HAND).shrink(1);
						event.getPlayer().setHeldItem(EnumHand.MAIN_HAND, new ItemStack(RegItems.fullironshovel));

					}
				}
				if (is != null && is.getItem() == Items.DIAMOND_SHOVEL) {
					if (event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.GRASS_PATH) ||
							event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.FARMLAND) || 
							event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.DIRT) ||
							event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.GRASS)) {
						event.getPlayer().getHeldItem(EnumHand.MAIN_HAND).shrink(1);
						event.getPlayer().setHeldItem(EnumHand.MAIN_HAND, new ItemStack(RegItems.fulldiamondshovel));

					}
				}
			}
		}
}
/*
 * 
 || is.getItem() == Items.WOODEN_SHOVEL || is.getItem() == Items.IRON_SHOVEL || is.getItem() == Items.GOLDEN_SHOVEL|| is.getItem() == Items.DIAMOND_SHOVEL
}else 	
	if (is != null && is.getItem() == Items.WOODEN_SHOVEL){
		event.getPlayer().setHeldItem(EnumHand.MAIN_HAND, new ItemStack(RegItems.fullwoodshovel));
}else 	
	if (is != null && is.getItem() == Items.IRON_SHOVEL){
		event.getPlayer().setHeldItem(EnumHand.MAIN_HAND, new ItemStack(RegItems.fullironshovel));
}else 	
	if (is != null && is.getItem() == Items.GOLDEN_SHOVEL){
		event.getPlayer().setHeldItem(EnumHand.MAIN_HAND, new ItemStack(RegItems.fullgoldshovel));
}
	else 	
		if (is != null && is.getItem() == Items.DIAMOND_SHOVEL){
			event.getPlayer().setHeldItem(EnumHand.MAIN_HAND, new ItemStack(RegItems.fulldiamondshovel));
	}
 */
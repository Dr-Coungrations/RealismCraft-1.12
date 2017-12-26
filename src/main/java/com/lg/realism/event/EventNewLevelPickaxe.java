package com.lg.realism.event;

import com.lg.realism.RegBlocks;
import com.lg.realism.RegItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventNewLevelPickaxe {
	@SubscribeEvent
	public void onDrop(BlockEvent.HarvestDropsEvent event) {		
		EntityPlayer player = (EntityPlayer)event.getHarvester();

		//	
		//	Item.ToolMaterial toolMaterial = item.getHarvestLevel(3);
		if(!event.getWorld().isRemote) { 	
			if(player != null) {
				ItemStack is = player.getHeldItem(EnumHand.MAIN_HAND);
				Item item = is.getItem();
				IBlockState blockState = event.getState();
				int level = item.getHarvestLevel(is, "pickaxe", player, blockState);
				if(item != null && (item ==  Items.DIAMOND_PICKAXE || item ==  Items.GOLDEN_PICKAXE || item ==  Items.STONE_PICKAXE || item ==  Items.WOODEN_PICKAXE || item ==  Items.IRON_PICKAXE)){
					event.getDrops().clear();
				}
				//stone pickaxe. LVL 1
				if(item != null && item == RegItems.stonepickaxe){

					if(event.getState().getBlock().equals(RegBlocks.copperore)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(RegItems.oreitemcopper, 1 + event.getWorld().rand.nextInt(2)));
					}
					if(event.getState().getBlock().equals(Blocks.COAL_ORE)) {
						event.getDrops().clear();
					}
					if(event.getState().getBlock().equals(Blocks.LAPIS_ORE)) {
						event.getDrops().clear();
					}
					if(event.getState().getBlock().equals(Blocks.EMERALD_ORE)) {
						event.getDrops().clear();
					}
					if(event.getState().getBlock().equals(Blocks.REDSTONE_ORE)) {
						event.getDrops().clear();
					}
					if(event.getState().getBlock().equals(Blocks.IRON_ORE)) {
						event.getDrops().clear();
					}
					if(event.getState().getBlock().equals(Blocks.GOLD_ORE)) {
						event.getDrops().clear();
					}
					if(event.getState().getBlock().equals(Blocks.DIAMOND_ORE)) {
						event.getDrops().clear();
					}
				}
				if(item != null && item == RegItems.copperpickaxe){
					if(event.getState().getBlock().equals(RegBlocks.copperore)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(RegItems.oreitemcopper, 1 + event.getWorld().rand.nextInt(2)));
					}
					if(event.getState().getBlock().equals(Blocks.COAL_ORE)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(Items.COAL, 2 + event.getWorld().rand.nextInt(6)));
					}
					if(event.getState().getBlock().equals(Blocks.LAPIS_ORE)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(Items.DYE, 2 + event.getWorld().rand.nextInt(6),4));
					}
					if(event.getState().getBlock().equals(Blocks.EMERALD_ORE)) {
						event.getDrops().clear();
					}
					if(event.getState().getBlock().equals(Blocks.REDSTONE_ORE)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(Items.REDSTONE, 2 + event.getWorld().rand.nextInt(6)));
					}
					if(event.getState().getBlock().equals(Blocks.IRON_ORE)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(RegItems.oreitemiron, 1 + event.getWorld().rand.nextInt(3)));
					}
					if(event.getState().getBlock().equals(Blocks.GOLD_ORE)) {
						event.getDrops().clear();
					}
					if(event.getState().getBlock().equals(Blocks.DIAMOND_ORE)) {
						event.getDrops().clear();
					}
				}
				if(item != null && item == RegItems.ironpickaxe){
					if(event.getState().getBlock().equals(RegBlocks.copperore)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(RegItems.oreitemcopper, 1 + event.getWorld().rand.nextInt(2)));
					}
					if(event.getState().getBlock().equals(Blocks.COAL_ORE)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(Items.COAL, 2 + event.getWorld().rand.nextInt(6)));
					}
					if(event.getState().getBlock().equals(Blocks.LAPIS_ORE)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(Items.DYE, 2 + event.getWorld().rand.nextInt(6),4));
					}
					if(event.getState().getBlock().equals(Blocks.EMERALD_ORE)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(Items.EMERALD, 1 + event.getWorld().rand.nextInt(7)));
					}
					if(event.getState().getBlock().equals(Blocks.REDSTONE_ORE)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(Items.REDSTONE, 2 + event.getWorld().rand.nextInt(6)));
					}
					if(event.getState().getBlock().equals(Blocks.IRON_ORE)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(RegItems.oreitemiron, 1 + event.getWorld().rand.nextInt(3)));
					}
					if(event.getState().getBlock().equals(Blocks.GOLD_ORE)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(RegItems.oreitemgold, 1 + event.getWorld().rand.nextInt(3)));
					}
					if(event.getState().getBlock().equals(Blocks.DIAMOND_ORE)) {
						event.getDrops().clear();
					}
				}
				if(item != null && item == RegItems.goldpickaxe){
					if(event.getState().getBlock().equals(RegBlocks.copperore)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(RegItems.oreitemcopper, 1 + event.getWorld().rand.nextInt(2)));
					}
					if(event.getState().getBlock().equals(Blocks.COAL_ORE)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(Items.COAL, 4 + event.getWorld().rand.nextInt(6)));
					}
					if(event.getState().getBlock().equals(Blocks.LAPIS_ORE)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(Items.DYE, 2 + event.getWorld().rand.nextInt(6),4));
					}
					if(event.getState().getBlock().equals(Blocks.EMERALD_ORE)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(Items.EMERALD, 1 + event.getWorld().rand.nextInt(7)));
					}
					if(event.getState().getBlock().equals(Blocks.REDSTONE_ORE)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(Items.REDSTONE, 2 + event.getWorld().rand.nextInt(6)));
					}
					if(event.getState().getBlock().equals(Blocks.IRON_ORE)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(RegItems.oreitemiron, 1 + event.getWorld().rand.nextInt(3)));
					}
					if(event.getState().getBlock().equals(Blocks.GOLD_ORE)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(RegItems.oreitemgold, 1 + event.getWorld().rand.nextInt(3)));
					}
					if(event.getState().getBlock().equals(Blocks.DIAMOND_ORE)) {
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(RegItems.oreitemdiamond, 1 + event.getWorld().rand.nextInt(2)));
					}
				}



			}
		}
	}

}


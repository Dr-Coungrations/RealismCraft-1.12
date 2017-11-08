package com.lg.realism.Items;

import com.lg.realism.Realism;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemShovel extends Item {
	
	/*
	 * 0 empty wooden shovel
	 * 1 empty stone shovel
	 * 
	 * 2 full dirt wooden shovel
	 * 3 full dirt stone shovel
	 * 
	 * 4 full grass wooden shovel
	 * 5 full grass stone shovel
	 * 
	 * 6 full gravel wooden shovel
	 * 7 full gravel stone shovel
	 */
	
	public ItemShovel() {
		setRegistryName("shovel").setHasSubtypes(true).setCreativeTab(Realism.tabMain).setMaxStackSize(1);
	}
	
	public String getUnlocalizedName(ItemStack stack)
    {
		switch(stack.getMetadata()) {
		case 0: return "emptyWoodShovel";
		case 1: return "emptyStoneShovel";
		case 2: return "dirtWoodShovel";
		case 3: return "dirtStoneShovel";
		case 4: return "grassWoodShovel";
		case 5: return "grassStoneShovel";
		case 6: return "gravelWoodShovel";
		case 7: return "gravelStoneShovel";
		default: return "shovel";
		}
    }
	
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (isInCreativeTab(tab))
        {
            items.add(new ItemStack(this, 1, 0));
            items.add(new ItemStack(this, 1, 1));
        }
    }
	
	public boolean isEmpty(ItemStack stack) {
		return stack.getMetadata() < 2;
	}
	
	public int getShovelType(ItemStack stack) {
		return stack.getMetadata() % 2;
	}
	
	public int getShovelContent(ItemStack stack) {
		return stack.getMetadata() / 2;
	}
	
	public Block getShovelBlock(ItemStack stack) {
		int content = getShovelContent(stack);
		switch(content) {
		case 1: return Blocks.DIRT;
		case 2: return Blocks.GRASS;
		case 3: return Blocks.GRAVEL;
		default: return Blocks.AIR;
		}
	}
	
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		ItemStack stack = player.getHeldItem(hand);
		IBlockState state = world.getBlockState(pos);
		Block block = state.getBlock();
		if (isEmpty(stack)) {
			int newMeta = 0;
			if (block == Blocks.DIRT)
				newMeta += 2;
			if (block == Blocks.GRASS)
				newMeta += 4;
			if (block == Blocks.GRAVEL)
				newMeta += 6;
			if (newMeta != 0) {
				player.setHeldItem(hand, new ItemStack(this, 1, newMeta + getShovelType(stack)));
				world.setBlockToAir(pos);
			}
		} else {
			Block b = getShovelBlock(stack);
			world.setBlockState(pos.add(facing.getDirectionVec()), b.getDefaultState());
			player.setHeldItem(hand, new ItemStack(this, 1, getShovelType(stack)));
		}
        return EnumActionResult.SUCCESS;
    }
}

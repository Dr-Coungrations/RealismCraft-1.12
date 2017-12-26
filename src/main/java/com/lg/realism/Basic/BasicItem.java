package com.lg.realism.Basic;

import com.lg.realism.Realism;
import net.minecraft.item.Item;

public class BasicItem extends Item
{
	public BasicItem(String name, int maxStackSize)
	{
		this.setRegistryName(name);
		this.setCreativeTab(Realism.tabMain);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(maxStackSize);
	}
}
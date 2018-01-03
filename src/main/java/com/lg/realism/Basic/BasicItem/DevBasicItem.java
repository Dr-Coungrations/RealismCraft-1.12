package com.lg.realism.Basic.BasicItem;

import net.minecraft.item.Item;

import com.lg.realism.Realism;

public class DevBasicItem extends Item{
	public DevBasicItem(String name,int maxStackSize){
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(maxStackSize);
	}
}

package com.lg.realism.Basic.BasicItem;

import com.lg.realism.Realism;

import net.minecraft.item.Item;
import scala.tools.nsc.MainClass;

public class BasicItem extends Item{
	public BasicItem(String name,int maxStackSize){
		this.setRegistryName(name);
		this.setCreativeTab(Realism.tabMain);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(maxStackSize);
		

	}

}

package com.lg.realism.Basic;

import com.lg.realism.Realism;

import net.minecraft.item.ItemFood;

/**
 * Basics API class by Food
 * @author LegendGamer
 */
public class BasicFood extends ItemFood{

	public BasicFood(int amount, float saturation, boolean isWolfFood,String name) {
		super(amount, saturation, isWolfFood);	
		this.setRegistryName(name);
		this.setCreativeTab(Realism.tabMain);
		this.setUnlocalizedName(name);  
	}
}

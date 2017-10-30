package com.lg.realism.Items;

import net.minecraft.item.ItemPickaxe;

import com.lg.realism.Realism;

public class RealismPickaxe extends ItemPickaxe
{
    public RealismPickaxe(String name, ToolMaterial material)
    {
        super(material);
   setCreativeTab(Realism.tabMain);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
       
    }
}

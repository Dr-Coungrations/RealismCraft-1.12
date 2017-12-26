package com.lg.realism.Items;

import com.lg.realism.Realism;
import net.minecraft.item.ItemPickaxe;

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

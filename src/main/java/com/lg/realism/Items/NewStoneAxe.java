package com.lg.realism.Items;

import com.lg.realism.Realism;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;

public class NewStoneAxe extends ItemAxe {
    public NewStoneAxe(String name, ToolMaterial material) {
        super(material, 0, 0);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(Realism.tabMain);
    }
}

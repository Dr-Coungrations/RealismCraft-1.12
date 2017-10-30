package com.lg.realism.GrowWood.BurntTree;

import com.lg.realism.GrowWood.AppleTree.BlockAppleTree;
import com.lg.realism.Realism;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBurntTree extends Block {


    public BlockBurntTree(final Material materialIn, final String name, float hardness, String hravLevel, int level, float resistanse, SoundType soundtype) {
        super(materialIn);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setSoundType(soundtype);
        this.setHardness(hardness);
        this.setResistance(resistanse);
        this.setHarvestLevel(hravLevel, level);
        this.setCreativeTab(Realism.tabMain);
    }

}




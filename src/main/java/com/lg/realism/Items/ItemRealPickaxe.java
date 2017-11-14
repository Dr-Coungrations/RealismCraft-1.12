package com.lg.realism.Items;

import java.util.List;

import javax.annotation.Nullable;

import com.lg.realism.Realism;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemRealPickaxe extends Item {
	
	public ItemRealPickaxe(String regName, String name) {
		setRegistryName(regName).setUnlocalizedName(name).setCreativeTab(Realism.tabMain).setMaxStackSize(1);
		setHarvestLevel("pickaxe", 4);
	}
	
	public float getStrVsBlock(ItemStack stack, IBlockState state)
    {
        return 5.0F;
    }
	
	public boolean canHarvestBlock(IBlockState block)
    {
        return true;
    }
	
	@Override
    public int getHarvestLevel(ItemStack stack, String toolClass, @javax.annotation.Nullable net.minecraft.entity.player.EntityPlayer player, @javax.annotation.Nullable IBlockState blockState)
    {
		return 4;
    }
	
	public boolean onBlockDestroyed(ItemStack stack, World world, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        if (!world.isRemote)
        {
        	NBTTagCompound nbt = stack.getTagCompound();
        	if (nbt == null)
        		nbt = new NBTTagCompound();
        	nbt.setInteger("damage", nbt.getInteger("damage") + 1);
        	stack.setTagCompound(nbt);
        }
        return true;
    }
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		if (stack.hasTagCompound())
			tooltip.add("Damage: " + stack.getTagCompound().getInteger("damage"));
    }
}

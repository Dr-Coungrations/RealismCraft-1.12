package com.lg.realism.Items;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.lg.realism.Realism;
import com.lg.realism.RegItems;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemRealPickaxe extends Item {
	
	public float strength;
	public float speed;
	
	public ItemRealPickaxe(String regName, String name, float strength, float speed) {
		setRegistryName(regName).setUnlocalizedName(name).setCreativeTab(Realism.tabMain).setMaxStackSize(1);
		setHarvestLevel("pickaxe", 4);
		this.strength = strength;
		this.speed = speed;
	}
	
	public float getStrVsBlock(ItemStack stack, IBlockState state)
	{
		NBTTagCompound nbt = stack.getTagCompound();
		if (nbt != null) {
			return ((-nbt.getFloat("UpSharpness") + strength) / strength + 0.25F) * speed;
		}
		return speed;
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
        	nbt.setFloat("UpDamage", nbt.getFloat("UpDamage") + 0.5F);
        	nbt.setFloat("UpSharpness", nbt.getFloat("UpSharpness") + 0.55F);
        	nbt.setFloat("HandleDamage", nbt.getFloat("HandleDamage") + 0.25F);
			
        	if (nbt.getFloat("UpSharpness") > strength)
        		nbt.setFloat("UpSharpness", strength);
        	
			if (nbt.getFloat("UpDamage") >= strength) {
				stack.shrink(1);
				if (entityLiving instanceof EntityPlayer)
					((EntityPlayer)entityLiving).inventory.addItemStackToInventory(new ItemStack(RegItems.wood_pickaxe_handle));
			} else
				stack.setTagCompound(nbt);
        }
        return true;
    }
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		if (stack.hasTagCompound()) {
			
			String green = "" + TextFormatting.GREEN;
			String yellow = "" + TextFormatting.YELLOW;
			String red = "" + TextFormatting.RED;
			String res = "" + TextFormatting.RESET;
			
			int proc = (int)((-stack.getTagCompound().getFloat("UpDamage") + strength) / strength * 100);
			String color = proc > 60 ? green : proc > 20 ? yellow : red;
			tooltip.add("Upper Damage: " + color + proc + res + "%");
			
			proc = (int)((-stack.getTagCompound().getFloat("UpSharpness") + strength) / strength * 100);
			color = proc > 60 ? green : proc > 20 ? yellow : red;
			tooltip.add("Upper Sharpness: " + color + proc + res + "%");
			
			proc = (int)((-stack.getTagCompound().getFloat("HandleDamage") + strength) / strength * 100);
			color = proc > 60 ? green : proc > 20 ? yellow : red;
			tooltip.add("Handle Damage: " + color + proc + res + "%");
		}
    }
	
	public boolean showDurabilityBar(ItemStack stack)
	{
		return false;
	}
	
	public double getDurabilityForDisplay(ItemStack stack)
	{
		NBTTagCompound nbt = stack.getTagCompound();
		if (nbt == null)
			return 0F;
		else
			return nbt.getFloat("UpDamage") / 10F;
	}
}

package com.lg.realism.GrowWood;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.lg.realism.RegBlocks;
import com.lg.realism.API.BlockSide;
import com.mojang.realmsclient.gui.ChatFormatting;

public class BranchBirch extends BlockSide
{

    protected static final AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.375D, 0.375D, 0D, 0.625D, 0.625D, 1D), new AxisAlignedBB(0.375D, 0.375D, 0D, 0.625D, 0.625D, 1D),
    	new AxisAlignedBB(0D, 0.375D, 0.375D, 1D, 0.625D, 0.625D), new AxisAlignedBB(0D, 0.375D, 0.375D, 1D, 0.625D, 0.625D)};

    public BranchBirch(String name)
    {
        super(name, Material.WOOD, SIDE_AABB);
        this.setHardness(1.2F);

        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }


    @Override
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);

            worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.STICK)));
     
        
    }
 
    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        Block block = worldIn.getBlockState(pos.up()).getBlock();
        return state;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 3));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | state.getValue(FACING).getHorizontalIndex();
            i |= 8;
     


            i |= 4;
        

        return i;
    }
}
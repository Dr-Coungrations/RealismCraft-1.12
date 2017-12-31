package com.lg.realism.Blocks.Cactus;

import com.lg.realism.API.BlockSide;
import com.lg.realism.Realism;
import com.lg.realism.RegBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class SideCactus extends BlockSide
{
    private static final AxisAlignedBB[] SIDE_AABB = {
    		new AxisAlignedBB(0.375D, 0.375D, 0.75D, 0.625D, 0.625D, 1D),
    		new AxisAlignedBB(0.375D, 0.375D, 0.0D, 0.625D, 0.625D, 0.25D),
    		new AxisAlignedBB(0.0D, 0.375D, 0.375D, 0.25D, 0.625D, 0.625D), 
    		new AxisAlignedBB(0.75D, 0.375D, 0.375D, 1D, 0.625D, 0.625D)
    };

    public SideCactus(String name)
    {
        super(name, Material.WOOD, SIDE_AABB);
        this.setHardness(1.2F);
        this.setCreativeTab(Realism.tabDev);
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
        return state;
    }

    @Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos,IBlockState state, int fortune)
    {
		List<ItemStack> ret = super.getDrops(world, pos, state,fortune);
		ret.add(new ItemStack(Item.getItemFromBlock(RegBlocks.cactussmall), 1, 0));
		return ret;
	}

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 3));
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        EnumFacing enumfacing = EnumFacing.fromAngle((double)placer.rotationYaw);
        worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i |= state.getValue(FACING).getHorizontalIndex();
        i |= 8;
        i |= 4;
        return i;
    }
}
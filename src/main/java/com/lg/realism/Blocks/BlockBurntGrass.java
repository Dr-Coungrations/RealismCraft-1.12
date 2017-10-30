package com.lg.realism.Blocks;

import com.lg.realism.Realism;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockBurntGrass extends Block{

    public BlockBurntGrass(final Material materialIn, final String name, float hardness, float resistanse, SoundType soundtype) {
        super(materialIn);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setSoundType(soundtype);
        this.setHardness(hardness);
        this.setResistance(resistanse);
        this.setCreativeTab(Realism.tabMain);
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
        super.updateTick(world, pos, state, random);
        world.scheduleBlockUpdate(pos, this, 1, 0);
        if(!world.isRemote){
            if(world.getBlockState(new BlockPos(pos.getX(),pos.getY() + 1,pos.getZ())).getBlock() != Blocks.AIR || world.getBlockState(new BlockPos(pos.getX(),pos.getY() + 1,pos.getZ())).getBlock().getMaterial(Blocks.WATER.getDefaultState()) == Material.WATER){
                world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()),Blocks.DIRT.getDefaultState());
            }
        }
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack itemStack) {
        world.scheduleBlockUpdate(pos, this, 1, 0);
    }
}

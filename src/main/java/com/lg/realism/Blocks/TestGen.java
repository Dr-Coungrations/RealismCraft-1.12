package com.lg.realism.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.lg.realism.Basic.BasicBlock;
import com.lg.realism.World.GenCactus.WorldGenNewCactus;

public class TestGen extends BasicBlock{

	public TestGen(Material materialIn, String name, float hardness,
			float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		// TODO Auto-generated constructor stub
	}
	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        return new WorldGenNewCactus().generate(worldIn, worldIn.rand, pos);
    }
}

package com.lg.realism.Blocks.CompactWorkbench;

import com.lg.realism.GuiHandler;
import com.lg.realism.Realism;
import com.lg.realism.Basic.BasicBlock;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCompactWorkbench extends BasicBlock
{


    public BlockCompactWorkbench(Material materialIn, String name, float hardness, float resistanse,
			SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		   this.setCreativeTab(Realism.tabMain);
	}

	/**
     * Called when the block is right clicked by a player.
     */
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {

            playerIn.openGui(Realism.INSTANCE, GuiHandler.COMPACT_WORKBENCH, worldIn, pos.getX(), pos.getY(), pos.getZ());
            playerIn.addStat(StatList.CRAFTING_TABLE_INTERACTION);
            return true;
    }
}
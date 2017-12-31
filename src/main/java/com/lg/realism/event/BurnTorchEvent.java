package com.lg.realism.event;

import com.lg.realism.RegBlocks;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BurnTorchEvent
{
    public static final PropertyDirection FACING = PropertyDirection.create("facing", facing -> facing != EnumFacing.DOWN);

    @SubscribeEvent
    public void burn(PlayerInteractEvent.RightClickBlock e)
    {
        final World world = e.getWorld();

        if (world.getBlockState(e.getPos()) == RegBlocks.extorch.getDefaultState())
        {
            world.setBlockState(e.getPos(), RegBlocks.torch.getDefaultState());
        }

        if (world.getBlockState(e.getPos()) == RegBlocks.extorch.getDefaultState().withProperty(FACING, EnumFacing.WEST))
        {
            world.setBlockState(e.getPos(), RegBlocks.torch.getDefaultState().withProperty(FACING, EnumFacing.WEST));
        }

        if (world.getBlockState(e.getPos()) == RegBlocks.extorch.getDefaultState().withProperty(FACING, EnumFacing.EAST))
        {
            world.setBlockState(e.getPos(), RegBlocks.torch.getDefaultState().withProperty(FACING, EnumFacing.EAST));
        }

        if (world.getBlockState(e.getPos()) == RegBlocks.extorch.getDefaultState().withProperty(FACING, EnumFacing.SOUTH))
        {
            world.setBlockState(e.getPos(), RegBlocks.torch.getDefaultState().withProperty(FACING, EnumFacing.SOUTH));
        }

        if (world.getBlockState(e.getPos()) == RegBlocks.extorch.getDefaultState().withProperty(FACING, EnumFacing.NORTH))
        {
            world.setBlockState(e.getPos(), RegBlocks.torch.getDefaultState().withProperty(FACING, EnumFacing.NORTH));
        }
    }
}
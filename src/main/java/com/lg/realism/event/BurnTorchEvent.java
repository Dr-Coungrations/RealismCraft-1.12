package com.lg.realism.event;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.lg.realism.RegBlocks;

import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BurnTorchEvent {
	 public static final PropertyDirection FACING = PropertyDirection.create("facing", new Predicate<EnumFacing>()
    {
        public boolean apply(@Nullable EnumFacing p_apply_1_)
        {
            return p_apply_1_ != EnumFacing.DOWN;
        }
    });
	@SubscribeEvent
	public void burn(PlayerInteractEvent.RightClickBlock event){

		final World world = event.getWorld();
		EntityPlayer player = (EntityPlayer) event.getEntity();
		ItemStack is = player.getHeldItem(EnumHand.MAIN_HAND);

		if(is != null) {
			if ( is.getItem().getItemFromBlock(RegBlocks.torch) != null) {
				if(world.getBlockState(event.getPos()) == RegBlocks.extorch.getDefaultState()) {
					world.setBlockState(event.getPos(), RegBlocks.torch.getDefaultState());
				}
				if(world.getBlockState(event.getPos()) == RegBlocks.extorch.getDefaultState().withProperty(FACING, EnumFacing.WEST)) {
					world.setBlockState(event.getPos(), RegBlocks.torch.getDefaultState().withProperty(FACING, EnumFacing.WEST));
				}
				if(world.getBlockState(event.getPos()) == RegBlocks.extorch.getDefaultState().withProperty(FACING, EnumFacing.EAST)) {
					world.setBlockState(event.getPos(), RegBlocks.torch.getDefaultState().withProperty(FACING, EnumFacing.EAST));
				}
				if(world.getBlockState(event.getPos()) == RegBlocks.extorch.getDefaultState().withProperty(FACING, EnumFacing.SOUTH)) {
					world.setBlockState(event.getPos(), RegBlocks.torch.getDefaultState().withProperty(FACING, EnumFacing.SOUTH));
				}
				if(world.getBlockState(event.getPos()) == RegBlocks.extorch.getDefaultState().withProperty(FACING, EnumFacing.NORTH)) {
					world.setBlockState(event.getPos(), RegBlocks.torch.getDefaultState().withProperty(FACING, EnumFacing.NORTH));
				}
			}
		}
	}
}
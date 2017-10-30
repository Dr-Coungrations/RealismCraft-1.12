package com.lg.realism.fire;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class BlockFireGuiHandler implements IGuiHandler{
	
	public static final int BLOCK_FIRE_GUI_ID = 6;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == BLOCK_FIRE_GUI_ID) {
			return new BlockFireContainer(player.inventory, (BlockFireTileEntity) world.getTileEntity(new BlockPos(x, y, z)));
		}	
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == BLOCK_FIRE_GUI_ID) {
			return new BlockFireGui(player.inventory, (BlockFireTileEntity) world.getTileEntity(new BlockPos(x, y, z)));
		}
			
		return null;
	}

}

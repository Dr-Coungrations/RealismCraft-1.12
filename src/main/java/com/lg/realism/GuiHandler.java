package com.lg.realism;

import com.lg.realism.Blocks.CompactWorkbench.CompactWBContainer;
import com.lg.realism.Blocks.CompactWorkbench.GuiCompactWorkbench;
import com.lg.realism.Items.Backpacks.ItemStorageContainer;
import com.lg.realism.Items.Backpacks.ItemStorageGui;
import com.lg.realism.NewInventory.ContainerCustomInv;
import com.lg.realism.NewInventory.GUICustomInv;
import com.lg.realism.NewInventory.CAPforINV.CAPCustomInventoryProvider;
import com.lg.realism.NewInventory.CAPforINV.ICAPCustomInventory;
import com.lg.realism.fire.BlockFireContainer;
import com.lg.realism.fire.BlockFireGui;
import com.lg.realism.fire.BlockFireTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{
	
	public static final int BLOCK_FIRE_GUI_ID = 6;
	public static final int GUI_BACKPACK = 2;
	public static final int COMPACT_WORKBENCH = 1;
	 public static final int INVENTORY_GUI_ID = 0;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		ItemStack current = player.getActiveItemStack();
		if (current != null) {
		}
		 ICAPCustomInventory inv = player.getCapability(CAPCustomInventoryProvider.INVENTORY_CAP, null);
		   switch (ID)
	        {
	            case BLOCK_FIRE_GUI_ID: return new BlockFireContainer(player.inventory, (BlockFireTileEntity) world.getTileEntity(new BlockPos(x, y, z)));
	            case GUI_BACKPACK: return new ItemStorageContainer(player, null);
	            case INVENTORY_GUI_ID: return new ContainerCustomInv(player.inventory, inv.getInventory(), player);
	            case COMPACT_WORKBENCH: return new CompactWBContainer(player.inventory, world, new BlockPos(x, y, z));
	            default: return null;
	        }	
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		   ICAPCustomInventory inv = player.getCapability(CAPCustomInventoryProvider.INVENTORY_CAP, null);
		  switch (ID)
	        {
	        	case BLOCK_FIRE_GUI_ID:return new BlockFireGui(player.inventory, (BlockFireTileEntity) world.getTileEntity(new BlockPos(x, y, z)));
	        	case GUI_BACKPACK: return new ItemStorageGui();
	        	case INVENTORY_GUI_ID: return new GUICustomInv(player, player.inventory, inv.getInventory());
	        	case COMPACT_WORKBENCH: return new GuiCompactWorkbench(player.inventory, world, new BlockPos(x, y, z));
	        }

			
		return null;
	}

}

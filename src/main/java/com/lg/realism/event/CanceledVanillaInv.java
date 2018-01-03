package com.lg.realism.event;

import com.lg.realism.PSystem.NetworkHandler;
import com.lg.realism.PSystem.OpenInventoryMessage;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CanceledVanillaInv {

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void cancel(GuiOpenEvent event) {
		EntityPlayer ep = Minecraft.getMinecraft().player;
		if( ep !=null && !ep.isCreative()) {	
			if(event.getGui() instanceof GuiInventory) {		
				NetworkHandler.INSTANCE.sendToServer(new OpenInventoryMessage());
				event.setCanceled(true);
			}
		}

	}

}
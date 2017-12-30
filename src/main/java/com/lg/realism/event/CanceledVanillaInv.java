package com.lg.realism.event;

import com.lg.realism.PSystem.NetworkHandler;
import com.lg.realism.PSystem.OpenInventoryMessage;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CanceledVanillaInv {

	@SubscribeEvent
	public void cancel(GuiOpenEvent event) {
		EntityPlayer ep = Minecraft.getMinecraft().player;
		if( ep !=null && !ep.isCreative()) {	
			if(event.getGui() instanceof GuiInventory) {		
				NetworkHandler.NETWORK.sendToServer(new OpenInventoryMessage());
				event.setCanceled(true);
			}
		}

	}

}
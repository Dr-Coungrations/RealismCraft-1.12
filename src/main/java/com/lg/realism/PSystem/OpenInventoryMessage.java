package com.lg.realism.PSystem;

import com.lg.realism.GuiHandler;
import com.lg.realism.Realism;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class OpenInventoryMessage extends AbstractPacket<OpenInventoryMessage> {
	public OpenInventoryMessage() {}
	@Override    
	public void fromBytes(ByteBuf buf) {}   
	@Override   
	public void toBytes(ByteBuf buf) {}  
	@Override    
	public void handleClientSide(EntityPlayer player) {} 
	@Override    
	public void handleServerSide(EntityPlayer player) {  
		player.openGui(Realism.INSTANCE, GuiHandler.INVENTORY_GUI_ID, player.getEntityWorld(), (int)player.posX, (int)player.posY, (int)player.posZ);   
	}}
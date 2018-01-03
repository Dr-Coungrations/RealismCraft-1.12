package com.lg.realism.PSystem;

import com.lg.realism.GuiHandler;
import com.lg.realism.Realism;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class OpenInventoryMessage extends AbstractPacket<OpenInventoryMessage>{   
	private static int open;
	public OpenInventoryMessage() {}
	public OpenInventoryMessage(int i)
	{
		open = i;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		open = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(open);
	}
	@Override
	public void handleServerSide(EntityPlayerMP player) {
		player.openGui(Realism.INSTANCE, GuiHandler.INVENTORY_GUI_ID, player.getEntityWorld(), (int)player.posX, (int)player.posY, (int)player.posZ);   
	}
	@Override
	public void handleClientSide(EntityPlayer player) {

		}
}


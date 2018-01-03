package com.lg.realism.PSystem;

import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class ColdMessageClient extends AbstractPacket<ColdMessageClient> {
	
	private static boolean temp;
	
	public ColdMessageClient() {}
	
	public ColdMessageClient(boolean i) {
		temp = i;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		temp = buf.readBoolean();
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeBoolean(temp);
	}
	
	@Override
	public void handleClientSide(EntityPlayer player) {
		if(player!= null){
			IBarLevel cap = player.getCapability(WaterBarProv.LEVEL_CAP, null);
			cap.setCommonCold(temp);
		}
	}
	
	@Override
	public void handleServerSide(EntityPlayerMP player) {}
}
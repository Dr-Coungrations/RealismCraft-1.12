package com.lg.realism.PSystem;

import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class HUDSyncMessageServer extends AbstractPacket<HUDSyncMessageServer> {
	
	private static int level;
	
	public HUDSyncMessageServer() {}
	
	public HUDSyncMessageServer(int i) {
		level = i;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		level = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(level);
	}
	
	@Override
	public void handleClientSide(EntityPlayer player) {

	}
	
	@Override
	public void handleServerSide(EntityPlayerMP player) {
		if(player!= null){
			IBarLevel cap = player.getCapability(WaterBarProv.LEVEL_CAP, null);
			cap.setWaterLevel(level);
		}
		
	}
}
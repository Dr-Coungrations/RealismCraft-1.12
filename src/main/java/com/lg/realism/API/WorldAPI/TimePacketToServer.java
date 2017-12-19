package com.lg.realism.API.WorldAPI;

import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
import com.lg.realism.PSystem.AbstractPacket;
import com.lg.realism.PSystem.ColdMessageClient;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class TimePacketToServer extends AbstractPacket<TimePacketToServer> {
	
	private static int time;
	
	public TimePacketToServer() {}
	
	public TimePacketToServer(int i) {
		time = i;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		time = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(time);
	}
	
	@Override
	public void handleClientSide(EntityPlayer player) {
	}
	
	@Override
	public void handleServerSide(EntityPlayer player) {
		if(player!= null){
			ISeasonHandler season = player.getCapability(SeasonProvider.LEVEL_CAP, null);
			season.setAutunm(time);
			season.setWinter(time);
			season.setSummer(time);
			season.setSpring(time);
		}
	}
}

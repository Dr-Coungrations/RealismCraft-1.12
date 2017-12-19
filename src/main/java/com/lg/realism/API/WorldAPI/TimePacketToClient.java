package com.lg.realism.API.WorldAPI;

import com.lg.realism.PSystem.AbstractPacket;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class TimePacketToClient extends AbstractPacket<TimePacketToClient> {
	
	private static int time;
	
	public TimePacketToClient() {}
	
	public TimePacketToClient(int i) {
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
		if(player!= null){
			ISeasonHandler season = player.getCapability(SeasonProvider.LEVEL_CAP, null);
			season.setAutunm(time);
			season.setWinter(time);
			season.setSummer(time);
			season.setSpring(time);
		}
	}
	
	@Override
	public void handleServerSide(EntityPlayer player) {

	}
}


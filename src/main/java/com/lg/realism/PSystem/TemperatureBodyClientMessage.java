package com.lg.realism.PSystem;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;

public class TemperatureBodyClientMessage extends AbstractPacket<TemperatureBodyClientMessage> {
	
	private static float temp;
	
	public TemperatureBodyClientMessage() {}
	
	public TemperatureBodyClientMessage(float i) {
		temp = i;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		temp = buf.readFloat();
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeFloat(temp);
	}
	
	@Override
	public void handleClientSide(EntityPlayer player) {
		if(player!= null){
			IBarLevel cap = player.getCapability(WaterBarProv.LEVEL_CAP, null);
			cap.setTempBody(temp);
		}
	}
	
	@Override
	public void handleServerSide(EntityPlayer player) {}
}
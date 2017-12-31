package com.lg.realism.PSystem;

import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public final class TemperatureBodyServerMessage extends AbstractPacket
{
	public TemperatureBodyServerMessage() {}
	public TemperatureBodyServerMessage(float temp)
	{
		buf().writeFloat(temp);
	}
	
	@Override
	public void handleServerSide(EntityPlayer player)
	{
		if (player != null)
		{
			player.getCapability(WaterBarProv.LEVEL_CAP, null).setTempBody(buf().readFloat());
		}
	}
}
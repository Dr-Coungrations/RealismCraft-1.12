package com.lg.realism.API.WorldAPI;

import com.lg.realism.PSystem.AbstractPacket;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class TimePacketToServer extends AbstractPacket
{
	public TimePacketToServer() {}
	public TimePacketToServer(int time)
    {
		buf().writeInt(time);
	}

	@Override
	public void handleServerSide(EntityPlayer player)
    {
		if (player!= null)
		{
			int time = buf().readInt();

			ISeasonHandler season = player.getCapability(SeasonProvider.LEVEL_CAP, null);
			season.setAutunm(time);
			season.setWinter(time);
			season.setSummer(time);
			season.setSpring(time);
		}
	}
}
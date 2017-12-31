package com.lg.realism.PSystem;

import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public final class HUDSyncMessage extends AbstractPacket
{
	public HUDSyncMessage() {}
	public HUDSyncMessage(int level)
	{
		buf().writeInt(level);
	}

	@Override
	public void handleClientSide(EntityPlayer player)
	{
		if (player != null)
		    player.getCapability(WaterBarProv.LEVEL_CAP, null).setWaterLevel(buf().readInt());
	}
}
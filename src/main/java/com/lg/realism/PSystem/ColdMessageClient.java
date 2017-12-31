package com.lg.realism.PSystem;

import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public final class ColdMessageClient extends AbstractPacket
{
	public ColdMessageClient() {}
	public ColdMessageClient(boolean temp)
	{
        buf().writeBoolean(temp);
	}
	
	@Override
	public void handleClientSide(EntityPlayer player)
    {
		if (player != null)
		    player.getCapability(WaterBarProv.LEVEL_CAP, null).setCommonCold(buf().readBoolean());
	}
}
package com.lg.realism.PSystem;

import com.lg.realism.Realism;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public final class NetworkHandler
{
	private static short id;
	public static final SimpleNetworkWrapper NETWORK = new SimpleNetworkWrapper(Realism.MODID);

	public NetworkHandler()
	{
		register(HUDSyncMessage.class, Side.CLIENT);
		register(HUDSyncMessageServer.class, Side.SERVER);
		register(TemperatureBodyClientMessage.class, Side.CLIENT);
		register(TemperatureBodyServerMessage.class, Side.SERVER);
		register(ColdMessageClient.class, Side.CLIENT);
	}

	private void register(Class<? extends AbstractPacket> packet, Side side)
	{
		try
		{
			NETWORK.registerMessage(packet.newInstance(), packet, id++, side);
		}
		catch (InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}
}
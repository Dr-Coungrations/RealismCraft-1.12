package com.lg.realism.PSystem;

import com.lg.realism.Realism;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler
{
	public static final SimpleNetworkWrapper NETWORK = new SimpleNetworkWrapper(Realism.MODID);
	private static int id;

	public NetworkHandler()
	{
		register(HUDSyncMessage.class, Side.CLIENT);
		register(HUDSyncMessageServer.class, Side.SERVER);
		register(TemperatureBodyClientMessage.class, Side.CLIENT);
		register(TemperatureBodyServerMessage.class, Side.SERVER);
		register(ColdMessageClient.class, Side.CLIENT);
	}

	private void register(Class packet, Side side)
	{
		NETWORK.registerMessage(packet, packet, id++, side);
	}
}
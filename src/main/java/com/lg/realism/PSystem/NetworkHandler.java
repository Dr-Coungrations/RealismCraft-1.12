package com.lg.realism.PSystem;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import com.lg.realism.Realism;

public class NetworkHandler {

	public static final NetworkHandler INSTANCE = new NetworkHandler();
	public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(Realism.MODID);
	private static int id;

	public NetworkHandler() {}

	public void init() {
		NETWORK.registerMessage(HUDSyncMessage.class, HUDSyncMessage.class, id++, Side.CLIENT);
		NETWORK.registerMessage(HUDSyncMessageServer.class, HUDSyncMessageServer.class, id++, Side.SERVER);
		NETWORK.registerMessage(TemperatureBodyClientMessage.class, TemperatureBodyClientMessage.class, id++, Side.CLIENT);
		NETWORK.registerMessage(TemperatureBodyServerMessage.class, TemperatureBodyServerMessage.class, id++, Side.SERVER);
		NETWORK.registerMessage(ColdMessageClient.class, ColdMessageClient.class, id++, Side.CLIENT);
	}

	public void sendToAll(final IMessage message) {
		NETWORK.sendToAll(message);
	}

	public void sendTo(final IMessage message, final EntityPlayerMP player) {
		NETWORK.sendTo(message, player);
	}

	public void sendToAllAround(final IMessage message, final NetworkRegistry.TargetPoint point) {
		NETWORK.sendToAllAround(message, point);
	}

	public void sendToDimension(final IMessage message, final int dimensionId) {
		NETWORK.sendToDimension(message, dimensionId);
	}

	public void sendToServer(final IMessage message){
		NETWORK.sendToServer(message);
	}
}

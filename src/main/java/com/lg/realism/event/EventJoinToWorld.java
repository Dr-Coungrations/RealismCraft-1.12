package com.lg.realism.event;

import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
import com.lg.realism.PSystem.HUDSyncMessage;
import com.lg.realism.PSystem.NetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
/*
 * The basis of this code comes from modifications Bionisation 2
 * Thanks Thunder for the help
 */
public class EventJoinToWorld {
	
	@SubscribeEvent
	public void syncInvHUD(PlayerChangedDimensionEvent event) {  
		
		EntityPlayer player = (EntityPlayer)event.player;
		
		if(!player.world.isRemote){
			IBarLevel capabilities = player.getCapability(WaterBarProv.LEVEL_CAP, null);  
			NetworkHandler.NETWORK.sendTo(new HUDSyncMessage(capabilities.getWaterLevel()), (EntityPlayerMP)player);
		} 
	}
}

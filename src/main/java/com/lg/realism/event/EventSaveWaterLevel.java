package com.lg.realism.event;

import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
import com.lg.realism.PSystem.HUDSyncMessage;
import com.lg.realism.PSystem.NetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*
 * The basis of this code comes from modifications Bionisation 2
 * Thanks Thunder for the help
 */
public class EventSaveWaterLevel {
	
	@SubscribeEvent
	public void onDeath(LivingDeathEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			
			EntityPlayer player = (EntityPlayer) event.getEntity();
			IBarLevel capabilities = player.getCapability(WaterBarProv.LEVEL_CAP, null);
			
			NetworkHandler.INSTANCE.sendTo(new HUDSyncMessage(capabilities.getWaterLevel()), (EntityPlayerMP)player);
		}
	}
}


package com.lg.realism.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.lg.realism.Realism;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
/*
 * The basis of this code comes from modifications Bionisation 2
 * Thanks Thunder for the help
 */
public class CapEventHandler {
	
	public static final ResourceLocation LEVEL_CAP = new ResourceLocation(Realism.MODID ,"waterLevel");
	
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent event) {
		if(event.getObject() instanceof EntityPlayer){
			event.addCapability(LEVEL_CAP, new WaterBarProv());
		}
	}
}
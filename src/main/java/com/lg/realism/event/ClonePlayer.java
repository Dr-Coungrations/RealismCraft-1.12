package com.lg.realism.event;

import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClonePlayer {
	
	@SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event) {
        EntityPlayer player = event.getEntityPlayer();
        IBarLevel newCap = player.getCapability(WaterBarProv.LEVEL_CAP, null);
        IBarLevel oldCap = event.getOriginal().getCapability(WaterBarProv.LEVEL_CAP, null);
        newCap.copyCapabilities(oldCap);
    }
}

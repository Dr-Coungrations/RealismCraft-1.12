package com.lg.realism.Diseaces;

import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
import com.lg.realism.Sounds.SoundsRegister;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class Cold
{
	@SubscribeEvent
	public void commonCold(PlayerTickEvent e)
    {
		if (e.player.getCapability(WaterBarProv.LEVEL_CAP, null).getCommonCold())
		{
		    e.player.motionX *= 0.8F;
            e.player.motionZ *= 0.8F;
            e.player.jumpMovementFactor *= 0.5F;

            if (e.player.ticksExisted % 110 == 0)
                e.player.playSound(SoundsRegister.isheavybreathing, 0.6F, 1.0F);
		}
	}
}
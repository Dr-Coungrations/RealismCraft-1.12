package com.lg.realism.Diseaces;

import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
import com.lg.realism.Sounds.SoundsRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class Grippe
{
	@SubscribeEvent
	public void grippe(PlayerTickEvent e)
	{
		if (e.player.getCapability(WaterBarProv.LEVEL_CAP, null).getGrippe())
		{
			e.player.motionX *= 0.4F;
			e.player.motionZ *= 0.4F;
			e.player.jumpMovementFactor *= 0.4F;
			e.player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("poison"), 5600, 7));

			if (e.player.ticksExisted % 110 == 0)
				e.player.playSound(SoundsRegister.isheavybreathing, 0.8F, 1.0F);
		}
	}
}
package com.lg.realism.event.Diseaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.event.GuiScreenEvent.PotionShiftEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

import java.util.Objects;

import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
import com.lg.realism.Sounds.SoundsRegister;

public class Grippe {
	@SubscribeEvent
	public void grippe(PlayerTickEvent e)
	{
		if (Objects.requireNonNull(e.player.getCapability(WaterBarProv.LEVEL_CAP, null)).getGrippe())
		{
			e.player.motionX *= 0.4F;
			e.player.motionZ *= 0.4F;
			e.player.jumpMovementFactor *= 0.4F;
			e.player.addPotionEffect(new PotionEffect(Potion.getPotionById(19), 5600, 7));

			if (e.player.ticksExisted % 110 == 0)
				e.player.playSound(SoundsRegister.isheavybreathing, 0.8F, 1.0F);
		}
	}
}

package com.lg.realism.Diseaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.event.GuiScreenEvent.PotionShiftEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
import com.lg.realism.Sounds.SoundsRegister;

public class Grippe {
	@SubscribeEvent
	public void grippe(PlayerTickEvent event){
		EntityPlayer player = (EntityPlayer) event.player;
		IBarLevel capabilities = event.player.getCapability(WaterBarProv.LEVEL_CAP, null);
		if(capabilities.getGrippe()){
		player.motionX *= 0.4F;
		player.motionZ *= 0.4F;
		player.jumpMovementFactor *= 0.4F;
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(19), 5600, 7));
		if(player.ticksExisted % 110 == 0){
		player.playSound(SoundsRegister.isheavybreathing, 0.8F, 1.0F);
		}
		}
	}
}

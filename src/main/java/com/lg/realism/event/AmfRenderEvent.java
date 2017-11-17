package com.lg.realism.event;

import com.lg.realism.Sounds.SoundsRegister;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class AmfRenderEvent {
	static Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	public void renderAmfEffect(PlayerTickEvent event) {

		EntityPlayer player = (EntityPlayer) event.player;

		if(player.getActivePotionEffects() == MobEffects.NIGHT_VISION){
			
			player.jumpMovementFactor *= 40F;
			player.eyeHeight *= 40F;
			player.motionX *= 40F;
			player.motionY *= 2F;
			player.motionZ *= 40F;
			player.cameraYaw *= 40F;
			if(player.ticksExisted % 110 == 0){
				player.playSound(SoundsRegister.isheavybreathing, 0.6F, 1.0F);
				}
		}
	}
}

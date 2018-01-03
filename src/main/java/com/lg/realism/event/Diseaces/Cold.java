package com.lg.realism.event.Diseaces;

import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
import com.lg.realism.Config.ConfigManager;
import com.lg.realism.Sounds.SoundsRegister;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class Cold {
	@SubscribeEvent
	public void commonCold(PlayerTickEvent event){
		EntityPlayer player = (EntityPlayer) event.player;
		IBarLevel capabilities = event.player.getCapability(WaterBarProv.LEVEL_CAP, null);
		if(capabilities.getCommonCold()){
		player.motionX *= 0.8F;
		player.motionZ *= 0.8F;
		player.jumpMovementFactor *= 0.5F;
	//	player.setFire(1);
		if(player.ticksExisted % 110 == 0){
		player.playSound(SoundsRegister.isheavybreathing, 0.6F, 1.0F);
		}
		}
	}
}

package com.lg.realism.Particle;

import com.lg.realism.Realism;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ParticleEvent{
	@SubscribeEvent 
	public void spriteRegisterEventPre(TextureStitchEvent.Pre event) {      
		ResourceLocation PARTICLE_BLOOD_TEXTURE = new ResourceLocation("realism:particles/leavespart");  
		event.getMap().registerSprite(PARTICLE_BLOOD_TEXTURE); 
		
		}
	}

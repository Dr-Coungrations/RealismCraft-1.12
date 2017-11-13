package com.lg.realism.event;

import org.lwjgl.opengl.GL11;

import com.lg.realism.Realism;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventDamageIndicator {
	
	private static Minecraft mc = Minecraft.getMinecraft();
	
	@SubscribeEvent
	public void render(RenderGameOverlayEvent.Post event) {
		if (event.isCancelable() && event.getType() != ElementType.TEXT) return;
		RayTraceResult raytrace = mc.objectMouseOver;
		if (raytrace != null && raytrace.typeOfHit == RayTraceResult.Type.ENTITY) {
			if (raytrace.entityHit instanceof EntityLivingBase) {
				EntityLivingBase ent = (EntityLivingBase) raytrace.entityHit;
				
				float hp = ent.getHealth() / ent.getMaxHealth();
				int deg = (int) (hp * 100);
				
				mc.fontRenderer.drawString(deg + "%", 4, 4, 0xFFFFFF);
				
				mc.getTextureManager().bindTexture(new ResourceLocation(Realism.MODID, "textures/gui/damage_indicator.png"));
				
				GL11.glPushMatrix();
				GlStateManager.enableBlend();
				mc.ingameGUI.drawTexturedModalRect(2, 2, 0, 0, 64, 16);
				mc.ingameGUI.drawTexturedModalRect(3, 3, 0, 16, (int)(hp * 62), 14);
				GL11.glPopMatrix();
			}
		}
	}
}

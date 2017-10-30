package com.lg.realism.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.lwjgl.opengl.GL11;

import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
import com.lg.realism.Config.ConfigManager;

public class VisualTempBody {
	static Minecraft mc = Minecraft.getMinecraft();
	
	@SubscribeEvent
	public void renderTempBody(RenderGameOverlayEvent.Post event) {
		String color = "";
		IBarLevel capabilities = Minecraft.getMinecraft().player.getCapability(WaterBarProv.LEVEL_CAP, null);
		if (event.isCancelable() || event.getType() != ElementType.FOOD) return;
		
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			int x = event.getResolution().getScaledWidth() / 2 - (ConfigManager.xTextTempBody);
			int y = event.getResolution().getScaledHeight() - (ConfigManager.yTextTempBody);
			FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
			if(capabilities.getTempBody() < 36){
			fontrenderer.drawString(TextFormatting.BLACK + I18n.format("tempBody") + ":" + " " + TextFormatting.BLUE + capabilities.getTempBody() + TextFormatting.BLACK + " C", x, y, 0xFFFFFF);
			}
			if(capabilities.getTempBody() < 37 && capabilities.getTempBody() > 36){
			fontrenderer.drawString(TextFormatting.BLACK + I18n.format("tempBody") + ":" + " " + TextFormatting.DARK_GREEN + capabilities.getTempBody() + TextFormatting.BLACK + " C", x, y, 0xFFFFFF);
			}
			if(capabilities.getTempBody() > 37 && capabilities.getTempBody() < 39){
			fontrenderer.drawString( TextFormatting.BLACK + I18n.format("tempBody") + ":" + " " + TextFormatting.RED + capabilities.getTempBody() + TextFormatting.BLACK + " C", x, y, 0xFFFFFF);
			}
			if(capabilities.getTempBody() > 39){
			fontrenderer.drawString( TextFormatting.BLACK + I18n.format("tempBody") + ":" + " " + TextFormatting.DARK_RED + capabilities.getTempBody() + TextFormatting.BLACK + " C", x, y, 0xFFFFFF);
			}
			GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}
}

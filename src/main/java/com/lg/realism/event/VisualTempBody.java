package com.lg.realism.event;

import org.lwjgl.opengl.GL11;

import com.lg.realism.RegItems;
import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
import com.lg.realism.Config.ConfigManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.RenderSpecificHandEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class VisualTempBody {
	static Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	public void renderTempBody(RenderSpecificHandEvent event) {
		String color = "";
		IBarLevel capabilities = Minecraft.getMinecraft().player.getCapability(WaterBarProv.LEVEL_CAP, null);
		if (event.getItemStack().getItem() == RegItems.thermo && (event.getHand() == EnumHand.MAIN_HAND)){


			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

			FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
			if(capabilities.getTempBody() < 36){
				fontrenderer.drawString(TextFormatting.BLACK + I18n.format("tempBody") + ":" + " " + TextFormatting.BLUE + capabilities.getTempBody() + TextFormatting.BLACK + " C", 0, 10, 0xFFFFFF);
			}
			if(capabilities.getTempBody() < 37 && capabilities.getTempBody() > 36){
				fontrenderer.drawString(TextFormatting.BLACK + I18n.format("tempBody") + ":" + " " + TextFormatting.DARK_GREEN + capabilities.getTempBody() + TextFormatting.BLACK + " C", 0, 20, 0xFFFFFF);
			}
			if(capabilities.getTempBody() > 37 && capabilities.getTempBody() < 39){
				fontrenderer.drawString( TextFormatting.BLACK + I18n.format("tempBody") + ":" + " " + TextFormatting.RED + capabilities.getTempBody() + TextFormatting.BLACK + " C", 0, 30, 0xFFFFFF);
			}
			if(capabilities.getTempBody() > 39){
				fontrenderer.drawString( TextFormatting.BLACK + I18n.format("tempBody") + ":" + " " + TextFormatting.DARK_RED + capabilities.getTempBody() + TextFormatting.BLACK + " C", 0, 40, 0xFFFFFF);
			}
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
		}
	}
}

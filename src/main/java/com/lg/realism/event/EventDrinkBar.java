package com.lg.realism.event;


import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
/*
 * Created with the help of a timaxa007
 */
public class EventDrinkBar {
	
	static Minecraft mc = Minecraft.getMinecraft();
	public static final ResourceLocation textureWater = new ResourceLocation("realism:textures/gui/drinkbar.png");
	
	@SubscribeEvent
	public void renderWLevel(RenderGameOverlayEvent.Post event) {
		IBarLevel capabilities = Minecraft.getMinecraft().player.getCapability(WaterBarProv.LEVEL_CAP, null);
		if (event.isCancelable() || event.getType() != ElementType.FOOD) return;
		//Matrix draw
		GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				
					mc.renderEngine.bindTexture(textureWater);
					int left = event.getResolution().getScaledWidth() / 2 + 10;
					int top = event.getResolution().getScaledHeight() - 49;
					int wlevel = (int)(((float)capabilities.getWaterLevel()/ 100F) * 10F);

						for (int i = 0; i < 10; ++i) {
							mc.ingameGUI.drawTexturedModalRect(left + i * 8, top, (wlevel > i ? 8 : 0), 0, 7, 9);
						}
			GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}

}

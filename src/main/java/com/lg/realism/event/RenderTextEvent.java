package com.lg.realism.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderSpecificHandEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import com.lg.realism.Realism;
import com.lg.realism.RegItems;
import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;

public class RenderTextEvent {
	public static int page = 0;
	public static int charge;

	@SubscribeEvent
	public void render(RenderSpecificHandEvent event){
		if(page == 0){
			
			if (event.getItemStack().getItem() == RegItems.counter && (event.getHand() == EnumHand.MAIN_HAND)){
				Minecraft mc = Minecraft.getMinecraft();
				
				EntityPlayer player = Minecraft.getMinecraft().player;
				IBarLevel capabilities = Minecraft.getMinecraft().player.getCapability(WaterBarProv.LEVEL_CAP, null);
				
				GL11.glPushMatrix();
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glTranslatef(0.435F, -0.12F, -1.07F);
				GL11.glScalef(0.005f, -0.005f, 0.005f);
				GL11.glRotatef(22.5F, 1 ,0, 0);
				GL11.glRotatef(0F, 0 ,1, 0);
				GL11.glRotatef(0F, 0 ,0, 1);
				FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
				fontrenderer.drawString("Temp Body: " + capabilities.getTempBody(), 0, 0, 0xFFFFFF);
				fontrenderer.drawString("Health: " + player.getHealth(), 0, 10, 0xFFFFFF);
				fontrenderer.drawString("Water Level: " + capabilities.getWaterLevel(), 0, 20, 0xFFFFFF);
				fontrenderer.drawString("CoordX: " + player.getPosition().getX(), 0, 30, 0xFFFFFF);
				fontrenderer.drawString("CoordY: " + player.getPosition().getY(), 0, 40, 0xFFFFFF);
				fontrenderer.drawString("CoordZ: " + player.getPosition().getZ(), 0, 50, 0xFFFFFF);
				fontrenderer.drawString("Time(Min): " + (player.getEntityWorld().getWorldTime()/20)/60, 0, 60, 0xFFFFFF);
				fontrenderer.drawString("Time(Sec): "  + player.getEntityWorld().getWorldTime()/20, 0, 70, 0xFFFFFF);
				fontrenderer.drawString("Weather: "  + player.getEntityWorld().isRaining(), 0, 80, 0xFFFFFF);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glPopMatrix();
			}
			if (event.getItemStack().getItem() == RegItems.counter && (event.getHand() == EnumHand.OFF_HAND)){
				EntityPlayer player = Minecraft.getMinecraft().player;
				IBarLevel capabilities = Minecraft.getMinecraft().player.getCapability(WaterBarProv.LEVEL_CAP, null);
				GL11.glPushMatrix();
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glTranslatef(0.435F, -0.12F, -1.07F);
				GL11.glScalef(0.005f, -0.005f, 0.005f);
				GL11.glRotatef(22.5F, 1 ,0, 0);
				GL11.glRotatef(0F, 0 ,1, 0);
				GL11.glRotatef(0F, 0 ,0, 1);
				FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
				fontrenderer.drawString("Temp Body: " + capabilities.getTempBody(), -215, 0, 0xFFFFFF);
				fontrenderer.drawString("Health: " + player.getHealth(), -215, 10, 0xFFFFFF);
				fontrenderer.drawString("Water Level: " + capabilities.getWaterLevel(), -215, 20, 0xFFFFFF);
				fontrenderer.drawString("CoordX: " + player.getPosition().getX(), -215, 30, 0xFFFFFF);
				fontrenderer.drawString("CoordY: " + player.getPosition().getY(), -215, 40, 0xFFFFFF);
				fontrenderer.drawString("CoordZ: " + player.getPosition().getZ(), -215, 50, 0xFFFFFF);
				fontrenderer.drawString("Time(Min): " + (player.getEntityWorld().getWorldTime()/20)/60, -215, 60, 0xFFFFFF);
				fontrenderer.drawString("Time(Sec): "  + player.getEntityWorld().getWorldTime()/20, -215, 70, 0xFFFFFF);
				fontrenderer.drawString("Weather: "  + player.getEntityWorld().isRaining(), -215, 80, 0xFFFFFF);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glPopMatrix();
			}
		}
		
		if(page == 0){
			if (event.getItemStack().getItem() == RegItems.counter && (event.getHand() == EnumHand.OFF_HAND)){
				Minecraft mc = Minecraft.getMinecraft();
				ResourceLocation textureLevelBattery = new ResourceLocation("realism:textures/gui/battery.png");
			
				GL11.glPushMatrix();
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glTranslatef(0.435F, -0.12F, -1.07F);
				GL11.glScalef(0.005f, -0.005f, 0.005f);
				GL11.glRotatef(22.5F, 1 ,0, 0);
				GL11.glRotatef(0F, 0 ,1, 0);
				GL11.glRotatef(0F, 0 ,0, 1);
				mc.renderEngine.bindTexture(textureLevelBattery);
				mc.ingameGUI.drawTexturedModalRect(0,0,0,0,16,16);
				mc.ingameGUI.drawTexturedModalRect(0,0,16,0,16,16);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glPopMatrix();
			}
			if (event.getItemStack().getItem() == RegItems.counter && (event.getHand() == EnumHand.MAIN_HAND)){
				Minecraft mc = Minecraft.getMinecraft();
				ResourceLocation textureLevelBattery = new ResourceLocation("realism:textures/gui/battery.png");
		
				GL11.glPushMatrix();
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glTranslatef(0.435F, -0.12F, -0.7F);
				GL11.glScalef(0.004f, -0.004f, 0.004f);
				GL11.glRotatef(22.5F, 1 ,0, 0);
				GL11.glRotatef(0F, 0 ,1, 0);
				GL11.glRotatef(0F, 0 ,0, 1);
				mc.renderEngine.bindTexture(textureLevelBattery);
				mc.ingameGUI.drawTexturedModalRect(-2,-42,0,0,16,16);
				if(charge == 0){
					mc.ingameGUI.drawTexturedModalRect(-2,-42,16,0,0,16);
					}
				if(charge == 1){
				mc.ingameGUI.drawTexturedModalRect(-2,-42,16,0,4,16);
				}
				if(charge == 2){
					mc.ingameGUI.drawTexturedModalRect(-2,-42,16,0,8,16);
					}
				if(charge == 3){
					mc.ingameGUI.drawTexturedModalRect(-2,-42,16,0,12,16);
					}
				if(charge == 4){
					mc.ingameGUI.drawTexturedModalRect(-2,-42,16,0,16,16);
					}
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glPopMatrix();
			}
		}
	}
	
	public static String KEY_CATEGORY = "key.categories." + Realism.MODID;
	public static KeyBinding pressKeyOne = new KeyBinding("key.clearUrine", Keyboard.KEY_V, KEY_CATEGORY);
	public static KeyBinding pressKeyTwo = new KeyBinding("key.clearUrinec", Keyboard.KEY_B, KEY_CATEGORY);
	public static KeyBinding pressKeyCharge = new KeyBinding("key.charge", Keyboard.KEY_N, KEY_CATEGORY);
	public static KeyBinding pressKeyChargeM = new KeyBinding("key.chargem", Keyboard.KEY_K, KEY_CATEGORY);
	@SubscribeEvent
	public void nextPage(KeyInputEvent event){
		if (pressKeyOne.isPressed())
			page++;
		
		if (pressKeyTwo.isPressed())
			page--;
		
		if (pressKeyCharge.isPressed())
			System.out.println(charge++);
		
		if (pressKeyChargeM.isPressed())
			System.out.println(charge++);
	}

}


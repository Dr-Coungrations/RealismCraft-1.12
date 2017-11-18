package com.lg.realism.event;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.lg.realism.Items.ItemRealPickaxe;
import com.lg.realism.Items.ItemRealShovel;
import com.lg.realism.entity.gender.EntityGenderPig;
import com.lg.realism.proxy.ClientProxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class EventToolMode {
	
	public static KeyBinding KEY_TOOL_MODE = new KeyBinding("key.toolMode", Keyboard.KEY_J, ClientProxy.KEY_CATEGORY);
	public static KeyBinding KEY_DEV = new KeyBinding("key.dev", Keyboard.KEY_K, ClientProxy.KEY_CATEGORY);
	
	public static enum EnumToolMode {
		FULL(0), TAKE(1), ROAD(2);
		
		private int id;
		
		EnumToolMode(int id) { this.id = id; }
		
		public int getId() { return id; }
		
		public EnumToolMode getNext() {
			switch(this) {
			case FULL : return TAKE;
			case TAKE : return ROAD;
			default: return FULL;
			}
		}
		
		public EnumToolMode getPrev() {
			switch(this) {
			case FULL : return ROAD;
			case TAKE : return FULL;
			default: return ROAD;
			}
		}
	}
	
	static Minecraft mc = Minecraft.getMinecraft();
	public static final ResourceLocation modesTexture = new ResourceLocation("realism:textures/gui/tools_modes.png");
	
	@SubscribeEvent
	public void render(RenderGameOverlayEvent.Post event) {
		if (!event.isCancelable()) {
			ItemStack stack = mc.player.getHeldItemMainhand();
			//if (stack == null) return;
			if (event.getType() == ElementType.TEXT && stack.getItem() instanceof ItemRealShovel) {
				GL11.glPushMatrix();
				GlStateManager.enableBlend();
				
				mc.renderEngine.bindTexture(modesTexture);
				mc.ingameGUI.drawTexturedModalRect(4, 4, ClientProxy.currentToolMode.getId() * 20, 0, 20, 20);
				GL11.glPopMatrix();
			}
			if (event.getType() == ElementType.FOOD && stack.getItem() instanceof ItemRealPickaxe) {
				NBTTagCompound nbt = stack.getTagCompound();
				
				GL11.glPushMatrix();
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				int h = mc.fontRenderer.FONT_HEIGHT;
				
				float upDamage = 0F;
				float upSharpness = 0F;
				float handleDamage = 0F;
				
				if (nbt != null && nbt.hasKey("UpDamage")) {
					upDamage = nbt.getFloat("UpDamage");
					upSharpness = nbt.getFloat("UpSharpness");
					handleDamage = nbt.getFloat("HandleDamage");
				}
				
				int damage = (int)(upDamage / 10F * 100);
				damage = -damage + 100;
				mc.fontRenderer.drawString(damage + "% ( " + upDamage + " )", 4, 64, 0xFFFFFF);
				
				damage = (int)(upSharpness / 10F * 100);
				damage = -damage + 100;
				mc.fontRenderer.drawString(damage + "% ( " + upSharpness + " )", 4, 64 + h, 0xFFFFFF);
				
				damage = (int)(handleDamage / 10F * 100);
				damage = -damage + 100;
				mc.fontRenderer.drawString(damage + "% ( " + handleDamage + " )", 4, 64 + h * 2, 0xFFFFFF);
				
				GL11.glDisable(GL11.GL_TEXTURE_2D);
				GL11.glColor4f(1F, 0F, 0F, 1F);
				
				Tessellator tessellator = Tessellator.getInstance();
				BufferBuilder bufferbuilder = tessellator.getBuffer();
				
				bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
				drawDamageBar(bufferbuilder, 4, 4, 26, 4, upDamage / 10F);
				drawDamageBar(bufferbuilder, 4, 10, 26, 4, upSharpness / 10F);
				drawDamageBar(bufferbuilder, 4, 16, 26, 4, handleDamage / 10F);
				tessellator.draw();
				
				GL11.glColor4f(1F, 1F, 1F, 1F);
				
				GL11.glEnable(GL11.GL_TEXTURE_2D);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glPopMatrix();
			}
		}
	}
	
	public void drawDamageBar(BufferBuilder bb, int x, int y, int width, int height, float damage) {
		bb.pos((double)(x), (double)(y), 0D).color(0, 0, 0, 255).endVertex();
		bb.pos((double)(x), (double)(y + height), 0D).color(0, 0, 0, 255).endVertex();
		bb.pos((double)(x + width), (double)(y + height), 0.0D).color(0, 0, 0, 255).endVertex();
		bb.pos((double)(x + width), (double)(y), 0D).color(0, 0, 0, 255).endVertex();
		
		int rgb = MathHelper.hsvToRGB(Math.max(0.0F, (float) (1.0F - damage)) / 3.0F, 1.0F, 1.0F);
		int r = rgb >> 16 & 255;
		int g = rgb >> 8 & 255;
		int b = rgb & 255;
		
		x++;
		y++;
		width = (int) ((width - 2F) * (-damage + 1F));
		height -= 2;
		
		bb.pos((double)(x), (double)(y), 0D).color(r, g, b, 255).endVertex();
		bb.pos((double)(x), (double)(y + height), 0D).color(r, g, b, 255).endVertex();
		bb.pos((double)(x + width), (double)(y + height), 0D).color(r, g, b, 255).endVertex();
		bb.pos((double)(x + width), (double)(y), 0D).color(r, g, b, 255).endVertex();
	}
	
	@SubscribeEvent
	public void onKey(KeyInputEvent event) {
		if (mc.player.getHeldItemMainhand().getItem() instanceof ItemRealShovel)
			if (KEY_TOOL_MODE.isPressed())
				ClientProxy.currentToolMode = ClientProxy.currentToolMode.getNext();
		if (KEY_DEV.isPressed())
			mc.world.spawnEntity(new EntityGenderPig(mc.world));
	}
}

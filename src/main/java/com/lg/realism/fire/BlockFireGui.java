package com.lg.realism.fire;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class BlockFireGui extends GuiContainer{
	
    private static final ResourceLocation FIRE_GUI_TEXTURE = new ResourceLocation("realism:textures/gui/cumpfire.png");
    private final InventoryPlayer playerInventory;
    private final IInventory inventory;

    public BlockFireGui(InventoryPlayer playerInv, IInventory inv){
    	
        super(new BlockFireContainer(playerInv, inv));
        this.playerInventory = playerInv;
        this.inventory = inv;
    }
    
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
    	
        String s = I18n.format(this.inventory.getDisplayName().getUnformattedText());
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 120, this.ySize - 96, 4210752);

    }

    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
    	
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(FIRE_GUI_TEXTURE);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

     
    }

    private int getBurnLeftScaled(int pixels){
    	
        int i = this.inventory.getField(1);

        if (i == 0){
        	
            i = 200;
        }

        return this.inventory.getField(0) * pixels / i;
    }
}

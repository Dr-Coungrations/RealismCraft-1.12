package com.lg.realism.Blocks.CompactWorkbench;

import com.lg.realism.Realism;
import com.lg.realism.fire.BlockFireContainer;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GuiCompactWorkbench extends GuiContainer{

    private float oldMouseX;
    private float oldMouseY;
    private static final ResourceLocation compact_workbench_TEXTURE = new ResourceLocation(Realism.MODID + ":textures/gui/compact_workbench.png");
    
    private final InventoryPlayer playerInventory;
    private final IInventory inventory;
    InventoryPlayer playerInv;
    IInventory inv;
    public GuiCompactWorkbench(InventoryPlayer inventoryPlayer,World world,BlockPos pos){
    	
        super(new CompactWBContainer(inventoryPlayer,world, pos));
        this.playerInventory = playerInv;
        this.inventory = inv;
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.oldMouseX = (float)mouseX;
        this.oldMouseY = (float)mouseY;
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
    	this.drawDefaultBackground();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(compact_workbench_TEXTURE);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

    }

}

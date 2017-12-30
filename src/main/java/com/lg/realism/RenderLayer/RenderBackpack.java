package com.lg.realism.RenderLayer;

import com.lg.realism.RegItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class RenderBackpack implements LayerRenderer<EntityPlayer>
{
   @Override
   public void doRenderLayer(EntityPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
   {
       GlStateManager.pushMatrix();
       //������� ��������
       GlStateManager.translate(0, 0.15F, 0.15F);
       //�������� ��������
       GlStateManager.rotate(90F, 0, 1, 0);
       GlStateManager.rotate(180F, 1, 0, 0);
       //������� ��������
       GlStateManager.scale(1.3F, 1.3F, 1.3F);

       //�������: ���� ����� ������, �� �� ������ ��������� ������ �������.
       if(player.isSneaking())
       {
           GlStateManager.rotate(-30F, 1, 0, 0);
           GlStateManager.translate(0, -0.155F, 0.04F);
       }

       //������ ��������(������� �� Minecraft)
       Minecraft.getMinecraft().getRenderItem().renderItem(new ItemStack(RegItems.backpack), player, ItemCameraTransforms.TransformType.FIXED, false);
       GlStateManager.popMatrix();
   }

   @Override
   public boolean shouldCombineTextures()
   {
       return false;
   }
}

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
       //Позиция предмета
       GlStateManager.translate(0, 0.15F, 0.15F);
       //Вращение предмета
       GlStateManager.rotate(90F, 0, 1, 0);
       GlStateManager.rotate(180F, 1, 0, 0);
       //Размеры предмета
       GlStateManager.scale(1.3F, 1.3F, 1.3F);

       //Условие: Если игрок присел, то мы меняем положение нашего колчана.
       if(player.isSneaking())
       {
           GlStateManager.rotate(-30F, 1, 0, 0);
           GlStateManager.translate(0, -0.155F, 0.04F);
       }

       //Рендер предмета(обычный из Minecraft)
       Minecraft.getMinecraft().getRenderItem().renderItem(new ItemStack(RegItems.backpack), player, ItemCameraTransforms.TransformType.FIXED, false);
       GlStateManager.popMatrix();
   }

   @Override
   public boolean shouldCombineTextures()
   {
       return false;
   }
}

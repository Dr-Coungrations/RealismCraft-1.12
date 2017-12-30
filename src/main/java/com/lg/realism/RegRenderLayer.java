package com.lg.realism;

import com.lg.realism.RenderLayer.RenderBackpack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;

public class RegRenderLayer
{
    public static void register()
    {
        setLayer(new RenderBackpack());
    }

    private static void setLayer(final LayerRenderer layer)
    {
        Minecraft.getMinecraft().getRenderManager().getSkinMap().get("default").addLayer(layer);
        Minecraft.getMinecraft().getRenderManager().getSkinMap().get("slim").addLayer(layer);
    }
}
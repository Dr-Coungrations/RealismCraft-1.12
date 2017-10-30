package com.lg.realism.event;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryModifiable;

@EventBusSubscriber
public class DelVanillaRecipes {

@SubscribeEvent
   public static void registerRecipes(RegistryEvent.Register<IRecipe> event)
   {
    ResourceLocation WoodenAxe = new ResourceLocation("minecraft:wooden_axe");

    IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();
       
    modRegistry.remove(WoodenAxe);
    
   }
}
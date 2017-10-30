package com.lg.realism.Sounds;

import com.lg.realism.Realism;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class SoundsRegister
{
   public static SoundEvent isheavybreathing;

   public static void register()
   {   
       /**
        *  Наша музыка/мелодия.
        */
	   isheavybreathing = new SoundEvent(new ResourceLocation(Realism.MODID + ":isheavybreathing"));
   }
}

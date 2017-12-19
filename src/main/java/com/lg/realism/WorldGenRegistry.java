package com.lg.realism;


import net.minecraftforge.fml.common.registry.GameRegistry;

import com.lg.realism.Config.ConfigManager;
import com.lg.realism.World.WorldGeneratorFour;
import com.lg.realism.World.WorldGeneratorOne;
import com.lg.realism.World.WorldGeneratorThree;
import com.lg.realism.World.WorldGeneratorTwo;
import com.lg.realism.World.GenOre.WorldGenOre;

public class WorldGenRegistry {
	public static WorldGeneratorOne wgo = new WorldGeneratorOne();
	public static WorldGeneratorTwo wgt = new WorldGeneratorTwo();
	public static WorldGeneratorThree wgth = new WorldGeneratorThree();
	public static WorldGenOre wgenore = new WorldGenOre();
	public static WorldGeneratorFour wgf = new WorldGeneratorFour();
	public static void registry(){
		
		
		if(ConfigManager.enableFirstGenerator){
	//	GameRegistry.registerWorldGenerator(wgo, 0);
		}
		if(ConfigManager.enableTwoGenerator){
	//	GameRegistry.registerWorldGenerator(wgt, 1);
		}
		if(ConfigManager.enableThirdGenerator){
	//	GameRegistry.registerWorldGenerator(wgth, 2);
		}
//		GameRegistry.registerWorldGenerator(wgenore, 3);
//		GameRegistry.registerWorldGenerator(wgf, 1);
	}
}

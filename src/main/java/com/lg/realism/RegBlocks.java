package com.lg.realism;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import com.lg.realism.Basic.BasicBlockWithDropItem;
import com.lg.realism.Blocks.Ash;
import com.lg.realism.Blocks.BlockBurntGrass;
import com.lg.realism.Blocks.BlockBurntTree;
import com.lg.realism.Blocks.BlockDryGrass;
import com.lg.realism.Blocks.MossBlock;
import com.lg.realism.Blocks.PaneHorizontal;
import com.lg.realism.Blocks.RealismRedSand;
import com.lg.realism.Blocks.RealismSand;
import com.lg.realism.Blocks.TestGen;
import com.lg.realism.Blocks.WetRedSand;
import com.lg.realism.Blocks.WetSand;
import com.lg.realism.Blocks.Cactus.CactusSmall;
import com.lg.realism.Blocks.Cactus.OneStageCactus;
import com.lg.realism.Blocks.Cactus.SideCactus;
import com.lg.realism.Blocks.DeadTree.BlockDeadTree;
import com.lg.realism.Blocks.DeadTree.DeadBranch;
import com.lg.realism.Blocks.Ocean.Corals;
import com.lg.realism.Blocks.Ocean.Seaweeds;
import com.lg.realism.GrowWood.BirchBranch;
import com.lg.realism.GrowWood.GrowTreeStageOne;
import com.lg.realism.GrowWood.GrowTreeStageOneBirch;
import com.lg.realism.GrowWood.GrowTreeStageOneSpruce;
import com.lg.realism.GrowWood.GrowTreeStageTwo;
import com.lg.realism.GrowWood.GrowTreeStageTwoBirch;
import com.lg.realism.GrowWood.GrowTreeStageTwoSpruce;
import com.lg.realism.GrowWood.OakBranch;
import com.lg.realism.GrowWood.SmallLeaves;
import com.lg.realism.GrowWood.SmallLeavesBirch;
import com.lg.realism.GrowWood.SmallLeavesSpruce;
import com.lg.realism.GrowWood.AppleTree.AppleTreeStageOne;
import com.lg.realism.GrowWood.AppleTree.AppleTreeStageTwo;
import com.lg.realism.GrowWood.AppleTree.BlockAppleTree;
import com.lg.realism.GrowWood.AppleTree.BranchAppleTree;
import com.lg.realism.GrowWood.AppleTree.LeavesAppleTree;
import com.lg.realism.GrowWood.AppleTree.SmallLeavesAppleTree;
import com.lg.realism.Items.DryVine;
import com.lg.realism.Items.WetVine;
import com.lg.realism.fire.BlockFire;

public class RegBlocks {
	public static Block panehorizontal = new PaneHorizontal(Material.WOOD, "panehorizontal", 3F, 3F, SoundType.WOOD);
	//appletree
	public static Block blockappletree = new BlockAppleTree(Material.WOOD, "blockappletree", 6F, 6F, SoundType.WOOD);
	public static Block appletreeone = new AppleTreeStageOne(Material.WOOD, "appletreeone", 3F, 3F, "axe", 1, SoundType.WOOD);
	public static Block appletreetwo = new AppleTreeStageTwo(Material.WOOD, "appletreetwo", 6F, 6F, "axe", 1, SoundType.WOOD);
	
	public static Block smallleavesappletree = new SmallLeavesAppleTree(Material.LEAVES, "smallleavesappletree", 2F, 2F, "shears", 1, SoundType.GROUND);
	public static Block leavesappletree = new LeavesAppleTree(Material.LEAVES, "leavesappletree", 2F, 2F, "shears", 1, SoundType.GROUND);
	//Oak
	public static Block growtreeone = new GrowTreeStageOne(Material.WOOD, "growtreeone", 3F, 3F, "axe", 1, SoundType.WOOD);
	public static Block growtreetwo = new GrowTreeStageTwo(Material.WOOD, "growtreetwo", 6F, 6F, "axe", 1, SoundType.WOOD);
	
	public static Block smallleaves = new SmallLeaves(Material.LEAVES, "smallleaves", 2F, 2F, "shears", 1, SoundType.GROUND);
	//Spruce
	public static Block growtreeonespruce = new GrowTreeStageOneSpruce(Material.WOOD, "growtreeonespruce", 3F, 3F, "axe", 1, SoundType.WOOD);
	public static Block growtreetwospruce = new GrowTreeStageTwoSpruce(Material.WOOD, "growtreetwospruce", 6F, 6F, "axe", 1, SoundType.WOOD);

	public static Block smallleavesspruce = new SmallLeavesSpruce(Material.LEAVES, "smallleavesspruce", 2F, 2F, "shears", 1, SoundType.GROUND);
	//birch
	public static Block growtreeonebirch = new GrowTreeStageOneBirch(Material.WOOD, "growtreeonebirch", 3F, 3F, "axe", 1, SoundType.WOOD);
	
	
	public static Block growtreetwobirch = new GrowTreeStageTwoBirch(Material.WOOD, "growtreetwobirch", 6F, 6F, "axe", 1, SoundType.WOOD);
	public static Block smallleavesbirch = new SmallLeavesBirch(Material.LEAVES, "smallleavesbirch", 2F, 2F, "shears", 1, SoundType.GROUND);
	//new ore
	public static Block copperore = new BasicBlockWithDropItem(Material.ROCK, "copperore", 3F, 3F, SoundType.STONE, RegItems.oreitemcopper, 2,0);
	//kaolin
	public static Block kaolinit = new BasicBlockWithDropItem(Material.ROCK, "kaolinit", 3F, 3F, SoundType.STONE, RegItems.kaolin, 2,0);

	//Vine
	public static Block wetvine = new WetVine(Material.LEAVES, "wetvine", 0.1F, 0.1F, "shears", 1, SoundType.GROUND);
	public static Block dryvine = new DryVine(Material.LEAVES, "dryvine", 0.1F, 0.1F, "shears", 1, SoundType.GROUND);
	//sand
	public static Block wetsand = new WetSand(Material.SAND, "wetsand", 2F, 2F, SoundType.SAND);
	public static Block wetredsand = new WetRedSand(Material.SAND, "wetredsand", 2F, 2F, SoundType.SAND);
	public static Block realismsand = new RealismSand(Material.SAND, "realismsand", 2F, 2F, SoundType.SAND);
	public static Block realismredsand = new RealismRedSand(Material.SAND, "realismredsand", 2F, 2F, SoundType.SAND);
	//moss
	public static Block mossblock = new MossBlock(Material.LEAVES, "mossblock", 0.1F, 0.1F, "mossblock", 1, SoundType.GROUND);
	//salt
	public static Block saltblock = new BasicBlockWithDropItem(Material.ROCK, "saltblock", 2F, 2F, SoundType.STONE, RegItems.salt,4,0);
	
	//ocean
		//corals
	public static Block corals = new Corals(Material.WOOD, "corals", 3F, 3F, "axe", 1, SoundType.WOOD);
		//seaweeds
	public static Block seaweeds = new Seaweeds(Material.GRASS, "seaweeds");
	
	public static Block coralblock = new BasicBlockWithDropItem(Material.ROCK, "coralblock", 3F, 3F, SoundType.STONE, Item.getItemFromBlock(RegBlocks.corals), 2,0);
	
	public static Block cumpfire = new BlockFire("cumpfire", false);
	

	public static Block testgen = new TestGen(Material.LEAVES, "testgen", 0.1F, 0.1F, SoundType.GROUND);
	
	public static Block cactusone = new OneStageCactus(Material.WOOD, "cactusone", 3F, 3F, "axe", 1, SoundType.WOOD);
	public static Block cactusside = new SideCactus("cactusside");
	public static Block cactussmall = new CactusSmall(Material.GRASS, "cactussmall", 1F, 1F, "axe", 1, SoundType.WOOD);
	
	public static Block blockdrygrass = new BlockDryGrass(Material.GLASS, "blockdrygrass", 1F, 2F, SoundType.PLANT);
	public static Block blockburntgrass = new BlockBurntGrass(Material.GLASS, "blockburntgrass", 1F, 2F, SoundType.PLANT);
	public static Block ash = new Ash(Material.GLASS, "ash", 0.2F, 2F, SoundType.SNOW);

	public static Block blockburnttree = new BlockBurntTree(Material.WOOD, "blockburnttree", 6F, "axe",  1, 3F, SoundType.WOOD);
	public static Block blockdeadtree = new BlockDeadTree(Material.WOOD, "blockdeadtree", 6F, "axe",  1, 3F, SoundType.WOOD);
	
	public static Block connectblock = new BirchBranch("connectblock");
	public static Block oakbranch = new OakBranch("oakbranch");
	public static Block branchappletree = new BranchAppleTree("branchappletree");
	public static Block deadbranch = new DeadBranch("deadbranch");
	public static void register() {
		
		
		registerBlock(connectblock);
		registerBlock(deadbranch);
		registerBlock(blockdeadtree);
		registerBlock(blockburnttree);
		registerBlock(ash);
		registerBlock(blockburntgrass);
		registerBlock(blockdrygrass);
		registerBlock(coralblock);
		registerBlock(cactussmall);
		registerBlock(seaweeds);
		registerBlock(corals);
		registerBlock(cactusside);
		registerBlock(cactusone);
		registerBlock(panehorizontal);
		registerBlock(appletreeone);
		registerBlock(appletreetwo);
		registerBlock(branchappletree);
		registerBlock(leavesappletree);
		registerBlock(smallleavesappletree);
		registerBlock(testgen);
		registerBlock(blockappletree);
		registerBlock(oakbranch);
		registerBlock(smallleavesbirch);
		
		registerBlock(growtreeonebirch);
		registerBlock(growtreetwobirch);
		registerBlock(copperore);
		registerBlock(growtreeone);
		registerBlock(growtreetwo);
		registerBlock(saltblock);
		registerBlock(wetsand);
		registerBlock(kaolinit);
		registerBlock(cumpfire);
		registerBlock(wetredsand);
		registerBlock(realismredsand);
		registerBlock(wetvine);
		registerBlock(mossblock);
		registerBlock(realismsand);
		registerBlock(dryvine);
		registerBlock(smallleaves);
		registerBlock(growtreeonespruce);
		registerBlock(growtreetwospruce);
		registerBlock(smallleavesspruce);
	}
	public static void registerRender() {
		registerRenderBlock(connectblock);
		registerRenderBlock(deadbranch);
		registerRenderBlock(blockdeadtree);
		registerRenderBlock(blockburnttree);
		registerRenderBlock(ash);
		registerRenderBlock(blockburntgrass);
		registerRenderBlock(blockdrygrass);
		registerRenderBlock(coralblock);
		registerRenderBlock(cactussmall);
		registerRenderBlock(seaweeds);
		registerRenderBlock(corals);
		registerRenderBlock(cactusside);
		registerRenderBlock(cactusone);
		registerRenderBlock(panehorizontal);
		registerRenderBlock(testgen);
		registerRenderBlock(leavesappletree);
		registerRenderBlock(appletreeone);
		registerRenderBlock(appletreetwo);
		registerRenderBlock(branchappletree);
		registerRenderBlock(smallleavesappletree);
		registerRenderBlock(blockappletree);
		registerRenderBlock(oakbranch);
		registerRenderBlock(smallleavesbirch);

		registerRenderBlock(growtreeonebirch);
		registerRenderBlock(growtreetwobirch);
		registerRenderBlock(copperore);
		registerRenderBlock(growtreeone);
		registerRenderBlock(cumpfire);
		registerRenderBlock(kaolinit);
		registerRenderBlock(wetsand);
		registerRenderBlock(wetredsand);
		registerRenderBlock(saltblock);
		registerRenderBlock(realismredsand);
		registerRenderBlock(growtreetwo);
		registerRenderBlock(realismsand);
		registerRenderBlock(wetvine);
		registerRenderBlock(dryvine);
		registerRenderBlock(mossblock);
		registerRenderBlock(smallleaves);
		registerRenderBlock(growtreeonespruce);
		registerRenderBlock(growtreetwospruce);
		registerRenderBlock(smallleavesspruce);
	}
	public static void registerBlock(Block block) {
		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}
	public static void registerRenderBlock(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
	
}

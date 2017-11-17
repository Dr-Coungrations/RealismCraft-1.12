package com.lg.realism;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import com.lg.realism.API.ItemDrink;
import com.lg.realism.Basic.BasicDamageItem;
import com.lg.realism.Basic.BasicFood;
import com.lg.realism.Basic.BasicItem;
import com.lg.realism.Items.Counter;
import com.lg.realism.Items.ItemShovel;
import com.lg.realism.Items.Kaolin;
import com.lg.realism.Items.NewStoneAxe;
import com.lg.realism.Items.PointedStone;
import com.lg.realism.Items.RealismPickaxe;
import com.lg.realism.Items.Rope;
import com.lg.realism.Items.Stonehand;
import com.lg.realism.Items.WetVineItem;
import com.lg.realism.Items.FullShovel.FullDiamondShovel;
import com.lg.realism.Items.FullShovel.FullGoldShovel;
import com.lg.realism.Items.FullShovel.FullIronShovel;
import com.lg.realism.Items.FullShovel.FullStoneShovel;
import com.lg.realism.Items.FullShovel.FullWoodenShovel;
import com.lg.realism.Items.ItemsLog.BirchSapling;
import com.lg.realism.Items.ItemsLog.ItemBranchBirch;
import com.lg.realism.Items.ItemsLog.OakSapling;
import com.lg.realism.Items.ItemsLog.SpruceSapling;

public class RegItems {

	
	public static Item fullstoneshovel = new FullStoneShovel("fullstoneshovel",1);
	public static Item fullwoodshovel = new FullWoodenShovel("fullwoodshovel",1);
	public static Item fullironshovel = new FullIronShovel("fullironshovel",1);
	public static Item fullgoldshovel = new FullGoldShovel("fullgoldshovel",1);
	public static Item fulldiamondshovel = new FullDiamondShovel("fulldiamondshovel",1);
	
	public static Item branchbirchitem = new ItemBranchBirch("branchbirchitem",1);
	
	public static Item newstoneaxe = new NewStoneAxe("newstoneaxe",Realism.StoneMaterial);
	public static Item bladestoneaxe = new BasicItem("bladestoneaxe",64);
	
	public static Item bladestoneshovel = new BasicItem("bladestoneshovel",64);
			
	public static Item handfuldirt = new BasicItem("handfuldirt",64);
	public static Item dirtformshovel = new BasicItem("dirtformshovel",64);
	public static Item dirtformaxe = new BasicItem("dirtformaxe",64);
	public static Item dirtformchisel = new BasicItem("dirtformchisel",64);
	
	public static Item kaolin = new BasicItem("kaolin",64);
	public static Item kaolindust = new Kaolin("kaolindust",64);
	
	public static Item stonebladechisel = new BasicItem("stonebladechisel",64);
	
	public static Item annealedclaycup = new BasicItem("annealedclaycup",1);
	public static Item annealedclaycupfull = new ItemDrink("annealedclaycupfull",1,10,RegItems.annealedclaycup);
	
	public static Item stonechisel = new BasicDamageItem("stonechisel",1,64);
	public static Item pistil = new BasicDamageItem("pistil",1,64);
	
	public static Item claycup = new BasicItem("claycup",64);
	public static Item clayplate = new BasicItem("clayplate",64);
	public static Item annealedclayplate = new BasicItem("annealedclayplate",64);
	
	public static Item itemcup = new BasicItem("itemcup",1);
	public static Item itemcupfill = new ItemDrink("itemcupfill",1,30, RegItems.itemcup);
	
	public static ItemFood konin = new BasicFood(8, 6F, true, "konin");
	public static ItemFood cookedkonin = new BasicFood(12, 12F, true, "cookedkonin");
	public static ItemFood playermeat = new BasicFood(6, 6F, true, "playermeat");
	public static ItemFood cookedplayermeat = new BasicFood(8, 12F, true, "cookedplayermeat");
	
	public static Item stonehand = new Stonehand("stonehand",64);
	public static Item clumpclay = new BasicItem("clumpclay",64);
	public static Item mossitem = new BasicItem("mossitem",64);
	public static Item turf = new BasicItem("turf",64);
	public static Item rope = new Rope("rope",64);
	public static Item salt = new BasicItem("salt",64);
	public static ItemFood pumpkinnugget = new BasicFood(2, 1.2F, false, "pumpkinnugget");
	public static Item wetvineitem = new WetVineItem("wetvineitem",64);
	public static Item dryvineitem = new BasicItem("dryvineitem",64);
	public static Item spoke = new BasicItem("spoke",64);
	public static Item spokes = new BasicDamageItem("spokes",1,64);
	public static Item pointedstone = new PointedStone("pointedstone",ToolMaterial.IRON, 64);
	
	
	public static Item acorn = new BasicItem("acorn",64);
	public static Item stonepickaxe = new RealismPickaxe("stonepickaxe",Realism.StoneMaterial);
	public static Item copperpickaxe = new RealismPickaxe("copperpickaxe",Realism.CopperMaterial);
	public static Item ironpickaxe = new RealismPickaxe("ironpickaxe",Realism.IronMaterial);
	public static Item goldpickaxe = new RealismPickaxe("goldpickaxe",Realism.GoldenMaterial);
	public static Item diamondpickaxe = new RealismPickaxe("diamondpickaxe",Realism.DiamondMaterial);
	
	public static Item oaksapling = new OakSapling("oaksapling",64);
	public static Item birchsapling = new BirchSapling("birchsapling",64);
	public static Item sprucesapling = new SpruceSapling("sprucesapling",64);
	
	public static Item oreitemiron = new BasicItem("oreitemiron",64),
			   oreitemgold = new BasicItem("oreitemgold",64),
			   oreitemcopper = new BasicItem("oreitemcopper",64),
			   oreitemdiamond = new BasicItem("oreitemdiamond",64);
		// MaximPixel's Items
	
	public static Item woodenshovel = new ItemShovel("woodenshovel", "woodenshovel");
	public static Item stoneshovel = new ItemShovel("stoneshovel", "stoneshovel");
	
	public static Item counter = new Counter("counter",1);

	
	public static void register() {
		// MP's register
		
		registerItem(woodenshovel);
		registerItem(stoneshovel);
		
		
		registerItem(counter);
		registerItem(cookedplayermeat);
		registerItem(playermeat);
		registerItem(cookedkonin);
		registerItem(konin);
		registerItem(birchsapling);
		registerItem(diamondpickaxe);
		registerItem(goldpickaxe);
		registerItem(ironpickaxe);
		registerItem(copperpickaxe);
		registerItem(stonepickaxe);
		registerItem(branchbirchitem);
		registerItem(oreitemiron);
		registerItem(oreitemgold);
		registerItem(oreitemcopper);
		registerItem(oreitemdiamond);
		registerItem(kaolindust);
		registerItem(pistil);
		registerItem(dirtformchisel);
		registerItem(stonechisel);
		registerItem(clayplate);
		registerItem(annealedclayplate);
		registerItem(annealedclaycupfull);
		registerItem(annealedclaycup);
		registerItem(claycup);
		registerItem(stonebladechisel);
		registerItem(itemcup);
		registerItem(acorn);
		registerItem(itemcupfill);
		registerItem(oaksapling);
		registerItem(sprucesapling);
		registerItem(handfuldirt);
		registerItem(stonehand);
		registerItem(kaolin);
		registerItem(rope);
		registerItem(salt);
		registerItem(bladestoneshovel);
		registerItem(pumpkinnugget);
		registerItem(mossitem);
		registerItem(newstoneaxe);
		registerItem(bladestoneaxe);
		registerItem(turf);
		registerItem(dirtformaxe);
		registerItem(dirtformshovel);
		registerItem(spokes);
		registerItem(spoke);
		registerItem(fullstoneshovel);
		registerItem(fullwoodshovel);
		registerItem(fullironshovel);
		registerItem(fullgoldshovel);
		registerItem(fulldiamondshovel);
		registerItem(wetvineitem);
		registerItem(dryvineitem);
		registerItem(pointedstone);
		registerItem(clumpclay);

	}
	public static void registerRender() {
	
		registerRenderItem(counter);
		registerRenderItem(cookedplayermeat);
		registerRenderItem(playermeat);
		registerRenderItem(cookedkonin);
		registerRenderItem(konin);
		registerRenderItem(birchsapling);
		registerRenderItem(branchbirchitem);
		
		registerRenderItem(oreitemiron);
		registerRenderItem(oreitemgold);
		registerRenderItem(oreitemcopper);
		registerRenderItem(oreitemdiamond);
		
		registerRenderItem(diamondpickaxe);
		registerRenderItem(goldpickaxe);
		registerRenderItem(ironpickaxe);
		registerRenderItem(copperpickaxe);
		registerRenderItem(stonepickaxe);
		
		registerRenderItem(kaolindust);
		registerRenderItem(pistil);
		registerRenderItem(dirtformchisel);
		registerRenderItem(stonechisel);
		registerRenderItem(annealedclayplate);
		registerRenderItem(clayplate);
		
		registerRenderItem(annealedclaycupfull);
		registerRenderItem(annealedclaycup);
		registerRenderItem(claycup);
		registerRenderItem(itemcup);
		registerRenderItem(kaolin);
		registerRenderItem(acorn);
		
		registerRenderItem(itemcupfill);
		registerRenderItem(oaksapling);
		registerRenderItem(sprucesapling);
		registerRenderItem(dirtformaxe);
		registerRenderItem(dirtformshovel);
		registerRenderItem(handfuldirt);
		registerRenderItem(turf);
		
		registerRenderItem(stonebladechisel);
		registerRenderItem(salt);
		registerRenderItem(bladestoneshovel);
		registerRenderItem(pumpkinnugget);
		
		registerRenderItem(rope);
		registerRenderItem(bladestoneaxe);
		registerRenderItem(newstoneaxe);
		registerRenderItem(mossitem);
		registerRenderItem(spokes);
		registerRenderItem(spoke);
		
		registerRenderItem(fullstoneshovel);
		registerRenderItem(fullwoodshovel);
		registerRenderItem(fullironshovel);
		registerRenderItem(fullgoldshovel);
		registerRenderItem(fulldiamondshovel);
		
		registerRenderItem(stonehand);
		registerRenderItem(clumpclay);
		registerRenderItem(wetvineitem);
		registerRenderItem(dryvineitem);
		registerRenderItem(pointedstone);
		
		String modid = Realism.MODID;
		
		registerRenderItem(woodenshovel, 0, new ResourceLocation(modid, "woodenshovelempty"));
		registerRenderItem(woodenshovel, 1, new ResourceLocation(modid, "woodenshoveldirt"));
		registerRenderItem(woodenshovel, 2, new ResourceLocation(modid, "woodenshovelgrass"));
		registerRenderItem(woodenshovel, 3, new ResourceLocation(modid, "woodenshovelgravel"));
		registerRenderItem(stoneshovel, 0, new ResourceLocation(modid, "stoneshovel"));
		registerRenderItem(stoneshovel, 1, new ResourceLocation(modid, "stoneshoveldirt"));
		registerRenderItem(stoneshovel, 2, new ResourceLocation(modid, "stoneshovelgrass"));
		registerRenderItem(stoneshovel, 3, new ResourceLocation(modid, "stoneshovelgravel"));
	}
	
	public static void preRegisterRender() {
		String modid = Realism.MODID;
		
		registerCustomModel(woodenshovel, 0, new ResourceLocation(modid, "woodenshovelempty"));
		registerCustomModel(woodenshovel, 1, new ResourceLocation(modid, "woodenshoveldirt"));
		registerCustomModel(woodenshovel, 2, new ResourceLocation(modid, "woodenshovelgrass"));
		registerCustomModel(woodenshovel, 3, new ResourceLocation(modid, "woodenshovelgravel"));
		registerCustomModel(stoneshovel, 0, new ResourceLocation(modid, "stoneshovelempty"));
		registerCustomModel(stoneshovel, 1, new ResourceLocation(modid, "stoneshoveldirt"));
		registerCustomModel(stoneshovel, 2, new ResourceLocation(modid, "stoneshovelgrass"));
		registerCustomModel(stoneshovel, 3, new ResourceLocation(modid, "stoneshovelgravel"));
	}
	
	private static void registerItem(Item item) {
		ForgeRegistries.ITEMS.register(item);
	}
	
	private static void registerCustomModel(Item item, int meta, ResourceLocation location) {
		ModelLoader.setCustomModelResourceLocation(item, meta, getModel(location));
	}
	
	private static void registerRenderItem(Item item) {
		registerRenderItem(item, item.getRegistryName());
	}
	
	private static void registerRenderItem(Item item, ResourceLocation location) {
		registerRenderItem(item, 0, location);
	}
	
	private static void registerRenderItem(Item item, int meta, ResourceLocation location) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, getModel(location));
	}
	
	public static ModelResourceLocation getModel(ResourceLocation location) {
		return new ModelResourceLocation(location, "inventory");
	}
}

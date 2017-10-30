package com.lg.realism.Craft;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.lg.realism.RegItems;

public class RealismCrafts {
	public static void recipesRegister() {
		GameRegistry.addShapedRecipe(new ResourceLocation("rope"), new ResourceLocation("rope"), new ItemStack(RegItems.rope),new Object[]{
			"Y Y",
			" Y ",
			"YHY",
			'Y', RegItems.dryvineitem,
			'H', RegItems.spokes,
			});
		GameRegistry.addShapedRecipe(new ResourceLocation("spoke"), new ResourceLocation("spoke"), new ItemStack(RegItems.spoke),new Object[]{
			" H ",
			" Y ",
			" H ",
			'Y', Items.STICK,
			'H', RegItems.stonehand,
			});
		GameRegistry.addShapedRecipe(new ResourceLocation("spoke"), new ResourceLocation("spoke"), new ItemStack(RegItems.spoke),new Object[]{
			" H ",
			" Y ",
			" H ",
			'Y', Items.STICK,
			'H', RegItems.stonehand,
			});
		GameRegistry.addShapedRecipe(new ResourceLocation("dirtformaxe"), new ResourceLocation("dirtformaxe"), new ItemStack(RegItems.dirtformaxe),new Object[]{
			"  Y",
			"  Y",
			"Y Y",
			'Y', RegItems.handfuldirt,
			});
		GameRegistry.addShapedRecipe(new ResourceLocation("dirtformshovel"), new ResourceLocation("dirtformshovel"), new ItemStack(RegItems.dirtformshovel),new Object[]{
			"Y Y",
			"Y Y",
			"Y Y",
			'Y', RegItems.handfuldirt,
			});
		GameRegistry.addShapedRecipe(new ResourceLocation("dirtformchisel"), new ResourceLocation("dirtformchisel"), new ItemStack(RegItems.dirtformchisel),new Object[]{
			"  Y",
			"Y Y",
			"YYY",
			'Y', RegItems.handfuldirt,
			});
		GameRegistry.addShapedRecipe(new ResourceLocation("claycup"), new ResourceLocation("claycup"), new ItemStack(RegItems.claycup),new Object[]{
			"Y Y",
			"Y Y",
			"YYY",
			'Y', RegItems.clumpclay,
			});
		GameRegistry.addShapedRecipe(new ResourceLocation("clayplate"), new ResourceLocation("clayplate"), new ItemStack(RegItems.clayplate),new Object[]{
			"   ",
			"Y Y",
			"YYY",
			'Y', RegItems.clumpclay,
			});
		
		GameRegistry.addShapedRecipe(new ResourceLocation("stoneshovel"), new ResourceLocation("stoneshovel"), new ItemStack(Items.STONE_SHOVEL),new Object[]{
			" H ",
			" B ",
			" Y ",
			'Y', Items.STICK,
			'B', RegItems.rope,
			'H', RegItems.bladestoneshovel,
			});
		GameRegistry.addShapedRecipe(new ResourceLocation("newstoneaxe"), new ResourceLocation("newstoneaxe"), new ItemStack(RegItems.newstoneaxe),new Object[]{
			" B ",
			" Y ",
			" H ",
			'H', Items.STICK,
			'Y', RegItems.rope,
			'B', RegItems.bladestoneaxe,
			});
		GameRegistry.addShapedRecipe(new ResourceLocation("stonechisel"), new ResourceLocation("stonechisel"), new ItemStack(RegItems.stonechisel),new Object[]{
			" B ",
			" Y ",
			" H ",
			'H', Items.STICK,
			'Y', RegItems.rope,
			'B', RegItems.stonebladechisel,
			});
		GameRegistry.addShapedRecipe(new ResourceLocation("kaolindust"), new ResourceLocation("kaolindust"), new ItemStack(RegItems.kaolindust),new Object[]{
			" B ",
			" Y ",
			" H ",
			'H', RegItems.annealedclayplate,
			'Y', RegItems.kaolin,
			'B', RegItems.pistil,
			});
		GameRegistry.addShapelessRecipe(new ResourceLocation("wetvineitem"), new ResourceLocation("wetvineitem"), new ItemStack(RegItems.wetvineitem), new Ingredient[] {Ingredient.fromItem(RegItems.pointedstone),
			Ingredient.fromItem(Item.getItemFromBlock(Blocks.VINE))});
		GameRegistry.addShapelessRecipe(new ResourceLocation("pistil"), new ResourceLocation("pistil"), new ItemStack(RegItems.pistil), new Ingredient[] {Ingredient.fromItem(RegItems.stonechisel),
			Ingredient.fromItem(RegItems.stonehand)});
		
		GameRegistry.addShapelessRecipe(new ResourceLocation("bladestoneaxe"), new ResourceLocation("bladestoneaxe"), new ItemStack(RegItems.bladestoneaxe), new Ingredient[] {Ingredient.fromItem(RegItems.pointedstone),
			Ingredient.fromItem(RegItems.stonehand), Ingredient.fromItem(RegItems.dirtformaxe)});
		GameRegistry.addShapelessRecipe(new ResourceLocation("bladestoneaxe"), new ResourceLocation("stonebladechisel"), new ItemStack(RegItems.stonebladechisel), new Ingredient[] {Ingredient.fromItem(RegItems.pointedstone),
			Ingredient.fromItem(RegItems.stonehand), Ingredient.fromItem(RegItems.dirtformchisel)});
		GameRegistry.addShapelessRecipe(new ResourceLocation("bladestoneshovel"), new ResourceLocation("bladestoneshovel"), new ItemStack(RegItems.bladestoneshovel), new Ingredient[] {Ingredient.fromItem(RegItems.pointedstone),
			Ingredient.fromItem(RegItems.stonehand), Ingredient.fromItem(RegItems.dirtformshovel)});
		GameRegistry.addShapelessRecipe(new ResourceLocation("spokes"), new ResourceLocation("spokes"), new ItemStack(RegItems.spokes), new Ingredient[] {Ingredient.fromItem(RegItems.spoke),
			Ingredient.fromItem(RegItems.spoke)});
		GameRegistry.addShapelessRecipe(new ResourceLocation("spokes"), new ResourceLocation("spokes"), new ItemStack(RegItems.pumpkinnugget,8), new Ingredient[] {Ingredient.fromItem(Item.getItemFromBlock(Blocks.PUMPKIN)),Ingredient.fromItem(Item.getItemFromBlock(Blocks.PUMPKIN))});
		//FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(Items.REDSTONE, 1), new ItemStack(Items.STICK, 1), 0.2f);

	}
}

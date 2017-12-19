package com.lg.realism.proxy;

import com.lg.realism.Realism;
import com.lg.realism.RegBlocks;
import com.lg.realism.RegItems;
import com.lg.realism.Sounds.SoundsRegister;
import com.lg.realism.event.EventToolMode;
import com.lg.realism.event.RenderTextEvent;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	public static String KEY_CATEGORY = "key.categories." + Realism.MODID;
	public static EventToolMode.EnumToolMode currentToolMode = EventToolMode.EnumToolMode.FULL;
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		RegItems.preRegisterRender();
		
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		
		RegBlocks.registerRender();
		RegItems.registerRender();
		SoundsRegister.register();
		 ClientRegistry.registerKeyBinding(RenderTextEvent.pressKeyOne); 
		 ClientRegistry.registerKeyBinding(RenderTextEvent.pressKeyTwo); 
		 ClientRegistry.registerKeyBinding(RenderTextEvent.pressKeyCharge); 
		 ClientRegistry.registerKeyBinding(RenderTextEvent.pressKeyChargeM); 
		 
			ClientRegistry.registerKeyBinding(EventToolMode.KEY_TOOL_MODE);
			
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
		
		final BlockColors block = FMLClientHandler.instance().getClient().getBlockColors();         
		block.registerBlockColorHandler(new IBlockColor() { 
			
			@Override
			public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex)
			{return worldIn != null && pos != null ? (tintIndex == 1 ? BiomeColorHelper.getGrassColorAtPos(worldIn, pos) : 0xFFFFFFFF) : ColorizerGrass.getGrassColor(0.5D, 1.0D);}                
		}, RegBlocks.smallleaves,RegBlocks.smallleavesspruce,RegBlocks.smallleavesbirch,RegBlocks.mossblock,RegBlocks.smallleavesappletree,RegBlocks.leavesappletree);

		ItemColors color = FMLClientHandler.instance().getClient().getItemColors();
		color.registerItemColorHandler(new IItemColor() {
			

			@Override
			public int colorMultiplier(ItemStack stack, int tintIndex) {
				return block.colorMultiplier( RegBlocks.smallleaves.getStateFromMeta(0), (IBlockAccess)null, (BlockPos)null, tintIndex);}
			},
				RegBlocks.smallleaves,RegBlocks.smallleavesspruce,RegBlocks.mossblock,RegBlocks.smallleavesbirch,RegBlocks.smallleavesappletree,RegBlocks.leavesappletree);
		
	}


}
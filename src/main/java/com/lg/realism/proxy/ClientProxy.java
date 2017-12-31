package com.lg.realism.proxy;

import com.lg.realism.Realism;
import com.lg.realism.RegBlocks;
import com.lg.realism.RegItems;
import com.lg.realism.Sounds.SoundsRegister;
import com.lg.realism.event.*;
import com.lg.realism.event.registration.RegEvents;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public final class ClientProxy extends CommonProxy
{
	public static String KEY_CATEGORY = "key.categories." + Realism.MODID;
	public static EventToolMode.EnumToolMode currentToolMode = EventToolMode.EnumToolMode.FULL;

	@Override
	public void preInit(FMLPreInitializationEvent e)
	{
		super.preInit(e);
		RegItems.preRegisterRender();
		new RegEvents.Client();
	}

	@Override
	public void init(FMLInitializationEvent e)
	{
		super.init(e);
		
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
	public void postInit(FMLPostInitializationEvent e)
	{
		super.postInit(e);
		
		final BlockColors block = FMLClientHandler.instance().getClient().getBlockColors();         
		block.registerBlockColorHandler((state, worldIn, pos, tintIndex) -> worldIn != null && pos != null ? (tintIndex == 1 ? BiomeColorHelper.getGrassColorAtPos(worldIn, pos) : 0xFFFFFFFF) : ColorizerGrass.getGrassColor(0.5D, 1.0D), RegBlocks.smallleaves, RegBlocks.smallleavesspruce, RegBlocks.smallleavesbirch, RegBlocks.mossblock, RegBlocks.smallleavesappletree, RegBlocks.leavesappletree);

		final ItemColors color = FMLClientHandler.instance().getClient().getItemColors();
		color.registerItemColorHandler((stack, tintIndex) -> block.colorMultiplier( RegBlocks.smallleaves.getStateFromMeta(0), null, null, tintIndex), RegBlocks.smallleaves, RegBlocks.smallleavesspruce, RegBlocks.mossblock, RegBlocks.smallleavesbirch, RegBlocks.smallleavesappletree, RegBlocks.leavesappletree);
	}
}
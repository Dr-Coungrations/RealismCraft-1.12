package com.lg.realism.API.WorldAPI;

import com.lg.realism.Realism.TimeTicker;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class SeasonHandler implements ISeasonHandler
{
    private World world = Minecraft.getMinecraft().world;
	private TimeTicker wsd = TimeTicker.get(world);

	public int autunm = 3, summer = 2, winter = 0, spring = 1;

	@Override
	public void setSpring(int value)
    {
		if (wsd.season == 1)
		{
			value = wsd.season;	
		}
	}

	public void yellowingLeaves(IBlockState state, IBlockAccess world, BlockColors blockcolor, BlockPos pos, IBlockColor ibc) {

	}
	
	@Override
	public int getSpring() {
		return spring;
	}

	@Override
	public void setAutunm(int value) {
		if(wsd.season == 3) {
			
			value = wsd.season;	
		}
	}

	@Override
	public int getAutunm() {
		return autunm;
	}

	@Override
	public void setSummer(int value) {
		if(wsd.season == 2) {
			value = wsd.season;	
		}
	}

	@Override
	public int getSummer() {
		return summer;
	}

	@Override
	public void setWinter(int value) {
		if(wsd.season == 0) {
			value = wsd.season;	
		}
	}

	@Override
	public int getWinter() {
		return winter;
	}


}
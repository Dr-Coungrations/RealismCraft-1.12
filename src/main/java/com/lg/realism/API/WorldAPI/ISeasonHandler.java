package com.lg.realism.API.WorldAPI;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public interface ISeasonHandler {
	public void setSpring(int value);
	public int getSpring();
	
	public void setAutunm(int value);
	public int getAutunm();
	
	public void setSummer(int value);
	public int getSummer();
	
	public void setWinter(int value);
	public int getWinter();

}

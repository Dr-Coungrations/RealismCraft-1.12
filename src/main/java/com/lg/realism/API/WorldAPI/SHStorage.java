package com.lg.realism.API.WorldAPI;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class SHStorage implements IStorage<ISeasonHandler> {

	@Override
	public NBTBase writeNBT(Capability<ISeasonHandler> capability, ISeasonHandler sh, EnumFacing side) {
		NBTTagCompound properties = new NBTTagCompound();
		properties.setInteger("autunm", sh.getAutunm());
		properties.setInteger("winter", sh.getWinter());
		properties.setInteger("spring", sh.getSpring());
		properties.setInteger("summer", sh.getSummer());
		return properties;
	}
	
	@Override
	public void readNBT(Capability<ISeasonHandler> capability, ISeasonHandler sh, EnumFacing side, NBTBase nbt) {	
		NBTTagCompound properties = (NBTTagCompound)nbt;
		sh.setAutunm(properties.getInteger("autunm"));
		sh.setWinter(properties.getInteger("winter"));
		sh.setSpring(properties.getInteger("spring"));
		sh.setSummer(properties.getInteger("summer"));
	}
	
}

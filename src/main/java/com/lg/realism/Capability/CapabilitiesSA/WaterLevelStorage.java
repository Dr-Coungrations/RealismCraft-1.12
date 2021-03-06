package com.lg.realism.Capability.CapabilitiesSA;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
/*
 * The basis of this code comes from modifications Bionisation 2
 * Thanks Thunder for the help
 */
public class WaterLevelStorage implements IStorage<IBarLevel> {

	@Override
	public NBTBase writeNBT(Capability<IBarLevel> capability, IBarLevel instance, EnumFacing side) {
		NBTTagCompound properties = new NBTTagCompound();
		properties.setInteger("waterlevel", instance.getWaterLevel());
		properties.setFloat("tempBody", instance.getTempBody());
		properties.setBoolean("cold", instance.getCommonCold());
		properties.setBoolean("grippe", instance.getCommonCold());
		return properties;
	}
	
	@Override
	public void readNBT(Capability<IBarLevel> capability, IBarLevel instance, EnumFacing side, NBTBase nbt) {	
		NBTTagCompound properties = (NBTTagCompound)nbt;
		instance.setWaterLevel(properties.getInteger("waterlevel"));
		instance.setTempBody(properties.getFloat("tempBody"));
		instance.setCommonCold(properties.getBoolean("cold"));
		instance.setCommonCold(properties.getBoolean("grippe"));
	}
	
}

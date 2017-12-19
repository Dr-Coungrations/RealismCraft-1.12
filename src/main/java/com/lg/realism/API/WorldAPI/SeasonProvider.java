package com.lg.realism.API.WorldAPI;

import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class SeasonProvider implements ICapabilitySerializable<NBTBase> {
	
	@CapabilityInject(ISeasonHandler.class)
	public static final Capability<ISeasonHandler> LEVEL_CAP = null;
	
	private ISeasonHandler instance = LEVEL_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {	
		
		 return capability == LEVEL_CAP;		 
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		
		 return capability == LEVEL_CAP ? LEVEL_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		
		 return LEVEL_CAP.getStorage().writeNBT(LEVEL_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
	
		LEVEL_CAP.getStorage().readNBT(LEVEL_CAP, this.instance, null, nbt);
	}

}
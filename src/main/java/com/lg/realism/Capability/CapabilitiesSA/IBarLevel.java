package com.lg.realism.Capability.CapabilitiesSA;

import java.util.List;
/*
 * The basis of this code comes from modifications Bionisation 2
 * Thanks Thunder for the help
 */
public interface IBarLevel {
	//Water Bar
	public void addWaterLevel(int level);
	public void reduceWaterLevel(int level);
	public int getWaterLevel();
	public void setWaterLevel(int level);
	
	public void addTempBody(float temp);
	public void reduceTempBody(float temp);
	public float getTempBody();
	public void setTempBody(float temp);
	
	public boolean getCommonCold();
	public void setCommonCold(boolean cold);
	
	public boolean getGrippe();
	public void setGrippe(boolean grippe);
	
	public void setTicker(int value);
	public int getTicker();
	public void incrementTicker();
	public void copyCapabilities(IBarLevel indicator);

}

	
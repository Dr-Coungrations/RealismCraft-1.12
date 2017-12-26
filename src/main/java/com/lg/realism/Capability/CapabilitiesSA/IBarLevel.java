package com.lg.realism.Capability.CapabilitiesSA;

/**
 * The basis of this code comes from modifications Bionisation 2
 * Thanks Thunder for the help
 */
public interface IBarLevel
{
	//Water Bar
    void addWaterLevel(int level);
	void reduceWaterLevel(int level);
	int getWaterLevel();
	void setWaterLevel(int level);
	
	void addTempBody(float temp);
	void reduceTempBody(float temp);
	float getTempBody();
	void setTempBody(float temp);
	
	boolean getCommonCold();
	void setCommonCold(boolean cold);
	
	boolean getGrippe();
	void setGrippe(boolean grippe);
	
	void setTicker(int value);
	int getTicker();
	void incrementTicker();
	void copyCapabilities(IBarLevel indicator);
}
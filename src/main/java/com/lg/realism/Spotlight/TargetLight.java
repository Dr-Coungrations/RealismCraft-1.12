package com.lg.realism.Spotlight;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class TargetLight {
	float[] ambient = {0.2F,0.2F,0.2F,1.0F};
	float[] diffuse = {1.0F,1.0F,1.0F,1.0F};
	float[] specular = {0.0F,0.0F,0.0F,1.0F};
	float[] direction = {0, 0, -1, 0};
	int lastLightId = 0;
	public void setAmbient(float r, float g, float b,float a){
		ambient[0] = r;
		ambient[1] = g;
		ambient[2] = b;
		ambient[3] = a;
	}
	public void setDiffuse(float r, float g, float b,float a){
		diffuse[0] = r;
		diffuse[1] = g;
		diffuse[2] = b;
		diffuse[3] = a;
	}
	public void setSpecular(float r, float g, float b,float a){
		specular[0] = r;
		specular[1] = g;
		specular[2] = b;
		specular[3] = a;
	}
	public void setDirection(float x, float y,float z){
		direction[0] = x;
		direction[1] = y;
		direction[2] = z;
	}
	public void enable(GL11 gl, int lightId){
		gl.glEnable(lightId);
		lastLightId = lightId;
	}
	public void disable(GL11 gl, int lightId){
		gl.glDisable(lightId);
		lastLightId = lightId;
	}
}

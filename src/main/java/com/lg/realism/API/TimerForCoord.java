package com.lg.realism.API;

/**
 * API.
 * A small class designed for tying the timer code to the global coordinates of a particular block. Examples of using it in growing trees.
 * ��������� �����, ��������������� ��� ������������ ������� ���� � ������� ����������� ����������� �����. ������� ������������� �������� � �������� ��������.
 * @author LegendGemer
 */
public class TimerForCoord
{
	public int x, y, z, time;

	public TimerForCoord(int x, int y, int z, int time)
	{
		this.x = x;
		this.y= y;
		this.z = z;
		this.time = time;
	}
}
package main.components;
import lejos.hardware.port.*;
import lejos.hardware.sensor.*;

/* 
 * Class that extends the EV3UltrasonicSensor
 * class with readable void and return methods
 */
public class USensor extends EV3UltrasonicSensor
{

	private float[] sample;
	private double maxDist;
	
	public USensor(Port port, double dist) 
	{
		super(port);
		this.sample = new float[this.sampleSize()];
		this.maxDist = dist;
	}
	
	public boolean enemy()
	{
		this.fetchSample(sample, 0);
		return sample[0] < maxDist;
	}
}

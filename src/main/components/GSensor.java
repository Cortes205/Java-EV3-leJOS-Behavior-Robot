package main.components;
import lejos.hardware.port.*;
import lejos.hardware.sensor.*;

public class GSensor extends EV3GyroSensor 
{

	private float[] sample;
	
	public GSensor(Port port) 
	{
		super(port);
		this.sample = new float[this.sampleSize()];
	}
	
	public boolean veeringLeft()
	{
		this.getAngleMode().fetchSample(sample, 0);
		return sample[0] < -5;
	}
	
	public boolean veeringRight()
	{
		this.getAngleMode().fetchSample(sample, 0);
		return sample[0] > 5;
	}

}

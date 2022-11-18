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
	
	/* This allows the robot to detect itself in a 10 degree lane. if it is veering left
	* it will return true on an angle less than -5, and if it veering right it will
	* return true on an angle greater than 5. tbh idek if this works but it seems
	* that the robot reacts in some way */
	public boolean veeringLeft() 
	{
		this.getAngleMode().fetchSample(sample, 0);
		return sample[0] > 5;
	}
	
	public boolean veeringRight()
	{
		this.getAngleMode().fetchSample(sample, 0);
		return sample[0] < -5;
	}

}

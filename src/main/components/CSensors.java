package main.components;
import lejos.hardware.port.*;
import lejos.hardware.sensor.*;

/* 
 * Class that combines both left & right colour 
 * sensors with custom return methods to make 
 * the main class more readable.
 */
public class CSensors
{

	private EV3ColorSensor left;
	private EV3ColorSensor right;
	private float[] leftSample;
	private float[] rightSample;
	
	public CSensors(Port l, Port r) 
	{
		this.left = new EV3ColorSensor(l);
		this.right = new EV3ColorSensor(r);
		this.leftSample = new float[left.sampleSize()];
		this.rightSample = new float[right.sampleSize()];
	}
		
	public boolean checkLeft() // Returns true if the robot is seeing a non-black colour
	{
		left.getRedMode().fetchSample(leftSample, 0); // Detects reflected light off of a surface
		return leftSample[0] >= 0.1; // Black colours don't reflect light (or reflect very little) so the comparing value is very low.
	}
	
	public boolean checkRight() // Same as other method but for the other colour sensor
	{
		right.getRedMode().fetchSample(rightSample, 0);
		return rightSample[0] >= 0.1;
	}

}

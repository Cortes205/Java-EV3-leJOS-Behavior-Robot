package main;
import main.components.*;
import behaviour.*;
import lejos.hardware.*;
import lejos.hardware.port.*;
import lejos.robotics.subsumption.*;

public class Main 
{

	// Instantiate custom classes that use EV3 Classes inside
	public static Motors motors = new Motors(MotorPort.A, MotorPort.D, MotorPort.C);
	public static CSensors colour = new CSensors(SensorPort.S1, SensorPort.S4);
	public static USensor detect = new USensor(SensorPort.S2, 0.25);
	public static GSensor gyro = new GSensor(SensorPort.S3);
	public static Arbitrator behaviours;
	
	// Variables that hold values for speed & delays
	public static final int shovelSpeed = 50;
	public static final int backDelay = 500;
	public static final int backSpeed = 80;
	public static final int turnDelay = 515;
	public static final int turnSpeed = 50;
	public static final int waitSpeed = 75;
	public static final int offset = 80;
	public static final int detectedSpeed = 100;
	public static final int turnAfter = 3000;
	public static int ms = 0;
	public static boolean dontTurn = false;
	
	
	public static void main(String[] args) 
	{
		Button.LEDPattern(4);
		Sound.beepSequenceUp();
		Button.waitForAnyPress();
		gyro.reset();
		delay(5000);
		motors.set();
		Behavior b1 = new Drive();
		Behavior b2 = new AdjustRight();
		Behavior b3 = new AdjustLeft();
		Behavior b4 = new Charge();
		Behavior b5 = new Patrol();
		Behavior b6 = new VeerRight();
		Behavior b7 = new VeerLeft();
		behaviours = new Arbitrator(new Behavior[]{b1, b2, b3, b4, b5, b6, b7});
		behaviours.go();
	}
	
	public static void exit()
	{
		if (Button.ESCAPE.isDown())
		{
			behaviours.stop();
			System.exit(0);
		}
	}
	
	public static void delay(int ms)
	{
		try 
		{
			Thread.sleep(ms);
		} 
		catch (InterruptedException e) {}
	}

}

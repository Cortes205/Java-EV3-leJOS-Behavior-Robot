package behaviour;
import main.*;
import lejos.robotics.subsumption.*;

public class Charge extends Main implements Behavior
{
	private boolean suppressed = false;
	
	/* Runs if the robot sees another robot but if it notices a non-black colour it won't run. this is
	* crucial because we were competing in a black octagon outlined in white so we had to stay in the ring
	* no matter what */
	@Override
	public boolean takeControl() 
	{
		return detect.enemy() && !colour.checkLeft() && !colour.checkRight();
	}

	@Override
	public void action() 
	{
		suppressed = false;
		dontTurn = true;
		motors.forward(detectedSpeed);
		exit();
		gyro.reset();
		if (!suppressed)
		{
			Thread.yield();
		}
	}

	@Override
	public void suppress() 
	{
		suppressed = true;
	}

}

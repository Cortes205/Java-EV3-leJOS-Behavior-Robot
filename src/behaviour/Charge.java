package behaviour;
import main.*;
import lejos.robotics.subsumption.*;

public class Charge extends Main implements Behavior
{
	private boolean suppressed = false;
	
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

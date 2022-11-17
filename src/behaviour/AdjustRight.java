package behaviour;
import main.*;
import lejos.robotics.subsumption.*;

public class AdjustRight extends Main implements Behavior
{
	
	private boolean suppressed = false;

	@Override
	public boolean takeControl() 
	{
		return colour.checkLeft();
	}

	@Override
	public void action() 
	{
		suppressed = false;
		motors.back(backSpeed);
		delay(backDelay);
		motors.right(turnSpeed);
		delay(turnDelay);
		ms += backDelay + turnDelay;
		gyro.reset();
		exit();
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

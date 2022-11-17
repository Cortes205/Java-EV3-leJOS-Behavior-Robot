package behaviour;
import main.*;
import lejos.robotics.subsumption.*;

public class Patrol extends Main implements Behavior
{

	public boolean suppressed = false;
	
	@Override
	public boolean takeControl() 
	{
		return ms >= turnAfter;
	}

	@Override
	public void action() 
	{
		suppressed = false;
		if (!dontTurn)
		{
			motors.left(waitSpeed);
			delay(700);
			gyro.reset();
		}
		exit();
		ms = 0;
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

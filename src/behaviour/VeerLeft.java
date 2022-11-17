package behaviour;
import main.*;
import lejos.robotics.subsumption.*;

public class VeerLeft extends Main implements Behavior
{

	private boolean suppressed = false;
	
	@Override
	public boolean takeControl()
	{
		return gyro.veeringRight() && !detect.enemy() && !colour.checkLeft() && !colour.checkRight() && ms != turnAfter;
	}

	@Override
	public void action() 
	{
		suppressed = false;
		motors.offsetRight(waitSpeed, offset);
		delay(1);
		ms++;
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
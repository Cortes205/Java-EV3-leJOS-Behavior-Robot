package behaviour;
import main.*;
import lejos.robotics.subsumption.*;

public class VeerRight extends Main implements Behavior
{

	private boolean suppressed = false;
	
	// if the robot is veering left and no other behaviours need to run then one of the motors will be faster than the other one.
	
	@Override
	public boolean takeControl()
	{
		return gyro.veeringLeft() && !detect.enemy() && !colour.checkLeft() && !colour.checkRight() && ms != turnAfter;
	}

	@Override
	public void action() 
	{
		suppressed = false;
		motors.offsetLeft(waitSpeed, offset);
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

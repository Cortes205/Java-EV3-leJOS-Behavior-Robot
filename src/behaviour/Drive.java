package behaviour;
import main.*;
import lejos.hardware.*;
import lejos.robotics.subsumption.*;

public class Drive extends Main implements Behavior
{

	private boolean suppressed = false;
	
	@Override
	public boolean takeControl() // Always runs if no other behaviours are runnning
	{
		return true;
	}

	@Override
	public void action() 
	{
		suppressed = false;
		dontTurn = false;
		motors.forward(waitSpeed);
		delay(1);
		ms++;
		if (Button.ESCAPE.isDown() && !suppressed)
		{
			behaviours.stop();
			System.exit(0);
		}
			
	}

	@Override
	public void suppress() 
	{
		suppressed = true;
	}

}

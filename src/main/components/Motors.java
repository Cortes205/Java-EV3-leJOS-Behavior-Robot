package main.components;
import main.*;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;

/* 
 * Class that combines both left & right motors 
 * with custom methods to make calling methods
 * easier and more readable
 */
public class Motors extends Main
{

	private UnregulatedMotor left;
	private UnregulatedMotor right;
	private NXTRegulatedMotor shovel;
	
	public Motors(Port l, Port r, Port port)
	{
		this.left = new UnregulatedMotor(l);
		this.right = new UnregulatedMotor(r);
		this.shovel = new NXTRegulatedMotor(port);
	}
	
	private void setSpeed(int speed)
	{
		left.setPower(speed);
		right.setPower(speed);
	}
	
	public void set()
	{
		shovel.setSpeed(shovelSpeed);
		shovel.forward();
		delay(235);
	}
	
	public void forward(int speed)
	{
		setSpeed(speed);
		right.forward();
		left.forward();
	}
	
	public void back(int speed)
	{
		setSpeed(speed);
		right.backward();
		left.backward();
	}
	
	public void right(int speed)
	{
		setSpeed(speed);
		right.backward();
		left.forward();
	}
	
	public void left(int speed)
	{
		setSpeed(speed);
		right.forward();
		left.backward();
	}
	
	public void offsetRight(int speed, int offset)
	{
		right.setPower(offset);
		left.setPower(speed);
		right.forward();
		left.forward();
	}
	
	public void offsetLeft(int speed, int offset)
	{
		right.setPower(speed);
		left.setPower(offset);
		right.forward();
		left.forward();
	}
}

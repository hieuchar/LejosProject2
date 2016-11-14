

import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;

public class Drivetrain {
	public static NXTRegulatedMotor motorOne;
	public static NXTRegulatedMotor motorTwo;
	public Drivetrain()
	{
		motorOne = Motor.A;
		motorTwo = Motor.B;
	}
	public void Forward()
	{
		motorOne.forward();
		motorTwo.forward();
	}
	public void Turn()
	{
		motorOne.forward();
		motorTwo.backward();
	}
	public void Backward()
	{
		motorOne.backward();
		motorTwo.backward();
	}
	public void Stop()
	{
		motorOne.stop();
		motorTwo.stop();
	}
}

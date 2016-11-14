

import java.util.ArrayList;
import java.util.List;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class TouchSensorModule implements Runnable {
	private TouchSensor touchSensorOne;
	private TouchSensor touchSensorTwo;
	private List<CanContactedListener> listeners = new ArrayList<CanContactedListener>();

	public TouchSensorModule(Robot r)
	{
		touchSensorOne = new TouchSensor(SensorPort.S2);
		touchSensorTwo = new TouchSensor(SensorPort.S3);
		listeners.add(r);
	
	}
	@Override
	public void run()
	{
		while(!Robot.getStatus())
		{
			if(touchSensorOne.isPressed() || touchSensorTwo.isPressed())
			{
				for(CanContactedListener c : listeners)
				{
					c.CanContacted();
				}				
			}
			Thread.yield();
		}
	}
}

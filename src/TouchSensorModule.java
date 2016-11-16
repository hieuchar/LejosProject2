

import java.util.ArrayList;
import java.util.List;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class TouchSensorModule implements Runnable {
	private TouchSensor touchSensorOne;
	private TouchSensor touchSensorTwo;
	private List<CanContactedListener> listeners = new ArrayList<CanContactedListener>();

	public TouchSensorModule()
	{
		touchSensorOne = new TouchSensor(SensorPort.S2);
		touchSensorTwo = new TouchSensor(SensorPort.S3);
	}
	public void addListener(Robot r)
	{
		listeners.add(r);
	}
	@Override
	public void run()
	{
		boolean foundCan = false;
		while(!foundCan)
		{
			if(touchSensorOne.isPressed() || touchSensorTwo.isPressed())
			{
				for(CanContactedListener c : listeners)
				{
					c.CanContacted();
				}					
				foundCan = true;
			}					
		}
	}
	
}

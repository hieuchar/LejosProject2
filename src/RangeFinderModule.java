

import java.util.ArrayList;
import java.util.List;

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class RangeFinderModule implements Runnable{
	private List<CanFoundListener> listeners = new ArrayList<CanFoundListener>();
	private UltrasonicSensor ultrasonicSensor;
	public RangeFinderModule(Robot r)
	{
		ultrasonicSensor = new UltrasonicSensor(SensorPort.S1);
		listeners.add(r);
	}
	@Override
	public void run()
	{
		boolean canFound = false;
		while(!canFound)
		{
			if(ultrasonicSensor.getDistance() < 40)
			{
				for(CanFoundListener c : listeners)
				{
					c.Found();
				}				
				canFound = true;
			}
			
		}
	}


}

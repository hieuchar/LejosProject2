

import java.util.ArrayList;
import java.util.List;

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class IRSensorModule implements Runnable{
	private LightSensor IRSensor;
	private List<LineFoundListener> listeners = new ArrayList<LineFoundListener>();
	public IRSensorModule(Robot r)
	{
		IRSensor = new LightSensor(SensorPort.S4);
		listeners.add(r);
	}
	@Override
	public void run()
	{
		IRSensor.setFloodlight(LightSensor.RED);	
		IRSensor.setFloodlight(true);
		while(true)
		{
			if(IRSensor.getLightValue() < 38)
			{
				//throw event linefound
				for(LineFoundListener l : listeners)
				{
					l.LineFound();
				}				
			}
			Thread.yield();
		}
	}

}

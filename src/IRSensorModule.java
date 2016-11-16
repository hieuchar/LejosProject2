

import java.util.ArrayList;
import java.util.List;

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class IRSensorModule implements Runnable{
	private LightSensor IRSensor;
	private List<LineFoundListener> listeners = new ArrayList<LineFoundListener>();
	public IRSensorModule()
	{
		IRSensor = new LightSensor(SensorPort.S4);
		
	}
	@Override
	public void run()
	{
		IRSensor.setFloodlight(LightSensor.RED);	
		IRSensor.setFloodlight(true);
		while(!Robot.getStatus())
		{
			foundLine(IRSensor.readValue());			
		}
	}
	public boolean foundLine(int value)
	{
		if(value < 38){
			for(LineFoundListener l : listeners)
			{
				l.LineFound();
			}	
			return true;
		}
		else return false;
	}
	public void addListener(Robot r)
	{
		listeners.add(r);
	}

}

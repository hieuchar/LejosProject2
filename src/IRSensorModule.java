

import java.util.ArrayList;
import java.util.List;


public class IRSensorModule implements Runnable{
	private HardWareIRSensor IRSensor;
	private List<LineFoundListener> listeners = new ArrayList<LineFoundListener>();
	public IRSensorModule(HardWareIRSensor iRSensor)
	{
			this.IRSensor = iRSensor;
	}
	@Override
	public void run()
	{
		IRSensor.setFloodlight(5);	
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

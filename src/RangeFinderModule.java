

import java.util.ArrayList;
import java.util.List;


public class RangeFinderModule implements Runnable{
	private List<CanFoundListener> listeners = new ArrayList<CanFoundListener>();
	private HardWareRangeFinder ultrasonicSensor;
	public RangeFinderModule(HardWareRangeFinder hardware)
	{
			ultrasonicSensor = hardware;
	}
	public void AddListener(Robot r)
	{
		listeners.add(r);
	}
	@Override
	public void run()
	{
		boolean canFound = false;
		while(!canFound)
		{
			canFound = FoundCan(ultrasonicSensor.getDistance());
		}
	}
	public boolean FoundCan(int j)
	{
		if (j < 40)
		{
			for(CanFoundListener c : listeners)
			{
				c.Found();
			}
		}
		return j < 40;
	}


}

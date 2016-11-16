

public class CanManager {
	private RangeFinderModule rangeFinder;
	private TouchSensorModule touchSensors;
	Thread rfThread ;
	Thread tThread;
	public int distance = 255;
	public CanManager(Robot r) 
	{
		touchSensors = new TouchSensorModule();
		touchSensors.addListener(r);
		rangeFinder = new RangeFinderModule(r);
	}
	public void Start()
	{
		rfThread = new Thread(rangeFinder);
		tThread = new Thread(touchSensors);		
		rfThread.start();
		tThread.start();		
	}
	public void ReBoot()
	{
		rfThread = new Thread(rangeFinder);
		tThread = new Thread(touchSensors);	
		tThread.start();
		rfThread.start();
	}
}

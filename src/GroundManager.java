

public class GroundManager {
	
	public IRSensorModule irSensor;
	private Drivetrain dt;
	Thread irThread;
	public GroundManager(Robot r)
	{
				
		irSensor = new IRSensorModule(r);
		irThread = new Thread(irSensor);
		dt = new Drivetrain();
		irThread.start();
		irThread.setDaemon(true);		
		
	}
	public void Turn()
	{
		dt.Turn();
	}
	public void Forward()
	{
		dt.Forward();
	}
	public void Backward()
	{
		dt.Backward();
	}
	public void Stop()
	{
		dt.Stop();
	}
	public void RebootIR()
	{
		irThread.start();
	}
}

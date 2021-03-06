

public class GroundManager {
	
	public IRSensorModule irSensor;
	private Drivetrain dt;
	Thread irThread;
	public GroundManager(Robot r)
	{
		HardWareIRSensor hardware= 	new IRSensor();	
		irSensor = new IRSensorModule(hardware);
		irSensor.addListener(r);
		dt = new Drivetrain();
		irThread = new Thread(irSensor);
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
}

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class RangeFinderSensor implements HardWareRangeFinder{
	private UltrasonicSensor ultrasonicSensor;
	public RangeFinderSensor()
	{
		ultrasonicSensor = new UltrasonicSensor(SensorPort.S1);
	}
	@Override
	public int getDistance() {
		// TODO Auto-generated method stub
		return ultrasonicSensor.getDistance();
	}
	@Override
	public void setDistance(int distance) {
		// TODO Auto-generated method stub
		
	}

}

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class IRSensor implements HardWareIRSensor{
	private LightSensor IRSensor;
	public IRSensor()
	{
		IRSensor = new LightSensor(SensorPort.S4);
	}
	@Override
	public void setFloodlight(boolean power) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setFloodlight(int color) {
		// TODO Auto-generated method stub
		IRSensor.setFloodlight(LightSensor.RED);
	}
	@Override
	public int readValue() {
		// TODO Auto-generated method stub
		return IRSensor.readValue();
	}
	@Override
	public void setValue(int value) {
		// TODO Auto-generated method stub
		
	}
	
}

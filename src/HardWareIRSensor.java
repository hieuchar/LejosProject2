
public interface HardWareIRSensor {
	public void setFloodlight(boolean power);
	public void setFloodlight(int color);
	public int readValue();
	public void setValue(int value);
}

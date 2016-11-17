
public class VirtualIRSensor implements HardWareIRSensor {
	private int value;
	@Override
	public void setFloodlight(boolean power) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFloodlight(int color) {
		// TODO Auto-generated method stub

	}

	@Override
	public int readValue() {
		// TODO Auto-generated method stub
		return value;
	}
	public void setValue(int value){
		this.value = value;
	}
}

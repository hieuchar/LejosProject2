import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		IRSensorModule irMod = new IRSensorModule();
		assertTrue(irMod.foundLine(35));
		assertFalse(irMod.foundLine(40));
		assertTrue(irMod.foundLine(-12));
		assertFalse(irMod.foundLine(675157645));
		TouchSensorModule tsm = new TouchSensorModule();
		
		
	}

}

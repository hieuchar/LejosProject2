import static org.junit.Assert.*;
import org.junit.Test;

public class Tests {
	@Test
	public  void testIRSensor() {
		HardWareIRSensor tester = new VirtualIRSensor();
		tester.setValue(35);
		IRSensorModule irMod = new IRSensorModule(tester);
		assertTrue(irMod.foundLine(tester.readValue()));
		tester.setValue(40);
		assertFalse(irMod.foundLine(tester.readValue()));
		tester.setValue(-12);
		assertTrue(irMod.foundLine(tester.readValue()));
		tester.setValue(675157645);
		assertFalse(irMod.foundLine(tester.readValue()));
	}
	@Test
	public  void testRangeFinder()
	{
		HardWareRangeFinder tester = new VirtualRangeFinder();
		RangeFinderModule rfMod = new RangeFinderModule(tester);
		tester.setDistance(35);
		assertTrue(rfMod.FoundCan(tester.getDistance()));
		tester.setDistance(41);
		assertFalse(rfMod.FoundCan(tester.getDistance()));
		tester.setDistance(-12);
		assertTrue(rfMod.FoundCan(tester.getDistance()));
		tester.setDistance(675157645);
		assertFalse(rfMod.FoundCan(tester.getDistance()));
	}
	@Test
	public  void testClock()
	{
		Clock clock = new Clock();

		clock.Start();
		try { Thread.sleep(25000); }
		catch (InterruptedException e) { }
		clock.Stop();
		System.out.println(clock.GetTime());
		assertTrue(clock.GetTime() < 30);
		Clock clock2 = new Clock();
		clock2.Start();
		try { Thread.sleep(31000); }
		catch (InterruptedException e) { }
		clock2.Stop();
		System.out.println(clock2.GetTime());
		assertTrue(clock2.GetTime() > 30);
	}
}

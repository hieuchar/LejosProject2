import static org.junit.Assert.*;
import org.junit.Test;

public class Tests {
	@Test
	public static void testIRSensor() {
		IRSensorModule irMod = new IRSensorModule();
		assertTrue(irMod.foundLine(35));
		assertFalse(irMod.foundLine(40));
		assertTrue(irMod.foundLine(-12));
		assertFalse(irMod.foundLine(675157645));
	}
	@Test
	public static void testRangeFinder()
	{
		RangeFinderModule rfMod = new RangeFinderModule();
		assertTrue(rfMod.FoundCan(35));
		assertFalse(rfMod.FoundCan(41));
		assertTrue(rfMod.FoundCan(-12));
		assertFalse(rfMod.FoundCan(675157645));
	}
	@Test
	public static void testClock()
	{
	  Clock clock = new Clock();
	  
	  clock.Start();
	  try { Thread.sleep(2500); }
    catch (InterruptedException e) { }
	  clock.Stop();
	  assertTrue(clock.GetTime() < 30);
	  
	  clock.Start();
    try { Thread.sleep(3100); }
    catch (InterruptedException e) { }
    clock.Stop();
    assertTrue(clock.GetTime() > 30);
	}
}

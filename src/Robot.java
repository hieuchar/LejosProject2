
import lejos.nxt.Button;

public class Robot implements CanFoundListener, CanContactedListener, LineFoundListener {
	public static GroundManager gm;
	public static CanManager cm;
	public static UI ui;
	public static Clock clock;
	private static boolean done = false;
	private static int BEEP = 45;
	private static int BUZZ = 850;
	private static int CHIRP = 1300;	
	private static int cansCleared;	
	private boolean inContact = false;
	public static void main(String[]args)
	{		
		Button.waitForAnyPress();
		Robot r = new Robot();
		r.Start();
	}
	public Robot() 
	{
		gm = new GroundManager(this);
		cm = new CanManager(this);
		ui = new UI();
		clock = new Clock();
		cansCleared = 0;
	}
	public void Start() 
	{
		clock.Start();
		cm.Start();
		gm.Turn();		
		ui.playNoise(BUZZ);
		Wait();
	}
	public void Wait()
	{
		while(cansCleared < 3)
		{
			Thread.yield();
		}
		Evacuate();
		clock.Stop();
		ui.DisplayTime(clock.GetTime());
		Button.waitForAnyPress();
	}
	@Override
	public void LineFound()
	{
		if(cansCleared < 3)
		{
			gm.Stop();
			if(inContact)
			{
				cansCleared++;
				inContact = false;
			}
			
			Sleep(250);
			
			gm.Backward();
			ui.playNoise(CHIRP);
			
			Sleep(1500);
			
			gm.Turn();
			ui.playNoise(BUZZ);
		}
	}
	@Override
	public void CanContacted()
	{
		inContact = true;
		ui.playNoise(BEEP);
	}
	@Override
	public void Found()
	{
		gm.Forward();
		ui.playNoise(BUZZ);
	}
	public void Evacuate()
	{
		gm.Forward();
		ui.playNoise(BUZZ);
		Sleep(3000);
    done = true;
		ui.DisplayTime(clock.GetTime());
		gm.Stop();
		Button.waitForAnyPress();
		System.exit(0);
	}
	public boolean getStatus()
	{
		return done;
	}
	public void Sleep(int milliseconds)
	{
	  try { Thread.sleep(milliseconds); }
    catch(InterruptedException e) { }
	}
}

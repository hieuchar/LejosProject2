
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
	private boolean inContact = false;
	public static void main(String[]args) throws InterruptedException
	{		
		
		Button.waitForAnyPress();
//		clock = new Clock();
//		ui = new UI();
//		clock.Start();
//		Thread.sleep(2000);
//		clock.Stop();
//		ui.DisplayTime(clock.GetTime());
		Robot r = new Robot();		
		r.Start();
	}
	public Robot() 
	{
		cm = new CanManager(this);
		gm = new GroundManager(this);
		ui = new UI();
		clock = new Clock();
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
		int timer = 0;
		while(timer < 29)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			timer++;
		}
		Evacuate();
		clock.Stop();
		ui.DisplayTime(clock.GetTime());
		Button.waitForAnyPress();
	}
	@Override
	public void LineFound()
	{	
			gm.Stop();
			try{
				Thread.sleep(200);
			}
			catch(InterruptedException e)
			{
				
			}
			ui.playNoise(CHIRP);
			gm.Backward();			
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
			}
			ui.playNoise(BUZZ);
			gm.Turn();			
			try{
				Thread.sleep(1200);
				cm.ReBoot();
			}
			catch(InterruptedException e)
			{
				
			}						
			inContact = false;			
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
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gm.Forward();
		ui.playNoise(BUZZ);
	}
	public static void Evacuate()
	{
		done = true;
		gm.Forward();
		ui.playNoise(BUZZ);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
	
		}		
		gm.Stop();
		Button.waitForAnyPress();
		System.exit(0);
	}
	public static boolean getStatus()
	{
		return done;
	}

}

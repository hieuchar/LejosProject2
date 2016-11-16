

public class Clock {

	private long start;
	private long end;

	public  Clock()
	{
			
	}
	public void Start()
	{
		start = System.currentTimeMillis();
		
	}
	public void Stop()
	{
		end = System.currentTimeMillis();
		
	}
	public double GetTime()
	{
		return (end / 1000) - (start / 1000); 
	}

}

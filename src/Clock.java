

public class Clock {

	private double start;
	private double end;

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
		return (double)(end - start)/100;
	}

}

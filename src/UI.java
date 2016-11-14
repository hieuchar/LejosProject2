



public class UI {
	DisplayModule display;
	SpeakerModule speaker;
	public UI()
	{
		display = new DisplayModule();
		speaker = new SpeakerModule();
		Thread speakerThread = new Thread(speaker);
		speakerThread.start();
	}
	public void DisplayTime(double time)
	{
		display.DisplayTime(time);
	}
	public void playNoise(int frequency)
	{
		speaker.setFrequency(frequency);

	}
}



import lejos.nxt.Sound;

public class SpeakerModule implements Runnable{
	private int frequency = 45;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;;){
			Sound.playTone(frequency, 200, 100);
			try {
				Thread.sleep(350);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void setFrequency(int frequency)
	{
		this.frequency = frequency;
	}
}

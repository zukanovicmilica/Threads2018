/*
 * Created on May 10, 2018
 *
 */
package music;

public class Synchronizer {

	private boolean firstVoiceFlag;
	private boolean secondVoiceFlag;
	private boolean thirdVerse;
	private boolean fourthVerse;
	private boolean patti;
	private boolean bruce;
	private boolean choir;

	public Synchronizer(boolean firstVoiceFlag, boolean secondVoiceFlag, boolean thirdVerse) {
		super();
		this.firstVoiceFlag = firstVoiceFlag;
		this.secondVoiceFlag = secondVoiceFlag;
		this.thirdVerse = thirdVerse;
	}

	public synchronized void singFirstVoice(String lyrics, int delay) {
		while (!firstVoiceFlag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sing(lyrics, delay);
	}

	public synchronized void singSecondVoice(String lyrics, int delay) {
		while (!secondVoiceFlag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sing(lyrics, delay);
	}

	public synchronized void singThirdVerse(String lyrics, int delay) {
		while (!thirdVerse) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sing(lyrics, delay);
	}

	private void sing(String lyrics, int delay) {
		System.out.println(lyrics);
		try {
			wait(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (firstVoiceFlag) {
			firstVoiceFlag = !firstVoiceFlag;
			secondVoiceFlag = !secondVoiceFlag;
			notifyAll();
			return;
		}
		if (secondVoiceFlag) {
			secondVoiceFlag = !secondVoiceFlag;
			thirdVerse = !thirdVerse;
			notifyAll();
			return;
		}
		if (thirdVerse) {
			thirdVerse = !thirdVerse;
			firstVoiceFlag = !firstVoiceFlag;
			notifyAll();
			return;
		}
	}

}

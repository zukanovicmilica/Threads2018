/*
 * Created on May 10, 2018
 *
 */
package music;

import javax.swing.JTextArea;

public class Synchronizer {

	private boolean firstVoiceFlag;
	private boolean secondVoiceFlag;
	private boolean thirdVerse;
	private boolean patti;
	private boolean bruce;
	private boolean choir;
	private JTextArea textArea;

	public Synchronizer(boolean firstVoiceFlag, boolean secondVoiceFlag, boolean thirdVerse,boolean patti, boolean bruce, boolean choir, JTextArea textArea) {
		super();
		this.firstVoiceFlag = firstVoiceFlag;
		this.secondVoiceFlag = secondVoiceFlag;
		this.thirdVerse = thirdVerse;
		this.textArea=textArea;
		this.patti=patti;
		this.bruce=bruce;
		this.choir=choir;
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
		textArea.append(lyrics+'\n');
		try {
			wait(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (firstVoiceFlag) {
			if (bruce) {
				firstVoiceFlag = false;
				secondVoiceFlag = true;
				notifyAll();
				return;
			}
			if (!bruce && choir) {
				firstVoiceFlag = false;
				thirdVerse = true;
				notifyAll();
				return;
			}
		}
		if (thirdVerse) {
			if (patti) {
				thirdVerse = false;
				firstVoiceFlag = true;
				notifyAll();
				return;
			}
			if(!patti && bruce) {
				thirdVerse=false;
				secondVoiceFlag=true;
				notifyAll();
				return;
			}
		}
		if (secondVoiceFlag) {
			if (choir) {
				secondVoiceFlag = false;
				thirdVerse = true;
				notifyAll();
				return;
			}
			if (!choir && patti) {
				secondVoiceFlag = false;
				firstVoiceFlag = true;
				notifyAll();
				return;
			}
		}
	}

	public boolean isFirstVoiceFlag() {
		return firstVoiceFlag;
	}

	public void setFirstVoiceFlag(boolean firstVoiceFlag) {
		this.firstVoiceFlag = firstVoiceFlag;
	}

	public boolean isSecondVoiceFlag() {
		return secondVoiceFlag;
	}

	public void setSecondVoiceFlag(boolean secondVoiceFlag) {
		this.secondVoiceFlag = secondVoiceFlag;
	}

	public boolean isThirdVerse() {
		return thirdVerse;
	}

	public void setThirdVerse(boolean thirdVerse) {
		this.thirdVerse = thirdVerse;
	}

	public boolean isPatti() {
		return patti;
	}

	public void setPatti(boolean patti) {
		this.patti = patti;
	}

	public boolean isBruce() {
		return bruce;
	}

	public void setBruce(boolean bruce) {
		this.bruce = bruce;
	}

	public boolean isChoir() {
		return choir;
	}

	public void setChoir(boolean choir) {
		this.choir = choir;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	

}

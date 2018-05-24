/*
 * Created on May 9, 2018
 *
 */
package test;

import java.util.Scanner;

import javax.swing.JTextArea;

import music.Performance;
import music.Singer;
import music.Synchronizer;
import music.Voice;

public class Test {

	public static final Scanner IN = new Scanner(System.in);

	private Singer pattiSmith;
	private Singer bruceSpringsteen;
	private Singer choir;
	private Synchronizer synch;

	public void initializeSingingInThreads(JTextArea textArea) {
		String lyrics1 = "Because the night";
		String lyrics2 = "Belongs to lovers";
		String lyrics3 = "Because the night" + '\n' + "Belong to lust";

		boolean stopIt = false;
		synch = new Synchronizer(false, false, false, false, false, false, textArea);
		synch.setTextArea(textArea);
		
		Performance firstVoicePerformance = new Performance(lyrics1, 2000);
		Performance secondVoicePerformance = new Performance(lyrics2, 2000);
		Performance thirdVersePerformance = new Performance(lyrics3, 2000);

		pattiSmith = new Singer("Patti Smith", Voice.FIRST, firstVoicePerformance, stopIt, synch);
		bruceSpringsteen = new Singer("Bruce Springsteen", Voice.SECOND, secondVoicePerformance, stopIt, synch);
		choir = new Singer("Choir", Voice.THIRD, thirdVersePerformance, stopIt, synch);
	}

	public synchronized void startIt() {
		pattiSmith.start();
		bruceSpringsteen.start();
		choir.start();
	}

	public synchronized void stop() {
		pattiSmith.setStopIt(true);
		bruceSpringsteen.setStopIt(true);
		choir.setStopIt(true);
	}

	public void testSingInThreads() {

		pattiSmith.start();
		bruceSpringsteen.start();
		choir.start();

		IN.nextLine();
		pattiSmith.setStopIt(true);
		bruceSpringsteen.setStopIt(true);
		choir.setStopIt(true);
	}

	public void simpleDelay() {
		long l1 = System.currentTimeMillis();
		System.out.println("Wait 2sec...");
		while (System.currentTimeMillis() < (l1 + 2000)) {
		}
		System.out.println("Done.");
	}

	public synchronized void waitDelay() {
		System.out.println("Wait 2sec...");
		try {
			wait(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done.");
	}

	public synchronized void loopDelay() {
		System.out.println("Wait 5 times 2sec...");
		for (int i = 0; i < 4; i++) {
			try {
				wait(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i + 1);
		}
		System.out.println("Done.");
	}

	public synchronized void threadWaitDelay() {
		WaitThread w1 = new WaitThread("t1");
		WaitThread w2 = new WaitThread("t2");
		System.out.println("Two threads...");
		w1.start();
		try {
			wait(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w2.start();
	}

	public synchronized void startPatti() {
		synch.setPatti(true);
		synch.setFirstVoiceFlag(true);
		synch.setSecondVoiceFlag(false);
		synch.setChoir(false);
		pattiSmith.start();
	}
	
	public synchronized void stopPatti() {
		pattiSmith.setStopIt(true);
		synch.setPatti(false);
	}

	public synchronized void startBruce() {
		synch.setBruce(true);
		synch.setSecondVoiceFlag(true);
		synch.setFirstVoiceFlag(false);
		synch.setChoir(false);
		bruceSpringsteen.start();
	}
	
	public synchronized void stopBruce() {
		bruceSpringsteen.setStopIt(true);
		synch.setBruce(false);
	}

	public synchronized void startChoir() {
		synch.setChoir(true);
		synch.setThirdVerse(true);
		synch.setSecondVoiceFlag(false);
		synch.setFirstVoiceFlag(false);
		choir.start();
	}

	public synchronized void stopChoir() {
		choir.setStopIt(true);
		synch.setChoir(false);
	}

	public Test getT() {
		// TODO Auto-generated method stub
		return null;
	}

}

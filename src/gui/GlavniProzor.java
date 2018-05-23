package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import test.Test;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private Test t= new Test();
	public JTextArea textArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor frame = new GlavniProzor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GlavniProzor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(146, 11, 308, 325);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t.initializeSingingInThreads(textArea);
				t.startPatti();
				t.startBruce();
				t.startChoir();
			}
		});
		btnStart.setBounds(10, 13, 106, 23);
		contentPane.add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.stopPatti();
				t.stopBruce();
				t.stopChoir();
				textArea.setText("");
			}
		});
		btnStop.setBounds(10, 47, 106, 23);
		contentPane.add(btnStop);
		
		JButton btnStartPatti = new JButton("Start Patti");
		btnStartPatti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.initializeSingingInThreads(textArea);
				t.startPatti();
			}
		});
		btnStartPatti.setBounds(10, 113, 106, 23);
		contentPane.add(btnStartPatti);
		
		JButton btnStopPatti = new JButton("Stop Patti");
		btnStopPatti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.stopPatti();
				textArea.setText("");
			}
		});
		btnStopPatti.setBounds(10, 147, 106, 23);
		contentPane.add(btnStopPatti);
		
		JButton btnStartBruce = new JButton("Start Bruce");
		btnStartBruce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.initializeSingingInThreads(textArea);
				t.startBruce();
			}
		});
		btnStartBruce.setBounds(10, 195, 106, 23);
		contentPane.add(btnStartBruce);
		
		JButton btnStopBruce = new JButton("Stop Bruce");
		btnStopBruce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.stopBruce();
				textArea.setText("");
			}
		});
		btnStopBruce.setBounds(10, 229, 106, 23);
		contentPane.add(btnStopBruce);
		
		JButton btnStartChoir = new JButton("Start choir");
		btnStartChoir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.initializeSingingInThreads(textArea);
				t.startChoir();
			}
			
		});
		btnStartChoir.setBounds(10, 279, 106, 23);
		contentPane.add(btnStartChoir);
		
		JButton btnStopChoir = new JButton("Stop choir");
		btnStopChoir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.stopChoir();
				textArea.setText("");
			}
		});
		btnStopChoir.setBounds(10, 313, 106, 23);
		contentPane.add(btnStopChoir);
	}
}

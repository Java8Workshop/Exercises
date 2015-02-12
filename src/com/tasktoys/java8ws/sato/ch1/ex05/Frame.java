package com.tasktoys.java8ws.sato.ch1.ex05;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame extends JFrame {

	JButton button1;
	JButton button2;

	Frame() {
		button1 = new JButton("start1");
		button1.setSize(new Dimension(100, 40));
		button1.setLocation(50, 20);
		button1.addActionListener(event -> {
			(new Thread(r)).start();
		});
		add(button1);
		
		button2 = new JButton("start2");
		button2.setSize(new Dimension(100, 40));
		button2.setLocation(50, 100);
		button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					(new Thread(new PrintThread())).start();
        }});
		add(button2);
		
		this.setLayout(null);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
	}
	
	Runnable r = () -> {
		while(true) {
			System.out.println(Thread.currentThread());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};
}

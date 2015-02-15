package com.tasktoys.java8ws.hosoai.ch1.ex05;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingActionsWithLambda extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JLabel label;
	private void initializeComponents(){
		label = new JLabel("Please Button Push");
		button1 = new JButton("Button1");
		button1.addActionListener(e->label.setText("button1 pushed"));
		button2 = new JButton("Button2");
		button2.addActionListener(e->label.setText("button2 pushed"));
		button3 = new JButton("Button3");
		button3.addActionListener(e->label.setText("button3 pushed"));
		setLayout(new BorderLayout());
		getContentPane().add(label, BorderLayout.NORTH);
		getContentPane().add(button1, BorderLayout.WEST);
		getContentPane().add(button2, BorderLayout.CENTER);
		getContentPane().add(button3, BorderLayout.EAST);
	}
	
	public static void main(String[] args) {
		SwingActionsWithLambda mainFrame = new SwingActionsWithLambda();
		mainFrame.setSize(600,600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.initializeComponents();
		mainFrame.setVisible(true);
	}
}

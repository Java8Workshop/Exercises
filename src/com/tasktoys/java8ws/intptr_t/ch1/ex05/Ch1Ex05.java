package com.tasktoys.java8ws.intptr_t.ch1.ex05;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

class NoLambda extends JFrame {
	private static final long serialVersionUID = 3041983631624626815L;

	public NoLambda() {
		JButton button = new JButton("don't push me");
		button.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(NoLambda.this, "why pushed?");
				System.exit(0);
			}
		});
		this.add(button);
		this.setBounds(0, 0, 200, 100);
	}
};

class WithLambda extends JFrame {
	private static final long serialVersionUID = -6877818084825193652L;

	public WithLambda() {
		JButton button = new JButton("plz push me!!!");
		button.addActionListener( e -> {
			JOptionPane.showMessageDialog(this, "thx pushed."); // <- thisがそのままかける！
			System.exit(0);
		} );
		this.add(button);
		this.setBounds(200, 0, 200, 100);
	}
}

public class Ch1Ex05 {
	public static void main(String[] args) {
		JFrame[] frames = new JFrame[]{
			new NoLambda(),
			new WithLambda()
		};
		for(JFrame f : frames){
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
}

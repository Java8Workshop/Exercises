package com.tasktoys.java8ws.mrbearing.ch1.ex05;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class RamdaTest {
  
  
  
  public static void main(String[] args){
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JButton buttonWithoutRamda = new JButton("no ramda");
    buttonWithoutRamda.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("no ramda");
      }
    });
    
    JButton buttonWithRamda = new JButton("ramda");
    buttonWithRamda.addActionListener( (ActionEvent e) ->{
      System.out.println("ramda!!");
     } );
    
    
    frame.getContentPane().setLayout(new FlowLayout());
    frame.getContentPane().add(buttonWithoutRamda);
    frame.getContentPane().add(buttonWithRamda);
    frame.pack();
    frame.setVisible(true);
    
  }

}

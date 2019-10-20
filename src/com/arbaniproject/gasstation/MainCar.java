package com.arbaniproject.gasstation;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainCar {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                try {
					frame.add(new DrawCar());
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                }
        });
	}

}

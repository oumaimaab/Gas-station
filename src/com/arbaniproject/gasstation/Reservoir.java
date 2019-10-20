package com.arbaniproject.gasstation;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class Reservoir extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JProgressBar gasLevel ;
	public JProgressBar getGasLevel() {
		return gasLevel;
	}

	public Reservoir() {
		gasLevel = new JProgressBar(SwingConstants.VERTICAL, 0, 100);
		gasLevel.setStringPainted(true);
		gasLevel.setValue(100);
		this.add(gasLevel,BorderLayout.EAST);
	}

	public void descrease() 
    { 	
		int level = gasLevel.getValue();
		level-=10;
        gasLevel.setValue(level);
        
    } 
	public void fill() {
		 gasLevel.setValue(100);
	}
	
	
}

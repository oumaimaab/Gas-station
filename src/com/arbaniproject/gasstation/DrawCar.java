package com.arbaniproject.gasstation;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawCar extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 800;
	private Reservoir gasLevel = new Reservoir();
	GridBagConstraints c = new GridBagConstraints();
	List<Car> cars;

	public DrawCar() throws IOException {
		cars = new ArrayList<>();
		cars.add(new Car(100, 500,gasLevel));
		c.anchor = GridBagConstraints.PAGE_END;
		this.add(gasLevel,c);

		Timer timer = new Timer(20, new ActionListener() {
			public  void actionPerformed(ActionEvent e) {
				for (Car car : cars) {
					synchronized (car) {
						if (car.getX()==300) {
							gasLevel.descrease();
							try {
								car.wait(2000);
								
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
							if (gasLevel.getGasLevel().getValue()==10) {
								
									try {
										car.wait(1000);
									} catch (InterruptedException e1) {
										e1.printStackTrace();
									}
									gasLevel.fill();	
							}
						}
					}
					
					car.moveCar();
					repaint();
				}
			}
		});
		timer.start();
	}

	public Reservoir getGasLevel() {
		return gasLevel;
	}

	public void setGasLevel(Reservoir gasLevel) {
		this.gasLevel = gasLevel;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Car car : cars) {
			try {
				car.drawCar(g);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

}



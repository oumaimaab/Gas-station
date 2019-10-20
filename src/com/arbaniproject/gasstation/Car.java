package com.arbaniproject.gasstation;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Car extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int INCREMENT = 5;
	int x, y, WIDTH = 1000, HEIGHT = 800;;
	Image carImage, gasPump, background;
	Graphics offScreenGraphics, offScreenGraphics2;
	Reservoir gasLevel;
	public Car(int x, int y,Reservoir gasLevel) {
		this.x = x;
		this.y = y;	
		this.gasLevel = gasLevel;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void drawCar(Graphics g) throws IOException {

		carImage = ImageIO.read(new File("car" + 3 + ".png"));
		background = ImageIO.read(new File("background.jpg"));
		g.clearRect(0, 0, WIDTH + 1, HEIGHT + 1);
		g.drawImage(background, 0, 0, WIDTH, HEIGHT, this);
		g.drawImage(carImage, x, y, null);
		
		
	}

	public void moveCar() {
		if (x == WIDTH) {
			x = 0;
		} 
		else {
			x += INCREMENT;
		}
		synchronized (this) {
			if(gasLevel.getGasLevel().getValue()==100){
				notify();
				gasLevel.descrease();
				
			}
			
			notify();
		}
	}

}
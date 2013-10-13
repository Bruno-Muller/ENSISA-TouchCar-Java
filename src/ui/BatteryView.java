package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import touchcar.Controller;
import car.Car;
import car.can.CanMessage;
import car.opticalblock.OpticalBlock;

@SuppressWarnings("serial")
public class BatteryView extends JPanel {
	
	Car model;
	Controller controller;
	
	public BatteryView(Car model, Controller controller) {
		super.setPreferredSize(new Dimension(160, 80));
		this.model = model;
		this.controller = controller;
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics g = graphics.create();	
		
		if (this.model.getError(OpticalBlock.FRONT_LEFT, CanMessage.ERROR_BATTERY_VOLTAGE) ||
				this.model.getError(OpticalBlock.FRONT_RIGHT, CanMessage.ERROR_BATTERY_VOLTAGE) ||
				this.model.getError(OpticalBlock.REAR_LEFT, CanMessage.ERROR_BATTERY_VOLTAGE) ||
				this.model.getError(OpticalBlock.REAR_RIGHT, CanMessage.ERROR_BATTERY_VOLTAGE) )
			this.paintBattery(g, Color.RED);
		else
			this.paintBattery(g, Color.DARK_GRAY);
	}

	private void paintBattery(Graphics g, Color color) {
		g.setColor(color);
		g.drawRect(50, 30, 60, 30);
		g.drawRect(60, 25, 10, 5);
		g.drawRect(90, 25, 10, 5);
		g.drawLine(60, 45, 70, 45);
		g.drawLine(65, 40, 65, 50);
		g.drawLine(90, 45, 100, 45);
	}

}

package ui.button;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import car.Car;
import car.light.Light;
import car.opticalblock.OpticalBlock;

import touchcar.Controller;

@SuppressWarnings("serial")
public class LeftBlinkerButton extends BlinkerButton {
	
	private static int xPoints[] = {30, 70, 70, 120, 120, 70, 70};
	private static int yPoints[] = {40, 20, 30, 30, 50, 50, 60};
	
	public LeftBlinkerButton(Car model, Controller controller) {
		super(model, controller, xPoints, yPoints);
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics, this.model.getLight(OpticalBlock.FRONT_LEFT, Light.BLINKER).isOn() || this.model.getLight(OpticalBlock.REAR_LEFT, Light.BLINKER).isOn());
	}
	
	public void mousePressed(MouseEvent arg0) {
		super.mousePressed(arg0);
		super.controller.toggleLeftBlinker();
	}

}

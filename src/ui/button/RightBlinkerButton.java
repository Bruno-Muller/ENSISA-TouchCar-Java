package ui.button;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import touchcar.Controller;
import car.Car;
import car.light.Light;
import car.opticalblock.OpticalBlock;

@SuppressWarnings("serial")
public class RightBlinkerButton extends BlinkerButton {
	
	private static int xPoints[] = {40, 90, 90, 130, 90, 90, 40};
	private static int yPoints[] = {30, 30, 20, 40, 60, 50, 50};

	public RightBlinkerButton(Car model, Controller controller) {
		super(model, controller, xPoints, yPoints);
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics, this.model.getLight(OpticalBlock.FRONT_RIGHT, Light.BLINKER).isOn() || this.model.getLight(OpticalBlock.REAR_RIGHT, Light.BLINKER).isOn());
	}
	
	public void mousePressed(MouseEvent arg0) {
		super.mousePressed(arg0);
		super.controller.toggleRightBlinker();
	}

}

package ui.button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import touchcar.Controller;
import car.Car;
import car.light.Light;
import car.opticalblock.OpticalBlock;

@SuppressWarnings("serial")
public class StopLightButton extends TextButton {

	public StopLightButton(Car model, Controller controller) {
		super(model, controller, "StopLight", Color.RED);
	}
	
	public void mousePressed(MouseEvent arg0) {
		super.mousePressed(arg0);
		super.controller.toggleStopLight();
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics, super.model.getLight(OpticalBlock.REAR_LEFT, Light.STOP_LIGHT).isOn() || super.model.getLight(OpticalBlock.REAR_RIGHT, Light.STOP_LIGHT).isOn());
	}

}

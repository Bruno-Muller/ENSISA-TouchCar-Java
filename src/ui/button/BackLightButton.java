package ui.button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import touchcar.Controller;
import car.Car;
import car.light.Light;
import car.opticalblock.OpticalBlock;

@SuppressWarnings("serial")
public class BackLightButton extends TextButton {

	public BackLightButton(Car model, Controller controller) {
		super(model, controller, "BackLight", Color.ORANGE);
	}
	
	public void mousePressed(MouseEvent arg0) {
		super.mousePressed(arg0);
		super.controller.toggleBackLight();
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics, super.model.getLight(OpticalBlock.REAR_LEFT, Light.BACK_LIGHT).isOn() || super.model.getLight(OpticalBlock.REAR_RIGHT, Light.BACK_LIGHT).isOn());
	}

}

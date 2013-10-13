package ui.button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import touchcar.Controller;
import car.Car;
import car.light.Light;
import car.opticalblock.OpticalBlock;

@SuppressWarnings("serial")
public class WarningButton extends Button {
	
	
	private static int xPoints[] = {50, 80, 110};
	private static int yPoints[] = {60, 10, 60};
	
	public WarningButton(Car model, Controller controller) {
		super(model, controller);
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics g = graphics.create();
		if ((super.model.getLight(OpticalBlock.FRONT_LEFT, Light.BLINKER).isOn() || super.model.getLight(OpticalBlock.REAR_LEFT, Light.BLINKER).isOn()) && 
				(super.model.getLight(OpticalBlock.FRONT_RIGHT, Light.BLINKER).isOn() || super.model.getLight(OpticalBlock.REAR_RIGHT, Light.BLINKER).isOn()))
			this.paintWarning(g, Color.RED, Color.ORANGE);
		else
			this.paintWarning(g, null, Color.RED);

	}
	
	public void mousePressed(MouseEvent arg0) {
		super.mousePressed(arg0);
		this.controller.toggleWarning();
	}
		
	private void paintWarning(Graphics g, Color fill, Color border) {
		if (fill != null) {
			g.setColor(fill);
			g.fillPolygon(xPoints, yPoints, xPoints.length);
		}
		g.setColor(border);
		g.drawPolygon(xPoints, yPoints, xPoints.length);
		
		g.drawLine(80, 25, 80, 45);
		g.drawLine(80, 50, 80, 50);
	}

}

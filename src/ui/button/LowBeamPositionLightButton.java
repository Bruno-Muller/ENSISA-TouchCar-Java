package ui.button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import touchcar.Controller;
import car.Car;
import car.light.Light;
import car.opticalblock.OpticalBlock;

@SuppressWarnings("serial")
public class LowBeamPositionLightButton extends Button {
	
	public LowBeamPositionLightButton(Car model, Controller controller) {
		super(model, controller);
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics g = graphics.create();
		if (this.model.getLight(OpticalBlock.FRONT_LEFT, Light.POSITION_LIGHT).isOn() ||
				this.model.getLight(OpticalBlock.FRONT_RIGHT, Light.POSITION_LIGHT).isOn() ||
				this.model.getLight(OpticalBlock.REAR_LEFT, Light.POSITION_LIGHT).isOn() ||
				this.model.getLight(OpticalBlock.REAR_RIGHT, Light.POSITION_LIGHT).isOn())
			this.paintPositionLight(g, Color.GREEN, Color.GREEN);
		else
			this.paintPositionLight(g, null, Color.GREEN);
			
		if (this.model.getLight(OpticalBlock.FRONT_LEFT, Light.LOWBEAM).isOn() ||
				this.model.getLight(OpticalBlock.FRONT_RIGHT, Light.LOWBEAM).isOn())
			this.paintLowBeam(g, Color.GREEN, Color.GREEN);
		else
			this.paintLowBeam(g, null, Color.GREEN);

	}
	
	public void mousePressed(MouseEvent arg0) {
		super.mousePressed(arg0);
		super.controller.toggleLowBeamPositionLight();
	}
	
	private void paintLowBeam(Graphics g, Color fill, Color border) {
		if (fill != null) {
			g.setColor(fill);
			g.fillArc(105, 20, 10, 40, 90, 180);
			g.fillRect(110, 20, 20, 40);
			g.fillArc(110, 20, 40, 40, -90, 180);	
		}
		
		g.setColor(border);
		g.drawLine(70, 27, 100, 20);
		g.drawLine(70, 37, 97, 30);
		g.drawLine(70, 47, 95, 40);
		g.drawLine(70, 57, 97, 50);
		g.drawLine(70, 67, 100, 60);
		
		g.drawArc(105, 20, 10, 40, 90, 180);
		g.drawLine(110, 20, 130, 20);
		g.drawLine(110, 60, 130, 60);
		g.drawArc(110, 20, 40, 40, -90, 180);		
	}
	
	private void paintPositionLight(Graphics g, Color fill, Color border) {
		if (fill != null) {
			g.setColor(fill);
			g.fillOval(20, 25, 30, 30);
			g.fillRect(30, 20, 10, 6);
		}
		
		g.setColor(border);
		g.drawOval(20, 25, 30, 30);	
		int xPoints[] = {30, 30, 40, 40};
		int yPoints[] = {25, 20, 20, 25};
		g.drawPolyline(xPoints, yPoints, xPoints.length);
		
		g.drawLine(17, 22, 21, 26);
		g.drawLine(10, 40, 15, 40);
		g.drawLine(17, 58, 21, 54);
		g.drawLine(55, 40, 60, 40);
		g.drawLine(53, 58, 49, 54);	
		g.drawLine(35, 60, 35, 65);
		g.drawLine(53, 22, 49, 26);
	}

}

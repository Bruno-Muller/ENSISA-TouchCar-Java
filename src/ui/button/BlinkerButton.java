package ui.button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import car.Car;

import touchcar.Controller;

@SuppressWarnings("serial")
public abstract class BlinkerButton extends Button {
	
	private int xPoints[];
	private int yPoints[];

	public BlinkerButton(Car model, Controller controller, int[] xPoints, int[] yPoints) {
		super(model, controller);
		this.xPoints = xPoints;
		this.yPoints = yPoints;
	}
	
	public void paintComponent(Graphics graphics, boolean on) {
		super.paintComponent(graphics);
		Graphics g = graphics.create();
		if (on)
			this.paintBlinker(g, Color.GREEN, Color.GREEN);
		else
			this.paintBlinker(g, null, Color.GREEN);
	}
	
	public void mousePressed(MouseEvent arg0) {
		super.mousePressed(arg0);

	}
	
	private void paintBlinker(Graphics g, Color fill, Color border) {
		if (fill != null) {
			g.setColor(fill);
			g.fillPolygon(xPoints, yPoints, xPoints.length);
		}
		g.setColor(border);
		g.drawPolygon(xPoints, yPoints, xPoints.length);
	}

}

package ui.button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import car.Car;

import touchcar.Controller;

@SuppressWarnings("serial")
public abstract class TextButton extends Button {
	
	private String text;
	private Color activeColor;
		
	public TextButton(Car model, Controller controller, String text, Color activeColor) {
		super(model, controller);
		this.text = text;
		this.activeColor = activeColor;
	}
	
	public void paintComponent(Graphics graphics, boolean on) {
		super.paintComponent(graphics);
		Graphics g = graphics.create();
		if (on)
			this.paintText(g, this.activeColor);
		else
			this.paintText(g, Color.BLACK);
	}
	
	public void mousePressed(MouseEvent arg0) {
		super.mousePressed(arg0);
	}
		
	protected void paintText(Graphics g, Color color) {
		g.setColor(color);
		g.drawString(this.text, 80-g.getFontMetrics().stringWidth(this.text)/2, 50-g.getFontMetrics().getHeight()/2);
	}
}

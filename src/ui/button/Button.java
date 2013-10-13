package ui.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import car.Car;

import touchcar.Controller;

@SuppressWarnings("serial")
public abstract class Button extends JPanel implements MouseListener {
	
	private boolean isPressed;
	protected Car model;
	protected Controller controller;
	
	protected Button(Car model, Controller controller) {
		this.isPressed = false;
		this.model = model;
		this.controller = controller;
		super.setPreferredSize(new Dimension(160, 80));
		//super.setMinimumSize(new Dimension(160, 80));
		//super.setMaximumSize(new Dimension(160, 80));
		
		super.addMouseListener(this);
	}

	public void paintComponent(Graphics graphics) {
		Graphics g = graphics.create();
		if (this.isPressed)
			this.paintPressedButton(g);
		else
			this.paintReleasedButton(g);
	}
		
	final public void mouseClicked(MouseEvent arg0) {
	}
	
	final public void mouseEntered(MouseEvent arg0) {
	}
	
	final public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
		this.isPressed = true;
		this.repaint();
		
	}
	
	public void mouseReleased(MouseEvent arg0) {
		this.isPressed = false;
		this.repaint();
	}
	
	private void paintPressedButton(Graphics g) {
		this.paintButton(g, Color.GRAY, Color.DARK_GRAY);
	}
	
	private void paintReleasedButton(Graphics g) {
		this.paintButton(g, Color.DARK_GRAY, Color.GRAY);
	}
	
	private void paintButton(Graphics g, Color fill, Color border) {
		g.setColor(fill);
		g.fillRoundRect(0, 0, 159, 79, 5, 5);
		g.setColor(border);
		g.drawRoundRect(0, 0, 159, 79, 5, 5);
	}
	
	
	
}

package ui.button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import touchcar.Controller;
import car.Car;
import car.light.Light;
import car.opticalblock.OpticalBlock;

@SuppressWarnings("serial")
public class MainBeamButton extends Button {

	public MainBeamButton(Car model, Controller controller) {
		super(model, controller);
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics g = graphics.create();	
		if (this.model.getLight(OpticalBlock.FRONT_LEFT, Light.MAINBEAM).isOn() ||
				this.model.getLight(OpticalBlock.FRONT_RIGHT, Light.MAINBEAM).isOn())	
			this.paintMainBeam(g, Color.CYAN, Color.CYAN);
		else
			this.paintMainBeam(g, null, Color.CYAN);

	}
	
	public void mousePressed(MouseEvent arg0) {
		super.mousePressed(arg0);
		super.controller.toggleMainBeam();
	}
	
	public void mouseReleased(MouseEvent arg0) {
		super.mouseReleased(arg0);
		if (this.model.getLight(OpticalBlock.FRONT_LEFT, Light.LOWBEAM).isOff() &&
				this.model.getLight(OpticalBlock.FRONT_RIGHT, Light.LOWBEAM).isOff())
			super.controller.toggleMainBeam();
	}
	
	private void paintMainBeam(Graphics g, Color fill, Color border) {
		if (fill != null) {
			g.setColor(fill);
			g.fillArc(75, 20, 10, 40, 90, 180);
			g.fillRect(80, 20, 20, 40);
			g.fillArc(80, 20, 40, 40, -90, 180);	
		}
		
		g.setColor(border);
		g.drawLine(40, 20, 70, 20);
		g.drawLine(40, 30, 67, 30);
		g.drawLine(40, 40, 65, 40);
		g.drawLine(40, 50, 67, 50);
		g.drawLine(40, 60, 70, 60);
		
		g.drawArc(75, 20, 10, 40, 90, 180);
		g.drawLine(80, 20, 100, 20);
		g.drawLine(80, 60, 100, 60);
		g.drawArc(80, 20, 40, 40, -90, 180);		
	}

}

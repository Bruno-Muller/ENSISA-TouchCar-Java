package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WebcamView extends JPanel {
	
	private static String WEBCAM_NOT_AVAILABLE = "Webcam not implemented";

	public WebcamView() {
		super();
		super.setPreferredSize(new Dimension(800,600));
	}
	
	
	public void paintComponent(Graphics graphics) {
		Graphics g = graphics.create();
		
		g.setColor(Color.RED);
		g.drawRect(0, 0, 799, 599);
		
		g.drawLine(0, 0, 799, 599);
		g.drawLine(0, 599, 799, 0);
		
		g.drawString(WEBCAM_NOT_AVAILABLE, 400-g.getFontMetrics().stringWidth(WEBCAM_NOT_AVAILABLE)/2, 300);
	}
}

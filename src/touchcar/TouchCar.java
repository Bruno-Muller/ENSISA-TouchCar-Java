package touchcar;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.UnknownHostException;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import car.Car;

import ui.BatteryView;
import ui.CarView;
import ui.WebcamView;
import ui.button.*;

@SuppressWarnings("serial")
public class TouchCar extends JFrame {
	
	private Car model;
	private Controller controller;
	
	TouchCar() throws UnknownHostException, IOException {
		super("TouchCar");
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		super.setBackground(Color.BLACK);
		super.setForeground(Color.WHITE);
		
		this.model = new Car();
		this.controller = new Controller(this.model, this);
		
		JPanel north = new JPanel();
		north.add(new LeftBlinkerButton(this.model, this.controller));
		north.add(new MainBeamButton(this.model, this.controller));
		north.add(new LowBeamPositionLightButton(this.model, this.controller));
		north.add(new RightBlinkerButton(this.model, this.controller));
		super.getContentPane().add(north, java.awt.BorderLayout.NORTH);
		
		JPanel center = new JPanel();
		center.add(new WebcamView());
		super.getContentPane().add(center, java.awt.BorderLayout.CENTER);
		
		JPanel west = new JPanel();
		west.setLayout(new GridLayout(0,1));
		west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
		west.add(new WarningButton(this.model, this.controller));
		west.add(new StopLightButton(this.model, this.controller));
		west.add(new BackLightButton(this.model, this.controller));
		super.getContentPane().add(west, java.awt.BorderLayout.WEST);
		
		JPanel east = new JPanel();
		east.setLayout(new GridLayout(0,1));
		east.add(new BatteryView(this.model, this.controller));
		east.add(new CarView(this.model));
		super.getContentPane().add(east, java.awt.BorderLayout.EAST);
		
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		TouchCar self = new TouchCar();
		self.pack();
		self.setVisible(true);
	}

}

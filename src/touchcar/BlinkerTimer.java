package touchcar;

import java.util.Timer;
import car.Car;

public class BlinkerTimer {
	private Car model;
	private TouchCar view;
	private Timer timer;
	
	
	BlinkerTimer(Car model, TouchCar view) {
		this.model = model;
		this.view = view;
	}
	
	public void start() {
		if (this.timer != null)
			this.timer.cancel();
		this.timer = new Timer();
		this.timer.schedule(new BlinkerTask(model, view), 500, 500);

	}
		
	public void stop() {
		if (this.timer != null)
			this.timer.cancel();
		this.timer = null;
	}
	
}

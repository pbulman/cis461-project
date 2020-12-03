package finalproj;
import java.util.Random;

public class Passenger implements Runnable {

	Control c;
	
	public Passenger(Control cr) {
		c = cr;
	}
	
	public void run() {
		try {
			c.load();
			c.unload();
		}
		catch (InterruptedException e) {	
		}
	}
}

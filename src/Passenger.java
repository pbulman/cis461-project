package finalproj;

public class Passenger implements Runnable {

	Control c;
	
	public Passenger(Control cr) {
		c = cr;
	}
	
	public synchronized void run() {
		try {
			for(int i = 0; i < c.M; i++) {
				c.load();
				c.unload();
			}

		}
		catch (InterruptedException e) {	
		}
	}
}

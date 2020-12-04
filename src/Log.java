package finalproj;

public class Log implements Runnable {

	Control c;
	
	public Log(Control cr) {
		c = cr;
	}
	
	public synchronized void run() {
		try {
			for(int i = 0; i < c.M/c.N; i++) {
			c.clean();
			c.ride();
			}
		}
		catch (InterruptedException e) {}
	}	
}

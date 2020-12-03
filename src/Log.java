package finalproj;

public class Log implements Runnable {

	Control c;
	
	public Log(Control cr) {
		c = cr;
	}
	
	public void run() {
		try {
			c.clean();
			c.ride();
		}
		catch (InterruptedException e) {}
	}	
}

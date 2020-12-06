/*
 * CIS 461 Final Project
 * Fall 2020 Semester
 * Peter Bulman and Cole Wagner
 */

package finalproj;

public class Log implements Runnable {

	Control c;
	
	public Log(Control cr) {
		c = cr;
	}
	
	public void run() {
		try {
			// For each time the log is going to go around (based off how many seats and passengers there are)
			// Clean and start the ride
			for(int i = 0; i < c.M/c.N; i++) {
			c.clean();
			c.ride();
			}
			
		}
		catch (InterruptedException e) {}
	}	
}

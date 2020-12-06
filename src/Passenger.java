/*
 * CIS 461 Final Project
 * Fall 2020 Semester
 * Peter Bulman and Cole Wagner
 */

package finalproj;

public class Passenger implements Runnable {

	Control c;
	
	public Passenger(Control cr) {
		c = cr;
	}
	
	public void run() {
		try {
			// For each passenger, they will have to be loaded and unloaded
			for(int i = 0; i < c.M; i++) {
				c.load();
				c.unload();
			}
		}
		catch (InterruptedException e) {	
		}
	}
}

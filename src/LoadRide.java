/*
 * CIS 461 Final Project
 * Fall 2020 Semester
 * Peter Bulman and Cole Wagner
 */

package finalproj;

public class LoadRide {

    public static void main(String args[]) {
    	
    	// Instance of the monitor
    	Control c = new Control();
        
    	// Start a thread for the log
    	Thread log = new Thread(new Log(c), "log");
        log.start();
        
        // Start a thread for each passenger
        Thread[] passengers = new Thread[c.M];
        for (int i=0; i<c.M; i++) {
        	Thread passenger = new Thread(new Passenger(c));
        	passengers[i] = passenger;
        	passengers[i].start();
        }
    }
}

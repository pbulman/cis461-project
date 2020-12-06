/*
 * CIS 461 Final Project
 * Fall 2020 Semester
 * Peter Bulman and Cole Wagner
 */

package finalproj;

public class Control {
	
	// N is the total number of seats on the ride
	public int N = 5;
	
	// M is the total number of passengers waiting to ride
	public int M = 10;
	
	// Booleans to keep track of whether or not the ride has left the platform and if the ride has been cleaned
	boolean left = true;
	boolean clean = false;

	// Number of passengers currently on the ride
	private int numPassengers = 0;
	
	/*
	 * This control class serves as the monitor for the program. The following methods
	 * have the "synchronized" keyword because they have shared data and we can
	 * only have one thread executing at a time.
	 */
	
	
	synchronized void load() throws InterruptedException {
		// When the ride is clean, not full of passengers, and hasn't left the platform, load passengers
	    while (clean == false || numPassengers == N || left == true)  {
	    	wait();
	    }
	    ++numPassengers;
	    System.out.println("Passenger loaded: " + numPassengers);
	    notifyAll();
	}
	
	synchronized void unload() throws InterruptedException {
		// When the ride is not already empty, and hasn't left yet, unload passengers
	    while (numPassengers <= 0 || left == false)  {
	    	wait();
	    }
	    clean = false;
	    --numPassengers;
	    System.out.println("Passenger unloaded: " + numPassengers);
	    notifyAll();
	}
	
	synchronized void ride() throws InterruptedException {
		// When the log is full, start the ride
	    while (numPassengers != N)  {
	    	wait();
	    }
	    left = true;
	    System.out.println("Ride left");
	    notifyAll();

	}
	
	synchronized void clean() throws InterruptedException {
		// When the ride is not clean and when it is empty, clean the ride
	    while (clean == true || numPassengers != 0)  {
	    	wait();
	    }
	    clean = true;
	    left = false;
	    System.out.println("Cleaned");
	    notifyAll();
	}
}

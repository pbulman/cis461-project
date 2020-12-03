package finalproj;

public class Control {
	private int N = 5;
	private int M = 8;
	boolean left = true;
	private int numPassengers = 0;
	
	public Control() {
		
	}
	
	synchronized void load() throws InterruptedException {
	    while (numPassengers == N)  {
	    	wait();
	    }
	    ++numPassengers;	 
	    System.out.println("Passenger loaded: " + numPassengers);
	    notifyAll();
	}
	
	synchronized void unload() throws InterruptedException {
	    while (numPassengers == N || !left)  {
	    	wait();
	    }
	    --numPassengers;
	    System.out.println("Passenger unloaded: " + numPassengers);
	    notifyAll();
	}
	
	synchronized void ride() throws InterruptedException {
	    while (numPassengers != N || left)  {
	    	wait();
	    }
	    left = true;	    
	    System.out.println("Ride left");
	    notifyAll();

	}
	
	synchronized void clean() throws InterruptedException {
	    while (numPassengers == N || !left)  {
	    	wait();
	    }
	    numPassengers = 0;
	    left = false;	
	    System.out.println("Cleaned");
	    notifyAll();
	}
}

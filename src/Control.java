package finalproj;

public class Control {
	public int N = 5;
	public int M = 10;
	boolean left = true;
	boolean clean = false;

	private int numPassengers = 0;
	
	
	synchronized void load() throws InterruptedException {
	    while (clean == false || numPassengers == N || left == true)  {
	    	wait();
	    }
	    ++numPassengers;
	    System.out.println("Passenger loaded: " + numPassengers);
	    notifyAll();
	}
	
	synchronized void unload() throws InterruptedException {
	    while (numPassengers > N || left == false)  {
	    	wait();
	    }
	    clean = false;
	    --numPassengers;
	    System.out.println("Passenger unloaded: " + numPassengers);
	    notifyAll();
	}
	
	synchronized void ride() throws InterruptedException {
	    while (numPassengers != N)  {
	    	wait();
	    }
	    left = true;
	    System.out.println("Ride left");
	    notifyAll();

	}
	
	synchronized void clean() throws InterruptedException {
	    while (clean == true || numPassengers != 0)  {
	    	wait();
	    }
	    clean = true;
	    left = false;
	    System.out.println("Cleaned");
	    notifyAll();
	}
}

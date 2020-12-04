package finalproj;

public class LoadRide {

    public static void main(String args[]) {
    	
    	Control c = new Control();
        Thread log = new Thread(new Log(c), "log");
        log.start();
        
        Thread[] passengers = new Thread[c.M];
        for (int i=0; i<c.M; i++) {
        	Thread passenger = new Thread(new Passenger(c));
        	passengers[i] = passenger;
        	passengers[i].start();
        }
    }
}

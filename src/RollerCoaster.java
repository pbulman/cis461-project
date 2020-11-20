package hw5;

public class Museum {
	private boolean cond = true;

    public synchronized void load(int val) throws InterruptedException{
    	while(!cond) {
            wait();
        }

    	
        notifyAll();
    }

    public synchronized int unload() throws InterruptedException{
        while(cond) {
            wait();   
        }

        notifyAll();
    }
}

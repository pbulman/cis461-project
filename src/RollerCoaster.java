public class RollerCoaster {
    
    private boolean cond = true;

    public synchronized void load(int val) throws InterruptedException{
    	while(!cond) {
            wait();
        }
	
	//insert here
    	
        notifyAll();
    }

    public synchronized int unload() throws InterruptedException{
        while(cond) {
            wait();   
        }
	    
	 //insert here

        notifyAll();
    }
}

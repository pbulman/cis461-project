public class BufferImp <E> implements Buffer <E>{
	
	protected E[] buf;
	protected int in = 0;
	protected int out = 0;
	protected int count = 0;
	protected int size;
	
	protected int max = 5;
	protected int numPassengers = 0;
	protected boolean left = false;
	
	@SuppressWarnings("unchecked")
	public BufferImp(int size) {
		this.size = size;
		buf = (E[]) new Object[size];
	}
	
	public synchronized void load() 
            throws InterruptedException {
	    while (numPassengers == max)  {
	    	wait();
	    }
	    ++numPassengers;	    
	    notifyAll();
	}

	public synchronized void unload() 
            throws InterruptedException {
	    while (numPassengers < max)  {
	    	wait();
	    }
	    --numPassengers;	    
	    notifyAll();
	}
	
	public synchronized void ride() 
            throws InterruptedException {
	    while (numPassengers < max)  {
	    	wait();
	    }
	    left = true;	    
	}
	
	public synchronized void clean() 
            throws InterruptedException {
	    while (numPassengers < max || !left)  {
	    	wait();
	    }
	    numPassengers = 0;
	    left = false;	    
	    notifyAll();
	}
	
	
}



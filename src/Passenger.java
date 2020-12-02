import java.util.Random;

public class Passenger implements Runnable {
  Buffer <String> buf;
  Passenger(Buffer <String> b) {buf = b;}

  public void run() {
    try {
      while(true) {
    	  
    	Random r = new Random();
    	char randomChar = (char) (r.nextInt(90-65) + 65);

    	System.out.println("Producing: " + randomChar);
        buf.put(String.valueOf(randomChar)); 
        
      }
    } catch (InterruptedException e){}
  }
}

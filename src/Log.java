public class Log implements Runnable {

	Buffer <String> buf;
	
	Log(Buffer <String> b) {buf = b;}
	
	public void run() {
		try {
			while(true) {
				String s = buf.get();
				System.out.println("Consuming: " + s);
			}
		}catch (InterruptedException e){};
	}
}

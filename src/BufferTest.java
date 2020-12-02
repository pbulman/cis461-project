public class BufferTest {

    public static void main(String args[]) {
        
        Buffer<String> buffer = new BufferImp<String>(5);

        Thread passenger = new Thread(new Passenger(buffer), "passenger");
        Thread log = new Thread(new Log(buffer), "log");
        
        passenger.start();
        log.start();
    }
}

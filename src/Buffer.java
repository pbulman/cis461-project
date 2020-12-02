public interface Buffer<E> {
	//put object into buffer
	public void put(E o) throws InterruptedException;
	//get object from buffer
	public E get() throws InterruptedException;
}

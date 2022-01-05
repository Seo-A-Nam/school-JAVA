
public class SynchronizedCounter {

	private int c = 0;
	public synchronized void inc() {
		c = c + 1;
	}
	
	public synchronized void dec() {
		c = c - 1;
	}
	
	public synchronized int value() {
		return c;
	}
}



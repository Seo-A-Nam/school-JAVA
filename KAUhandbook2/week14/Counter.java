
public class Counter {
	private int c = 0;
	public void inc() {
		c = c + 1;
	}
	
	public void dec() {
		c = c - 1;
	}
	
	public int value() {
		return c;
	}
}

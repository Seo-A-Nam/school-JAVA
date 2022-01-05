//Multithreaded program example
//import java.lang.Thread;

class Printer implements Runnable
{
	private static final int MAX = 1000;
	private String tname;	// thread name
	private int sleepTime;	// milliseconds
	private int value;		// current sum
	private int delta;
	
	Printer( String name, int waiting, int increment )
	{
		tname = name;
		value = 0;
		sleepTime = waiting;
		delta = increment;
	}
	
	public void run()
	{
		System.out.printf("Thread %s starting.\n", tname);
		do {
			System.out.printf("Thread %s printing %d\n", tname, value);
			try {
				Thread.sleep(sleepTime);
			}
			catch( InterruptedException exception ) {
				System.out.printf("%s %s\n","Thread %s terminate abnormally.", tname);
			}
			value += delta;	//increase value if less than Max
			
			} while (value <= MAX);
		System.out.printf("Thread %s ending\n.", tname);
	}
}

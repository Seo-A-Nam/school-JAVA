
public class ThreadTest2
{
	static public void main(String args[])
	{
		//Create two threads
		int count = 1;
		System.out.println("--Thread main starting.");
		try {
			Thread thread1 = new Thread(new Printer("Printer1",50,100));
			thread1.start();
			Thread thread2 = new Thread(new Printer("Printer2", 70,300));
			thread2.start();
			do {
				System.out.printf("--Thread main printing %d\n", count);
				Thread.sleep(35);
				count++;	//increase value if less than Max
			} while (count <= 10);
		}
		
		catch( InterruptedException exception ) {
			System.out.printf("%s %s\n", "--Thread main terminate abnormally.");
		}
		
		System.out.println("--Thread main ending.\n");
	}
}


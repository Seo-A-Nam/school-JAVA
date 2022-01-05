//final instance variable in a class
public class Increment {
	private int total = 0; //total of all increments
	private final int INCREMENT; //���
	
	//constructor initializes final instance variable INCREMENT
	public Increment(int incrementValue)
	{
		INCREMENT = incrementValue;	//initialize constant variable (once)
	}
	
	//add increment to total
	public void addIncrementToTotal()
	{
		total += INCREMENT;
	}
}

//Time2 class declaration with overloaded constructors
public class Time2 
{
	private int hour;
	private int minute;
	private int second;
	
	//Time2 no-argument constructor: initializes each instance variable
	//to zero; ensures that Time2 objects start in a consistent state
	public Time2()
	{
		this(0,0,0);
	}
	public Time2(int h)
	{
		this(h,0,0);
	}
	public Time2(int h, int m)
	{
		this(h,m,0);
	}
	public Time2(int h, int m, int s)
	{
		setTime(h,m,s);	//invoke setTime to validate time
	}
	public Time2(Time2 time)
	{
		//invoke Time2 three-argument constructor
		this(time.getHour(),time.getMinute(),time.getScecond());
	}
}

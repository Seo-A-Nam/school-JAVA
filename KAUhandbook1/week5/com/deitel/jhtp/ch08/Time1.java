//Time1 class declaration maintains the time in 24-hour format.
package com.deitel.jhtp.ch08;	//helps make Time1 a unique class name; must be first statement in file
public class Time1 
{
	private int hour;
	private int minute;
	private int second;
	
	//set a new time value using universal time; 
	//ensure that the data remains consistent by setting invalid values to zero
	public void setTime(int h, int m, int s)
	{
		hour = (( h >=0 && h <24 )? h :0 );// validate hour
		minute =(( m >=0 && m <60 )? m :0 );
		second = (( s >=0 && s <60 )? s :0 );
	}
	
	//convert to String in universal-time format(HH:MM:SS)
	public String toUniversalString()
	{
		return String.format("%02d:%02d:%02d", hour, minute,second);
	}
}

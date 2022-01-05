//Static variable used to maintain a count of the number of Employee objects in memory
public class Employee 
{
	private String firstName;
	private String lastName;
	private static int count = 0; //number of Employees created
	
	//output String indicating that constructer was called
	public Employee( String first, String last )
	{
		firstName = first;
		lastName = last;
		
		++count;
		System.out.printf("Employee contructor: %s %s; count = %d\n",firstName, lastName, count);
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public static int getCount()	//static method to get static count value
	{
		return count;
	}
}

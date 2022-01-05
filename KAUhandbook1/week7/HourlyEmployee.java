//HourlyEmployee class extends Employee
public class HourlyEmployee extends Employee2
{
	private double wage;
	private double hours;
	
	public HourlyEmployee( String first, String last, String ssn,
			double hourlywage, double hoursworked );
	{
		super( first, last, ssn );
		setWage( hourlyWage );
		setHours( hoursWorked );
	}
	
	public void setWage( double hourlyWage )
	{
		wage = ( hourlyWage < 0.0 ) ? 0.0 : hourlyWage;
	}
	
	public void setHours( double hoursWorked )
	{
		hours = ( hours < 0.0 ) ? 0.0 : hoursWorked;
	}
	
	public double getWage()
	{
		return wage;
	}
	
	public double getHours()
	{
		return hours;
	}
	//calculate earnings: override abstract method earnings in Employee
	@Override
	public double earnings() 
	{
		if( getHours() <= 40 )
			return getWage() * getHours();
		else
			return 40 * getWage() + ( getHours() - 40 ) * getWage() * 1.5;
	}
	
	//return String representation of HourlyEmployee object
	@Override
	public String toString()
	{
		return String.format("hourly employee: %s\n%s: $%,.2f; %s: %,.2f",
				super.toString(),"hourly wage", getWage(),"hours worked", getHours());
	}
	
}

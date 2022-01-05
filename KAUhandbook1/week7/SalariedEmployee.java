//SalariedEmployee concrete class extends abstracgt class Employee
public class SalariedEmployee extends Employee2
{
	private double weeklySalary;
	
	public SalariedEmployee( String first, String last, String ssn, double salary)
	{
		super(first,last,ssn);		//pass to Employee2 constructor
		setWeeklySalary(salary);	//validate and store salary
	}
	
	public void setWeeklySalary( double salary )
	{
		weeklySalary = salary < 0.0 ? 0.0 : salary;
	}
	public double getWeeklySalary()
	{
		return weeklySalary;
	}
	
	//calculate earnings: override abstract method earnings in Employee
	@Override
	public double earnings()
	{
		return getWeeklySalary();
	}
	
	//return String representation of SalariedEmployee object
	@Override
	public String toString()
	{
		return String.format("salaried employee: %s\n%s: $%.2f", super.toString(),"weekly salary", getWeeklySalary());
	}
	
}

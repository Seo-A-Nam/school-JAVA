
public class SalariedEmployee2 extends Employee3{
	private double weeklySalary;
	
	public SalariedEmployee2( String first, String last, String ssn, double salary)
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
	public double getPaymentAmount()
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

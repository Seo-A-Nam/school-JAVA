// this class inherits from commission employee
// and accesses the superclass's private data via inherited public methods
public class BasePlusCommissionEmployee2 extends CommissionEmployee2 
{
	private double baseSalary; //base Salary per week
	//six-argument constructor
	public BasePlusCommissionEmployee(String first,String last, String ssn,
			double sales, double rate, double salary)
	{
		super(first, last, ssn, sales, rate);
		setBaseSalary( salary ); //validate and store base salary
	}
	
	public void setBaseSalary( double salary )
	{
		baseSalary = (salary < 0.0 ) ? 0.0 : salary;
	}
	
	public double getBaseSalary()
	{
		return baseSalary;
	}
	
	//calculate earnings
	@Override //indicates that this method overrides a superclass method
	public double earnings()
	{
		return getBaseSalary() + super.earnings();
	}
	
	//return String representation of BasePlusCommissionEmployee
	@Override
	public String toString()
	{
		return String.format("%s %s\n%s: %.2f","base-salaried",super.toString(),"base salary", getBaseSalary());
	}
	
	
}

//CommissionEmployee class uses methods to manipulate its private instance variables
public class CommissionEmployee 
{
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	private double grossSales;	//gross weekly sales
	private double commissionRate;	// commission percentage
	
	//five-argument constructor
	public CommissionEmployee( String first, String last, 
									String ssn, double sales, double rate )
	{
		//implicit call to Object constructor occurs here
		firstName = first;
		lastName = last;
		socialSecurityNumber = ssn;
		setGrossSales(sales);	//validate and store gross sales
		setCommissionRate(rate);	// validate and store commission rate
	}
	
	public void setSocialSecurityNumber(String ssn) 
	{
		socialSecurityNumber = ssn; //should validate
	}
	public String getSocialSecurityNumber() 
	{
		return socialSecurityNumber;
	}
	public void setGrossSales(double sales) 
	{
		grossSales = (sales < 0.0) ? 0.0 : sales;
	}
	public double getGrossSales() 
	{
		return grossSales;
	}
	public void setCommissionRate(double rate)
	{
		commissionRate = (rate >0.0 && rate <1.0 )? rate: 0.0;
	}
	public double getCommissionRate()
	{
		return commissionRate;
	}
	//calculate earnings
	public double earnings()
	{
		return getCommissionRate() * getGrossSales();
	}
	//return String representation of CommissionEmployee object
	@Override //indicates that this method overrides a superclass method
	public String toString()
	{
		return String.format("%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f",
				"commission employee",getFirstName(), getLastName(),"social security number", getSocialSecurityNumber(),"gross sales",
				getGrossSales(),"commission rate",getCommissionRate());
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
}

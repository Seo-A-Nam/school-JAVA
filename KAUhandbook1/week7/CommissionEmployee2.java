
public class CommissionEmployee2 extends Employee2 
{
	private double grossSales;
	private double commissionRate;
	
	public ComissionEmployee2( String first, String last, String ssn, double sales, double rate )
	{
		super( first, last, ssn );
		setGrossSales(sales);
		setCommissionRate(rate);
	}
	
	public void setCommissionRate(double rate)
	{
		commissionRate = ( rate > 0.0 && rate < 1.0 ) ? rate : 0.0;
	}
	
	public double getCommissonRate()
	{
		return commissionRate;
	}
	
	public void setGrossSales(double sales)
	{
		grossSales = ( sales < 0.0 ) ? 0.0 : sales;
	}
	
	public double getGrossSales()
	{
		return grossSales;
	}
	
	//calculate earnings; override abstract method earnings in Employee
	@Override
	public double earnings()
	{
		return getCommissonRate() * getGrossSales();
	}
	
	@Override
	public String toString()
	{
		return String.format("%s: %s\n%s: $%,.2f; %s: %.2f",
				"commission employee", super.toString(),"gross sales", getGrossSales(),"commission rate", getCommissonRate());
		
	}
}

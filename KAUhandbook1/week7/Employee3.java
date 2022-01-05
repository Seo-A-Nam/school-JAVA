
public abstract class Employee3 implements Payable 
{
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	
	public Employee3(String first, String last, String ssn)
	{
		firstName = first;
		lastName = last;
		socialSecurityNumber = ssn;
	}

	public void setFirstName(String first)
	{
		firstName = first;	//should validate
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setLastName(String last)
	{
		lastName = last;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setSocialSecurityNumber(String ssn)
	{
		socialSecurityNumber = ssn;
	}
	
	public String getSocialSecurityNumber()
	{
		return socialSecurityNumber;
	}
	
	//return String representation of Employee object
	@Override
	public String toString()
	{
		return String.format("%s %s\nsocial security number: %s", getFirstName(),getLastName(),getSocialSecurityNumber());
	}
	
	//Note : we do not implement Payable method getPaymentAmount here
	//so this class must be declared abstract to avoid a compilation error.
}

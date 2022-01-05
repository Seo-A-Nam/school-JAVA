//Employee abstract superclass
public abstract class Employee2 
{
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	
	//three-argument constructor
	public Employee2(String first, String last, String ssn )
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
	//abstract method overridden by concrete subclasses
	public abstract double earnings();	//no implement here
}

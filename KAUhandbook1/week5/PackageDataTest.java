//Package-access memebers of a class are accessible by other classes int the same package
public class PackageDataTest {
	public static void main(String[] args)
	{
		PackageData packageData = new PackageData();
		
		//output String representation of packageData
		System.out.printf("After instantiation:\n%s\n",packageData );
		
		//change package access data in packageData object
		packageData.number = 77;
		packageData.string = "Goodbye";
		
		//output String representation of packageData
		System.out.printf("\nAfter chaging values:\n%s\n",packageData);
	}
}


//class with package access instance variables
class PackageData
{
	int number;
	String string;
	
	//constructor
	public PackageData()
	{
		number = 0;
		string = "Hello";
	}
	
	//return package data object String representation
	public String toString()
	{
		return String.format("number: %d; string: %s", number, string);
	}
	
}

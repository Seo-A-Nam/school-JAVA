//복리표 만들기
//Compound-interest calculations with for.
public class Interest {
	public static void main(String[] args)
	{
		double amount;	// amount on deposit at end of each year
		double principal = 1000.0;	// initial amount before interest
		double rate = 0.05;	// interest rate
		
		//display headers
		System.out.printf("%s%20s\n","Year", "Amount on deposit"); //	%20s 는 20자리 잡아서 출력을 의미
		
		//calculate amount on deposit for each of ten years
		for( int year = 1; year <= 10; year++)
		{
			//calculate new amount for specified year
			amount = principal * Math.pow( 1.0+rate, year );
			//display the year and the amount
			System.out.printf("%4d%,20.2f\n", year, amount); //%,20.2f 는 20자리 잡아 2자리 소숫점 출력을 의미
		}
		
	}
}

package panlindrome;
import java.util.Scanner;

public class Panlindrome {
	
	public static void determine() {
		
		int number = 0;
		int tmp = 0;
		int reverse = 0;
		int digit = 0;
		
		
		while( number != -1 )
		{
			reverse = 0;
			System.out.print("Enter a number: ");
			Scanner input = new Scanner(System.in);
			number = input.nextInt();
			digit= number;
			
			while(number > 0) {
				tmp= number %10;
				reverse= reverse*10 + tmp;
				number= number/10;
				//System.out.printf("reverse statement: %d\n",reverse);
				//System.out.printf("digit: %d\n",digit);
				//System.out.printf("number: %d\n",number);
			}
			
			if(digit== -1) {
				System.out.println("Bye!\n");
			}
			else if(reverse == digit) {
				System.out.println(">Yes, it is a palindrome.\n");
			}
			else {
				System.out.println(">Not a palindrome.\n");
			}
		}
			
		}
		
	public static void displayMessage() {
		System.out.println("Welcome to Palindrome Tester");
	}
	
	public static void main(String[] args)
	{
		
		Panlindrome.displayMessage();
		Panlindrome.determine();

	}
}

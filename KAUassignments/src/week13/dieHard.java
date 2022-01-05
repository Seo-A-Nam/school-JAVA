package week13;

import java.util.InputMismatchException;
import java.util.Scanner;

/*종료 지시가 있을 때까지 분자와 분모 두 개의 정수를 입력 받고 메소
드 divide(int a, int b)를 호출하여 반환받은 a/b 값을 소숫점 3자리의 형식의 실수로 출력
하는 작업을 반복.
 프로그램은 입력 실수나 고의적인 오류 데이터 입
력이 있을 경우에도 프로그램이 중지되지 않으며 종료 지시가 있을 때까지 계속하여 정상적
으로 실행됨 */

public class dieHard {
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		boolean continueLoop = true;	//determines if more input is needed
		int count = 0;
		do
		{
			try
			{
				if(count>0) System.out.print("enter 0 at numerator to end the program\n");
				
				System.out.print("Please enter an integer numerator: "); //분자
				int numerator = scanner.nextInt();
				System.out.print("Please enter an integer denominator: "); //분모
				int denominator = scanner.nextInt();
				
				while(denominator==0) {
					System.out.println("Zero is an invalid denominator. Please try again.\n");
					System.out.print("Please enter an integer denominator: "); //분모
					denominator = scanner.nextInt();
				}
			
				double result = divide(numerator, denominator);
				System.out.printf("\nResult: %d / %d =  %.3f\n",numerator, denominator, result);
			
				if (numerator == 0 )
				{
					continueLoop = false;	
					System.out.print("End the program.");
				}
				count++;
			}
			catch(InputMismatchException inputMismatchException) 
			{
				System.err.printf("\nException: %s\n", inputMismatchException);
				scanner.nextLine();	//discard input so user can try again
				System.out.println("You must enter integers. Please try again.\n");
			}
			catch( ArithmeticException arithmeticException) 
			{
				System.err.printf("\nException: %s\n",arithmeticException);
				System.out.println("Zero is an invalid denominator. Please try again.\n");
			}
			} while(continueLoop);	//end do...while
	}
	public static double divide(int a, int b) 
			throws ArithmeticException
	{
		
		return (double)a / b;
		
		
	}
}

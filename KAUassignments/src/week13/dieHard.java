package week13;

import java.util.InputMismatchException;
import java.util.Scanner;

/*���� ���ð� ���� ������ ���ڿ� �и� �� ���� ������ �Է� �ް� �޼�
�� divide(int a, int b)�� ȣ���Ͽ� ��ȯ���� a/b ���� �Ҽ��� 3�ڸ��� ������ �Ǽ��� ���
�ϴ� �۾��� �ݺ�.
 ���α׷��� �Է� �Ǽ��� �������� ���� ������ ��
���� ���� ��쿡�� ���α׷��� �������� ������ ���� ���ð� ���� ������ ����Ͽ� ������
���� ����� */

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
				
				System.out.print("Please enter an integer numerator: "); //����
				int numerator = scanner.nextInt();
				System.out.print("Please enter an integer denominator: "); //�и�
				int denominator = scanner.nextInt();
				
				while(denominator==0) {
					System.out.println("Zero is an invalid denominator. Please try again.\n");
					System.out.print("Please enter an integer denominator: "); //�и�
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

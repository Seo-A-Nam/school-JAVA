//Shifted and scaled random integers.
import java.util.Random;

public class RandomIntegers {
	public static void main( String[] args )
	{
		Random randomNumbers = new Random();
		// Random randomNumbers = new Random(5); //new Random(seedValue)�� , seedValue�� ������ �׻� ���� �������� �����ϵ��� �� �� ����
		int face;
		
		//loop 20 times
		for( int counter = 1; counter <= 20; counter++ ) 
		{
			//pick random integer from 1 to 6
			face = 1 + randomNumbers.nextInt( 6 );
			System.out.printf("%d ", face);
			
			//if counter is divisible by 5, start a new line of output
			if ( counter % 5 ==0 )
				System.out.println();
		}
	}
}

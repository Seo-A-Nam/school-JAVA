import java.util.Random;

public class Craps 
//�ֻ��� 2�� ���ÿ� ���� ó���� ���� 7 �Ǵ� 11 ������ �̱�. ó���� ���� 2,3,�̳� 12�� ��쿡�� ��
//ù�ǿ� �ºΰ� �ȳ���, 1. ù��° �ո�ŭ ���� ������ ������ �̱�� 	2. 7�� ������ ����. 	���� �ϳ��� �� ������ �����
{
	public static void main(String[] args)
	{
		int fPoint;
		int A = Roll();
		if ( A==0 || A== 1 )
		{
			
		}
		else
		{
			fPoint = A;
			keepRoll(fPoint);
		}
			
	}
	
	public static int randomDice() {
		Random random = new Random();
		
		int a = random.nextInt(6) + 1;
		int b = random.nextInt(6) + 1;
		int sum = a + b;
			
		System.out.printf("Player rolled %d + %d = %d\n",a,b,sum);
		
		return sum;
		
	}
	
	public static int Roll() 
	{
		int point =randomDice();
		
		if( point == 7 || point == 11 )
		{
			System.out.println("Player wins");
			return 0;
		}
			
		else if( point == 2 || point == 3 || point == 12 )
		{
			System.out.println("Player loses");
			return 1;
		}
			
		else
		{
			System.out.printf("Point is %d\n",point);
			return point;
		}
	}
	
	public static void keepRoll(int fPoint) 
	{
		int point;
		while(true)
		{
			point = randomDice();
			
			if(point == 7) 
			{
				System.out.println("Player loses");
				break;
			}
			else if (point == fPoint) 
			{
				System.out.println("Player wins");
				break;
			}
			else {
				
			}
			
		}
	}
	
}

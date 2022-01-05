import java.util.Random;

public class Craps 
//주사위 2개 동시에 던져 처음에 합이 7 또는 11 나오면 이김. 처음에 합이 2,3,이나 12일 경우에는 짐
//첫판에 승부가 안나면, 1. 첫번째 합만큼 같은 점수가 나오면 이긴다 	2. 7이 나오면 진다. 	둘중 하나가 될 때까지 계속함
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

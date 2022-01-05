package cardgame9;
/*9주차 실습
 * Computer(딜러)가 랜덤하게 카드 섞기를 한 후 Player에게 카드 5장을 준다. 이 중에 face
가 같은 카드가 2장 이상 있으면 player가 이긴다. one pair가 있으면 pair를 이룬 가장 큰
수를 다음과 같이 출력한다. 없으면 Dealer라고 출력한다. yes 인 경우 face도 출력한다. 실행 종료를 지시할 때까지 반복해서 이 게임을 실행할 수 있다.*/
import java.util.Scanner;

public class OnePairGame {
	public static void main(String[] args) {
		int round = 1; //현재 몇번째 게임인지 센다
		int check = 0; //종료코드 1
		System.out.print("계속하려면 0, 종료하려면 1을 입력하세요\n");
		
		Scanner input = new Scanner(System.in);
		while(true) {
			
			System.out.printf("게임  %d : ", round++ );
			CardPlay.play();
			CardPlay.determine();
			check = input.nextInt(); //종료코드 입력되면 break 되게끔 설계
			if(check==1) break;
		}
		System.out.print("종료\n");
	}
}

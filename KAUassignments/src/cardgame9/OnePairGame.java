package cardgame9;
/*9���� �ǽ�
 * Computer(����)�� �����ϰ� ī�� ���⸦ �� �� Player���� ī�� 5���� �ش�. �� �߿� face
�� ���� ī�尡 2�� �̻� ������ player�� �̱��. one pair�� ������ pair�� �̷� ���� ū
���� ������ ���� ����Ѵ�. ������ Dealer��� ����Ѵ�. yes �� ��� face�� ����Ѵ�. ���� ���Ḧ ������ ������ �ݺ��ؼ� �� ������ ������ �� �ִ�.*/
import java.util.Scanner;

public class OnePairGame {
	public static void main(String[] args) {
		int round = 1; //���� ���° �������� ����
		int check = 0; //�����ڵ� 1
		System.out.print("����Ϸ��� 0, �����Ϸ��� 1�� �Է��ϼ���\n");
		
		Scanner input = new Scanner(System.in);
		while(true) {
			
			System.out.printf("����  %d : ", round++ );
			CardPlay.play();
			CardPlay.determine();
			check = input.nextInt(); //�����ڵ� �ԷµǸ� break �ǰԲ� ����
			if(check==1) break;
		}
		System.out.print("����\n");
	}
}

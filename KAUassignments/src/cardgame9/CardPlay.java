package cardgame9;
//�� �п��� �������� ���� + �� ���� ���Ⱚ���� pair�� ã�Ƴ� ���п��α��� ������ִ� Ŭ����
import java.util.Random;
public class CardPlay {
	static int[] tmp1 = new int[6];
	static String[] tmp2 = new String[6];
	//���� ī���ȣ, ���� ���� ���� ������ ����
	static int [] tmp3 = new int[14]; //�� ���ں��� �ߺ����� ����� �� ����
	static int temp = 0;
	static int c = 0; //üũ��
	
	public static void play() {
		tmp1 = new int[6];
		tmp2 = new String[6];
		//���� ī���ȣ, ���� ���� ���� ������ ����
		tmp3 = new int[14]; //�� ���ں��� �ߺ����� ����� �� ����
		temp = 0;
		c = 0; //üũ�� 
		
		//round ������ �� ���� �ٽ� �迭 �� �ʱ�ȭ
		
		
	Random random = new Random();
	
	for(int i=0;i<5;i++) {
		tmp1[i] = CardSet.NumSet[random.nextInt(13)];
		tmp2[i] = CardSet.Card[random.nextInt(4)];
		
		
		
		for(int j=0; j<i; j++) {
			if((tmp1[i]== tmp1[j]) && (tmp2[i]==tmp2[j])) { //������ �̾Ҵ� �Ͱ� ���� ī��(����, ���ĺ� �Ѵ� ����)�� ���� ��� ���ڸ� �ٽ� �̵��� ����ó��
				while(tmp1[i]!=tmp1[j])
						temp = random.nextInt(13);
						tmp1[i] = CardSet.NumSet[temp];
			}
			
		}
	}
	
	System.out.print("(");
	
	for(int i=0;i<5;i++) {
		System.out.printf("%s%d ",tmp2[i], tmp1[i]);
		if(i!=4){
			System.out.print(",");
		}
	}
	System.out.print(")\t\t");
	//� ī�� �̾Ҵ��� ���
	
	}
	
	
	
	public static void determine() {
		for(int i=0;i<5;i++) {
			temp = tmp1[i];
			tmp3[temp]++;
		} //���� ī��� �� n ��� �ִ��� üũ
		for(int i=0;i<14;i++) {
			if(tmp3[i]>=2) System.out.printf("%d pair . ",i);
			else {
				c++;
			
		}
		}
		if(c==14) { System.out.print("Dealer wins.\n");}
		else{
			System.out.print("Player wins.\n");}
	}
}
	


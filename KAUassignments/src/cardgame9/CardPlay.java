package cardgame9;
//그 패에서 랜덤으로 추출 + 그 랜덤 추출값에서 pair을 찾아내 승패여부까지 출력해주는 클래스
import java.util.Random;
public class CardPlay {
	static int[] tmp1 = new int[6];
	static String[] tmp2 = new String[6];
	//랜덤 카드기호, 숫자 집합 각각 저장할 공간
	static int [] tmp3 = new int[14]; //각 숫자별로 중복값이 몇개인지 셀 공간
	static int temp = 0;
	static int c = 0; //체크용
	
	public static void play() {
		tmp1 = new int[6];
		tmp2 = new String[6];
		//랜덤 카드기호, 숫자 집합 각각 저장할 공간
		tmp3 = new int[14]; //각 숫자별로 중복값이 몇개인지 셀 공간
		temp = 0;
		c = 0; //체크용 
		
		//round 시작할 때 마다 다시 배열 값 초기화
		
		
	Random random = new Random();
	
	for(int i=0;i<5;i++) {
		tmp1[i] = CardSet.NumSet[random.nextInt(13)];
		tmp2[i] = CardSet.Card[random.nextInt(4)];
		
		
		
		for(int j=0; j<i; j++) {
			if((tmp1[i]== tmp1[j]) && (tmp2[i]==tmp2[j])) { //이전에 뽑았던 것과 같은 카드(숫자, 알파벳 둘다 같음)가 나올 경우 숫자만 다시 뽑도록 예외처리
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
	//어떤 카드 뽑았는지 출력
	
	}
	
	
	
	public static void determine() {
		for(int i=0;i<5;i++) {
			temp = tmp1[i];
			tmp3[temp]++;
		} //뽑은 카드들 중 n 페어 있는지 체크
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
	


package coding_test_drawing;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Draw extends JPanel
{
	private int number;
	
	public Draw(int count, int sum)
	{		
		number = count + sum;
			
	}
	
	public void paintComponent(Graphics g)
	{	
		super.paintComponent(g);
		int hgap = 10;  //각 도형 사이 10 정도 간격 // 가로간격
		int vgap = 10;  //세로간격 
		//한 줄에 8개 출력하면 다음 줄로 내려가며 위아래 간격 10 둬야함
		
		for(int j=0;j<number;j++) {
			if(j>=8 && j%8==0) {//예시 화면 보면, 한 줄당 최대 8개 도형밖에 못출력함
				vgap+=60;
				hgap=10; //줄바꿨을 때, 처음 시작 x점으로
			
			}
		switch(j%3)	//현재까지의 개수 % 3 ==0 이면 원, %3 ==1 이면 사각형, %3 ==2 이면 직선
			{
					
				case 0:
					g.drawOval(10+hgap, 10+vgap, 50, 50);
					break;
						
				case 1:
					g.drawRect(10+hgap, 10+vgap, 50, 50);
					break;
						
				case 2:
					g.drawLine(10+hgap,10+vgap,60+hgap,60+vgap);
					break;
						
						
				}//switch문 끝
		hgap+=60; //도형 하나 그린 뒤 간격 10 늘림
		}
			
	}
}
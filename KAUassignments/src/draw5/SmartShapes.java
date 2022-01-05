package draw5;
import java.awt.Graphics;
import javax.swing.JPanel;
import 
/*Problem (5주차 과제)
1.다음과 같이 동작하는 프로그램을 작성하라.
(1) 사용자는 원, 사각형, 선을 선택할 수 있다. (2) 프로그램은 사용자가 선택한 그림을 위치, 크기, 색, 개수(6-20개) 모두 random 값으
로 화면에 그린다. 각 그림은 그려지는 순서에 따라서 1,2,3, .. 으로 부르기로 한다. (3) 사용자가 k 번째 그림을 지우라는 명령을 하면 그 그림이 화면에서 사라진다. (4) redraw를 지시하면 지우기를 시작하기 전에 그린 처음 그린 그림이 복원된다.
(5) 기타 프로그램의 동작에 대해 설명하지 않은 부분이 있으면 자유롭게 결정한다.*/
public class SmartShapes extends Jpanel {
		private int number, I[],tmp[];
		public SmartShapes(int count)
		{		
			number = count;
			= (int)((Math.random()*10000)%10);
				
		}
		
		public void paintComponent(Graphics g)
		{	
			super.paintComponent(g);
			for(int j=0;j<number;j++) {
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
			} } } 
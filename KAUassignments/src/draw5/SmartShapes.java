package draw5;
import java.awt.Graphics;
import javax.swing.JPanel;
import 
/*Problem (5���� ����)
1.������ ���� �����ϴ� ���α׷��� �ۼ��϶�.
(1) ����ڴ� ��, �簢��, ���� ������ �� �ִ�. (2) ���α׷��� ����ڰ� ������ �׸��� ��ġ, ũ��, ��, ����(6-20��) ��� random ����
�� ȭ�鿡 �׸���. �� �׸��� �׷����� ������ ���� 1,2,3, .. ���� �θ���� �Ѵ�. (3) ����ڰ� k ��° �׸��� ������ ����� �ϸ� �� �׸��� ȭ�鿡�� �������. (4) redraw�� �����ϸ� ����⸦ �����ϱ� ���� �׸� ó�� �׸� �׸��� �����ȴ�.
(5) ��Ÿ ���α׷��� ���ۿ� ���� �������� ���� �κ��� ������ �����Ӱ� �����Ѵ�.*/
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
				switch(j%3)	//��������� ���� % 3 ==0 �̸� ��, %3 ==1 �̸� �簢��, %3 ==2 �̸� ����
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
							
							
					}//switch�� ��
			hgap+=60; //���� �ϳ� �׸� �� ���� 10 �ø�
			} } } 
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
		int hgap = 10;  //�� ���� ���� 10 ���� ���� // ���ΰ���
		int vgap = 10;  //���ΰ��� 
		//�� �ٿ� 8�� ����ϸ� ���� �ٷ� �������� ���Ʒ� ���� 10 �־���
		
		for(int j=0;j<number;j++) {
			if(j>=8 && j%8==0) {//���� ȭ�� ����, �� �ٴ� �ִ� 8�� �����ۿ� �������
				vgap+=60;
				hgap=10; //�ٹٲ��� ��, ó�� ���� x������
			
			}
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
		}
			
	}
}
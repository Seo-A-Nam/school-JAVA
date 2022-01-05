package draw4;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Shapes extends JPanel
{
	static int [] tmp= new int[100]; // �� ���� �� choice ����ϴ� �迭
	static int [] I = new int[100]; // �� ���� �� ������ i ����ϴ� �迭
	//�ش� ���� �� ������ i, choice ��� -> ���� ������ �����ؼ� ���� �׸����� �׸��� �� �ʿ��� 
	
	private int choice;
	private int L;
	
	public Shapes(int Loop, int userChoice)
	{		L=Loop;
			choice= userChoice;
	}
	public void paintComponent(Graphics g)
	{	
		super.paintComponent(g);
		
		I[L]= (int)((Math.random()*10000)%10);
		tmp[L]=choice;
		
		for(int j=0;j<=L;j++) {
			switch(tmp[j])
				{
						
					case 1:
						g.drawRect(10+I[j]*10, 10+I[j]*10, 50, 50);
						break;
					case 2:
						g.drawOval(10+I[j]*10, 10+I[j]*10, 50, 50);
						break;
					case 3:
						
						int xarray[]= {35+10*I[j],10+10*I[j],60+I[j]*10,35+10*I[j]};
						int yarray[]= {10+I[j]*10,35+10*I[j],60+I[j]*10,10+I[j]*10};
						g.drawPolyline(xarray,yarray, 4);
						break;
					case 4:
						int width = getWidth();
						int height = getHeight();
						g.drawLine(10+I[j]*10,10+I[j]*10,60+10*I[j],60+10*I[j]);
						break;
					default:
						break;
				} //switch�� ��
		}//for�� ��
	}
}
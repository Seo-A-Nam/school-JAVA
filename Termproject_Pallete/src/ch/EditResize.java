package ch;
// OrderResize.java
import java.awt.*;

public class EditResize extends Order {
	
	private int x1, y1; // �߽��� �Ǵ� ��ǥ
	private Shape temp; // ������ ������ ���� ����ϴ� �ӽ� ��ü

	// ������ ũ�⸦ �����Ѵ�.
	public void mousePressExe(Point p, Drawing Layer)
	{
		Shape s = Layer.getTopShape(p); // �ֻ��� ��ü�� ���´�.
		temp = s; 
		x1 = p.x;
		y1 = p.y;
	}
	public void mouseDragExe(Point p, Drawing Layer)
	{	
		if (temp != null&&Layer.getEditIndex()==Layer.getNowIndex(temp)) // ������ �ְ� ���õ� ��ü�� �ε�����
		{																 // ���� �ε����� ������
			temp.scale(p.x - x1, p.y - y1);			// ������ ���콺 �巡���� ��ŭ ũ�������Ѵ�.
			x1 = p.x;
			y1 = p.y;
		}      		
	}
}

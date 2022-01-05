package ch;

import java.awt.*;

public class EditMove extends Order {
	
	private Point lastPoint;	// ���콺�� ���� ������ ��
    private Shape s;			// �̵��� ����
 
  	public void mousePressExe(Point p, Drawing Layer)
  	{
		// ���콺�� ������ �� ���� ���� �����ϴ� �����߿�
		// ���� �տ� �ִ� ������ ã�´�.
		s = Layer.getTopShape(p);
    		if (s != null){		// ��ü�� ������
			
      		lastPoint = p;		
      			
    		}// ���콺�� ������ �� Ŀ���� ��ġ�� ����
  	}
  
  	public void mouseDragExe(Point p, Drawing Layer)
  	{
    		if (s != null&&Layer.getEditIndex()==Layer.getNowIndex(s))  // ���콺�� ������ �� ������ �����鼭 ���� ��ü�� �ε�����
    		{															// ���� ��ü�� �ε����� ������
			// ������ deltaX, deltaY��ŭ �����δ�
      		s.move(p.x - lastPoint.x, p.y - lastPoint.y); 	
			// ������ �Ŀ� ���� ���콺�� ��ġ�� �����Ѵ�
      		lastPoint = p;
    		}
			
  	}
	
}

package ch;
// DrawLine.java
import java.awt.*;

public class DrawLine extends Order {
    
  	private int x1, y1;	         		// ó�� ������
    private Shape temp;
  	// ���콺�� ���� �����κ��� ���ο� ������ �����ϰ� 
  	public void mousePressExe(Point p, Drawing Layer)
  	{
    		x1 = p.x;
    		y1 = p.y;
    		ShapeLine s = new ShapeLine(x1, y1, x1, y1, Layer.getColor());
    		if(Layer.isEditing()==true)
    		Layer.deselect();
    		Layer.add(s);	// ��ü�� �����Ѵ�.
  	}

  	// ���콺�� ó���� ���� �����κ��� �巡�׵Ǵ� ������ ������ �׸���.
  	public void mouseDragExe(Point p, Drawing Layer)
  	{
    		ShapeLine line = new ShapeLine(x1, y1, p.x, p.y, Layer.getColor());
    		
		// �巡�� �Ǵ� ���� ���� Ŀ����ġ�� �ִ� �������� �����ش�.	
    		Layer.remainEndshape(line);		// ������ shapeSave ������ �� �ڷ� ������.
  	}
}
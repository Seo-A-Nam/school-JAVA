package ch;
// OrderFill.java
import java.awt.*;

public class EditFill extends Order {

  	// ������ ������ �ٲ۴�
	public void mouseClickExe(Point p, Drawing Layer)
  	{
  		// ���콺�� Ŭ���ؼ� ��� ���� �����ϴ� �����߿�
  		// ���� �տ� �ִ� ������ ã�´�.
    		Shape s = Layer.getTopShape(p);
		if (s != null)									// ������ ������
		{
    			if(s.containsPoint(p))// ���� �����ߴ��� Ȯ���Ѵ�.
    			{
				s.setColor(Layer.getColor());    // ������ ������ �����Ѵ�.
				s.isFillPaint(p); // ���� ä���.
                
    			}
		}      		
    	}
}

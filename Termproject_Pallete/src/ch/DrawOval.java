package ch;
// DrawOval.java
import java.awt.*;

public class DrawOval extends Order{

	private Point first;	
	

	// ���콺�� ���� ��ġ�κ��� ���� �����Ѵ�. 
  	public void mousePressExe(Point p, Drawing Layer)
  	{
    		first = p;
    		ShapeOval o = new ShapeOval(p.x, p.y, 0, 0, Layer.getColor());
    		if(Layer.isEditing()==true)
    			Layer.deselect();
    		Layer.add(o); // ��ü�� �����Ѵ�.
  	}

	// ���콺�� ó���� ���� �����κ��� �巡�׵Ǵ� ������ ���� �׸���.
  	public void mouseDragShiftExe(Point p, Drawing Layer)
  	{
    		ShapeOval o = new ShapeOval(Math.min(p.x, first.x), Math.min(p.y, first.y),
                      Math.abs(p.x - first.x), Math.abs(p.x - first.x), Layer.getColor());

		// �巡�� �Ǵ� ���� ���� Ŀ����ġ�� �ִ� Ÿ������ �����ش�.			                      
    		Layer.remainEndshape(o);
  	}
  	public void mouseDragExe(Point p, Drawing Layer)
  	{
    		ShapeOval o = new ShapeOval(Math.min(p.x, first.x), Math.min(p.y, first.y),
                      Math.abs(p.x - first.x), Math.abs(p.y - first.y), Layer.getColor());

		// �巡�� �Ǵ� ���� ���� Ŀ����ġ�� �ִ� Ÿ������ �����ش�.			                      
    		Layer.remainEndshape(o);
  	}
}

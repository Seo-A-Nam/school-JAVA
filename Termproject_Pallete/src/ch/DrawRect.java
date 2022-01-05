package ch;
// DrawRect.java
import java.awt.*;

public class DrawRect extends Order {
	
  	private Point first;       // �簢���� ���� ��� �𼭸� ��ǥ
  	
  	public void mousePressExe(Point p, Drawing Layer)
  	{
    		first = p;
    		ShapeRect r = new ShapeRect(p.x, p.y, 0, 0, Layer.getColor());
    		if(Layer.isEditing()==true)
    			Layer.deselect();
    		Layer.add(r);	// ��ü�� �����Ѵ�.
  	}

  	// ���콺�� ó���� ���� �����κ��� �巡�׵Ǵ� ������ �簢���� �׸���.
  	public void mouseDragShiftExe(Point p, Drawing Layer)
  	{
    		ShapeRect r = new ShapeRect(Math.min(p.x, first.x), Math.min(p.y, first.y),
            	Math.abs(p.x - first.x), Math.abs(p.x - first.x), Layer.getColor());
    		
		// �巡�� �Ǵ� ���� ���� Ŀ����ġ�� �ִ� �簢������ �����ش�.	
    		Layer.remainEndshape(r);	
  	}
  	
  	public void mouseDragExe(Point p, Drawing Layer)
  	{
    		ShapeRect r = new ShapeRect(Math.min(p.x, first.x), Math.min(p.y, first.y),
            	Math.abs(p.x - first.x), Math.abs(p.y - first.y), Layer.getColor());
    		
		// �巡�� �Ǵ� ���� ���� Ŀ����ġ�� �ִ� �簢������ �����ش�.	
    		Layer.remainEndshape(r);	
  	}
}

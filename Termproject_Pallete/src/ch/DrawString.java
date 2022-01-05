package ch;

import java.awt.Point;

public class DrawString extends Order {
	public void mousePressExe(Point p, Drawing Layer)
  	{
    		String str=MyPainter.str.getText();
    		System.out.println(str);
    		ShapeString s = new ShapeString(str, p.x, p.y, Layer.getColor(), LineWidth.size);
    		if(Layer.isEditing()==true)
    			Layer.deselect();
    		Layer.add(s);	// 객체를 저장한다.
  	}
}

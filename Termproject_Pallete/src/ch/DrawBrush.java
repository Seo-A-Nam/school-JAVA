package ch;


import java.awt.Point;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

//���콺�� �̿��� �����Ӱ� �׸� �׸�
//�� �� ���� ����(ListWidget)
//���� �β� ����(RadioButton)
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;

public class DrawBrush extends Order {
    
  	private int x1, y1;	         		// ó�� ������
    private Shape temp;
    private int pointCount = 0;
    private int count = 0;
    private ShapeCurve[] points = new ShapeCurve[10000];
    private Point first;
  	// ���콺�� ó���� ���� �����κ��� �巡�׵Ǵ� ������ ������ �׸���.
    public void mousePressExe(Point p, Drawing Layer)
  	{
    		first = p;
    		ShapeCurve o = new ShapeCurve(p.x, p.y, LineWidth.size, Layer.getColor());
    		//if(Layer.isEditing()==true)
    		//	Layer.deselect();
    		Layer.add(o); // ��ü�� �����Ѵ�.
  	}
    public void mouseDragShiftExe(Point p, Drawing Layer)
  	{
    	ShapeCurve o = new ShapeCurve(p.x, p.y, LineWidth.size, Layer.getColor());

		// �巡�� �Ǵ� ���� ���� Ŀ����ġ�� �ִ� Ÿ������ �����ش�.			                      
    	Layer.remainEndshape(o);
  	}
  	public void mouseDragExe(Point p, Drawing Layer)
  	{
  		ShapeCurve o = new ShapeCurve(p.x, p.y, LineWidth.size, Layer.getColor());
  		Layer.add(o);
        
  	}
}

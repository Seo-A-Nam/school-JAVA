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

//마우스를 이용해 자유롭게 그림 그림
//선 색 선택 가능(ListWidget)
//선의 두께 선택(RadioButton)
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;

public class DrawBrush extends Order {
    
  	private int x1, y1;	         		// 처음 시작점
    private Shape temp;
    private int pointCount = 0;
    private int count = 0;
    private ShapeCurve[] points = new ShapeCurve[10000];
    private Point first;
  	// 마우스로 처음에 누른 점으로부터 드래그되는 점까지 직선을 그린다.
    public void mousePressExe(Point p, Drawing Layer)
  	{
    		first = p;
    		ShapeCurve o = new ShapeCurve(p.x, p.y, LineWidth.size, Layer.getColor());
    		//if(Layer.isEditing()==true)
    		//	Layer.deselect();
    		Layer.add(o); // 객체를 저장한다.
  	}
    public void mouseDragShiftExe(Point p, Drawing Layer)
  	{
    	ShapeCurve o = new ShapeCurve(p.x, p.y, LineWidth.size, Layer.getColor());

		// 드래그 되는 동안 현재 커서위치에 있는 타원만을 보여준다.			                      
    	Layer.remainEndshape(o);
  	}
  	public void mouseDragExe(Point p, Drawing Layer)
  	{
  		ShapeCurve o = new ShapeCurve(p.x, p.y, LineWidth.size, Layer.getColor());
  		Layer.add(o);
        
  	}
}

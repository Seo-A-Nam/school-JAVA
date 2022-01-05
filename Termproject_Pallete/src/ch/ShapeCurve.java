package ch;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public class ShapeCurve extends Shape implements Serializable{

	public int x, y, size;
	public Color color;
	public ShapeCurve(int x, int y, int size, Color color) {
		super(color);
		
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
         g.setColor(color);
         g.fillOval(x, y, size, size);
         
	      
	}

	@Override
	public boolean containsPoint(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void move(int deltaX, int deltaY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scale(int deltaX, int deltaY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int setLeftPoint(int left) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setTopPoint(int top) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isFillPaint(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

}

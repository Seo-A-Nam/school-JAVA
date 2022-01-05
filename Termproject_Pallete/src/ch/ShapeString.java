package ch;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public class ShapeString extends Shape implements Serializable{
	String str;
	int x, y;
	Color color;
	int size;
	public ShapeString(String str, int x, int y, Color color, int size) {
		super(color);
		// TODO Auto-generated constructor stub
		this.str = str;
		this.x = x;
		this.y =y;
		this.color = color;
		this.size = size;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setFont(new Font("±Ã¼­", Font.PLAIN, size));
		g.setColor(color);
		//System.out.println(str);
		g.drawString(str, x, y);
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

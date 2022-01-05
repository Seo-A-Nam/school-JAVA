package ch;
// ShapeLine.java
import java.awt.*;
import java.awt.geom.*;
import java.io.*;

//public class ShapeLine extends Shape {
public class ShapeLine extends Shape implements Serializable {	
	
	// ��(x1, y1)�� ��(x2, y2)�� �����ϴ� ����
  	private int x1, y1, x2, y2;
		
	
  	private Line2D.Double line;
  
  	// Line ������
	public ShapeLine(int x1, int y1, int x2, int y2, Color color)
  	{
  		super(color);				// ����, �� ���� �ʱ�ȭ
    	this.x1 = x1;
    	this.y1 = y1;
    	this.x2 = x2;
    	this.y2 = y2;
  	}
	  
	// ������ �׸���.
  	public void draw(Graphics g)
  	{
  		Graphics2D g2d = (Graphics2D) g;									// Graphics2D�� ĳ����
    	line = new Line2D.Double(x1, y1, x2, y2); 
    	g2d.setColor(getColor());											// ���� �����ϰ�
		g2d.draw(line);			
  	
    	
		if (super.getSelect() == true)		{	
		g.setColor(Color.BLACK);
		g.fillRect(this.x1,this.y1,5,5);
		g.fillRect(this.x1,this.y2,5,5);
		g.fillRect(this.x2,this.y2,5,5);
		g.fillRect(this.x2,this.y1,5,5);}// ���� ���� ä���.// ���� �׸���.
  	}
 	
 	// ������ �� ä��Ⱑ �ʿ����� ������ Shape�� �߻�޼ҵ��̹Ƿ� �������̵��Ѵ�.
	public boolean isFillPaint(Point p) {return true;}
	public boolean isGradient(Point p) {return true;}
	

	// ���� �ѷ��δ� ������ �簢�� �ȿ� ���� ��ġ�ϴ��� �˾Ƴ���.
	public boolean containsPoint(Point p)
	{
		int left = Math.min(x1, x2);
		int top = Math.min(y1, y2);
		int width = Math.abs(x1 - x2);
		int height = Math.abs(y1 - y2);
		
		if (p.x >= left && p.x <= left + width && p.y >= top && p.y <= top + height)
			return true;		
		else
			return false;		
		
	}

  	// ������ X�����κ��� deltaX, Y�����κ���deltaY��ŭ �����̵�
  	public void move(int deltaX, int deltaY)
  	{
    		x1 += deltaX;
    		y1 += deltaY;
    		x2 += deltaX;
    		y2 += deltaY;
  	}
  	
  	// ������ ũ�⸦ �����Ѵ�.
	public void scale(int deltaX, int deltaY)
	{
		x2 += deltaX;
		y2 += deltaY; 
	}
	
	public int setLeftPoint(int x)		// ��(x1, y1)�� ��(x2, y2)�� deltaX��ŭ �����ش�
	{
		int deltaX;
		deltaX = x - x1;
		x2 += deltaX;
		
		return x1 = x;
	}
	
	public int setTopPoint(int y)		// ��(x1, y1)�� ��(x2, y2)�� deltaX��ŭ �����ش�
	{
		int deltaY;
		deltaY = y - y1;
		y2 += deltaY;
		
		return y1 = y;
	}
	
	//	��ü ����ȭ�� ���� ObjectOutputStreamŬ������ writeObject �������̵�
	private void writeObject(ObjectOutputStream out) throws IOException
	{
		out.writeInt(x1);
		out.writeInt(y1);
		out.writeInt(x2);
		out.writeInt(y2);
	}
	
	//	��ü ����ȭ�� ���� ObjectInputStreamŬ������ writeObject �������̵�	
	private void readObject (java.io.ObjectInputStream in)
						throws IOException, ClassNotFoundException
	{
		x1 = in.readInt();
		y1 = in.readInt();
		x2 = in.readInt();
		y2 = in.readInt();
	}
}


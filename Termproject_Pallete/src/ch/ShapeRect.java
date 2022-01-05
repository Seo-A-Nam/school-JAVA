package ch;
// ShapeRect.java
import java.awt.*;
import java.awt.geom.*;
import java.io.*;

//public class ShapeRect extends Shape {
public class ShapeRect extends Shape implements Serializable {
	
  	private int left, top;          					// �簢���� ���� ��� �𼭸� ��ǥ
  	private int width, height;         				// �簢���� �ʺ�� ����
  	private Rectangle2D.Double rect;
  	private boolean isFillPaint;					// ��ä��� ����

	// Ÿ�� ��ä��� ����
  	// ������
  	public ShapeRect(int left, int top, int width, int height, Color color)
  	{
    		super(color);
    		this.left = left;
    		this.top = top;
    		this.width = width;
    		this.height = height;
  	}
  
  	// �簢���� �׸���.
  	public void draw(Graphics g)
  	{
		Graphics2D g2d = (Graphics2D) g;									//Graphics2D�� ĳ����

    		g2d.setColor(getColor());											// ���� �����ϰ�
    		rect = new Rectangle2D.Double(left, top, width, height);		// �簢���� ����
    															// �簢���� �׸���
    		g2d.setColor(getColor());											// ���� �����ϰ�
    		g2d.draw(rect);
        		// Ÿ���� �׸���.
    		if (isFillPaint == true)												// ��ä��� ����� ������
    			g2d.fill(rect);	
    		
    		
			if (super.getSelect() == true)		{		
				g.setColor(Color.BLACK);
				g.fillRect(this.left-5,this.top-5,5,5);
				g.fillRect(this.left-5,this.top+height,5,5);
				g.fillRect(this.left+width,this.top-5,5,5);
				g.fillRect(this.left+width,this.top+height,5,5);	}										// ���� ���� ä���.// ���� ä���.
  	}
	//	�簢�� �����ȿ� ���콺Ŀ���� ������ True�� �����Ͽ� ���� ä��� ��
	public boolean isFillPaint(Point p)
	{
		if (p.x >= left && p.x <= left + width && p.y >= top && p.y <= top + height)
			return this.isFillPaint = true;
		else
			return this.isFillPaint = false;
	}
	
  	// �簢�� �ȿ� ���� ��ġ�ϴ��� �˾Ƴ���.
  	public boolean containsPoint(Point p)
  	{
  		if (p.x >= left && p.x <= left + width && p.y >= top && p.y <= top + height)
  			return true;
    		else
    			return false;
  	}
  
  	// �簢���� �̵��Ѵ�.
  	// ���� ����� �𼭸� ��ǥ�� deltaX, deltaY ��ŭ �̵���Ų��.
  	public void move(int deltaX, int deltaY)
  	{
    		left += deltaX;
    		top += deltaY;
  	}
  	
  	// �簢���� ũ�⸦ �����Ѵ�.
  	// �簢���� �ʺ�� ���̸� deltaX, deltaY ��ŭ �����Ѵ�.
	public void scale(int deltaX, int deltaY)
	{
		width += deltaX;
		height += deltaY; 
	}

	public int setLeftPoint(int x)		// ���� ��� �𼭸� ��ǥ
	{
		return left = x;
	}
	
	public int setTopPoint(int y)
	{
		return top = y;
	}
	//	��ü ����ȭ�� ���� ObjectOutputStreamŬ������ writeObject �������̵�
	private void writeObject (ObjectOutputStream out) throws IOException 
	{
		out.writeInt(left);
		out.writeInt(top);
		out.writeInt(width);
		out.writeInt(height);
		out.writeBoolean(isFillPaint);
	}
	//	��ü ����ȭ�� ���� ObjectInputStreamŬ������ writeObject �������̵�
	private void readObject (ObjectInputStream in) 
					throws IOException, ClassNotFoundException
	{
		left = in.readInt();
		top = in.readInt();
		width = in.readInt();
		height = in.readInt();
		isFillPaint = in.readBoolean();
	}
}


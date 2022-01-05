package draw_6_7;

import java.awt.Color;
import java.awt.Graphics;

public class Myshape {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Color myColor;
	
	public Myshape(int x1, int y1, int x2, int y2, Color color) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		myColor = color;
	}
	
	public void draw(Graphics g, int choice) {
		g.setColor(myColor);
		switch(choice-1)	//입력값 1 이면 사각형, 2 이면 원, 3 이면 직선
		{
			case 0:
				g.drawRect(x1, y1, x2, x2);
				break;	
			case 1:
				
				g.drawOval(x1/2, y1/2, x2-x1/3, x2-x1/3);
				break;
							
			case 2:
				g.drawLine(x1, y1, x2, y2);
				break;
			default:
				break;
							
		}
		
		
	}
}

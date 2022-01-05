package panlindrome;

import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel extends JPanel
{
	public void paintComponent( Graphics g ) {
		
		super.paintComponent( g );
		int width = getWidth();
		int height = getHeight();
		for(int i = 1; i <= 250; i += 10) { 
			g.drawLine(0,i,i,height);
			g.drawLine(0,height,0,i);
		}
		
	}
}

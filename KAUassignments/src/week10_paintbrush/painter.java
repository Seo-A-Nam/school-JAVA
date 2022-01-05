package week10_paintbrush;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
//Testing PaintPanel

import com.sun.prism.paint.Color;

public class painter
{

	public static void main(String[] args)
	{
		
		JFrame application = new JFrame();
		
		LineWidth width = new LineWidth();
		LineColor color = new LineColor();
		
		application.add(width,BorderLayout.NORTH);
		application.add(color,BorderLayout.WEST);
		
		PaintBrush paintbrush = new PaintBrush();
		application.add(paintbrush, BorderLayout.CENTER);
		application.add(new JLabel ("Drag the mouse to draw"),BorderLayout.SOUTH);
		
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(800,400);
		application.setVisible(true);
		
	}
}
package Drawing_with_the_Mouse;
//Using Class MouseMotionAdapter
import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;
import javax.swing.JPanel;

public class PaintPanel extends JPanel{
	private int pointCount = 0; //count number of points
	//array of 1000 java.awt.Point references
	private Point[] points = new Point[1000];
	
	//set of GUI and register mouse event handler
	public PaintPanel()
	{
		//handle frame mouse motion event
		addMouseMotionListener(
				new MouseMotionAdapter() //anonymous inner class
				{
					//store drag coordinates and repaint
					public void mouseDragged( MouseEvent event )
					{
						if ( pointCount < points.length )
						{
							points [ pointCount ] = event.getPoint(); //find point
							pointCount++; //increment number of points in array
							repaint(); //repaint JFrame
						}
					}
				}
				);
	}
	//draw ovals in a 4-by-4 bounding box at specified locations on window
	public void paintCompoment( Graphics g )
	{
		super.paintComponent(g);  //clears drawing area
		//draw all points in array
		for(int i=0; i< pointCount; i++)
			g.fillOval(points[i].x, points[i].y, 4, 4);
	}
}

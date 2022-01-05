package draw5;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SmartshapeTest {
	public static void main(String[] args) 
	{
		int count=0;
		while(true) {
			String input = JOptionPane.showInputDialog("Enter 1 to draw oval\n" + "Enter 2 to draw rectangle\n" + "Enter 3 to draw line");
			count = Integer.parseInt(input);
			JFrame application = new JFrame();
			application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			SmartShapes panel = new SmartShapes(count);
			application.add(panel);
			application.setSize(300,300);
			application.setVisible(true);
			
		}
	}
}

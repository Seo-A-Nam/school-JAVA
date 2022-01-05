//Demonstrates the use of labels.
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class LabelDemo 
{
	public static void main(String[] args)
	{
		JLabel northLabel = new JLabel("North");
		ImageIcon labelIcon = new ImageIcon("week6/sample.gif");
		JLabel centerLabel = new JLabel(labelIcon);
		JLabel southLabel = new JLabel(labelIcon);
		
		//set the label to display text(as well as icon)
		southLabel.setText("South");
		
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add the labels to the frame + where on the frame to add the label
		application.add(northLabel,BorderLayout.NORTH);
		application.add(centerLabel,BorderLayout.CENTER);
		application.add(southLabel,BorderLayout.SOUTH);
		
		application.setSize(800,800);
		application.setVisible(true);
	}
}

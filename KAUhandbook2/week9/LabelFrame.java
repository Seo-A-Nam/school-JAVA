//Demonstrating the JLabel class
import java.awt.FlowLayout;	// specifies how components are arranged
import javax.swing.JFrame;	// provides basic window features
import javax.swing.JLabel;	// displays text and images
import javax.swing.SwingConstants;	// common constants used with Swing
import javax.swing.Icon;	// interface used to manipulate images
import javax.swing.ImageIcon;	// loads images

public class LabelFrame extends JFrame 
{
	private JLabel label1; //JLabel with just text
	private JLabel label2; //JLabel constructed with text and icon
	private JLabel label3; //JLabel with added text and icon
	
	// LabelFrame constructor adds JLabel's to JFrame
	public LabelFrame()
	{
		super("Testing JLabel");
		setLayout(new FlowLayout());	//set frame layout
		
		//JLabel constructor with a string argument
		label1 = new JLabel("Label with text");
		label1.setToolTipText("This is label1");
		add(label1);
		
		//JLabel constructor with string, Icon and alignment arguments
		Icon sample = new ImageIcon(getClass().getResource("/sample.gif"));
		label2 = new JLabel("Label with text and icon", sample , SwingConstants.LEFT);
		label2.setToolTipText("This is label2");
		add(label2);
		
		label3 = new JLabel();
		label3.setText("Label with icon and text at botton");
		label3.setIcon(sample); //add icon to JLabel
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText("This is label3");
		add(label3);
		
	}
	
	
}

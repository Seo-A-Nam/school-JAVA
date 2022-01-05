import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

//Creating JButtons.
public class ButtonFrame extends JFrame
{
	private JButton plainButton;	//button with just text
	private JButton fancyButton;	//button with icons
	
	//ButtonFrame adds JButtons to JFrame
	public ButtonFrame()
	{
		super("Testing Buttons");
		setLayout(new FlowLayout());	//set frame layout
		
		plainJButton = new JButton("Plain Button");	//button with text
		add(plainButton); //add plainButton to JFrame
		
		Icon bug1 = new ImageIcon (getClass().getResourse("bug1.gif"));
		Icon bug2 = new ImageIcon (getClass().getResourse("bug2.gif"));
		fancyButton = new JButton("Fancy Button",bug1);	//set image
		fancyButton.setRolloverIcon(bug2); //set rollover image
		add(fancyButton); //add fancyButton to JFrame
		
		//create new ButtonHandler for button event handling
		ButtonHandler handler = new ButtonHandler();
		fancyButton.addActionListener(handler);
		plainButton.addActionListener(handler);
	} //end ButtonFrme constructor
	

	//inner class for button event handling 
	private class ButtonHandler implements ActionListener
	{
		//handle button event
		public void actionPerformed(ActionEvent event)
		{
			JOptionPane.showMessageDialog(ButtonFrame.this, String.format("You pressed: %s",event.getActionCommand()));
			
		}	//end method actionPerformed
	}	//end private inner class ButtonHandler
}

//Testing TextFieldFrame
import javax.swing.JFrame;

public class TextFieldTest 
{
	public static void main(String[] args)
	{
		TextFieldFrame textFieldFrame = new TextFieldFrame();
		textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textFieldFrame.setSize(350, 110); //set frame size
		textFieldFrame.setVisible(true);  //display frame
	}
}

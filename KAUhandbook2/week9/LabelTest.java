//Testing LabelFrame
import javax.swing.JFrame;

public class LabelTest 
{
	public static void main(String[] args)
	{
		LabelFrame labelFrame = new LabelFrame();
		labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		labelFrame.setSize(1040, 720); //set frame size
		labelFrame.setVisible(true);  //display frame
	}
}

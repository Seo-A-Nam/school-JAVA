import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShapesTest {
	public static void main(String[] args)
	{
		//obtain user's choice
		String input = JOptionPane.showInputDialog("Enter 1 to draw rectangles\n" + "Enter 2 to draw ovals");
		int choice = Integer.parseInt(input);	//convert input to int
		
		//create the panel with the user's input
		Shapes panel = new Shapes( choice ); //ÆÐ³Î °´Ã¼
		JFrame application = new JFrame();	//À©µµ¿ì °´Ã¼
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(300, 300);
		application.setVisible(true);
	}
}

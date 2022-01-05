import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CheckBoxFrame extends JFrame {

	private JTextField textfield;		//displays text in changing fonts
	private JCheckBox boldCheckBox;		//to select/deselect bold
	private JCheckBox italicCheckBox;	//to select/deselect italic
	
	//CheckBoxFrame constructer adds JCheckBoxes to JFrame
	public CheckBoxFrame() {
		super("JCheckBOx Test");
		setLayout(new FlowLayout());	//set frame layout
		
		// set up JTextField and set its font
		textField = new JTextField("Watch the font style change",20);
		textField.setFont(new Font("Serif",Font.PLAIN,14));
		add(textField);		//add textField to JFrame
		
		boldCheckBox = new JCheckBox("Bold");	//create bold checkbox
		italicJCheckBox = new JCheckBox("Italic");	//create italic
		add(boldCheckBox); //add bold checkbox to JFrame
		add(italicCheckBox);	//add italic checkbox to JFrame
		
		//register listeners for JCheckBoxes
		CheckBoxHandler handler = new CheckBoxHandler();
		boldJCheckBox.addItemListener( handler );
		italicJCheckBox.addItemListener( handler );
	//private inner class for ItemListner event handling

	private class CheckBoxHandler implements ItemListener {
		public void itemStateChanged(ItemEvent event)
		{
			Font font = null;	//stores the new font
			
			//determine which CheckBoxes are checked and create Font
			if( boldCheckBox.isSelected() && italicCheckBox.isSelected())
				font = new Font("Serif",Font.BOLD + Font.ITALIC, 14);
			else if (boldCheckBox.isSelected())
				font = new Font("Serif",Font.BOLD, 14);
			else if (italicCheckBox.isSelected())
				font = new Font("Serif",Font.ITALIC, 14);
			else
				font = new Font("Serif",Font.PLAIN, 14);
			
			textField.setFont( font );	//set textField's font
		} //end method itemStateChanged 
	}

}

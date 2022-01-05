//Creating radio buttons using ButtonGroup and JRadioButton.
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class RadioButtonFrame extends JFrame {
	
	private JTextField textField;	//used to display font changes
	private Font plainFont;	//font for plain text
	private Font boldFont; //font for bold text
	private Font italicFont;	//font for italic text
	private JRadioButton	plainJRadioButton;	//selects plain text
	private JRadioButton	boldJRadioButton;	//selects bold text
	private JRadioButton	italicJRadioButton;	//selects italic text
	private JRadioButton	boldItalicJRadioButton;	//bold and italic
	private ButtonGroup radioGroup;	//buttongroup to hond radio buttons
	
	//RadioButtonFrame constructer adds JRadioButtons to JFrame
	public RadioButtonFrame() 
	{
		super( "RadioButton test" );
		setLayout( new FlowLayout() ); //set frame layout
		
		textField = new JTextField( "Watch the ont style change", 25 );
		add(textField); //add textField to JFrame
		
		//create radio buttons
		plainJRadioButton = new JRadioButton("Plain",true);
		boldJRadioButton = new JRadioButton("Bold",false);
		italicJRadioButton = new JRadioButton("Italic",false);
		boldItalicJRadioButton = new JRadioButton("Bold/Italic",false);
		add(plainJRadioButton); //add bold button to JFrame
		add(boldJRadioButton); //add italic button to JFrame
		add(boldItalicJRadioButton); //add bold and italic button to JFrame
		
		//create logical relationshipe between JRadioButtons
		radioGroup = new ButtonGroup();	//create ButtonGroup
		radioGroup.add( plainJRadioButton);	//add plain to group
		radioGroup.add( boldJRadioButton);	//add bold to group
		radioGroup.add( italicJRadioButton);	//add italic to group
		radioGroup.add( boldItalicJRadioButton);	//add bold and italic to group
		
		//create font objects
		plainFont = new font("Serif",Font.PLAIN ,14);
		boldFont = new font("Serif",Font.BOLD ,14);
		italicFont = new font("Serif",Font.ITALIC ,14);
		boldItalicFont = new font("Serif",Font.BOLD + Font.ITALIC ,14);	//set initial font to plain
		
		//register events for JRadioButtons
		plainJRadioButton.addItemListenr(
				new RadioButtonHandler(plainFont));
		boldJRadioButton.addItemListenr(
				new RadioButtonHandler(boldFont));
		italicJRadioButton.addItemListenr(
				new RadioButtonHandler(italicFont));
		boldItalicJRadioButton.addItemListenr(
				new RadioButtonHandler(boldItalicFont));
	}	//end RadioButtonFrame constructor
	
	//private inner class to handle radio button events
	private class RadioButtonHandler implements ItemListener
	{
		private Font font;	//font associated with this listener
		
		public RadioButtonHandler ( Font f )
		{
			font = f;	//set the font of this listener
		}
		
		public void itemStateChanged( ItemEvent event ) 
		{
			textField.setFont;	//set font of textField
		}
	}
}

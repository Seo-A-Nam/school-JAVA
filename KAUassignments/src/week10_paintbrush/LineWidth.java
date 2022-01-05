package week10_paintbrush;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LineWidth extends JPanel {
	
	public static int size = 3;

	private ButtonGroup radioGroup;
	private JRadioButton	three;	
	private JRadioButton	five;
	private JRadioButton	eight;
	private JRadioButton	twelve;
	private JRadioButton	sixteen;
	private JRadioButton	twenty;
	private static int choice;
	
	public LineWidth()
	{
		super();
		setLayout( new FlowLayout() );
		
		three = new JRadioButton("3",true);
		five = new JRadioButton("5",false);
		eight = new JRadioButton("8",false);
		twelve = new JRadioButton("12",false);
		sixteen = new JRadioButton("16",false);
		twenty = new JRadioButton("20",false);
		add(three);
		add(five);
		add(eight);
		add(twelve);
		add(sixteen);
		add(twenty);
		
		radioGroup = new ButtonGroup();
		radioGroup.add(three);
		radioGroup.add(five);
		radioGroup.add(eight);
		radioGroup.add(twelve);
		radioGroup.add(sixteen);
		radioGroup.add(twenty);
		
		three.addItemListener(
				new RadioButtonHandler(three));
		five.addItemListener(
				new RadioButtonHandler(five));
		eight.addItemListener(
				new RadioButtonHandler(eight));
		twelve.addItemListener(
				new RadioButtonHandler(twelve));
		sixteen.addItemListener(
				new RadioButtonHandler(sixteen));
		twenty.addItemListener(
				new RadioButtonHandler(twenty));
	}	
	
	
	private class RadioButtonHandler implements ItemListener
	{
		
		public RadioButtonHandler (JRadioButton B)
		{
			
		}
		
		public void itemStateChanged( ItemEvent event ) 
		{
			if(three.isSelected()) size=3;
			else if(five.isSelected()) size=5;
			else if(eight.isSelected()) size=8;
			else if(twelve.isSelected()) size=12;
			else if(sixteen.isSelected()) size=16;
			else if(twenty.isSelected()) size=20;

			}
			
		}
	}
	

package week10_paintbrush;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;

public class LineColor extends JPanel
{
	private JList colorJList;
	private static final String[] colorNames = {"Black", "Red", "Green", "Blue", "Yellow", "White"};
	private static final Color[] colors = {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.WHITE};
	public static Color selectedColor = Color.BLACK;
	public static int temp = 0 ;
	public LineColor() 
	{
		super();

		setLayout( new FlowLayout());
		
		colorJList = new JList(colorNames);
		colorJList.setVisibleRowCount(5);
		
		colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(colorJList));
		
		colorJList.addListSelectionListener(
				new ListSelectionListener()
				{
					public void valueChanged(ListSelectionEvent event)
					{
						selectedColor = colors[colorJList.getSelectedIndex()];
					}
				}
				);
	}
}

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GUIStart extends JFrame{
	private JButton loginButton;
	
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private ArrayList<JTextField> names = new ArrayList<JTextField>();
	private int size;
	
	public GUIStart() {
		size = Integer.parseInt( JOptionPane.showInputDialog( "How Many Players?" ) );
		
		//setLayout( new FlowLayout() );
		//super.setSize(577, 299); 
		
		for(int i = 0; i < size; i++) {
			labels.add( new JLabel("player " + (i+1) + " : ") );
			labels.get(i).setFont( new Font("Times New Roman", Font.BOLD, 20));
			labels.get(i).setForeground(Color.WHITE);
			labels.get(i).setBounds(10, 10+30*i, 100, 30);
			add(labels.get(i));
			
			names.add(new JTextField("", 20) );
			names.get(i).setFont( new Font("Times New Roman", Font.PLAIN, 20));
			names.get(i).setForeground(Color.BLACK);
			names.get(i).setBounds(110, 10+30*i, 200, 30);
			add(names.get(i));
			
		}
		
		loginButton = new JButton("Start");
	      Font fancyFont = new Font("Arial", Font.BOLD, 20);
	      loginButton.setFont(fancyFont);
	      loginButton.setBackground(new Color(255,0,0));
	      loginButton.setForeground(Color.WHITE);
	      add(loginButton,"South");

			
		
		ButtonHandler handler = new ButtonHandler();
		loginButton.addActionListener( handler );
		
		ImageIcon img = new ImageIcon( getClass().getResource("table.jpg") );
		 JLabel  ImgBox = new JLabel( img );
		 ImgBox.setBounds( 0, 50, img.getIconWidth(), img.getIconHeight() );
		 add( ImgBox ); 
		
	}
	
	private class ButtonHandler implements ActionListener{
		public void actionPerformed( ActionEvent event ) {
			for(int i = 0; i < size; i++) {
				Main.playermap.put(i, names.get(i).getText());
			}
			
			Main.cont = false;
			setVisible(false);
		}
	}
}

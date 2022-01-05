import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.util.ArrayList;
import java.util.Arrays;

public class GUIResult extends JFrame{
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private ArrayList<ArrayList<JButton>> cards = new ArrayList<ArrayList<JButton>>();

	public GUIResult( ArrayList<PlayerInfo> rankers ) {
      Font boldFont = new Font("Times New Roman", Font.BOLD, 16);
      
      //setLayout( new FlowLayout() );
      String text = "";
      int size = rankers.size();
      for (int i=0; i<size; i++) {
    	  labels.add( new JLabel( "Rank "+ (i+1) + " : " + rankers.get(i).getName() +" (" + rankers.get(i).getRank() + ")" ) );
    	  labels.get(i).setForeground(Color.yellow);
    	  labels.get(i).setFont(boldFont);
    	  labels.get(i).setBounds( 10, 12+121*i, 200, 50);
    	  add(labels.get(i));
    	  cards.add( new ArrayList<JButton>() );
    	  
    	  String[] temp = {new String(), new String(), new String(), new String(), new String()};
    	  for (int j=0; j<5; j++) {
    		  temp[j] = rankers.get(i).getHand().get(j).getSuit() + GUI.faceChange.get( rankers.get(i).getHand().get(j).getFace() );
    	  }
    	  Arrays.sort(temp);
    	  
    	  for(int j=0; j<5 ; j++) {
    		  cards.get(i).add( new JButton( temp[j] ) );
          if( (temp[j].contains("�솯") )|| (temp[j].contains("�솱")) )
          {
             //踰꾪듉�뿉 �뱾�뼱媛� �뀓�뒪�듃�뿉 �븯�듃,�떎�씠�븘媛� �엳�쑝硫� 鍮④컯. �뒪�럹�씠�뱶,�겢濡쒕쾭媛� �엳�쑝硫� 寃��젙
        	  cards.get(i).get(j).setForeground(Color.RED);
          }
          cards.get(i).get(j).setFont(boldFont);
          cards.get(i).get(j).setBackground(Color.WHITE);
          cards.get(i).get(j).setPreferredSize(new Dimension(60, 86));
          cards.get(i).get(j).setBounds( 25+75*j, 60+120*i, 60, 86);
          add( cards.get(i).get(j) );
          }
      }
      
      
      
      
      
      ImageIcon img = new ImageIcon( getClass().getResource("board.png") );
      JLabel  ImgBox = new JLabel( img );
	  ImgBox.setBounds( 0, 0, img.getIconWidth(), img.getIconHeight() );
	  add( ImgBox ); 
   }
}
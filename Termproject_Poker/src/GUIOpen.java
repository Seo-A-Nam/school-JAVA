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
import java.util.HashMap;

public class GUIOpen extends JFrame{
	
	
	public String cardChange(PlayingCard Face) {
		return GUI.faceChange.get( Face.getFace() );
		}
		
	
	
   public GUIOpen(PlayerInfo player, int i) {
	   super(player.getName());
	   
	   this.setLocation(1050, 250 + 120*i);
	   
	   	
		
      Font boldFont = new Font("Times New Roman", Font.BOLD, 16);
      
      ArrayList<PlayingCard> hand = player.getHand();
      
      //setLayout( new FlowLayout() );
      
      //JPanel SelectedSet = new JPanel();
      //SelectedSet.setBackground(Color.RED);   //배경색 초록색으로 설정
      //this.add(SelectedSet);
      
      //포커 카드 사이즈: 62 mm × 88 mm
      
      ArrayList<JButton> btns = new ArrayList<JButton>();
      for(int j=0; j<hand.size() ; j++) {
    	  btns.add( new JButton( hand.get(j).getSuit() + GUI.faceChange.get( hand.get(j).getFace() ) ) );
      if( (hand.get(j).toString().contains("♥") )|| (hand.get(j).toString().contains("♦")) )
      {
         //버튼에 들어갈 텍스트에 하트,다이아가 있으면 빨강. 스페이드,클로버가 있으면 검정
    	  btns.get(j).setForeground(Color.RED);
      }
      btns.get(j).setFont(boldFont);
      btns.get(j).setBackground(Color.WHITE);
      btns.get(j).setPreferredSize(new Dimension(62, 88));
      btns.get(j).setBounds( 30+67*j, 10, 62, 88);
      add( btns.get(j) );
      }
      
      
      
      ImageIcon img = new ImageIcon( getClass().getResource("pattern.png") );
		 JLabel  ImgBox = new JLabel( img );
		 ImgBox.setBounds( 0, 0, img.getIconWidth(), img.getIconHeight() );
		 add( ImgBox ); 
   }
}
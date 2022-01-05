import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel extends JPanel{
	public void paintComponent( Graphics g ) //오버라이드
	{
		super.paintComponents(g);	// g : 전달되는 객체, parent 클래스의 컴포넌트 매소드 호출
		
		int width = getWidth();	//total width
		int height = getHeight();	//total height
		
		g.drawLine(0, 0, width,height);
		g.drawLine(0, height, width, 0);
	}
}

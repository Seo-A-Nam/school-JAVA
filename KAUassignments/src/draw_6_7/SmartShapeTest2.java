package draw_6_7;
//6주차 java실습 
//2019125021 남서아
//소프트 2학년
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SmartShapeTest2 {
		public static void main(String[] args) {
		
		int number = 0;
		int change = 0;
		
		String input = JOptionPane.showInputDialog("Enter 1 to draw rectangle\n"+"Enter 2 to draw oval\n"+"Enter 3 to draw line");
		number = Integer.parseInt(input);
		SmartShapes2 panel = new SmartShapes2(number);
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(300,300);
		application.setVisible(true);
		
		while(true) {
		
			String k = JOptionPane.showInputDialog("Which shape you gonna change the color? : \n");
			change = Integer.parseInt(k);
			String C = JOptionPane.showInputDialog("Color: \n");
			//shape 값들 넣고 해당 k 값에 해당하는 순서 shape의 색상 변경
			SmartShapes2 panel2 = new SmartShapes2(number, change, C);
			application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			application.add(panel2);
			application.setSize(300,300);
			application.setVisible(true);
			
			String H = JOptionPane.showInputDialog("Do you want to erase all the shapes? : \n");
				if(H == "yes") {
					SmartShapes2 empty = new SmartShapes2(0); 
					JFrame application2 = new JFrame();
					application2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					application2.setSize(300,300);
					application2.setVisible(true);
					application2.add(empty);
				}
				else {}
			String R = JOptionPane.showInputDialog("Do you want to restore all the shapes? : \n");
				if(R == "yes") {
					//application.add(panel2);
					//application.setSize(300,300);
					//application.setVisible(true);
					panel2.repaint();
				}
				else {}
			}
		
		}
}
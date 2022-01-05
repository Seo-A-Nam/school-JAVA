package draw_6_7;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import java.util.Random;

public class SmartShapes2 extends JPanel {
	
	private Random randomNumbers = new Random();
	private static Myshape[] shapes; //도형의 배열
	private int choice;//
	private String colorchoice;
	private int K;
	private static int x1[] = new int [10];
	private static int x2[] = new int [10];
	private static int y1[] = new int [10];
	private static int y2[] = new int [10];
	
	//creates a panel with random shapes
	public SmartShapes2(int number)
	{
		choice = number;
		setBackground( Color.white );
		
		if(choice==0){
			//setBackground(Color.black);
		}
		else {
			shapes = new Myshape[ 5 + randomNumbers.nextInt(5) ];
			//도형 생성 
			for ( int count = 0; count < shapes.length; count++) {
				//랜덤 좌표값 생성 
				x1[count]= randomNumbers.nextInt(300);//
				y1[count]= randomNumbers.nextInt(300);
				x2[count] = randomNumbers.nextInt(300);
				y2[count] = randomNumbers.nextInt(300);
				//컬러 생성
				Color color = new Color(0,0,0);
				shapes[ count ] = new Myshape(x1[count], y1[count], x2[count], y2[count], color);
			
			}
	}
	}
	public SmartShapes2(int number, int change, String C)
	{
		choice = number;
		colorchoice = C;
		K = change-1;
		setBackground( Color.white );
		
		switch (colorchoice) {
			case "red" : Color red = new Color(255,0,0);
				shapes[K] = new Myshape(x1[K], y1[K], x2[K], y2[K], red);
				break;
			case "green" : Color green = new Color(0,255,0);
				shapes[K] = new Myshape(x1[K], y1[K], x2[K], y2[K], green);	
				break;
			case "blue" : Color blue = new Color(0,0,255);
				shapes[K] = new Myshape(x1[K], y1[K], x2[K], y2[K], blue);	
				break;
			case "yellow" : Color yellow = new Color(255,255,0);
				shapes[K] = new Myshape(x1[K], y1[K], x2[K], y2[K], yellow);
				break;
			case "black" : Color black = new Color(0,0,0);
				shapes[K] = new Myshape(x1[K], y1[K], x2[K], y2[K], black );
				break;
			
			
			}
	}

	public void paintComponent(Graphics g){
		{	
			super.paintComponent(g);
			for ( Myshape shape : shapes )
				shape.draw(g,choice);
		}
}
}

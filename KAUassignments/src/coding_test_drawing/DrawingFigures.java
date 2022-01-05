package coding_test_drawing;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
//프로그래밍 시험1 java 
/*
1. 사용자로부터 도형의 갯수(1부터 40까지)를 입력받는다.
2. 주어진 갯수의 도형을 600x400 크기의 자신의 이름을 가진 윈도우 내부에 그린다.
3. 도형은 지정된 갯수가 다 찰 때까지 원, 정사각형, 직선을 차례로 돌아가며 그린다. 예를
들어, 4를 입력했다면 화면에는 원, 사각형, 직선, 원이 함께 나타난다.
4. 각 도형은 50x50 크기의 투명한 bounding rectangle 안에 내접하여 그린다. 또한, 도형
과 도형 사이에는 10 pixel의 간격을 둔다.
5. 사용자는 위 작업을 반복할 수 있다.
6. 위 요구사항을 위배하지 않는 한 다른 내용은 마음대로 선택하거나 결정할 수 있다.*/
//도형 크기 같음. 간격 일정. 그러면 출력하는 도형의 순서와 그 저장 문제인 듯

public class DrawingFigures {
	public static void main(String[] args) 
	{
		int sum=0;
		int count=0;//카운트(1-40)
		while(true) {
				String input = JOptionPane.showInputDialog("Enter the number of figures to draw(1-40)");
				count = Integer.parseInt(input);
				JFrame application = new JFrame();
				application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Draw board = new Draw(count,sum);
				application.add(board);
				application.setSize(600,400);
				application.setVisible(true);
				sum+=count;
			}
		}
	}
	


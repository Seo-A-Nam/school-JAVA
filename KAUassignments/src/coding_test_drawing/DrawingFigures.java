package coding_test_drawing;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
//���α׷��� ����1 java 
/*
1. ����ڷκ��� ������ ����(1���� 40����)�� �Է¹޴´�.
2. �־��� ������ ������ 600x400 ũ���� �ڽ��� �̸��� ���� ������ ���ο� �׸���.
3. ������ ������ ������ �� �� ������ ��, ���簢��, ������ ���ʷ� ���ư��� �׸���. ����
���, 4�� �Է��ߴٸ� ȭ�鿡�� ��, �簢��, ����, ���� �Բ� ��Ÿ����.
4. �� ������ 50x50 ũ���� ������ bounding rectangle �ȿ� �����Ͽ� �׸���. ����, ����
�� ���� ���̿��� 10 pixel�� ������ �д�.
5. ����ڴ� �� �۾��� �ݺ��� �� �ִ�.
6. �� �䱸������ �������� �ʴ� �� �ٸ� ������ ������� �����ϰų� ������ �� �ִ�.*/
//���� ũ�� ����. ���� ����. �׷��� ����ϴ� ������ ������ �� ���� ������ ��

public class DrawingFigures {
	public static void main(String[] args) 
	{
		int sum=0;
		int count=0;//ī��Ʈ(1-40)
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
	


package ch;
import java.awt.event.*;
import javax.swing.*;

public class EventHandler implements ActionListener {

	public Order ordering; // �����ϰ� �� ���
  
	public void actionPerformed(ActionEvent event)
	{
		int i = Integer.parseInt(event.getActionCommand()); // �Է¹��� �׼� Ŀ�ǵ��� ���� ��Ƽ�� ���·� ��ȯ�Ѵ�.
		switch(i) // ����Ʈ���� �����ߴ� �Ͱ� ���������� 10������ ����� ��ü�� �׸��°�
		{		  // 20������ ����� ������ ���õ� ������ ���� ������Ʈ�� ���� ó���Ͽ����ϴ�.
		case 11 :
			ordering = new DrawLine();
			break;
		case 12 :
			ordering = new DrawOval();
			break;
		case 13 :
			ordering = new DrawBrush();
			break;
		case 14 :
			ordering = new DrawRect();
			break;
		case 15 :
			ordering = new DrawString();
			break;
		case 21 :
			ordering = new EditFill();
			break;
		case 22 :
			ordering = new EditResize();
			break;
		case 23 :
			ordering = new EditMove();
		    break;
		case 24 :
			ordering = new EditPaste();
			break;
		case 25 :
			ordering = new EditSelect();
			break;
		}  		
	}		
}

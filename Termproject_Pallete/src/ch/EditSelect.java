package ch;

import java.awt.*;

public class EditSelect extends Order {
	
		// ���콺�� ���� ������ ��	
    private Shape s;			// �̵��� ����
 
  	public void mouseClickExe(Point p, Drawing Layer)
  	{
		// ���콺�� ������ �� ���� ���� �����ϴ� �����߿�
		// ���� �տ� �ִ� ������ ã�´�.
		s = Layer.getTopShape(p);
		if(Layer.isEditing()==true){ // ���� �������̸�
			((Shape) Layer.getDrawing().get(Layer.getEditIndex())).setSelect(false); // ���������Ѵ�.
			
		}
			
    		if (s != null&&Layer.isEditing()==false){	 // �������̾ƴϸ�	
	        s.setSelect(true);// ������ ������
    		}// ���콺�� ������ �� Ŀ���� ��ġ�� ����
  	}
  
	
}

package ch;
// OrderPaste.java
import java.awt.*;

import javax.swing.*;

public class EditPaste extends Order {	
	// ������ �ٿ��ִ´�.

    public void mouseClickExe(Point p, Drawing Layer)
    {
	  Layer.add( Layer.paste(p));  // ������ �����Ѵ�.
	  if(Layer.isEditing()==true){ // ���� ���õ� ��ü�� �ִٸ�
		((Shape) Layer.getDrawing().get(Layer.getEditIndex())).setSelect(false); // ������ ������Ų��.
		
	}
	}

}


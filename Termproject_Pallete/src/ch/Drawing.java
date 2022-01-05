package ch;
// Drawing.java
import java.util.*;
import java.awt.*;
import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Drawing implements Serializable {

	private Vector saveSpace; // Shape�� ������ Vector����
	private Color nowColor; // ���� ����
    private int EditingIndex; // ���� ������ ��ü�� Vector �ε���
	private Shape doTemp, copyTemp, pasteTemp; // ����, �ٿ��ֱ��� �ӽ� Shape
	int imgflag;
	public ImageIcon img;
	// ������ ������ Vector�� �����ϰ� ����� �� ��Ÿ���� �ʱ�ȭ �Ѵ�.
	public Drawing(Color init_color) {
		saveSpace = new Vector();
		nowColor = init_color;
		imgflag = 0;
	}
	// ������ �����Ѵ�.
	public void setColor(Color color) {
		nowColor = color;
	}
	// ���� ������ ��´�
	public Color getColor() {
		return nowColor;
	}
	// �Է¹��� �ε����� Shape�� ���´�.
	public Shape getShape(int i)
	{
		return (Shape) saveSpace.get(i);
	}
	// ���õ� ��ü�� �����Ѵ�.
    public void delete()
    {
    	saveSpace.remove(getEditIndex());
    }
	// ������ ���Ϳ� �����Ѵ�.
	public void add(Shape s) {
		saveSpace.add(s);
	}
	// ���Ͱ����� ����� ������ ó������ �����ͼ� �׸���.
	
	public void setImg(ImageIcon img)
	{
		imgflag = 1;
		this.img = img;
	}
	
	public void draw(Graphics g) {
		if(imgflag == 1)
		{
			g.drawImage(img.getImage(), 0,0, null);
		}
		for (int i = 0; i < saveSpace.size(); i++)
			((Shape) saveSpace.get(i)).draw(g);
	}
	// ���õ� ��ü�� �ε����� ���´�.
	public int getEditIndex()
	{
		for (int i =0; i <= saveSpace.size() - 1; i++)
			if (((Shape) saveSpace.get(i)).getSelect()==true) 
			 return i;
			return 0;
	}
	// ���� �۾����� �ε����� ���´�.
	public int getNowIndex(Shape s)
	{
		for (int i =0; i <= saveSpace.size() - 1; i++)
		    if(i==saveSpace.indexOf((Shape) s))
			 return i;
			return 0;
	}
	// ��ü�� ���� ������ �Ǵ��Ѵ�.
    public boolean isEditing()
    {
    	if(saveSpace.isEmpty()==true||((Shape) saveSpace.get(getEditIndex())).getSelect()==false)
    	   return false;
    	return true;
    }
	// ���͸� ���� �ֱ��� �ε������� �˻��Ͽ� ���� ���콺 Ŀ���� ��ġ�� ���� �ִ� ������ �����Ѵ�.
	public Shape getTopShape(Point p) {
		for (int i = saveSpace.size() - 1; i >= 0; i--)
			// for���� �Ųٷ� ������.
			if (((Shape) saveSpace.get(i)).containsPoint(p)) 
			return (Shape) saveSpace.get(i); // ���;ȿ� ����Ǿ� �ִ� ������ �����Ѵ�.
	
		return null;
	}
	// ��ü�� ��������
   public void deselect(){
   	doTemp = (Shape) saveSpace.lastElement(); // ���� s�� ����Ǿ� �ִ� ��ġ�� ��´�.
	doTemp.setSelect(false);
   	}
	// Vector Ŭ������ indexOf�� remove�� �̿��Ͽ� ���� s�� �����.
	public void remove(Shape s) {
		int index = saveSpace.indexOf(s); // ���� s�� ����Ǿ� �ִ� ��ġ�� ��´�.
		if (index >= 0)
			saveSpace.remove(index); // saveSpace�迭���� �����.
	}
	// saveSpace �迭�� ��� ����.
	public void newShape() {
		saveSpace.removeAllElements();
		copyTemp = null;
		pasteTemp = null;
	}
	// Vector ������ �ڿ������� ��ü�� �ϳ��� �����.
    public void undo(){
        saveSpace.remove(saveSpace.indexOf(saveSpace.lastElement()));
    }
	// Shape s�� Clone()�ؼ� copyTemp�� �����Ѵ�.
	public void copy(Shape s) {
		try {
			copyTemp = (Shape) s.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	// Shape s�� Clone()�ؼ� copyTemp�� ������ �� �� ���� s�� �����Ѵ�
	public void cut(Shape s) {
		try {
			copyTemp = (Shape) s.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		int index = saveSpace.indexOf(s); // ���� s�� ����Ǿ� �ִ� ��ġ�� ��´�.
		if (index >= 0)
			saveSpace.remove(index); // saveSpace�迭���� �����.
	}
	// ���õ� ��ü�� �� �ڷ� ������,
	public void moveToBack(Shape s)
  	{
    		int index = saveSpace.indexOf(s);    // ���� s�� ����Ǿ� �ִ� ��ġ�� �˾Ƴ���
    		if (index >= 0)
    		{
      		saveSpace.remove(index);      	 // ���� s�� �����Ŀ�
			saveSpace.add(0, s);

    		}    		
  	}
	// copyTemp�� ����� Shape�� Clone()�Ͽ� pasteTemp�������� saveSpace�� �ǵڿ� ���Ѵ�.
	public Shape paste(Point p) {
		copyTemp.setLeftPoint(p.x); // copyTemp�� (x, y) ��ǥ�� ���콺 Ŭ�� ��ġ�� ����
		copyTemp.setTopPoint(p.y);

		try {
			pasteTemp = (Shape) copyTemp.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		 // pasteTemp�� saveSpace �ǵڿ� ���Ѵ�.
		return pasteTemp;
	}
	// ���콺�� �巡�� �Ǵ� ���� �׷��� ������ �߿�
	// ���� �������� �׷��� �κ������� ���ܳ��´�.
	public void remainEndshape(Shape s) {
		if (saveSpace.size() > 0) // �׸� �׸��� ������
		{
			saveSpace.remove(saveSpace.lastElement());
			saveSpace.add(s);
		}
	}
	// saveSpace�� ��´�.
	public Vector getDrawing() {
		return saveSpace;
	}
	// saveSpace�� save�� �����Ѵ�.
	public void setDrawing(Vector save) {
		saveSpace = save;
	}
	
 
  
}
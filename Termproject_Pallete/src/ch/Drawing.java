package ch;
// Drawing.java
import java.util.*;
import java.awt.*;
import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Drawing implements Serializable {

	private Vector saveSpace; // Shape를 저장할 Vector공간
	private Color nowColor; // 현재 색깔
    private int EditingIndex; // 현재 선택한 객체의 Vector 인덱스
	private Shape doTemp, copyTemp, pasteTemp; // 복사, 붙여넣기의 임시 Shape
	int imgflag;
	public ImageIcon img;
	// 도형을 저장할 Vector를 생성하고 색깔과 선 스타일을 초기화 한다.
	public Drawing(Color init_color) {
		saveSpace = new Vector();
		nowColor = init_color;
		imgflag = 0;
	}
	// 색깔을 설정한다.
	public void setColor(Color color) {
		nowColor = color;
	}
	// 현재 색깔을 얻는다
	public Color getColor() {
		return nowColor;
	}
	// 입력받은 인덱스의 Shape를 얻어온다.
	public Shape getShape(int i)
	{
		return (Shape) saveSpace.get(i);
	}
	// 선택된 객체를 삭제한다.
    public void delete()
    {
    	saveSpace.remove(getEditIndex());
    }
	// 도형을 백터에 저장한다.
	public void add(Shape s) {
		saveSpace.add(s);
	}
	// 백터공간에 저장된 도형을 처음부터 가져와서 그린다.
	
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
	// 선택된 객체의 인덱스를 얻어온다.
	public int getEditIndex()
	{
		for (int i =0; i <= saveSpace.size() - 1; i++)
			if (((Shape) saveSpace.get(i)).getSelect()==true) 
			 return i;
			return 0;
	}
	// 현재 작업중인 인덱스를 얻어온다.
	public int getNowIndex(Shape s)
	{
		for (int i =0; i <= saveSpace.size() - 1; i++)
		    if(i==saveSpace.indexOf((Shape) s))
			 return i;
			return 0;
	}
	// 객체의 선택 유무를 판단한다.
    public boolean isEditing()
    {
    	if(saveSpace.isEmpty()==true||((Shape) saveSpace.get(getEditIndex())).getSelect()==false)
    	   return false;
    	return true;
    }
	// 백터를 가장 최근의 인덱스부터 검색하여 현재 마우스 커서가 위치한 점에 있는 도형을 리턴한다.
	public Shape getTopShape(Point p) {
		for (int i = saveSpace.size() - 1; i >= 0; i--)
			// for문을 거꾸로 돌린다.
			if (((Shape) saveSpace.get(i)).containsPoint(p)) 
			return (Shape) saveSpace.get(i); // 벡터안에 저장되어 있는 도형을 리턴한다.
	
		return null;
	}
	// 객체의 선택해제
   public void deselect(){
   	doTemp = (Shape) saveSpace.lastElement(); // 도형 s가 저장되어 있는 위치를 얻는다.
	doTemp.setSelect(false);
   	}
	// Vector 클래스의 indexOf와 remove를 이용하여 도형 s를 지운다.
	public void remove(Shape s) {
		int index = saveSpace.indexOf(s); // 도형 s가 저장되어 있는 위치를 얻는다.
		if (index >= 0)
			saveSpace.remove(index); // saveSpace배열에서 지운다.
	}
	// saveSpace 배열을 모두 비운다.
	public void newShape() {
		saveSpace.removeAllElements();
		copyTemp = null;
		pasteTemp = null;
	}
	// Vector 공간의 뒤에서부터 객체를 하나씩 지운다.
    public void undo(){
        saveSpace.remove(saveSpace.indexOf(saveSpace.lastElement()));
    }
	// Shape s를 Clone()해서 copyTemp에 저장한다.
	public void copy(Shape s) {
		try {
			copyTemp = (Shape) s.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	// Shape s를 Clone()해서 copyTemp에 저장한 후 그 도형 s를 삭제한다
	public void cut(Shape s) {
		try {
			copyTemp = (Shape) s.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		int index = saveSpace.indexOf(s); // 도형 s가 저장되어 있는 위치를 얻는다.
		if (index >= 0)
			saveSpace.remove(index); // saveSpace배열에서 지운다.
	}
	// 선택된 객체를 맨 뒤로 보낸다,
	public void moveToBack(Shape s)
  	{
    		int index = saveSpace.indexOf(s);    // 도형 s가 저장되어 있는 위치를 알아내고
    		if (index >= 0)
    		{
      		saveSpace.remove(index);      	 // 도형 s를 지운후에
			saveSpace.add(0, s);

    		}    		
  	}
	// copyTemp에 저장된 Shape를 Clone()하여 pasteTemp저장한후 saveSpace의 맨뒤에 더한다.
	public Shape paste(Point p) {
		copyTemp.setLeftPoint(p.x); // copyTemp의 (x, y) 좌표를 마우스 클릭 위치로 설정
		copyTemp.setTopPoint(p.y);

		try {
			pasteTemp = (Shape) copyTemp.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		 // pasteTemp를 saveSpace 맨뒤에 더한다.
		return pasteTemp;
	}
	// 마우스가 드래그 되는 동안 그려진 도형들 중에
	// 가장 마지막에 그려진 부분을만을 남겨놓는다.
	public void remainEndshape(Shape s) {
		if (saveSpace.size() > 0) // 그린 그림이 있으면
		{
			saveSpace.remove(saveSpace.lastElement());
			saveSpace.add(s);
		}
	}
	// saveSpace를 얻는다.
	public Vector getDrawing() {
		return saveSpace;
	}
	// saveSpace를 save로 설정한다.
	public void setDrawing(Vector save) {
		saveSpace = save;
	}
	
 
  
}
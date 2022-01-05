package week10_paintbrush;

import java.awt.Point;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

//마우스를 이용해 자유롭게 그림 그림
//선 색 선택 가능(ListWidget)
//선의 두께 선택(RadioButton)
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;

public class PaintBrush extends JPanel
{
   private int pointCount = 0;
   private int count = 0;
   private paint[] points = new paint[10000];
   public PaintBrush()
   {
      setBackground(Color.WHITE);
      addMouseMotionListener(
            
            new MouseMotionAdapter()
            {
               public void mouseDragged(MouseEvent event)
               {
                  if (pointCount < points.length)
                  {
                     points[pointCount] = new paint(event.getPoint().x, event.getPoint().y, LineWidth.size, LineColor.selectedColor);
                     pointCount++;
                     repaint();
                  }
               }
            }
      );
   }
public class paint
{
   public Color color;
   public int x, y, size;
   public paint(int x, int y, int size, Color color)
   {
      this.x = x;
      this.y = y;
      this.size = size;
      this.color = color;
   }
}   
   
   public void paintComponent(Graphics g)
   {   
      super.paintComponent(g);
      for(int i = 0; i < pointCount; i++) 
      {
         g.setColor(points[i].color);
         g.fillOval(points[i].x, points[i].y, points[i].size, points[i].size);
      }
      
   }
}
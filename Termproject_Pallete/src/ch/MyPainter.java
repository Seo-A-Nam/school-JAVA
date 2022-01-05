package ch;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputListener;	//	MouseListener + MouseMotionListener
import javax.swing.filechooser.FileNameExtensionFilter;




public class MyPainter extends JFrame implements ActionListener {
	
	
	
	
	private EventHandler eventhandle; // ��� �ֿ��̺�Ʈ���� ������ �̺�Ʈ�ڵ鷯�� ��ü
	private final Color firstColor = Color.BLACK; //�⺻���� ���� ������ ����
	private static Order ordering;         					// ����� ���
	private Drawing Layer; 					// ��ɿ� ���� �׸��� �׸� ��ü
	private Pointlocation pointlocation; //���� Ŀ���� ��ġ�� �˷��ִ� �г�.
	private JPanel nowColorPanel;   //������� �����ִ� �гΰ�ü.
	private JPanel ToolBar_Pallet_text;   //�ȷ�Ʈ�� �ٲ��ִ� ��ư������ �� �г�.
	private CardLayout pallets;       //ī�巹�̾ƿ��� ��ü.(.next()�޼ҵ带 ��������) 			
	private JPanel ToolBar_Pallet_pallet; //3���� �ȷ�Ʈ�г��� �����ϴ� ��ü �ȷ�Ʈ�����г�.
	private JLabel helptext; //���� ���� ǥ������ ��.
	private JFrame gradientFrame; //�׶���Ʈ ������
	private static MyPainter application; 
	public static TextField str;
	//���ٹ�ư
	
	private JButton selectButton, CurveButton, lineButton, rectButton, ovalButton, polyButton, resizeButton, moveButton, deleteButton, 
					cutButton, addStringButton, pasteButton, copyButton, fillcolorButton, undoButton, backButton;
			
	//�ȷ�Ʈ��ư.		
	
	//�޴�
 	private JMenu fileMenu, Edit, Help;
 	//�޴�������.
 	private JMenuItem newItem, selectItem, openItem, saveItem, saveAsItem, exitItem, 
					moveItem, resizeItem, cutItem, copyItem, pasteItem, deleteItem, colorchooseItem, helpItem, About;
	//DrawPanel. ���� �׸��� �׷����� ĵ���������� �ϴ� �г�.				
	public CustomPanel DrawPanel;
	
	//��������� ����.
	private JFileChooser fileChoose = new JFileChooser();
	private String fileName = "�������.cha";
	private File saveFile;
	
	//�����Լ�.
	
	public static void main(String args[])
	{
		application = new MyPainter();
		application.setVisible(true);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                       
	}
	
	// CharismaPainter ������. �гε�� ��ư�� �����ϰ� ��ġ
 
	public MyPainter()
	{
		super();
		eventhandle = new EventHandler();	
		setTitle(fileName);		// JFrame �ʱ�ȭ
		
		
		//������ ��Ÿ�Ϸ� ����� ����.-----------
		
		try { 
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
			SwingUtilities.updateComponentTreeUI(this); 
		} 
		catch (Exception e) { }
		
		//---------------------------------------
		
		
 		ordering = new Order();          		// ����� ������ ��ü ����
 		Layer = new Drawing(firstColor);    // ���� �׸��� ������ ��ü ���� 
 		Color ColorDesign = new Color(232,232,233); //��ü�������� ���� RGB�� ����
 		
 		
 		//���� �޴�
		fileMenu = new JMenu("����(F)");
		fileMenu.setMnemonic('f');
		fileMenu.setBackground(ColorDesign);
				
		newItem = new JMenuItem("���� �����(N)", new ImageIcon("New.jpg"));
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		newItem.setBackground(ColorDesign);
		newItem.addActionListener(this);
		fileMenu.add(newItem);
		
		
		openItem = new JMenuItem("����(O)", new ImageIcon("Open.jpg"));
		openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		openItem.setBackground(ColorDesign);
		openItem.addActionListener(this);
		fileMenu.add(openItem);
		
		
		saveItem = new JMenuItem("����(S)", new ImageIcon("Save.jpg"));
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		saveItem.setBackground(ColorDesign);
		saveItem.addActionListener(this);
		fileMenu.add(saveItem);
		
		
		saveAsItem = new JMenuItem("�ٸ� �̸����� ����");
		saveAsItem.setBackground(ColorDesign);
		saveAsItem.addActionListener(this);
		fileMenu.add(saveAsItem);
		
		
		exitItem = new JMenuItem("����");
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
		exitItem.setBackground(ColorDesign);
		exitItem.addActionListener(this);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);	
		
		
		
		// ���� �޴�(����, �̵�, ��������, ����, �߶󳻱�, �ٿ��ֱ�, �����ϱ�, ������)	
		Edit = new JMenu("����(E)");
		Edit.setBackground(ColorDesign);
		Edit.setMnemonic('e');
		
		selectItem = new JMenuItem("�����ϱ�");
		selectItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		selectItem.setBackground(ColorDesign);
		selectItem.addActionListener(eventhandle);
		selectItem.setActionCommand("26");
		Edit.add(selectItem);
		
		moveItem = new JMenuItem("�̵��ϱ�");
		moveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		moveItem.setBackground(ColorDesign);
		moveItem.addActionListener(eventhandle);
		moveItem.setActionCommand("26");
		Edit.add(moveItem);
		
		resizeItem = new JMenuItem("ũ�� ����");
		resizeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		resizeItem.setBackground(ColorDesign);
		resizeItem.addActionListener(eventhandle);
		resizeItem.setActionCommand("24");
		Edit.add(resizeItem);
		
		copyItem = new JMenuItem("�����ϱ�");
		copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		copyItem.setBackground(ColorDesign);
		copyItem.addActionListener(eventhandle);
		copyItem.setActionCommand("23");
		Edit.add(copyItem);
		
		cutItem = new JMenuItem("�߶󳻱�");
		cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
		cutItem.setBackground(ColorDesign);
		cutItem.addActionListener(eventhandle);
		cutItem.setActionCommand("22");
		Edit.add(cutItem);
				
			
		pasteItem = new JMenuItem("�ٿ��ֱ�");
		pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		pasteItem.setBackground(ColorDesign);
		pasteItem.addActionListener(eventhandle);
		pasteItem.setActionCommand("27");
		Edit.add(pasteItem);
		
		deleteItem = new JMenuItem("�����ϱ�");
		deleteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		deleteItem.setBackground(ColorDesign);
		deleteItem.addActionListener(eventhandle);
		deleteItem.setActionCommand("25");
		Edit.add(deleteItem);
		
		
		
		
		
			
		// ���� �޴�	
		Help = new JMenu("����(H)");
		Help.setBackground(ColorDesign);
		Help.setMnemonic('h');
		
		helpItem = new JMenuItem("����");
		helpItem.setBackground(ColorDesign);
		helpItem.addActionListener(this);
		Help.add(helpItem);
		
		
		About = new JMenuItem("About..");
		About.setBackground(ColorDesign);
		About.addActionListener(this);
		Help.add(About);
		
		
		//�޴��� ����.
		JMenuBar menuBar = new JMenuBar();		
		menuBar.setBackground(ColorDesign);
		menuBar.add(fileMenu);
		menuBar.add(Edit);
		menuBar.add(Help);
		setJMenuBar(menuBar);
						
		//Toolbar
		//������ ��GUI
				
		int demension_width = 180;
		Dimension IconSize = new Dimension(demension_width,25);
		
		JPanel ToolBar = new JPanel();
		ToolBar.setBackground(ColorDesign);
		ToolBar.setBorder(BorderFactory.createLoweredBevelBorder());
		JPanel ToolBar_Tool = new JPanel();
		ToolBar.setBackground(ColorDesign);
		ToolBar_Tool.setLayout(new BorderLayout());
		JPanel ToolBar_Tool_text = new JPanel();
		JPanel ToolBar_Tool_tool = new JPanel();
		ToolBar_Tool_tool.setBackground(ColorDesign);
		
		ToolBar_Tool_text.setBorder(BorderFactory.createRaisedBevelBorder());
		JLabel Tool_text = new JLabel("���� ����");
     	ToolBar_Tool_text.add(Tool_text);
     	ToolBar_Tool_text.setBackground(ColorDesign);
     	ToolBar_Tool.add(ToolBar_Tool_text, BorderLayout.NORTH);
			
		ToolBar_Tool_tool.setBorder(BorderFactory.createRaisedBevelBorder());
		ToolBar_Tool_tool.setLayout(new GridLayout(14,1));
     	ToolBar_Tool_tool.setCursor(new Cursor(Cursor.HAND_CURSOR));
     
                    		
		//��ư�� �����ϰ� �����ϴ� �κ�.���콺��Ǹ����ʿ� ���콺��Ǿ���ͷ� ���µ���ǥ������ ����.
		
     	CurveButton = new JButton("������ �׸���");
     	CurveButton.setBackground(ColorDesign);
     	CurveButton.setToolTipText("������ �׸���");
     	CurveButton.setPreferredSize(IconSize);
     	CurveButton.addActionListener(eventhandle);
     	CurveButton.setActionCommand("13");
     	CurveButton.addMouseMotionListener
     	(
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent event)
                {
                    if ( ( event.getX() > 0 && event.getX() < demension_width ) && ( event.getY() > 0 && event.getY() < 25 ) )
                    {
                        helptext.setText("ĵ����â�� �巡���Ͽ� ���ϴ� ���� �׸��ϴ�.");
                    }
                }
                
                
            }
    	);
		ToolBar_Tool_tool.add(CurveButton);  
     	
		lineButton = new JButton("���� �׸���");
		lineButton.setBackground(ColorDesign);
		lineButton.setToolTipText("���׸���");
		lineButton.setPreferredSize(IconSize);
		lineButton.addActionListener(eventhandle);
		lineButton.setActionCommand("11");
		lineButton.addMouseMotionListener
     	(
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent event)
                {
                    if ( ( event.getX() > 0 && event.getX() < demension_width ) && ( event.getY() > 0 && event.getY() < 25 ) )
                    {
                        helptext.setText("ĵ����â�� �巡���Ͽ� ���� �׸��ϴ�.");
                    }
                }
                
                
            }
    	);
		ToolBar_Tool_tool.add(lineButton);  
		
		
		
		
        ovalButton = new JButton("��");
     	ovalButton.setBackground(ColorDesign);
     	ovalButton.setToolTipText("���׸���");
     	ovalButton.setPreferredSize(IconSize);
     	ovalButton.addActionListener(eventhandle);
     	ovalButton.setActionCommand("12");
     	ovalButton.addMouseMotionListener
     	(
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent event)
                {
                    if ( ( event.getX() > 0 && event.getX() < demension_width ) && ( event.getY() > 0 && event.getY() < 25 ) )
                    {
                        helptext.setText("ĵ����â�� �巡���Ͽ� Ÿ���� �׸��ϴ�. (+ shiftŰ - ���׸���)");
                    }
                }
                
                
            }
    	);
     	ToolBar_Tool_tool.add(ovalButton); 
     
     	rectButton = new JButton("�簢��");
     	rectButton.setBackground(ColorDesign);
     	rectButton.setToolTipText("�簢���׸���");
     	rectButton.setPreferredSize(IconSize);
     	rectButton.addActionListener(eventhandle);
     	rectButton.setActionCommand("14");
     	rectButton.addMouseMotionListener
     	(
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent event)
                {
                    if ( ( event.getX() > 0 && event.getX() < demension_width ) && ( event.getY() > 0 && event.getY() < 25 ) )
                    {
                        helptext.setText("ĵ����â�� �巡���Ͽ� �׸� �׸��ϴ�. (+ shiftŰ - ���簢���׸���)");
                    }
                }
                
                
            }
    	);
     	ToolBar_Tool_tool.add(rectButton);
     	
     	selectButton = new JButton("��ü ����");
		selectButton.setBackground(ColorDesign);
		selectButton.setToolTipText("��ü ����");
		selectButton.setPreferredSize(IconSize);
		selectButton.addActionListener(eventhandle);
		selectButton.setActionCommand("25");
		selectButton.addMouseMotionListener
     	(
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent event)
                {
                    if ( ( event.getX() > 0 && event.getX() < demension_width ) && ( event.getY() > 0 && event.getY() < 25 ) )
                    {
                        helptext.setText("������ ���ϴ� ���� ���� Ŭ���� �Ͽ� ���� ��� ������ �����մϴ�.(Alt + S)");
                    }
                }
                
                
            }
    	);
    	ToolBar_Tool_tool.add(selectButton);
	 
     	moveButton = new JButton("�̵�");
     	moveButton.setBackground(ColorDesign);
     	moveButton.setToolTipText("�̵�");
     	moveButton.setPreferredSize(IconSize);
     	moveButton.addActionListener(eventhandle);
     	moveButton.setActionCommand("23");
     	moveButton.addMouseMotionListener
     	(
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent event)
                {
                    if ( ( event.getX() > 0 && event.getX() < demension_width ) && ( event.getY() > 0 && event.getY() < 25 ) )
                    {
                        helptext.setText("���õ� ������ �̵��մϴ�.(Ctrl + M)");
                    }
                }
            }
    	);
     	ToolBar_Tool_tool.add(moveButton); 
     
     	resizeButton = new JButton("ũ�� ����");
     	resizeButton.setBackground(ColorDesign);
     	resizeButton.setToolTipText("ũ�� ����");
     	resizeButton.setPreferredSize(IconSize);
     	resizeButton.addActionListener(eventhandle);
     	resizeButton.setActionCommand("22");
     	resizeButton.addMouseMotionListener
     	(
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent event)
                {
                    if ( ( event.getX() > 0 && event.getX() < demension_width ) && ( event.getY() > 0 && event.getY() < 25 ) )
                    {
                        helptext.setText("���õ� ������ ũ�⸦ �����մϴ�.(Ctrl + R)");
                    }
                }
            }
    	);
     	ToolBar_Tool_tool.add(resizeButton);
     
     	cutButton = new JButton("�߶󳻱�");
     	cutButton.setBackground(ColorDesign);
     	cutButton.setToolTipText("�߶󳻱�");
    	cutButton.setPreferredSize(IconSize);
    	cutButton.addActionListener(this);
    	cutButton.addMouseMotionListener
     	(
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent event)
                {
                    if ( ( event.getX() > 0 && event.getX() < demension_width ) && ( event.getY() > 0 && event.getY() < 25 ) )
                    {
                        helptext.setText("���õ� ������ �����, ���Ŀ� �ٿ��ֱ��ϸ� �� ������ ���Դϴ�.(Alt + C)");
                    }
                }
            }
    	);
     	ToolBar_Tool_tool.add(cutButton); 
     
     	copyButton = new JButton("�����ϱ�");
     	copyButton.setBackground(ColorDesign);
     	copyButton.setToolTipText("�����ϱ�");
     	copyButton.setPreferredSize(IconSize);
     	copyButton.addActionListener(this);
     	copyButton.addMouseMotionListener
     	(
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent event)
                {
                    if ( ( event.getX() > 0 && event.getX() < demension_width ) && ( event.getY() > 0 && event.getY() < 25 ) )
                    {
                        helptext.setText("���õ� ������ �ٿ��ֱ��� �� ���Դϴ�.(Ctrl + C)");
                    }
                }
            }
    	);
     	ToolBar_Tool_tool.add(copyButton);
     	 pasteButton = new JButton("�ٿ��ֱ�");
 	    pasteButton.setBackground(ColorDesign);
   		pasteButton.setToolTipText("�ٿ��ֱ�");
      	pasteButton.setPreferredSize(IconSize);
      	pasteButton.addActionListener(eventhandle);
      	pasteButton.setActionCommand("24");
      	pasteButton.addMouseMotionListener
      	(
             new MouseMotionAdapter()
             {
                 public void mouseMoved(MouseEvent event)
                 {
                     if ( ( event.getX() > 0 && event.getX() < demension_width ) && ( event.getY() > 0 && event.getY() < 25 ) )
                     {
                         helptext.setText("������ �߶󳻰ų� ������ ������ ĵ����â�� �ٿ��ֽ��ϴ�.(Ctrl + V)");
                     }
                 }
             }
     	);
      	ToolBar_Tool_tool.add(pasteButton);
	    
     
     	deleteButton = new JButton("����");
     	deleteButton.setBackground(ColorDesign);
     	deleteButton.setToolTipText("����");
     	deleteButton.setPreferredSize(IconSize);
     	deleteButton.addActionListener(this);
     	deleteButton.addMouseMotionListener
     	(
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent event)
                {
                    if ( ( event.getX() > 0 && event.getX() < demension_width ) && ( event.getY() > 0 && event.getY() < 25 ) )
                    {
                        helptext.setText("���õ� ������ �����մϴ�.(Ctrl + D)");
                    }
                }
            }
    	);
     	ToolBar_Tool_tool.add(deleteButton);
     	
     	
     
     	fillcolorButton = new JButton("��ä���");
     	fillcolorButton.setBackground(ColorDesign);
     	fillcolorButton.setToolTipText("��ä���");
     	fillcolorButton.setPreferredSize(IconSize);
     	fillcolorButton.addActionListener(eventhandle);
     	fillcolorButton.setActionCommand("21");
     	fillcolorButton.addMouseMotionListener
     	(
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent event)
                {
                    if ( ( event.getX() > 0 && event.getX() < demension_width ) && ( event.getY() > 0 && event.getY() < 25 ) )
                    {
                        helptext.setText("���� ���� ���õ� ������ ä���ֽ��ϴ�.");
                    }
                }
            }
    	);
     	ToolBar_Tool_tool.add(fillcolorButton);
     	
     	
     	ToolBar_Tool.add(ToolBar_Tool_tool, BorderLayout.CENTER);
   	    //������ �ȷ�Ʈ
     	
   		JPanel ToolBar_Width = new JPanel();
     	ToolBar_Width.setLayout(new BorderLayout());
     	LineWidth width = new LineWidth();
     	ToolBar_Width.add(width);
     	//�ȷ�Ʈ�� �ٲ��ִ� �г�.���콺�����ʿ� ���콺����͸� ����� Ŭ�������� �ȷ�Ʈ�� �ٲ��ִ� �̺�Ʈó��.
		
     	
     	str = new TextField(10);
     	addStringButton = new JButton("�ؽ�Ʈ ����");
     	addStringButton.setBackground(ColorDesign);
     	addStringButton.setToolTipText("�ؽ�Ʈ ����");
     	addStringButton.setPreferredSize(IconSize);
     	addStringButton.addActionListener(eventhandle);
     	addStringButton.setActionCommand("15");
     	addStringButton.addMouseMotionListener
     	(
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent event)
                {
                    if ( ( event.getX() > 0 && event.getX() < demension_width ) && ( event.getY() > 0 && event.getY() < 25 ) )
                    {
                        helptext.setText("�Է��� ��Ʈ���� ���ϴ� ��ġ�� Ŭ���ϸ� �����˴ϴ�.");
                    }
                }
            }
    	);
     	ToolBar_Tool_tool.add(str);
     	ToolBar_Tool_tool.add(addStringButton);
     	
             
    	//������ �÷�GUI
     
     	JPanel ToolBar_Color = new JPanel();
     	ToolBar_Color.setBackground(ColorDesign);
     	ToolBar_Color.setBorder(BorderFactory.createRaisedBevelBorder());
     
     	JPanel nowColorWholePanel = new JPanel();
     	nowColorWholePanel.setBackground(ColorDesign);
       
        //������� �����ִ� �г�. ���콺�����ʿ� ���콺����͸� �̿��ؼ� JColorChooser�� �ҷ��´�.
        //���콺��Ǹ����ʿ� ���콺��Ǿ���͸� �̿��� ���µ���ǥ���ٿ� ������� �����ش�.
     	nowColorPanel = new JPanel();
	 	nowColorPanel.setBorder(BorderFactory.createLoweredBevelBorder());	// �׵θ� ����
     	nowColorPanel.setPreferredSize(new Dimension(25, 25));			// ũ�� ����
   	 	nowColorPanel.setBackground(Color.BLACK);
   	 	nowColorPanel.setToolTipText("���� ���� ����");
   	 	nowColorPanel.addMouseListener            
     	(
            new MouseAdapter()
            {
                public void mouseClicked(MouseEvent event) 
                {
                    if ( ( event.getX() > 0 && event.getX() < 25 ) && ( event.getY() > 0 && event.getY() < 25 ) )
                    {
                        Color color = JColorChooser.showDialog(MyPainter.this, "���� ���� �ȷ�Ʈ", firstColor);
			
						if(color == null)
							color = firstColor;
						nowColorPanel.setBackground(color);	
						Layer.setColor(color);	
                    }
                }
            }           
     	);
     
    	nowColorPanel.addMouseMotionListener
     	(
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent event)
                {
                    if ( ( event.getX() > 0 && event.getX() < 25 ) && ( event.getY() > 0 && event.getY() < 25 ) )
                    {
                        nowColorPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        helptext.setText("�� �κ��� ������ ��� ���� ���� â�� �� �� �ֽ��ϴ�.(Ctrl + U)");
                   	}
                
                }
            }
     	);
       
                  	
  	 
  	 	nowColorWholePanel.add(nowColorPanel);
  	 	 	
  	 
	 	JPanel nowcolortextPanel = new JPanel();
	 	nowcolortextPanel.setBackground(ColorDesign);
	 	JLabel nowcolortext = new JLabel("���� ��");
	 	nowcolortextPanel.add(nowcolortext);
		
		
		 		       
     	ToolBar_Color.setLayout(new BorderLayout());
     	ToolBar_Color.add(nowcolortextPanel, BorderLayout.CENTER);        
     	ToolBar_Color.add(nowColorWholePanel, BorderLayout.NORTH);
     
     
     
     
     
     
     	//���ٿ� ����_��, ��Ÿ_�÷� �г� ��ġ.
     	ToolBar.setLayout(new BorderLayout());
     	ToolBar.add(ToolBar_Width, BorderLayout.CENTER);
     	ToolBar.add(ToolBar_Tool, BorderLayout.NORTH);
     	ToolBar.add(ToolBar_Color, BorderLayout.SOUTH);
     
     
     
            
        //���¹�
     
     
        JPanel StatusBar = new JPanel();
        StatusBar.setBackground(ColorDesign);
        StatusBar.setPreferredSize(new Dimension(640,40));
        StatusBar.setBorder(BorderFactory.createLoweredBevelBorder());
     
        JPanel HelpBar = new JPanel();
        HelpBar.setBackground(ColorDesign);
        HelpBar.setBorder(BorderFactory.createRaisedBevelBorder());
        helptext = new JLabel("");
        HelpBar.add(helptext);     
               
        JPanel InnerStatusBar = new JPanel(); 
        InnerStatusBar.setBackground(ColorDesign);
        InnerStatusBar.setBorder(BorderFactory.createRaisedBevelBorder());       
        JLabel locationtext = new JLabel("���� Ŀ�� ��ġ : ");
        InnerStatusBar.add(locationtext);
        pointlocation = new Pointlocation();
        pointlocation.setBackground(ColorDesign);
        InnerStatusBar.add(locationtext);
        InnerStatusBar.add(pointlocation);
     
        StatusBar.setLayout(new BorderLayout());
        StatusBar.add(HelpBar, BorderLayout.CENTER);
        StatusBar.add(InnerStatusBar, BorderLayout.EAST);
     
     
        //�׸��� �׷����� ����.
        DrawPanel = new CustomPanel();
        DrawPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        DrawPanel.setBackground(Color.WHITE);
     
 	 
		
		
		//������ ����.
		addMouseMotionListener
     	(
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent event)
                {
                    if ( ( event.getX() > 0 && event.getX() < 640 ) && ( event.getY() > 0 && event.getY() < 50 ) )
                    {
                        helptext.setText("�޴��� �������ּ���");
                   	}
                   	
                    else if ( ( event.getX() > 0 && event.getX() < 75 ) && ( event.getY() > 50 && event.getY() < 80 ) )
                    {
                        helptext.setText("�� ������ ���� �������ּ���");
                   	}
                   	
                   	                   	
                    else if ( ( event.getX() > 0 && event.getX() < 640 ) && ( event.getY() > 465 && event.getY() < 505 ) )
                    {
                        helptext.setText("�̰����� ���� ���¸� �����ݴϴ�.");
                   	}
                   	               
                                        
                    else
                    	helptext.setText(""); 
                    	//�� �κ��� ������ �ٸ� ���� ��ġ���� �� ���µ���ǥ������ �������� ����������.
                
                }
            }
     	);
     
     //-------------------------------------------------------               
    //�гε��� �����ӿ� ���δ�.
    	
     Container container = getContentPane();
     container.setLayout(new BorderLayout());
     container.add(StatusBar, BorderLayout.SOUTH);
     container.add(DrawPanel, BorderLayout.CENTER);
	 container.add(ToolBar, BorderLayout.WEST);
	 
	 
	 //������ Ÿ��Ʋ�� ũ�� ����.
	 setTitle("My Painter");
     setSize(900,575);
	 
	 // ũ�⺯�� �Ұ�
     //setResizable(false);
             
     // �������� �ʰ� x��ư�� ������ ��쿡 ���� ó��
     addWindowListener(new WindowAdapter()
             { 
                 public void windowClosing(WindowEvent we)
                 { 
                     	if (Layer.getDrawing().isEmpty() == false)
 						{
 							checkForSave();
 						}
                    
                 } 
             }
         );
	}
	private BufferedImage b1 = new BufferedImage(1120,840,BufferedImage.TYPE_3BYTE_BGR); 
	private Graphics g1= b1.getGraphics();;
    //�����Լ�.
	private void Open()
  	{
  		//��ȭ���ڸ� ����.
  		JFileChooser fileChooser = new JFileChooser();

  		FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG(*.png)","png"); //png��������
		FileNameExtensionFilter filter2 = new FileNameExtensionFilter("JPG(*.jpg)","jpg");//jpg��������
		fileChooser.setFileFilter(filter); //png�� jpg�������� ���� ���� �߰�
		fileChooser.setFileFilter(filter2);
  		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
  		int result = fileChooser.showOpenDialog(this);
  		
  		if(result == JFileChooser.CANCEL_OPTION)
  			return;
  			
  		File file = fileChooser.getSelectedFile();
  		System.out.println(file.getName());
  		//����ó��.
  		if((file == null) || (file.getName().equals("")))
  		{
  			JOptionPane.showMessageDialog(this, "�����̸��� �Է����� �����̽��ϴ�!",
  			"�����̸��� �Է����� �����̽��ϴ�!",JOptionPane.ERROR_MESSAGE);
  		}
  		else if(file.getName().contains(".jpg") || file.getName().contains(".png")) {
  			
  			
  			if(result != JFileChooser.CANCEL_OPTION)
  			{
  				System.out.println(file.getPath());
  				Layer.setImg(new ImageIcon(file.getPath()));
  				String filename=file.getName();
  				
  				repaint();
  				//return filename;
  	  			
  			}
  		}
  		else
  		{
  			System.out.println("aaa");
	  		try
			{
				//��ü����ȭ�� ������ �ٽ� ����ȭ�ϰ� Layer�� �� ���͸� �����ϰ� repaint�� DrawPanel�� �ٽ� �׸���.
				ObjectInputStream open = new ObjectInputStream(new FileInputStream(file));
				Vector newobject = (Vector)open.readObject();
				Layer.setDrawing(newobject);
				open.close();
				repaint();
				saveFile = file;
				fileName = saveFile.getName();
				setTitle("���� ���ϸ� : " + fileName + " , ��ġ : " + saveFile.getPath());
			} 
			catch (Exception e) { System.out.println(e); }
  		}
  		
  	}
  	
  	
  	//�����Լ�.
 	private void Save()
  	{
  		//��ȭ����.
  		JFileChooser fileChooser = new JFileChooser();
  		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
  		
  		int result = fileChooser.showSaveDialog(this);
  		
  		if(result == JFileChooser.CANCEL_OPTION)
  			return;
  			
  		File file = fileChooser.getSelectedFile();
  		
  		//����ó��.
  		if((file == null) || (file.getName().equals("")))
  		{
  			JOptionPane.showMessageDialog(this, "�����̸��� �Է����� �����̽��ϴ�!",
  			"�����̸��� �Է����� �����̽��ϴ�!",JOptionPane.ERROR_MESSAGE);
  			
  		}
  		
  		else if(file.exists()){
  			if (JOptionPane.NO_OPTION == JOptionPane.showConfirmDialog(MyPainter.this,
  										 saveFile.getPath() + "\n���� �̸��� ������ �̹� �����մϴ�.\n" +
  										 "���� ������ �� ���Ϸ� ��ü�Ͻðڽ��ϱ�?", 
										"�ٸ� �̸����� ����",
										JOptionPane.YES_NO_OPTION, 
										JOptionPane.WARNING_MESSAGE))	 
  				return;		// No�� Ŭ���ϸ� �������� �ʴ´�.
  		}
  		
  		
  		try
		{
			//���͸� ��ü����ȭ�� ����ȭ.
			ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(file));
			save.writeObject(Layer.getDrawing());
			save.close();
		}
		catch (Exception e) { System.out.println(e); }			
			
		if (file != saveFile)
		{
			saveFile = file;
			fileName = saveFile.getName();
			setTitle("���� ���ϸ� : " + fileName + " , ��ġ : " + saveFile.getPath());
		}
  		  		
  	}
  	
  	//��������� ������ ������ Ȯ�����ִ� �Լ�.
  	public void checkForSave()
	{		
		if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(MyPainter.this,
										"���� ������ �����Ͻðڽ��ϱ�?",
										"���� �����ϱ�",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.WARNING_MESSAGE))
			Save();
		else
			return;
	}
  	
	
	// ----------------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent event)
	{
        DrawPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		Object action = event.getSource();
				
		// ----------------------------------------------------------------------
		// ����I/O����.
		if (action == newItem)
		{
			if (Layer.getDrawing().isEmpty() == false)
			{
				checkForSave();
			}
			Layer.newShape();
			repaint();
			setTitle("�������.paint");
			saveFile = null;
		}
		
		else if (action == openItem)
		{
			if (saveFile != null)
				checkForSave();
				Open();
		}
		
		else if (action == saveItem)
		{
			Save(); 		
		}
		
		else if (action == saveAsItem)
		{
			Save(); 
		}
		
		else if (action == exitItem)
		{
			checkForSave();
			System.exit(0);
		}
		
		//Ư�� ��ư�� ������ ���� ���콺 �۾�ȯ������ ���� ��Ŷ�� �������ش�.
        else if(action == lineButton ||action == polyButton ||action == ovalButton ||action == rectButton ||action == pasteButton)
               DrawPanel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR)); 

        else if(action == selectButton || action == fillcolorButton)
               DrawPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        else if(action == moveButton|| action==moveItem)
               DrawPanel.setCursor(new Cursor(Cursor.MOVE_CURSOR));
               
        //���ٹ�ư�̺�Ʈó��.

		else if(action == undoButton)
		{
			Layer.undo();
			repaint();
		}
		
		else if(action == backButton)
		{
			Layer.moveToBack(Layer.getShape(Layer.getEditIndex()));
			repaint();
		}
		
		else if(action == cutButton||action == cutItem)
		{
			Layer.cut(Layer.getShape(Layer.getEditIndex()));
			repaint();
		}
		
		
		else if(action == copyButton||action==copyItem)
		{
			Layer.copy(Layer.getShape(Layer.getEditIndex()));

		}
		
		else if (action == deleteButton||action==deleteItem)
		{
			if(Layer.isEditing()==true){
			Layer.delete();
			repaint();
			}
		}
		
		else if (action == About)
		{
			JOptionPane.showMessageDialog(MyPainter.this, "My Paint ver 1.0 \n", "MyPaint", JOptionPane.INFORMATION_MESSAGE);
		}
		
		//�ȷ�Ʈ�� �̺�Ʈ ó��.(RGB�ڵ带 �̿��� ������ ��쿡 Color�� �������ش�.)
		//------------------------------------------
		
		
	}
	  	
	
	//���� Ŀ�� ��ġ�� �˷��ִ� PointlocationŬ����.
	class Pointlocation extends JPanel
	{
		JLabel location = new JLabel("");
		
		public Pointlocation()
		{
			setBorder(BorderFactory.createLoweredBevelBorder());
			setPreferredSize(new Dimension(100,25));
			add(location);
		}
		
		public void settext(String text)
		{
			location.setText(text);
		}
				
		public void setPoint(int x, int y)
		{
			location.setText("( " + x + ", " + y + " )");
		}
	}

	// --------------------------------------------------------------------------------------------------------
	// ���콺 �̺�Ʈ�� �̿��Ͽ� ������ �׸��� �׸��� ĵ���������� �ϴ� DrawPanel.
	private class CustomPanel extends JPanel implements MouseInputListener
	{
 		// ������
 		public CustomPanel()
 		{
   		addMouseListener(this);
   		addMouseMotionListener(this);
   		
 		}
 
 		public void paint(Graphics g)
 		{
   		super.paint(g);
   		Layer.draw(g);
   		
 		}

 		// ���콺�� Ŭ������ �� ������ ����� �����Ѵ�
 		public void mouseClicked(MouseEvent event)
 		{
			//	���콺 ��� ��ư�� ������ ��ư�� �ƴ� ��쿡 ����
 			if (!(event.isMetaDown()) && !(event.isAltDown()))
 			{
 				eventhandle.ordering.mouseClickExe(event.getPoint(), Layer); 
 				repaint();
   			}
 			
 		}

 		// ���콺�� ������ �� ������ ����� �����Ѵ�.
 		public void mousePressed(MouseEvent event)
 		{
			if (!(event.isMetaDown()) && !(event.isAltDown()))
			{
				eventhandle.ordering.mousePressExe(event.getPoint(), Layer);
				repaint();
			}
			
			
 		}
 
		// ���콺�� �巡���� �� ������ ����� �����Ѵ�
 		public void mouseDragged(MouseEvent event)
 		{
			if (!(event.isMetaDown()) && !(event.isAltDown()) && event.isShiftDown())
 			{
 				eventhandle.ordering.mouseDragShiftExe(event.getPoint(), Layer); 
 	   			repaint();
 			}
			else if (!(event.isMetaDown()) && !(event.isAltDown()))
			{
			    eventhandle.ordering.mouseDragExe(event.getPoint(), Layer);
			    repaint();
			}
			
			pointlocation.setPoint(event.getX(), event.getY());		// ���콺�� ��ǥ�� �����ش�
			
 		}   

 		public void mouseReleased(MouseEvent event) 
 		{ 
 			eventhandle.ordering.mouseRelExe(event.getPoint(), Layer);
			repaint();
			pointlocation.setPoint(event.getX(), event.getY());	// ���콺�� ��ǥ�� �����ش�
			
			
 		}
 		public void mouseEntered(MouseEvent event) 
 		{
 			helptext.setText("�̰����� �׸��� �׷��ּ���."); //���콺�� DrawPanel�� ������ ���µ���ǥ������ ����.
 		}
 		public void mouseExited(MouseEvent event)
 		{
 			
 			pointlocation.settext("ĵ���� �ܺ�"); 	// ���콺�� DrawPanel�� ����� ����Ŀ����ġ�� 'ĵ���� �ܺ�'�� ����.
 		} 
 		
 		public void mouseMoved(MouseEvent event) 
 		{
 			pointlocation.setPoint(event.getX(), event.getY());			// ���콺�� ��ǥ�� �����ش�
 		} 
	}
	
	//������ ��ä��⿡�� ���ȿ���� �� �� �ִ� �׶���Ʈ.
	
	

	
}
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
	
	
	
	
	private EventHandler eventhandle; // 몇가지 주요이벤트들을 관리할 이벤트핸들러의 객체
	private final Color firstColor = Color.BLACK; //기본색을 검은 색으로 설정
	private static Order ordering;         					// 실행될 명령
	private Drawing Layer; 					// 명령에 따라 그림을 그릴 객체
	private Pointlocation pointlocation; //현재 커서의 위치를 알려주는 패널.
	private JPanel nowColorPanel;   //현재색을 보여주는 패널객체.
	private JPanel ToolBar_Pallet_text;   //팔레트를 바꿔주는 버튼역할을 할 패널.
	private CardLayout pallets;       //카드레이아웃의 객체.(.next()메소드를 쓰기위해) 			
	private JPanel ToolBar_Pallet_pallet; //3개의 팔레트패널을 관리하는 전체 팔레트관리패널.
	private JLabel helptext; //상태 도움 표시줄의 라벨.
	private JFrame gradientFrame; //그라디언트 프레임
	private static MyPainter application; 
	public static TextField str;
	//툴바버튼
	
	private JButton selectButton, CurveButton, lineButton, rectButton, ovalButton, polyButton, resizeButton, moveButton, deleteButton, 
					cutButton, addStringButton, pasteButton, copyButton, fillcolorButton, undoButton, backButton;
			
	//팔레트버튼.		
	
	//메뉴
 	private JMenu fileMenu, Edit, Help;
 	//메뉴아이템.
 	private JMenuItem newItem, selectItem, openItem, saveItem, saveAsItem, exitItem, 
					moveItem, resizeItem, cutItem, copyItem, pasteItem, deleteItem, colorchooseItem, helpItem, About;
	//DrawPanel. 직접 그림이 그려지는 캔버스역할을 하는 패널.				
	public CustomPanel DrawPanel;
	
	//파일입출력 관련.
	private JFileChooser fileChoose = new JFileChooser();
	private String fileName = "제목없음.cha";
	private File saveFile;
	
	//메인함수.
	
	public static void main(String args[])
	{
		application = new MyPainter();
		application.setVisible(true);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                       
	}
	
	// CharismaPainter 생성자. 패널들과 버튼을 생성하고 배치
 
	public MyPainter()
	{
		super();
		eventhandle = new EventHandler();	
		setTitle(fileName);		// JFrame 초기화
		
		
		//윈도우 스타일로 룩앤필 설정.-----------
		
		try { 
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
			SwingUtilities.updateComponentTreeUI(this); 
		} 
		catch (Exception e) { }
		
		//---------------------------------------
		
		
 		ordering = new Order();          		// 명령을 참조할 객체 생성
 		Layer = new Drawing(firstColor);    // 현재 그림을 참조할 객체 생성 
 		Color ColorDesign = new Color(232,232,233); //전체프레임의 색을 RGB로 정의
 		
 		
 		//파일 메뉴
		fileMenu = new JMenu("파일(F)");
		fileMenu.setMnemonic('f');
		fileMenu.setBackground(ColorDesign);
				
		newItem = new JMenuItem("새로 만들기(N)", new ImageIcon("New.jpg"));
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		newItem.setBackground(ColorDesign);
		newItem.addActionListener(this);
		fileMenu.add(newItem);
		
		
		openItem = new JMenuItem("열기(O)", new ImageIcon("Open.jpg"));
		openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		openItem.setBackground(ColorDesign);
		openItem.addActionListener(this);
		fileMenu.add(openItem);
		
		
		saveItem = new JMenuItem("저장(S)", new ImageIcon("Save.jpg"));
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		saveItem.setBackground(ColorDesign);
		saveItem.addActionListener(this);
		fileMenu.add(saveItem);
		
		
		saveAsItem = new JMenuItem("다른 이름으로 저장");
		saveAsItem.setBackground(ColorDesign);
		saveAsItem.addActionListener(this);
		fileMenu.add(saveAsItem);
		
		
		exitItem = new JMenuItem("종료");
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
		exitItem.setBackground(ColorDesign);
		exitItem.addActionListener(this);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);	
		
		
		
		// 편집 메뉴(선택, 이동, 리사이즈, 복사, 잘라내기, 붙여넣기, 삭제하기, 색상선택)	
		Edit = new JMenu("편집(E)");
		Edit.setBackground(ColorDesign);
		Edit.setMnemonic('e');
		
		selectItem = new JMenuItem("선택하기");
		selectItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		selectItem.setBackground(ColorDesign);
		selectItem.addActionListener(eventhandle);
		selectItem.setActionCommand("26");
		Edit.add(selectItem);
		
		moveItem = new JMenuItem("이동하기");
		moveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		moveItem.setBackground(ColorDesign);
		moveItem.addActionListener(eventhandle);
		moveItem.setActionCommand("26");
		Edit.add(moveItem);
		
		resizeItem = new JMenuItem("크기 변경");
		resizeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		resizeItem.setBackground(ColorDesign);
		resizeItem.addActionListener(eventhandle);
		resizeItem.setActionCommand("24");
		Edit.add(resizeItem);
		
		copyItem = new JMenuItem("복사하기");
		copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		copyItem.setBackground(ColorDesign);
		copyItem.addActionListener(eventhandle);
		copyItem.setActionCommand("23");
		Edit.add(copyItem);
		
		cutItem = new JMenuItem("잘라내기");
		cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
		cutItem.setBackground(ColorDesign);
		cutItem.addActionListener(eventhandle);
		cutItem.setActionCommand("22");
		Edit.add(cutItem);
				
			
		pasteItem = new JMenuItem("붙여넣기");
		pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		pasteItem.setBackground(ColorDesign);
		pasteItem.addActionListener(eventhandle);
		pasteItem.setActionCommand("27");
		Edit.add(pasteItem);
		
		deleteItem = new JMenuItem("삭제하기");
		deleteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		deleteItem.setBackground(ColorDesign);
		deleteItem.addActionListener(eventhandle);
		deleteItem.setActionCommand("25");
		Edit.add(deleteItem);
		
		
		
		
		
			
		// 도움말 메뉴	
		Help = new JMenu("도움말(H)");
		Help.setBackground(ColorDesign);
		Help.setMnemonic('h');
		
		helpItem = new JMenuItem("도움말");
		helpItem.setBackground(ColorDesign);
		helpItem.addActionListener(this);
		Help.add(helpItem);
		
		
		About = new JMenuItem("About..");
		About.setBackground(ColorDesign);
		About.addActionListener(this);
		Help.add(About);
		
		
		//메뉴바 설정.
		JMenuBar menuBar = new JMenuBar();		
		menuBar.setBackground(ColorDesign);
		menuBar.add(fileMenu);
		menuBar.add(Edit);
		menuBar.add(Help);
		setJMenuBar(menuBar);
						
		//Toolbar
		//툴바의 툴GUI
				
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
		JLabel Tool_text = new JLabel("도구 모음");
     	ToolBar_Tool_text.add(Tool_text);
     	ToolBar_Tool_text.setBackground(ColorDesign);
     	ToolBar_Tool.add(ToolBar_Tool_text, BorderLayout.NORTH);
			
		ToolBar_Tool_tool.setBorder(BorderFactory.createRaisedBevelBorder());
		ToolBar_Tool_tool.setLayout(new GridLayout(14,1));
     	ToolBar_Tool_tool.setCursor(new Cursor(Cursor.HAND_CURSOR));
     
                    		
		//버튼을 생성하고 설정하는 부분.마우스모션리스너와 마우스모션어댑터로 상태도움표시줄을 관리.
		
     	CurveButton = new JButton("자유선 그리기");
     	CurveButton.setBackground(ColorDesign);
     	CurveButton.setToolTipText("자유선 그리기");
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
                        helptext.setText("캔버스창에 드래그하여 원하는 선을 그립니다.");
                    }
                }
                
                
            }
    	);
		ToolBar_Tool_tool.add(CurveButton);  
     	
		lineButton = new JButton("직선 그리기");
		lineButton.setBackground(ColorDesign);
		lineButton.setToolTipText("선그리기");
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
                        helptext.setText("캔버스창에 드래그하여 선을 그립니다.");
                    }
                }
                
                
            }
    	);
		ToolBar_Tool_tool.add(lineButton);  
		
		
		
		
        ovalButton = new JButton("원");
     	ovalButton.setBackground(ColorDesign);
     	ovalButton.setToolTipText("원그리기");
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
                        helptext.setText("캔버스창에 드래그하여 타원을 그립니다. (+ shift키 - 원그리기)");
                    }
                }
                
                
            }
    	);
     	ToolBar_Tool_tool.add(ovalButton); 
     
     	rectButton = new JButton("사각형");
     	rectButton.setBackground(ColorDesign);
     	rectButton.setToolTipText("사각형그리기");
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
                        helptext.setText("캔버스창에 드래그하여 네모를 그립니다. (+ shift키 - 정사각형그리기)");
                    }
                }
                
                
            }
    	);
     	ToolBar_Tool_tool.add(rectButton);
     	
     	selectButton = new JButton("객체 선택");
		selectButton.setBackground(ColorDesign);
		selectButton.setToolTipText("객체 선택");
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
                        helptext.setText("편집을 원하는 도형 위에 클릭을 하여 편집 대상 도형을 선택합니다.(Alt + S)");
                    }
                }
                
                
            }
    	);
    	ToolBar_Tool_tool.add(selectButton);
	 
     	moveButton = new JButton("이동");
     	moveButton.setBackground(ColorDesign);
     	moveButton.setToolTipText("이동");
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
                        helptext.setText("선택된 도형을 이동합니다.(Ctrl + M)");
                    }
                }
            }
    	);
     	ToolBar_Tool_tool.add(moveButton); 
     
     	resizeButton = new JButton("크기 변경");
     	resizeButton.setBackground(ColorDesign);
     	resizeButton.setToolTipText("크기 변경");
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
                        helptext.setText("선택된 도형의 크기를 변경합니다.(Ctrl + R)");
                    }
                }
            }
    	);
     	ToolBar_Tool_tool.add(resizeButton);
     
     	cutButton = new JButton("잘라내기");
     	cutButton.setBackground(ColorDesign);
     	cutButton.setToolTipText("잘라내기");
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
                        helptext.setText("선택된 도형을 지우고, 직후에 붙여넣기하면 그 도형을 붙입니다.(Alt + C)");
                    }
                }
            }
    	);
     	ToolBar_Tool_tool.add(cutButton); 
     
     	copyButton = new JButton("복사하기");
     	copyButton.setBackground(ColorDesign);
     	copyButton.setToolTipText("복사하기");
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
                        helptext.setText("선택된 도형을 붙여넣기할 때 붙입니다.(Ctrl + C)");
                    }
                }
            }
    	);
     	ToolBar_Tool_tool.add(copyButton);
     	 pasteButton = new JButton("붙여넣기");
 	    pasteButton.setBackground(ColorDesign);
   		pasteButton.setToolTipText("붙여넣기");
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
                         helptext.setText("직전에 잘라내거나 복사한 도형을 캔버스창에 붙여넣습니다.(Ctrl + V)");
                     }
                 }
             }
     	);
      	ToolBar_Tool_tool.add(pasteButton);
	    
     
     	deleteButton = new JButton("삭제");
     	deleteButton.setBackground(ColorDesign);
     	deleteButton.setToolTipText("삭제");
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
                        helptext.setText("선택된 도형을 삭제합니다.(Ctrl + D)");
                    }
                }
            }
    	);
     	ToolBar_Tool_tool.add(deleteButton);
     	
     	
     
     	fillcolorButton = new JButton("색채우기");
     	fillcolorButton.setBackground(ColorDesign);
     	fillcolorButton.setToolTipText("색채우기");
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
                        helptext.setText("현재 색을 선택된 도형에 채워넣습니다.");
                    }
                }
            }
    	);
     	ToolBar_Tool_tool.add(fillcolorButton);
     	
     	
     	ToolBar_Tool.add(ToolBar_Tool_tool, BorderLayout.CENTER);
   	    //툴바의 팔레트
     	
   		JPanel ToolBar_Width = new JPanel();
     	ToolBar_Width.setLayout(new BorderLayout());
     	LineWidth width = new LineWidth();
     	ToolBar_Width.add(width);
     	//팔레트를 바꿔주는 패널.마우스리스너와 마우스어댑터를 사용해 클릭했을시 팔레트를 바꿔주는 이벤트처리.
		
     	
     	str = new TextField(10);
     	addStringButton = new JButton("텍스트 생성");
     	addStringButton.setBackground(ColorDesign);
     	addStringButton.setToolTipText("텍스트 생성");
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
                        helptext.setText("입력한 스트링을 원하는 위치에 클릭하면 생성됩니다.");
                    }
                }
            }
    	);
     	ToolBar_Tool_tool.add(str);
     	ToolBar_Tool_tool.add(addStringButton);
     	
             
    	//툴바의 컬러GUI
     
     	JPanel ToolBar_Color = new JPanel();
     	ToolBar_Color.setBackground(ColorDesign);
     	ToolBar_Color.setBorder(BorderFactory.createRaisedBevelBorder());
     
     	JPanel nowColorWholePanel = new JPanel();
     	nowColorWholePanel.setBackground(ColorDesign);
       
        //현재색을 보여주는 패널. 마우스리스너와 마우스어댑터를 이용해서 JColorChooser를 불러온다.
        //마우스모션리스너와 마우스모션어댑터를 이용해 상태도움표시줄에 도움글을 보여준다.
     	nowColorPanel = new JPanel();
	 	nowColorPanel.setBorder(BorderFactory.createLoweredBevelBorder());	// 테두리 설정
     	nowColorPanel.setPreferredSize(new Dimension(25, 25));			// 크기 설정
   	 	nowColorPanel.setBackground(Color.BLACK);
   	 	nowColorPanel.setToolTipText("현재 색상 선택");
   	 	nowColorPanel.addMouseListener            
     	(
            new MouseAdapter()
            {
                public void mouseClicked(MouseEvent event) 
                {
                    if ( ( event.getX() > 0 && event.getX() < 25 ) && ( event.getY() > 0 && event.getY() < 25 ) )
                    {
                        Color color = JColorChooser.showDialog(MyPainter.this, "색상 선택 팔레트", firstColor);
			
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
                        helptext.setText("이 부분을 누르면 고급 색상 선택 창을 열 수 있습니다.(Ctrl + U)");
                   	}
                
                }
            }
     	);
       
                  	
  	 
  	 	nowColorWholePanel.add(nowColorPanel);
  	 	 	
  	 
	 	JPanel nowcolortextPanel = new JPanel();
	 	nowcolortextPanel.setBackground(ColorDesign);
	 	JLabel nowcolortext = new JLabel("현재 색");
	 	nowcolortextPanel.add(nowcolortext);
		
		
		 		       
     	ToolBar_Color.setLayout(new BorderLayout());
     	ToolBar_Color.add(nowcolortextPanel, BorderLayout.CENTER);        
     	ToolBar_Color.add(nowColorWholePanel, BorderLayout.NORTH);
     
     
     
     
     
     
     	//툴바에 툴바_툴, 툴타_컬러 패널 배치.
     	ToolBar.setLayout(new BorderLayout());
     	ToolBar.add(ToolBar_Width, BorderLayout.CENTER);
     	ToolBar.add(ToolBar_Tool, BorderLayout.NORTH);
     	ToolBar.add(ToolBar_Color, BorderLayout.SOUTH);
     
     
     
            
        //상태바
     
     
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
        JLabel locationtext = new JLabel("현재 커서 위치 : ");
        InnerStatusBar.add(locationtext);
        pointlocation = new Pointlocation();
        pointlocation.setBackground(ColorDesign);
        InnerStatusBar.add(locationtext);
        InnerStatusBar.add(pointlocation);
     
        StatusBar.setLayout(new BorderLayout());
        StatusBar.add(HelpBar, BorderLayout.CENTER);
        StatusBar.add(InnerStatusBar, BorderLayout.EAST);
     
     
        //그림이 그려지는 영역.
        DrawPanel = new CustomPanel();
        DrawPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        DrawPanel.setBackground(Color.WHITE);
     
 	 
		
		
		//프레임 설정.
		addMouseMotionListener
     	(
            new MouseMotionAdapter()
            {
                public void mouseMoved(MouseEvent event)
                {
                    if ( ( event.getX() > 0 && event.getX() < 640 ) && ( event.getY() > 0 && event.getY() < 50 ) )
                    {
                        helptext.setText("메뉴를 선택해주세요");
                   	}
                   	
                    else if ( ( event.getX() > 0 && event.getX() < 75 ) && ( event.getY() > 50 && event.getY() < 80 ) )
                    {
                        helptext.setText("이 곳에서 툴을 선택해주세요");
                   	}
                   	
                   	                   	
                    else if ( ( event.getX() > 0 && event.getX() < 640 ) && ( event.getY() > 465 && event.getY() < 505 ) )
                    {
                        helptext.setText("이곳에선 현재 상태를 보여줍니다.");
                   	}
                   	               
                                        
                    else
                    	helptext.setText(""); 
                    	//이 부분이 없으면 다른 곳에 위치했을 때 상태도움표시줄을 공백으로 만들지못함.
                
                }
            }
     	);
     
     //-------------------------------------------------------               
    //패널들을 프레임에 붙인다.
    	
     Container container = getContentPane();
     container.setLayout(new BorderLayout());
     container.add(StatusBar, BorderLayout.SOUTH);
     container.add(DrawPanel, BorderLayout.CENTER);
	 container.add(ToolBar, BorderLayout.WEST);
	 
	 
	 //프레임 타이틀과 크기 설정.
	 setTitle("My Painter");
     setSize(900,575);
	 
	 // 크기변경 불가
     //setResizable(false);
             
     // 저장하지 않고 x버튼을 눌렀을 경우에 대한 처리
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
    //열기함수.
	private void Open()
  	{
  		//대화상자를 연다.
  		JFileChooser fileChooser = new JFileChooser();

  		FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG(*.png)","png"); //png파일필터
		FileNameExtensionFilter filter2 = new FileNameExtensionFilter("JPG(*.jpg)","jpg");//jpg파일필터
		fileChooser.setFileFilter(filter); //png와 jpg파일필터 각각 따로 추가
		fileChooser.setFileFilter(filter2);
  		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
  		int result = fileChooser.showOpenDialog(this);
  		
  		if(result == JFileChooser.CANCEL_OPTION)
  			return;
  			
  		File file = fileChooser.getSelectedFile();
  		System.out.println(file.getName());
  		//예외처리.
  		if((file == null) || (file.getName().equals("")))
  		{
  			JOptionPane.showMessageDialog(this, "파일이름을 입력하지 않으셨습니다!",
  			"파일이름을 입력하지 않으셨습니다!",JOptionPane.ERROR_MESSAGE);
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
				//객체직렬화된 파일을 다시 벡터화하고 Layer에 그 벡터를 설정하고 repaint로 DrawPanel에 다시 그린다.
				ObjectInputStream open = new ObjectInputStream(new FileInputStream(file));
				Vector newobject = (Vector)open.readObject();
				Layer.setDrawing(newobject);
				open.close();
				repaint();
				saveFile = file;
				fileName = saveFile.getName();
				setTitle("현재 파일명 : " + fileName + " , 위치 : " + saveFile.getPath());
			} 
			catch (Exception e) { System.out.println(e); }
  		}
  		
  	}
  	
  	
  	//저장함수.
 	private void Save()
  	{
  		//대화상자.
  		JFileChooser fileChooser = new JFileChooser();
  		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
  		
  		int result = fileChooser.showSaveDialog(this);
  		
  		if(result == JFileChooser.CANCEL_OPTION)
  			return;
  			
  		File file = fileChooser.getSelectedFile();
  		
  		//예외처리.
  		if((file == null) || (file.getName().equals("")))
  		{
  			JOptionPane.showMessageDialog(this, "파일이름을 입력하지 않으셨습니다!",
  			"파일이름을 입력하지 않으셨습니다!",JOptionPane.ERROR_MESSAGE);
  			
  		}
  		
  		else if(file.exists()){
  			if (JOptionPane.NO_OPTION == JOptionPane.showConfirmDialog(MyPainter.this,
  										 saveFile.getPath() + "\n같은 이름의 파일이 이미 존재합니다.\n" +
  										 "기존 파일을 이 파일로 대체하시겠습니까?", 
										"다른 이름으로 저장",
										JOptionPane.YES_NO_OPTION, 
										JOptionPane.WARNING_MESSAGE))	 
  				return;		// No를 클릭하면 저장하지 않는다.
  		}
  		
  		
  		try
		{
			//벡터를 객체직렬화로 파일화.
			ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(file));
			save.writeObject(Layer.getDrawing());
			save.close();
		}
		catch (Exception e) { System.out.println(e); }			
			
		if (file != saveFile)
		{
			saveFile = file;
			fileName = saveFile.getName();
			setTitle("현재 파일명 : " + fileName + " , 위치 : " + saveFile.getPath());
		}
  		  		
  	}
  	
  	//변경사항을 저장할 것인지 확인해주는 함수.
  	public void checkForSave()
	{		
		if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(MyPainter.this,
										"변경 사항을 저장하시겠습니까?",
										"파일 저장하기",
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
		// 파일I/O관련.
		if (action == newItem)
		{
			if (Layer.getDrawing().isEmpty() == false)
			{
				checkForSave();
			}
			Layer.newShape();
			repaint();
			setTitle("제목없음.paint");
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
		
		//특정 버튼이 눌림에 따라 마우스 작업환경으로 보일 툴킷을 변경해준다.
        else if(action == lineButton ||action == polyButton ||action == ovalButton ||action == rectButton ||action == pasteButton)
               DrawPanel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR)); 

        else if(action == selectButton || action == fillcolorButton)
               DrawPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        else if(action == moveButton|| action==moveItem)
               DrawPanel.setCursor(new Cursor(Cursor.MOVE_CURSOR));
               
        //툴바버튼이벤트처리.

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
		
		//팔레트의 이벤트 처리.(RGB코드를 이용해 각각의 경우에 Color를 설정해준다.)
		//------------------------------------------
		
		
	}
	  	
	
	//현재 커서 위치를 알려주는 Pointlocation클래스.
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
	// 마우스 이벤트를 이용하여 실제로 그림을 그리는 캔버스역할을 하는 DrawPanel.
	private class CustomPanel extends JPanel implements MouseInputListener
	{
 		// 생성자
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

 		// 마우스를 클릭했을 때 현재의 명령을 실행한다
 		public void mouseClicked(MouseEvent event)
 		{
			//	마우스 가운데 버튼과 오른쪽 버튼이 아닌 경우에 수행
 			if (!(event.isMetaDown()) && !(event.isAltDown()))
 			{
 				eventhandle.ordering.mouseClickExe(event.getPoint(), Layer); 
 				repaint();
   			}
 			
 		}

 		// 마우스를 눌렀을 때 현재의 명령을 실행한다.
 		public void mousePressed(MouseEvent event)
 		{
			if (!(event.isMetaDown()) && !(event.isAltDown()))
			{
				eventhandle.ordering.mousePressExe(event.getPoint(), Layer);
				repaint();
			}
			
			
 		}
 
		// 마우스를 드래그할 때 현재의 명령을 실행한다
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
			
			pointlocation.setPoint(event.getX(), event.getY());		// 마우스의 좌표를 보여준다
			
 		}   

 		public void mouseReleased(MouseEvent event) 
 		{ 
 			eventhandle.ordering.mouseRelExe(event.getPoint(), Layer);
			repaint();
			pointlocation.setPoint(event.getX(), event.getY());	// 마우스의 좌표를 보여준다
			
			
 		}
 		public void mouseEntered(MouseEvent event) 
 		{
 			helptext.setText("이곳에서 그림을 그려주세요."); //마우스가 DrawPanel에 들어오면 상태도움표시줄을 변경.
 		}
 		public void mouseExited(MouseEvent event)
 		{
 			
 			pointlocation.settext("캔버스 외부"); 	// 마우스가 DrawPanel을 벗어나면 현재커서위치를 '캔버스 외부'로 변경.
 		} 
 		
 		public void mouseMoved(MouseEvent event) 
 		{
 			pointlocation.setPoint(event.getX(), event.getY());			// 마우스의 좌표를 보여준다
 		} 
	}
	
	//도형의 색채우기에서 명암효과를 줄 수 있는 그라디언트.
	
	

	
}
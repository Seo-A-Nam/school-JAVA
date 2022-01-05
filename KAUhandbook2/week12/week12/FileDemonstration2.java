package week12;

//Demonstrating JFileChooser.

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FileDemonstration2	extends JFrame
{
	private JTextArea outputArea;
	private JScrollPane scrollpane;
	
	public FileDemonstration2()
	{
		super("Testing class File");
		outputArea = new JTextArea();
		
		scrollpane = new JScrollPane(outputArea);
		add(scrollpane, BorderLayout.CENTER);
		setSize(400,400); //set GUI size
		setVisible(true);
		
		analayzePath();	//create and analyze File object
	}
	
	//allow user to specify file or directory file
	private File getFileOrDirectory()
	{
		//display file dialog, so user can choose file or directory to open
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		int result = fileChooser.showOpenDialog(this);
		if(result == JFileChooser.CANCEL_OPTION)
			System.exit(1);
		File fileName = fileChooser.getSelectedFile(); //get file
		
		//display info about file or directory user specifies
		public void analyzePath() 
		{
			File name = getFileOrDirectory();
			
			if(name.exists())
			{
				//display file(or directory) info
				outputArea.setText(String.format("%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s",name.getName(),"exists",
						(name.isFile() ? "is a file" : "is not a file"),
						(name.isDirectory() ? "is a directory":"is not a directory"),
						(name.isAbsolute() ? "is absolute path" : "is not absolute path"),
						"Last modified: ", name.lastModified(), "Length: ",name.length(), "Path: ", name.getPath(),
						"Absolute path: ",name.getAbsolutePath(), "Parent: ", name.getParent()));
				
				if(name.isDirectory())
				{	//output directory listing
					String[] directory = name.list();
					outputArea.append("\n\nDirectory contents:\n");
					
					for(String directoryName : directory )
						outputArea.append( directoryName + "\n" );
				}
			}
		
			else //not file or directory, output error message
			{
				JOptionPane.showMessageDialog(this, name + "does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}

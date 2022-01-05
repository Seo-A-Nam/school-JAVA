import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.JFrame;

public class Main {
	static boolean cont = true; 
	static HashMap<Integer, String> playermap = new HashMap<Integer, String>();
	
	public static void main(String[] args) {
		// music
		File Clip = new File("C:\\Users\\ryouh\\OneDrive\\Development\\Eclipse\\JavaSE-2020-06\\WorkSpace-JavaSE\\TermProject2\\src\\music.wav");
		playSound(Clip);
		
		
		//
		GUI guistart = new GUI();
		
		
		guistart.callStarting();
		while(cont) {
			System.out.print(cont);
		}
		//playermap ; // 1:~~~; 2:~~~ ...
		
		//
		PokerGame game = new PokerGame(playermap);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setSize(539, 780);
		game.setLocationRelativeTo(null);
		game.setVisible(true);
		
		game.play();
	}
	
	public static void playSound(File Sound)
	{
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
			
			//Thread.sleep(clip.getMicrosecondLength()/1000);
		}
		catch(Exception e) {
			
		}
	}
}
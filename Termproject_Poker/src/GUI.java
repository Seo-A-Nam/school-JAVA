import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;

public class GUI {
	static HashMap<Integer, String> faceChange = new HashMap<Integer, String>();
	GUI(){
		faceChange.put(1, "A");
	   	faceChange.put(2, "2");
	   	faceChange.put(3, "3");
	   	faceChange.put(4, "4");
	   	faceChange.put(5, "5");
	   	faceChange.put(6, "6");
	   	faceChange.put(7, "7");
	   	faceChange.put(8, "8");
	   	faceChange.put(9, "9");
	   	faceChange.put(10, "10");
		faceChange.put(11, "J");
		faceChange.put(12, "Q");
		faceChange.put(13, "K");
	}
	
	public void callStarting() {
		GUIStart startFrame = new GUIStart();
		//startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.setSize(577, 280);
		startFrame.setLocationRelativeTo(null);
		startFrame.setVisible(true);
	}
	
	public void openHand(PlayerInfo player, int i) {
		GUIOpen openFrame = new GUIOpen( player , i);
		//openFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		openFrame.setSize(400, 150);
		//openFrame.setLocationRelativeTo(null);
		//
		openFrame.setVisible(true);
	}
	
	public void callReasultBoard( ArrayList<PlayerInfo> rankers ) {
		GUIResult resultFrame = new GUIResult( rankers );
		//openFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//420*570
	    //resultFrame.setPreferredSize(new Dimension(420,570));
		resultFrame.setSize(420, 700);
		resultFrame.setLocationRelativeTo(null);
		resultFrame.setVisible(true);
	}
}

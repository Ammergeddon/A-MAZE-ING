package buttons;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.Controller;
import controller.Listener;

public class Button_StartGame extends Button_Base{	
	public Button_StartGame(Controller controller, Listener listener) {
		super(controller, listener, 278, 76, "start");
		
		ICON = new ImageIcon("gui\\images\\ButtonDefault.png");
		ICON_HIGHLIGHT= new ImageIcon("gui\\images\\ButtonDefault_highlighted.png");
		
		this.setText("Start Game");
		this.setIcon(ICON);
	}
}

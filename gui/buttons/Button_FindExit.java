package buttons;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.Controller;
import controller.Listener;

public class Button_FindExit extends Button_Base{	
	public Button_FindExit(Controller controller, Listener listener) {
		super(controller, listener, 278, 76, "exit");
		
		ICON = new ImageIcon("gui\\images\\defaultButton.png");
		ICON_HIGHLIGHT = new ImageIcon("gui\\images\\defaultButton_highlighted.png");
		
		this.setText("Find Exit");
		this.setIcon(ICON);
	}
}

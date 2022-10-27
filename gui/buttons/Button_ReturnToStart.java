package buttons;

import javax.swing.ImageIcon;

import controller.Controller;
import controller.Listener;

public class Button_ReturnToStart extends Button_Base{
	public Button_ReturnToStart(Controller controller, Listener listener) {
		super(controller, listener, 150, 50, "return");
		
		ICON = new ImageIcon("gui\\images\\ButtonBackToStart.jpg");
		ICON_HIGHLIGHT = new ImageIcon("gui\\images\\ButtonBackToStart_highlighted.jpg");
		this.setIcon(ICON);
	}
}

package buttons;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.Controller;
import controller.Listener;

public class Button_Highscore extends Button_Base{
	private Image resized;
	
	public Button_Highscore(Controller controller, Listener listener) {
		super(controller, listener, 150, 50, "highscore");
		
		ImageIcon temp = new ImageIcon("gui\\images\\DefaultButton.png");
		Image img = temp.getImage();
		System.out.println(img);
		resized = img.getScaledInstance(150, -1, java.awt.Image.SCALE_DEFAULT);
		
		ICON = new ImageIcon(resized);
		ICON_HIGHLIGHT = new ImageIcon("gui\\images\\ButtonHighscore_highlighted.jpg");
		this.setIcon(ICON);
	}
}

package buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import controller.Controller;
import controller.Listener;

public class Button_SizeMedium extends Button_Base{
	private Button_SizeSmall button_sizeSmall;
	private Button_SizeLarge button_sizeLarge;
	
	
	public Button_SizeMedium(Controller controller, Listener listener) {
		super(controller, listener, 150, 50, "medium");
		
		ICON = new ImageIcon("gui\\images\\ButtonSetSize.jpg");
		ICON_HIGHLIGHT= new ImageIcon("gui\\images\\ButtonSetSize_highlighted.jpg");
		
		Font font = new Font("Segoe Print", Font.PLAIN, 30);
		this.setFont(font);
		this.setText("Medium");		
		this.setIcon(ICON);
		this.setBorder(BorderFactory.createLineBorder(Color.yellow, 5));
	}
	
	public void set_selected() {
		button_sizeSmall.set_deselected();
		button_sizeLarge.set_deselected();
		
		this.setBorderPainted(true);
	}
	
	public void set_deselected() {
		this.setBorderPainted(false);
	}
	
	public void set_buttons(Button_SizeSmall button_small, Button_SizeLarge button_large) {
		button_sizeSmall = button_small;
		button_sizeLarge = button_large;
	}
}

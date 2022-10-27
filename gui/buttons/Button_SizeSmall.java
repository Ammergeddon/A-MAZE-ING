package buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import controller.Controller;
import controller.Listener;

public class Button_SizeSmall extends Button_Base{
	private Button_SizeMedium button_sizeMedium;
	private Button_SizeLarge button_sizeLarge;

	public Button_SizeSmall(Controller controller, Listener listener) {
		super(controller, listener, 150, 50, "small");
		
		ICON = new ImageIcon("gui\\images\\ButtonSetSize.jpg");
		ICON_HIGHLIGHT= new ImageIcon("gui\\images\\ButtonSetSize_highlighted.jpg");
		
		Font font = new Font("Segoe Print", Font.PLAIN, 30);
		this.setFont(font);
		this.setText("Small");		
		this.setIcon(ICON);
		this.setBorder(BorderFactory.createLineBorder(Color.yellow, 5));
	}
	
	public void set_selected() {
		button_sizeMedium.set_deselected();
		button_sizeLarge.set_deselected();
		
		this.setBorderPainted(true);
	}
	
	public void set_deselected() {
		this.setBorderPainted(false);
	}
	
	public void set_buttons(Button_SizeMedium button_medium, Button_SizeLarge button_large) {
		button_sizeMedium = button_medium;
		button_sizeLarge = button_large;
	}
}

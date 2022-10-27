package buttons;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.Controller;
import controller.Listener;

public abstract class Button_Base extends JButton{
	protected ImageIcon ICON = null;
    protected ImageIcon ICON_HIGHLIGHT = null;
	
	public Button_Base(Controller controller, Listener listener, int width, int height, String command) {
		this.setSize(width, height);
		
		Font font = new Font("Segoe Print", Font.PLAIN, 40);
		this.setFont(font);
		this.setForeground(Color.white);
		this.setHorizontalTextPosition(this.CENTER);
		this.setVerticalTextPosition(this.CENTER);
		this.setBorderPainted(false);

		this.setActionCommand(command);
		this.addActionListener(controller);
		this.addMouseListener(listener);
	}
		
	public void set_highlight() {
		setIcon(ICON_HIGHLIGHT);
	};
	
	public void set_normal() {
		setIcon(ICON);
	};
}

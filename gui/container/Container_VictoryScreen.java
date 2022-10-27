package container;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import buttons.Button_Highscore;
import buttons.Button_ReturnToStart;
import controller.Controller;
import controller.Listener;

public class Container_VictoryScreen extends JPanel{
	public Container_VictoryScreen(Controller controller, Listener listener, JLabel background, int[] elapsedTime) {
		this.setSize(440, 300);
		this.setOpaque(false);
		this.setLayout(null);
		this.setLocation((background.getWidth()-this.getWidth())/2, (background.getHeight()-this.getHeight())/2);
		
		
		JPanel button_panel = this.create_buttonPanel(controller, listener);
		
		JLabel victoryPicture = new JLabel(new ImageIcon("gui\\images\\victory.jpg"));
		victoryPicture.setSize(440,165);
		victoryPicture.setLocation(0,0);
		
		JLabel victoryText = new JLabel();
		Font font = new Font("Verdana", Font.BOLD, 13);
		victoryText.setFont(font);
		victoryText.setForeground(Color.white);
		victoryText.setHorizontalAlignment(SwingConstants.CENTER);
		victoryText.setText("You solved the Labyrinth in " + elapsedTime[0] + " Minutes and " + elapsedTime[1] + " Seconds");
		victoryText.setSize(this.getWidth(), this.getHeight() - button_panel.getHeight() - victoryPicture.getHeight());
		victoryText.setLocation(0, victoryPicture.getHeight());
		
		
		this.add(victoryPicture);
		this.add(victoryText);
		this.add(button_panel);
	}
	
	private JPanel create_buttonPanel(Controller controller, Listener listener) {
		Button_ReturnToStart button_returnToStart = new Button_ReturnToStart(controller, listener);
		
		Button_Highscore button_highscore = new Button_Highscore(controller, listener);
		
		JPanel button_panel = new JPanel();
		button_panel.setLayout(null);
		button_panel.setOpaque(false);
		button_panel.setSize(button_returnToStart.getWidth() + button_highscore.getWidth() + 10, button_returnToStart.getHeight());
		
		button_returnToStart.setLocation(0, 0);
		button_highscore.setLocation(button_panel.getWidth() - button_highscore.getWidth(), 0);
		
		button_panel.add(button_returnToStart);
		button_panel.add(button_highscore);
		
		button_panel.setLocation((this.getWidth()-button_panel.getWidth())/2, this.getHeight()-button_panel.getHeight());
		return button_panel;
	}
}

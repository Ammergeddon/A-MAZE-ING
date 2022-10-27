package container;

import java.util.ResourceBundle.Control;

import javax.swing.JLabel;
import javax.swing.JPanel;

import buttons.Button_Highscore;
import buttons.Button_SizeLarge;
import buttons.Button_SizeMedium;
import buttons.Button_SizeSmall;
import buttons.Button_StartGame;
import controller.Controller;
import controller.Listener;

public class Container_StartScreen extends JPanel{
	private final int SIZE_SELECTION = 50;
	
	public Container_StartScreen(Controller controller, Listener listener, JLabel background) {		
		Button_StartGame button_startGame = new Button_StartGame(controller, listener);
		Button_Highscore button_highscore = new Button_Highscore(controller, listener);
		
		JPanel button_sizes = new JPanel();
		button_sizes.setLayout(null);
		button_sizes.setOpaque(false);
		button_sizes.setSize(button_startGame.getWidth(), (int)(SIZE_SELECTION * 4));
		
		Button_SizeSmall button_sizeSmall = new Button_SizeSmall(controller, listener);
		button_sizeSmall.setLocation((button_sizes.getWidth()-button_sizeSmall.getWidth())/2, 0);
		button_sizes.add(button_sizeSmall);
		
		Button_SizeMedium button_sizeMedium = new Button_SizeMedium(controller, listener);
		button_sizeMedium.setLocation((button_sizes.getWidth()-button_sizeSmall.getWidth())/2, (int)(SIZE_SELECTION*1.5));
		button_sizes.add(button_sizeMedium);
		
		Button_SizeLarge button_sizeLarge = new Button_SizeLarge(controller, listener);
		button_sizeLarge.setLocation((button_sizes.getWidth()-button_sizeSmall.getWidth())/2, SIZE_SELECTION*3);
		button_sizes.add(button_sizeLarge);
		
		button_sizeSmall.set_buttons(button_sizeMedium, button_sizeLarge);
		button_sizeMedium.set_buttons(button_sizeSmall, button_sizeLarge);
		button_sizeLarge.set_buttons(button_sizeSmall, button_sizeMedium);

		this.setSize(button_startGame.getWidth(), button_sizes.getHeight() + (int)(button_startGame.getHeight()*2) + (int)(button_highscore.getHeight()*1.5));
		this.setOpaque(false);
		this.setLayout(null);
		
		button_sizes.setLocation(0, 0);
		button_startGame.setLocation(0, this.getHeight()-button_startGame.getHeight()-(int)(button_highscore.getHeight()*1.5));
		button_highscore.setLocation((this.getWidth()-button_highscore.getWidth())/2, this.getHeight()-button_highscore.getHeight());
		
		this.add(button_sizes);
		this.add(button_startGame);
		this.add(button_highscore);
		this.setLocation((background.getWidth()-this.getWidth())/2,(background.getHeight()-this.getHeight())/2);
	}
}

package container;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import buttons.Button_ReturnToStart;
import controller.Controller;
import controller.Listener;

public class Container_Highscore extends JPanel{
	private final String[] header_text = {"Small" , "Medium", "Large"};
	
	public Container_Highscore(Controller controller, Listener listener, JLabel background, String[][] scores) {
		this.setOpaque(false);
		this.setLayout(null);
		
		Button_ReturnToStart button_returnToStart = new Button_ReturnToStart(controller, listener);
		
		JLabel[] headers = new JLabel[3];
		JLabel[][] highscores = new JLabel[3][10];
		
		Font font = new Font("Verdana", Font.BOLD, 20);
		
		for(int i=0; i<headers.length; i++) {
			headers[i] = new JLabel();
			headers[i].setSize(background.getWidth()/3, 40);
			headers[i].setLocation(i * headers[i].getWidth(), 0);
			headers[i].setHorizontalAlignment(SwingConstants.CENTER);
			headers[i].setText("Highscores: " + header_text[i]);
			headers[i].setForeground(Color.pink);
			headers[i].setFont(font);
			
			this.add(headers[i]);
			
			for(int j=0; j<highscores[i].length; j++) {
				highscores[i][j] = new JLabel();
				highscores[i][j].setSize(headers[i].getSize());
				highscores[i][j].setLocation(i * headers[i].getWidth(), highscores[i][j].getHeight()*j + highscores[i][j].getHeight());
				highscores[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				highscores[i][j].setText((j+1) + ".  " + scores[i][j]);
				highscores[i][j].setForeground(Color.yellow);
				highscores[i][j].setFont(font);
				
				this.add(highscores[i][j]);
			}
		}
		
		this.setSize(background.getWidth(), headers[0].getHeight()*11 + button_returnToStart.getHeight() + 20);
		button_returnToStart.setLocation((this.getWidth()-button_returnToStart.getWidth())/2, this.getHeight()-button_returnToStart.getHeight());
		
		this.setLocation((background.getWidth()-this.getWidth())/2, (background.getHeight()-this.getHeight())/2);
		this.add(button_returnToStart);
	}
}

package container;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import buttons.Button_FindExit;
import controller.Controller;
import controller.Listener;
import gui.Timer_Display;
import logic.Cell;

public class Container_GameScreen extends JPanel{
	private JLabel board;
	private Timer_Display timer;
	
	public Container_GameScreen(Controller controller, Listener listener, JLabel background, Cell[][] field) {
		this.setSize(background.getSize());
		this.setOpaque(false);
		this.setLayout(null);
		
		board = new JLabel(new ImageIcon("gui\\images\\grass.jpg"));
		board.setSize(field.length * 20, field.length * 20);
		board.setLocation((this.getWidth()-board.getWidth())/2, (this.getHeight()-board.getHeight())/2);
		board.setLayout(new GridLayout(field.length, field.length));
		for(int i=0; i<field.length; i++) {
			for(int j=0; j<field.length; j++) {
				field[i][j].set_walls();
				board.add(field[i][j]);
			}
		}
		
		Button_FindExit button_findExit = new Button_FindExit(controller, listener);
		button_findExit.setLocation((this.getWidth() + board.getWidth())/2 + (this.getWidth()/2 - board.getWidth()/2 - button_findExit.getWidth())/2, (this.getHeight()-button_findExit.getHeight())/2);
	
		timer = new Timer_Display();
		timer.setLocation(((this.getWidth()-board.getWidth())/2 - timer.getWidth())/2, (this.getHeight()-timer.getHeight())/2);
		
		this.add(timer);
		this.add(board);
		this.add(button_findExit);
		reload_board();
	}
	
	public void reload_board() {
		board.revalidate();
		board.repaint();
	}
	
	public void update_timer(int minutes, int seconds) {
		timer.update(minutes, seconds);
		timer.repaint();
	}
}


package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

import buttons.Button_FindExit;
import container.Container_GameScreen;
import container.Container_Highscore;
import container.Container_StartScreen;
import container.Container_VictoryScreen;
import controller.Controller;
import controller.Listener;
import logic.Cell;

public class GUI extends JFrame{
	private Controller controller;
	private Listener listener;

	private Player player;
	private Container_StartScreen startScreen;
	private Container_GameScreen gameScreen;
	private Container_VictoryScreen victoryScreen;
	private Container_Highscore highscoreScreen;
	private JLabel background;
	private Button_FindExit button_findExit;
	
	
	public GUI(Controller controller, Listener listener) {
		this.controller = controller;
		this.listener = listener;

		this.setSize(1500,800);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.addKeyListener(controller);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("A - MAZE - ING");
		this.setVisible(true);
		
		
		background=new JLabel(new ImageIcon("gui\\images\\background.jpg"));	
		background.setSize(this.getContentPane().getWidth(), this.getContentPane().getHeight());
		background.setLocation(0,0);
		background.setLayout(null);
        this.add(background);
        
        startScreen = new Container_StartScreen(controller, listener, background);
        background.add(startScreen);
		
		this.repaint();
		
		
		button_findExit = new Button_FindExit(controller, listener);
		button_findExit.setLocation(background.getWidth()/2-(button_findExit.getWidth()+50), 
				(background.getHeight()-button_findExit.getHeight())/2);
		
	}
	
	public boolean init(Cell[][] field) {
		if(field == null) {
			return false;
		}
		
		background.removeAll();
		startScreen = null;
		
		gameScreen = new Container_GameScreen(controller, listener, background, field);
		player = new Player(field[0][0].getWidth());
		background.add(gameScreen);
		reload_background();
		this.requestFocus();
		
		return true;
	}
	
	public void victory(int[] elapsedTime) {		
		background.removeAll();
		victoryScreen = new Container_VictoryScreen(controller, listener, background, elapsedTime);
		background.add(victoryScreen);
		reload_background();
	}
	
	public void reset() {
		background.removeAll();
		victoryScreen = null;
		startScreen = new Container_StartScreen(controller, listener, background);
		background.add(startScreen);
		reload_background();
	}
	
	public void show_highscore(String[][] scores){
		background.removeAll();
		highscoreScreen = new Container_Highscore(controller, listener, background, scores);
		background.add(highscoreScreen);
		reload_background();
	}
	
	public void reload_background() {
		background.revalidate();
		background.repaint();
	}
	
	public void reload_board() {
		gameScreen.reload_board();
		this.requestFocus();
	}
	
	public void update_timer(int minutes, int seconds) {
		gameScreen.update_timer(minutes, seconds);
	}
	
	/*
	 * 
	 * Getter / Setter
	 * 
	 */
	
	public void set_position(Cell[] position) {
		if(position != null) {
			position[0].add(player);
			position[0].repaint();
			
			if(position[1] != null) {
				position[1].remove(player);
				position[1].repaint();
			}
		}
		
		this.requestFocus();
	}
}
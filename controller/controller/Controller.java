package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;

import gui.GUI;
import logic.Cell;
import logic.Logic;

public class Controller implements ActionListener, KeyListener{
	private Logic logic;
	private Listener listener;
	private GUI gui;
	
	public Controller() {
		logic = new Logic(this);
		listener = new Listener();
		gui = new GUI(this, listener);
	}
	
	private void init() {
		if(gui.init(logic.init())) {
			gui.set_position(new Cell[] {logic.get_currentPosition(), null});
		}
	}
	
	public void update_timer(int minutes, int seconds) {
		gui.update_timer(minutes, seconds);
	}
	
	private void set_selected(Object source) {
		try {
			source.getClass().getMethod("set_selected").invoke(source);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("start")) {
			init();
		}
		else if(e.getActionCommand().equals("return")) {
			gui.reset();
			logic.reset();
		}
		else if(e.getActionCommand().equals("exit")) {
			logic.find_exit();
			gui.reload_board();
		}
		else if(e.getActionCommand().equals("highscore")) {
			gui.show_highscore(logic.get_highscores());
		}
		else if(e.getActionCommand().equals("small")) {
			logic.set_size(1);
			this.set_selected(e.getSource());
		}
		else if(e.getActionCommand().equals("medium")) {
			logic.set_size(2);
			this.set_selected(e.getSource());
		}
		else if(e.getActionCommand().equals("large")) {
			logic.set_size(3);
			this.set_selected(e.getSource());
		}
	}
	
	public static void main(String args[]) {
		Controller controller = new Controller();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {		
		if(e.getKeyCode() == KeyEvent.VK_W) {
			gui.set_position(logic.move(0));
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			gui.set_position(logic.move(1));
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			gui.set_position(logic.move(2));
			if(logic.get_isFinished()) {
				gui.victory(logic.get_time());
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			gui.set_position(logic.move(3));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

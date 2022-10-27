package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controller.Controller;

public class Logic {
	private Timer timer;
	private Cell currentPosition, exit;
	private int size;
	private boolean isFinished, pathShown, firstMove, isHighscore;
	
	public Logic(Controller controller) {
		timer = new Timer(controller);
		
		size = 0;
		isFinished = false;
		pathShown = false;
		firstMove = true;
		isHighscore = false;
	}
	
	public Cell[][] init() {
		if(size == 0) {
			return null;
		}
		
		Cell[][] field = new Cell[size*10+5][size*10+5];
		for(int i=0; i<field.length; i++) {
			for(int j=0; j<field.length; j++) {
				field[i][j] = new Cell();
				
				if(i!=0) {
					field[i][j].set_neighbour(0, field[i-1][j]);
					field[i-1][j].set_neighbour(2, field[i][j]);
				}
				if(j!=0) {
					field[i][j].set_neighbour(1, field[i][j-1]);
					field[i][j-1].set_neighbour(3, field[i][j]);
				}
			}
		}
		
		generateLabyrinth(field);
		return field;
	}
	
	private void generateLabyrinth(Cell[][] field) {
		Random random = new Random();
		currentPosition = field[0][random.nextInt(field.length)];
		currentPosition.remove_wall(0);
		
		field[random.nextInt(field.length)][random.nextInt(field.length)].generateLabyrinth();
		
		List<Integer> possibleExit = new ArrayList<Integer>();
		boolean[] walls;
		for(int i=0; i<field.length; i++) {
			walls = field[field.length-1][i].get_walls();
			
			if(walls[1] && walls[3]) {
				possibleExit.add(i);
			}
			else if(walls[0] && (walls[1] || walls[3])) {
				possibleExit.add(i);
			}
		}
		
		exit = field[field.length-1][possibleExit.get(random.nextInt(possibleExit.size()))];
		exit.remove_wall(2);
		
	}
	
	private void handle_highscore() {
		Highscore highscore = new Highscore(size);
		List<String> scores = highscore.read_file();
		
		int[] data = timer.get_time();
		int currentScore = data[0] * 60 + data[1];
		
		if(scores.size() > 0) {
			for(int i=0; i<scores.size(); i++) {
				if(Integer.parseInt(scores.get(i)) > currentScore) {
					isHighscore = true;
					scores.add(i, Integer.toString(currentScore));
					break;
				}
			}
			
			if(scores.size() > 10) {
				scores.remove(10);
			}
			else if(scores.size() < 10 && !isHighscore) {
				isHighscore = true;
				scores.add(scores.size(), Integer.toString(currentScore));
			}
			
			if(isHighscore) {
				highscore.write_file(scores);
			}
		}else {
			isHighscore = true;
			scores.add(Integer.toString(currentScore));
			highscore.write_file(scores);
		}
	}
	
	public void find_exit() {
		if(pathShown) {
			exit.removePath(null);
			pathShown = false;
		}else {
			currentPosition.find_exit(null);
			pathShown = true;
		}
	}
	
	public Cell[] move(int direction) {
		if(firstMove) {
			timer.start();
			firstMove = false;
		}
		
		Cell temp = currentPosition;
		currentPosition = currentPosition.move(direction, pathShown);
		
		if(temp == currentPosition) {
			return null;
		}
		else if(currentPosition == null) {
			timer.set_update(false);
			isFinished = true;
			this.handle_highscore();
			return null;
		}
		
		return new Cell[] {currentPosition, temp};
	}
	
	public String[][] get_highscores() {
		Highscore highscore = new Highscore(0);
		String[][] result = new String[3][10];
		
		List<String> scores;
		int temp;
		for(int i=0; i<result.length; i++) {
			scores = highscore.get_highscores(i+1);
			
			for(int j=0; j<result[i].length; j++) {
				try {
					temp = Integer.parseInt(scores.get(j));
					
					result[i][j] = Integer.toString((int)(temp/60)) + " Minutes  ";
					result[i][j] += temp%60 + " Seconds";
				}catch(Exception e){
					result[i][j] = " - - - - - "; 
				}
			}
		}
		
		return result;
	}
		
	public void reset() {
		size = 0;
		isFinished = false;
		pathShown = false;
		firstMove = true;
		isHighscore = false;
	}
	
	public Cell get_currentPosition() {
		return currentPosition;
	}
	
	public boolean get_isFinished() {
		return isFinished;
	}
	
	public void set_size(int size) {
		this.size = size;
	}
	
	public int[] get_time() {
		return timer.get_time();
	}
}


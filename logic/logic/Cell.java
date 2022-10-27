package logic;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class Cell extends JPanel{
	private Color COLOR_WALL = new Color(218,165,32);
	/*
	 0: north
	 1: west
	 2: south
	 3: east
	*/
	private final boolean[] wall = {true, true, true, true};
	private final Cell[] neighbour = new Cell[4];
	
	private boolean visited = false, isPath = false;
	
	public Cell() {
		super();
		
		this.setBackground(Color.black);
		this.setOpaque(false);
	}
	
	public void generateLabyrinth() {
		List<Integer> choice = new ArrayList<Integer>();
		visited = true;
		
		for(int i=0; i<neighbour.length; i++) {
			if(neighbour[i]!=null && !neighbour[i].get_visited()) {
				choice.add(i);
			}
		}
		
		int i;
		while(choice.size() > 0) {
			i = choice.get((int)(Math.random()*choice.size()));
			if(!neighbour[i].get_visited()) {
				remove_wall(i);
				neighbour[i].remove_wall((i+2) % 4);
				neighbour[i].generateLabyrinth();
			}
			choice.remove(Integer.valueOf(i));
		}
	}
	
	public boolean find_exit(Cell caller) {
		if(neighbour[2]==null && !wall[2]) {
			this.setOpaque(true);
			isPath = true;
			return true;
		}
		
		for(int i=0; i<neighbour.length; i++) {
			if(!wall[i] && neighbour[i]!=null && neighbour[i]!=caller) {
				if(neighbour[i].find_exit(this)) {
					this.setOpaque(true);
					isPath = true;
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void removePath(Cell caller) {
		if(!isPath) {
			return;
		}
		
		isPath = false;
		this.setOpaque(false);
		
		for(int i = 0; i<neighbour.length; i++) {
			if(!wall[i] && neighbour[i]!=null && neighbour[i]!=caller) {
				neighbour[i].removePath(this);
			}
		}
	}
	
	public Cell move(int direction, boolean pathShown) {
		if(!wall[direction]) {
			if(pathShown && neighbour[direction] != null) {
				isPath = neighbour[direction].addPath();
				this.setOpaque(isPath);
			}
			
			return neighbour[direction];
		}
		
		return this;
	}
	
	public boolean addPath() {
		if(isPath) {
			return false;
		}
		
		isPath = true;
		this.setOpaque(true);
		return true;
	}
	
	public void remove_wall(int direction) {
		wall[direction] = false;
	}
		
	public void set_walls() {	
		setBorder(new MatteBorder((wall[0]) ? 2 : 0, (wall[1]) ? 2 : 0, (wall[2]) ? 2 : 0, (wall[3]) ? 2 : 0, COLOR_WALL));
		if(!wall[0] && neighbour[0]==null) {
			wall[0] = true;
		}
	}
	
	public void set_neighbour(int direction, Cell neighbour) {
		this.neighbour[direction] = neighbour;
	}
	
	public boolean[] get_walls() {
		return wall;
	}
	
	public boolean get_visited() {
		return visited;
	}
}

package gui;

import java.awt.Color;

import javax.swing.JPanel;

public class Player extends JPanel{
	public Player(int dimension) {
		this.setSize(dimension/2, dimension/2);
		this.setBackground(Color.white);
		
		this.setLocation((dimension - this.getWidth())/2, (dimension - this.getHeight())/2);
	}
}

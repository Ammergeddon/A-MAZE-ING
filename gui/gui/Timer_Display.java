package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Timer_Display extends JLabel{	
	public Timer_Display() {
		this.setSize(400, 180);
		this.setOpaque(false);
		this.setLayout(null);
		
		Font font = new Font("Verdana", Font.BOLD, 128);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setForeground(Color.blue);
		this.setFont(font);
		this.setText("0:00");
	}
	
	public void update(int minutes, int seconds) {
		String text = minutes + ":" + (int)((seconds - seconds%10)/10) + "" + seconds%10;
		this.setText(text);
	}
}

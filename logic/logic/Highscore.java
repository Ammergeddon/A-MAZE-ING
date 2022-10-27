package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Highscore {
	private final String filename_small = "highscores_small.csv";
	private final String filename_medium = "highscores_medium.csv";
	private final String filename_large = "highscores_large.csv";
	private String filename;
	
	public Highscore(int size) {
		this.set_size(size);
	}
	
	public void set_size(int size) {
		switch(size) {
		case 0:
			filename = null;
		case 1:
			filename = filename_small;
			break;
		case 2:
			filename = filename_medium;
			break;
		case 3:
			filename = filename_large;
			break;
		default:
			filename = null;
			System.out.println("Filesize index out of range!");
		}
	}
	
	public void write_file(List<String> data) {
		try {
			FileWriter writer = new FileWriter(filename);
			for(int i=0; i<data.size(); i++) {
				writer.append(data.get(i));
				writer.append(';');
			}
			
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<String> read_file() {
		List<String> highscores = new ArrayList<String>();
		
		try {
			Scanner sc = new Scanner(new File(filename));
			sc.useDelimiter(";");
			
			while(sc.hasNext()) {
				highscores.add(sc.next());
			}
		} catch (FileNotFoundException e) {
			return highscores;
		}
		
		return highscores;
	}
	
	public List<String> get_highscores(int size){
		List<String> highscores = new ArrayList<String>();
		this.set_size(size);
		
		try {
			Scanner sc = new Scanner(new File(filename));
			sc.useDelimiter(";");
			
			while(sc.hasNext()) {
				highscores.add(sc.next());
			}
		} catch (FileNotFoundException e) {
			return highscores;
		}
		
		return highscores;
	}
}

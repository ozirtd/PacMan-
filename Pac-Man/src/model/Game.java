package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.scene.shape.Circle;

public class Game {
	
	private ArrayList<Balls> BList = new ArrayList<Balls>() ;
	private String path;
	private int number;
	
	public Game( ) {
	
		
	}
	
	public void save() throws FileNotFoundException {
		String message = "";
		File f = new File("Data/Game" + number + ".txt");
		PrintWriter pw = new PrintWriter(f);
		for(int c = 0; c < BList.size(); c++) {
			message += BList.get(c).Report() + "\n";
		}
		pw.write(message);
		pw.close();

	}
	
	public int load(String path) throws IOException {
		FileReader fr = new FileReader("Data/Game1.txt");
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		int level = 0;
		String line = br.readLine();
	
		while(line != null) {
			if(line.charAt(0) != '#') {
				
			String[] array = line.split("\t");
			
			if(array.length == 1) {
				level = Integer.parseInt(array[0]);
			}else {
			double radius = Double.parseDouble(array[0]);
			double x = Double.parseDouble(array[1]);
			double y = Double.parseDouble(array[2]);
			double speed = Double.parseDouble(array[3]);
			String direction = array[4];
		    int  nbounce = Integer.parseInt(array[5]);
			boolean bounce = Boolean.parseBoolean(array[6]);
			Balls b = new Balls(x,y,radius,nbounce,bounce,direction,speed);
			
			 BList.add(b);
			}
			
			}
			line = br.readLine();
			
			
		}
	
		return level;
	}
	
	
	public ArrayList<Balls> getBList() {
		return BList;
	}
	

	
	
	public void setBList(ArrayList<Balls> bList) {
		BList = bList;
	}
	
	
	

	

}

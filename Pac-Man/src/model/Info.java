package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Info implements Serializable{
	
	private String name;
	private int score;
	
	public Info(String name , int score) {
           this.name = name;
           this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String Report() {
		String message = name + "	" + score;
		return message;
	}

}

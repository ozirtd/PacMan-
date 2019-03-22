package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HallOfFame implements Serializable{
	
	Info[] level1 = new Info[10];
	Info[] level2 = new Info[10];
	Info[] level3 = new Info[10];
	
	public HallOfFame() {
		
	}
	
	public Info[] getLevel1() {
		return level1;
	}
	
	public Info[] getLevel2() {
		return level2;
	}
	
	public Info[] getLevel3() {
		return level3;
	}
	
	public String addScore(Info player , int level) {
		String message = "El jugador no tiene el puntaje necesario para el salon de la fama";
		switch (level){
		
		case 1:
			for(int c = 0; c < level1.length; c++) {
				if(level1[c].getScore() < player.getScore()) {
					level1[c] = player;
				}
			}
			message = "se añadio al salon de la fama";
			break;
		
			
		case 2:
			for(int c = 0; c < level2.length; c++) {
				if(level2[c].getScore() < player.getScore()) {
					level2[c] = player;
				}
			}
			message = "se añadio al salon de la fama";
			break;
			
		case 3:
			
			for(int c = 0; c < level2.length; c++) {
				if(level2[c].getScore() < player.getScore()) {
					level2[c] = player;
				}
			}
			message = "se añadio al salon de la fama";
			break;
			
		}
		
		return message;
	}
	
	public String showHallofFame(int level) {
		String message = "Nombre" + "	" + "Puntaje";
		switch (level) {
		
		case 1:
			
			for(int c = 0; c < level1.length; c++) {
				if(level1[c] != null) {
				message += level1[c].Report() + "\n";
				}
			}
			break;
			
		case 2:
			for(int c = 0; c < level2.length; c++) {
				if(level2[c] != null) {
				message += level2[c].Report() + "\n";
				}
			}
			
			break;
			
		case 3:
			
			for(int c = 0; c < level3.length; c++) {
				if(level3[c] != null) {
				message += level3[c].Report() + "\n";
				}
			}
			
			
			break;
			
		}
		
		return message;
	}
	
	
	

}

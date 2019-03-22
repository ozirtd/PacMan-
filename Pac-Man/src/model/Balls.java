package model;

import java.io.Serializable;

public class Balls implements Serializable{
	
private enum Direction{Derecha, Izquierda,Arriba,Abajo};
	
	private double x;
	private double y;
	private double radius;
	private Direction direction;
	private Direction pdirection;
	private boolean bounce;
	private int nbounce;
	private double speed;
	private boolean stop = false;
	public Balls(double x, double y,double radius,int nbounce, boolean bounce, String dir, double speed) {
		this.x= x;
		this.y = y;
		this.radius =radius;
		this.speed = speed;
		
		this.nbounce = nbounce;
		this.bounce = bounce;
		
		switch(dir) {
		
		case "Derecha" : 
			direction = Direction.Derecha;
			break;
		case "Izquierda" :
			direction = Direction.Izquierda;
			break;
		case "Arriba" :
			direction = Direction.Arriba;
			break;
		case "Abajo" :
			direction = Direction.Abajo;
			break;
		
		}
	pdirection = direction;
	
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getX() {
		return x;
	}
	
	
	public double getY() {
		return y;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public double getSpeed() {
		return speed;
	}
	public boolean isStop() {
		return stop;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	
	public double updatex(double width, double increment) {
	
	if(increment <= 0) {
		direction = Direction.Derecha;
	}else if (increment >= width) {
		direction = Direction.Izquierda;
	}
	
		int move = 0;
	 switch(direction) {
	 case Derecha:
		 move = 2;
		 break;
	 case Izquierda:
		 move = -2;
		 break;
	default:
		break;
		 
	 }
		return move;
	
		
	}
	
	public double updatey(double height, double increment) {
		
		if(increment > height) {
			direction = Direction.Arriba;
		}else if (increment <= radius+10) {
			direction = Direction.Abajo;
		}
		
		
		int move = 0;
		
		switch(direction) {
		 case Arriba:
			 move = -2;
			 break;
		 case Abajo:
			 move = +2;
			 break;
		default:
			break;
			 
		 }
			return move;
	}
	public int score() {
		int point = 0;
		if(pdirection != direction) {
			point = 1;
			pdirection = direction;
		}
		return point;
	}
	
	public String Report() {
	String message =   radius + "\t"+ x + "\t" + y +"\t" + speed + "\t" + direction + "\t" + nbounce + "\t" + bounce;
		
		return message;
		
	}
	
	public void ChangeDirection(){
		switch(direction) {
		
		case Derecha:
			
			direction = Direction.Izquierda;
			
			break;
			
		case Izquierda:
			
			direction = Direction.Derecha;
			
			break;
			
		case Arriba:
			
			direction = Direction.Abajo;
			
			break;
			
		case Abajo:
			
			direction = Direction.Arriba;
			
			break;
		
		}
	}
	
	
	
}



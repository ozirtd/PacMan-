package Thread;

import UI.MainController;
import model.Balls;

public class ShapeThread extends Thread {
	
	private Balls b;
	private MainController controler;
	private double speed;
	

	public ShapeThread(Balls b,MainController controler, double speed) {
		this.b = b;
		this.controler = controler;
		this.speed = speed;
	}
	                             
	public void run() {
		while(b.isStop() == false) {
			controler.MoveShape(b);
			
			try {
				long time = (long)speed + 40;
				sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		
		}
	}
	
	
	
	



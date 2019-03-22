package UI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Thread.ShapeThread;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import model.Balls;
import model.Game;
import model.HallOfFame;


public class MainController implements Serializable{

	private ArrayList<Balls> BList;
	private ArrayList<Arc> CList;
	private ArrayList<Circle> CircleList;
	private int score = 0;
	private int level;
	private HallOfFame hf;
	private Game firstGame;
	private ShapeThread st;
	
	 
	 @FXML
	    private Pane JPane;

	    @FXML
	    private MenuBar MenuBar;

	    @FXML
	    private Label Score;

	    
	    public void initialize() {
	    	JPane.setStyle("-fx-background-color : White");
	    	BList = new ArrayList<Balls>();
			CList = new ArrayList<Arc>();
			CircleList = new ArrayList<Circle>();
			hf = new HallOfFame();
			LoadHallOfFame();
			 
	    }
	    
	    public void CreateGame(ActionEvent event) throws IOException {
	    	firstGame = new Game();
	    	level = firstGame.load("Data/Game1.txt");
	    	BList = firstGame.getBList();
	    	
	    	for(int c = 0; c < BList.size(); c++) {
	    		if(BList.get(c) != null) {
	    			Balls ball = BList.get(c);
	    			Arc a = new Arc();
	    			a.setLayoutX(BList.get(c).getX());
	    			a.setLayoutY(BList.get(c).getY());
	    			a.setRadiusX(BList.get(c).getRadius());
	    			a.setRadiusY(BList.get(c).getRadius());
	    			a.setLayoutX(BList.get(c).getX());
	    			a.setStartAngle(45.0f);
	    			a.setType(ArcType.ROUND);
	    			a.setVisible(true);
	    			a.setLength(270.0f);
	    			a.setFill(Color.YELLOW);
	    			a.setOnMouseClicked(new EventHandler <MouseEvent>() {

						@Override
						public void handle(MouseEvent arg0) {
							ball.setStop(true);
				
						  System.out.println(st.isAlive());
					
						}
	    				
	    			});
	    		
	    			
	    			Circle eye = new Circle();
	    			eye.setLayoutX(BList.get(c).getX());
	    			eye.setLayoutY(BList.get(c).getY());
	    			eye.setRadius(BList.get(c).getRadius()-20);
	    			eye.setFill(Color.BLACK);
	    			eye.setVisible(true);
	    			CircleList.add(eye);
	    			
	    
	    			
	    			CList.add(a);
	    			JPane.getChildren().add(a);
	    			JPane.getChildren().add(eye);
	    			 st = new ShapeThread(ball,this,BList.get(c).getSpeed());
	    			 st.start();
	    				    		}
	    	}
	    	
	    	
	    
	    }
	    
	    public void MoveShape(Balls b) {
	    	Balls b1 = null;
	    	Arc c1 = null;
	    	Circle eye1 = null;
	    	
	    	double intersection;
	    	double WidthPane = 	JPane.getWidth();
			double HeightPane = JPane.getHeight()-MenuBar.getHeight();
			for(int c = 0; c < BList.size(); c++) {
				if(BList.get(c).equals(b)) { 
				c1 = CList.get(c);
				b1 = BList.get(c);
				eye1 = CircleList.get(c);
			
				}
			}
				for(int c = 0;c < BList.size(); c++ ) {
				
					double x1 = c1.getLayoutX();
					double y1 = c1.getLayoutY();
					
					double x2 = CList.get(c).getLayoutX();
					double y2 = CList.get(c).getLayoutY();
					
					 intersection = inter(x1,y1,x2,y2);
				 
					if(c1.getRadiusX() + CList.get(c).getRadiusX() >= intersection){
						b1.ChangeDirection();
						BList.get(c).ChangeDirection();
						
	    	
					}
					//cambiar el mecanismo de movimiento de los arcos
						double xincrement = c1.getLayoutX();
						double yincrement = c1.getLayoutY();
					
						c1.setLayoutX(xincrement + b1.updatex(WidthPane, xincrement));
						c1.setLayoutY(yincrement + b1.updatey(HeightPane, yincrement));
						eye1.setLayoutX(xincrement + b1.updatex(WidthPane, xincrement));
						eye1.setLayoutY(yincrement + (b1.updatey(HeightPane, yincrement))-12);
						
						score += BList.get(c).score();
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								Score.setText(Integer.toString(score));
								
							}
							
						});
						
					
				}
				
	    
	  }
	    
	    public static double inter(double x1, double y1,double x2, double y2) {
	    	double result = 0.0;
	    	double pow1 = Math.pow((x1 - x2), 2);
	    	double pow2 = Math.pow((y1 - y2), 2);
	    	pow1 = pow1 + pow2;
	    	result = Math.sqrt(pow1);
	    	return result;
	    	
	    }
	    
	    public void Exit(ActionEvent e) {
	    	System.exit(0);
	    }
	    
	    public void GuardarJuego(ActionEvent e) {
	    	try {
				firstGame.save();
			} catch (FileNotFoundException ex) {
				JOptionPane.showMessageDialog(null, "No se pudo cargar el archivo");
			}finally{
				JOptionPane.showMessageDialog(null, "Se guardo exitosamente el juego");
			}
	    }
	    
	    
	    
	    
	    public void SaveHallOfFame(ActionEvent event) {
	    	try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data/HallOfFame.txt"));
				oos.writeObject(hf);
				oos.close();
				JOptionPane.showMessageDialog(null, "Se salvo exitosamente el salon de la fama");
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "No se pudo encontrar el salon de la fama");
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "No se pudo cargar el salon de la fama");
				
			}
	    }
	    
	   public void LoadHallOfFame() {
		   
		  try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data/HallOfFame.txt"));
			
			try {
				hf = (HallOfFame)ois.readObject();
				ois.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No se pudo cargar el archivo de Salon de la fama");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Hubo un error el archivo de Salon de la fama");
			e.printStackTrace();
		}
		   
	   }
	   
	 
	 
			
  }
	    

	



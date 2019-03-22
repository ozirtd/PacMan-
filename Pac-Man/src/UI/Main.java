package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String [] args) {
		launch(args);
	}

	@Override
	public void start(Stage Stage ) throws Exception {
	
		Parent root = FXMLLoader.load(getClass().getResource("GameInterface.fxml"));
		Scene scene = new Scene(root);
		Stage.setTitle("Juego");
		Stage.setScene(scene);
		Stage.show();
	}
	
	
	}


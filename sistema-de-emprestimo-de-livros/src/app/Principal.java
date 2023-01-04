package app;

import app.view.TelaDeLogin;
import javafx.application.Application;
import javafx.stage.Stage;

public class Principal extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		new TelaDeLogin(primaryStage);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

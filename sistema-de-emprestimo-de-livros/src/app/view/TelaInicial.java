package app.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TelaInicial {
	
	private Stage primaryStage;
	private Stage secondStage = new Stage();
	private Scene cenaInicial;
	private String CSS = getClass().getResource("/app/view/estilo.css").toExternalForm();
	private HBox boxTelaInicial = new HBox();
	private Label labelTitulo = new Label("Universidade Federal Fluminense");
	private HBox boxTitulo = new HBox();
	
	public TelaInicial(Stage primaryStage) {
		this.primaryStage = primaryStage;
		inicializar();
		exibirTelaDeLogin();
	}
	
	private void inicializar() {
		labelTitulo.getStyleClass().add("tituloPrincipal");
		
		boxTitulo.setMaxHeight(50);
		
		boxTitulo.getChildren().add(labelTitulo);
		boxTitulo.getStyleClass().add("boxTituloPrincipal");
		
		boxTelaInicial.getChildren().add(boxTitulo);
		boxTelaInicial.getStyleClass().add("telaInicial");
		boxTelaInicial.setAlignment(Pos.BASELINE_CENTER);
		
		cenaInicial = new Scene(boxTelaInicial, 1200, 650);
		cenaInicial.getStylesheets().add(CSS);
		
		primaryStage.setScene(cenaInicial);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Emprestimo De Livros");
		primaryStage.show();
	}
	
	private void exibirTelaDeLogin() {
		Scene login = TelaDeLogin.obterCena(secondStage);
		login.getStylesheets().add(CSS);
		secondStage.setScene(login);
		secondStage.setX(560);
		secondStage.setY(200);
		secondStage.setResizable(false);
		secondStage.setTitle("Login");
		secondStage.show();
	}
	
}

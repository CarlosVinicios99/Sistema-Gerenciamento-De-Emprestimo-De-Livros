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
	private Titulo titulo;
	
	public TelaInicial(Stage primaryStage) {
		this.primaryStage = primaryStage;
		inicializar();
		exibirTelaDeLogin();
	}
	
	private void inicializar() {
		labelTitulo.getStyleClass().add("tituloPrincipal");
		
		titulo = new Titulo(labelTitulo);
		titulo.getStyleClass().add("boxTituloPrincipal");
		
		boxTelaInicial.getChildren().add(titulo);
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
		Scene login = TelaDeLogin.obterCena(primaryStage, secondStage);
		login.getStylesheets().add(CSS);
		secondStage.setScene(login);
		secondStage.setX(560);
		secondStage.setY(200);
		secondStage.setResizable(false);
		secondStage.setTitle("Login");
		secondStage.show();
	}
	
}

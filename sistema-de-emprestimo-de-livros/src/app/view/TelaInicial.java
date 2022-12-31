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
	
	public TelaInicial(Stage primaryStage) {
		this.primaryStage = primaryStage;
		inicializar();
		exibirTelaDeLogin();
	}
	
	private void inicializar() {
		labelTitulo.getStyleClass().add("tituloPrincipal");
		boxTelaInicial.setSpacing(30);
		boxTelaInicial.setAlignment(Pos.BASELINE_CENTER);
		boxTelaInicial.getChildren().add(labelTitulo);
		boxTelaInicial.getStyleClass().add("telaInicial");
		cenaInicial = new Scene(boxTelaInicial, 1200, 650);
		cenaInicial.getStylesheets().add(CSS);
		primaryStage.setScene(cenaInicial);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Emprestimo De Livros");
		primaryStage.show();
	}
	
	private void exibirTelaDeLogin() {
		Scene login = TelaDeLogin.obterCena();
		secondStage.setScene(login);
		secondStage.setX(560);
		secondStage.setY(200);
		secondStage.setResizable(false);
		secondStage.setTitle("Login");
		secondStage.show();
	}
	
}

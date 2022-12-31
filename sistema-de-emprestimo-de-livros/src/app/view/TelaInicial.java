package app.view;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TelaInicial {
	
	private Stage primaryStage;
	private Stage secondStage = new Stage();
	private Scene cenaInicial;
	private String CSS = getClass().getResource("/app/view/estilo.css").toExternalForm();
	
	public TelaInicial(Stage primaryStage) {
		this.primaryStage = primaryStage;
		inicializar();
		exibirTelaDeLogin();
	}
	
	private void inicializar() {
		cenaInicial = new Scene(new HBox(), 1200, 650);
		primaryStage.setScene(cenaInicial);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Emprestimo De Livros");
		primaryStage.show();
	}
	
	private void exibirTelaDeLogin() {
		Scene login = TelaDeLogin.obterCena();
		secondStage.setScene(login);
		secondStage.setResizable(false);
		secondStage.setTitle("Login");
		secondStage.show();
	}
	
}

package app.view;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class TelaDeLogin {
	
	static private HBox boxLogin;
	static private Scene cenaLogin;
	static private Label labelEmail;
	static private Label labelSenha;
	static private TextField campoEmail;
	static private PasswordField campoSenha;
	static private Button botaoEntrar;
	
	private TelaDeLogin() {
		
	}
	
	private static void configurarElementosVisuais() {
		boxLogin = new HBox();
		boxLogin.setMaxHeight(250);
		boxLogin.setMaxWidth(400);
		boxLogin.setAlignment(Pos.BASELINE_CENTER);
		boxLogin.setSpacing(10);
		
		labelEmail = new Label("E-mail:");
		labelEmail.setMaxSize(30, 15);
		labelSenha = new Label("Senha:");
		
		campoEmail = new TextField();
		campoSenha = new PasswordField();
		
		botaoEntrar = new Button("Entrar");
	}
	
	private static void adicionarElementosNaTela() {
		boxLogin.getChildren().add(labelEmail);
		boxLogin.getChildren().add(campoEmail);
		boxLogin.getChildren().add(labelSenha);
		boxLogin.getChildren().add(campoSenha);
		boxLogin.getChildren().add(botaoEntrar);
	}
	
	private static void adicionarAcaoBotaoEntrar() {
		
	}
	
	public static Scene obterCena() {
		configurarElementosVisuais();
		adicionarElementosNaTela();
		adicionarAcaoBotaoEntrar();
		cenaLogin = new Scene(boxLogin, 300, 400);
		return cenaLogin;
	}
	
	
	
}

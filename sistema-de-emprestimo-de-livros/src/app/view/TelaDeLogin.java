package app.view;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class TelaDeLogin {
	
	static private GridPane gridPaneLogin;
	static private Scene cenaLogin;
	static private Label labelEmail;
	static private Label labelSenha;
	static private TextField campoEmail;
	static private PasswordField campoSenha;
	static private Button botaoEntrar;
	
	private TelaDeLogin() {
		
	}
	
	private static void configurarElementosVisuais() {
		gridPaneLogin = new GridPane();
		criarGrid();
		
		labelEmail = new Label("E-mail: ");
		labelEmail.setMaxSize(70, 25);
		labelEmail.setAlignment(Pos.BASELINE_RIGHT);
		labelSenha = new Label("Senha: ");
		labelSenha.setMaxSize(70, 25);
		labelSenha.setAlignment(Pos.BASELINE_RIGHT);
		
		campoEmail = new TextField();
		campoEmail.setMaxSize(230, 30);
		campoSenha = new PasswordField();
		campoSenha.setMaxSize(230, 30);
		
		botaoEntrar = new Button("Entrar");
		botaoEntrar.setMaxSize(70, 25);
		
	}
	
	private static void adicionarElementosNaTela() {
		gridPaneLogin.add(labelEmail, 0, 0);
		gridPaneLogin.add(campoEmail, 1, 0);
		gridPaneLogin.add(labelSenha, 0, 1);
		gridPaneLogin.add(campoSenha, 1, 1);
		gridPaneLogin.add(botaoEntrar, 0, 2);
	}
	
	private static void adicionarAcaoBotaoEntrar() {
		
	}
	
	private static RowConstraints criarLinha() {
		RowConstraints linha = new RowConstraints();
		linha.setPercentHeight(20);
		linha.setFillHeight(true);
		return linha;
	}
	
	private static ColumnConstraints criarColuna(double width) {
		ColumnConstraints coluna = new ColumnConstraints();
		coluna.setFillWidth(true);
		coluna.setPercentWidth(width);
		return coluna;
	}
	
	private static void criarGrid() {
		gridPaneLogin.getRowConstraints().addAll(criarLinha(), criarLinha(), criarLinha(), criarLinha(), criarLinha());
		gridPaneLogin.getColumnConstraints().addAll(criarColuna(25), criarColuna(75));
	}
	
	
	public static Scene obterCena() {
		configurarElementosVisuais();
		adicionarElementosNaTela();
		adicionarAcaoBotaoEntrar();
		cenaLogin = new Scene(gridPaneLogin, 350, 400);
		return cenaLogin;
	}
	
}

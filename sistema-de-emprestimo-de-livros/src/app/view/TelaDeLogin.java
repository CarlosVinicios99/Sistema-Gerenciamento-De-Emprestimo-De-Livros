package app.view;


import app.repositories.DAO;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class TelaDeLogin {
	
	static private GridPane gridPaneLogin;
	static private Scene cenaLogin;
	static private Label labelCpf;
	static private Label labelSenha;
	static private TextField campoCpf;
	static private PasswordField campoSenha;
	static private Button botaoEntrar;
	
	private TelaDeLogin() {
		
	}
	
	private static void configurarElementosVisuais() {
		gridPaneLogin = new GridPane();
		criarGrid();
		gridPaneLogin.getStyleClass().add("telaLogin");
		
		labelCpf = new Label("CPF: ");
		labelCpf.setMaxSize(70, 25);
		labelCpf.setAlignment(Pos.BASELINE_RIGHT);
		labelSenha = new Label("Senha: ");
		labelSenha.setMaxSize(70, 25);
		labelSenha.setAlignment(Pos.BASELINE_RIGHT);
		
		campoCpf = new TextField();
		campoCpf.setMaxSize(230, 30);
		campoSenha = new PasswordField();
		campoSenha.setMaxSize(230, 30);
		
		botaoEntrar = new Button("Entrar");
		botaoEntrar.setTranslateX(47);
		botaoEntrar.setMaxSize(80, 30);
		botaoEntrar.getStyleClass().add("botaoDeConfirmacao");
		
	}
	
	private static void adicionarElementosNaTela() {
		gridPaneLogin.add(labelCpf, 0, 1);
		gridPaneLogin.add(campoCpf, 1, 1);
		gridPaneLogin.add(labelSenha, 0, 2);
		gridPaneLogin.add(campoSenha, 1, 2);
		gridPaneLogin.add(botaoEntrar, 1, 3);
	}
	
	private static void adicionarAcaoBotaoEntrar(Stage primaryStage, Stage secondStage) {
		botaoEntrar.setOnAction(e -> {
			String cpf = campoCpf.getText();
			String senha = campoSenha.getText();
			DAO.iniciarConexao();
			boolean resultado = DAO.bibliotecarioExiste(cpf, senha);
			System.out.println(resultado);
			if(resultado) {
				secondStage.close();
				DAO.fecharConexao();
				new TelaMenuPrincipal(primaryStage);
			}
			else {
				DAO.fecharConexao();
			}	
		});
	}
	
	private static RowConstraints criarLinha() {
		RowConstraints linha = new RowConstraints();
		linha.setPercentHeight(15);
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
	
	
	public static Scene obterCena(Stage primaryStage, Stage secondStage) {
		configurarElementosVisuais();
		adicionarElementosNaTela();
		adicionarAcaoBotaoEntrar(primaryStage, secondStage);
		cenaLogin = new Scene(gridPaneLogin, 350, 400);
		return cenaLogin;
	}
	
}

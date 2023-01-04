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
	
	private Stage stage = new Stage();
	private String CSS = getClass().getResource("/app/view/estilo.css").toExternalForm();
	private GridPane gridPaneLogin = new GridPane();
	private Scene cenaLogin;
	private Titulo titulo;
	private Label labelTitulo = new Label("Universidade Federal Fluminense");
	private Label labelTituloNavegacao = new Label("Olá bibliotecário, faça o login.");
	private Label labelCpf = new Label("CPF: ");
	private Label labelSenha = new Label("Senha: ");
	private TextField campoCpf = new TextField();
	private PasswordField campoSenha = new PasswordField();
	private Button botaoEntrar = new Button("Entrar");
	
	public TelaDeLogin(Stage stage) {
		this.stage = stage;
		criarGrid();
		configurarElementosVisuais();
		adicionarElementosNaTela();
		adicionarAcaoBotaoEntrar();
		exibirCena();
	}
	
	private void criarGrid() {
		gridPaneLogin.getColumnConstraints().addAll(criarColuna(100));
		gridPaneLogin.getRowConstraints().addAll(criarLinha(9), criarLinha(6), criarLinha(9), criarLinha(5),
				criarLinha(6), criarLinha(3), criarLinha(6), criarLinha(6), criarLinha(6));
	}
	
	private RowConstraints criarLinha(double height) {
		RowConstraints linha = new RowConstraints();
		linha.setPercentHeight(height);
		linha.setFillHeight(true);
		return linha;
	}
	
	private ColumnConstraints criarColuna(double width) {
		ColumnConstraints coluna = new ColumnConstraints();
		coluna.setPercentWidth(width);
		coluna.setFillWidth(true);
		return coluna;
	}
	
	private  void configurarElementosVisuais() {
		stage.setTitle("Emprestimos De Livros");
		stage.setResizable(false);
		
		gridPaneLogin.getStyleClass().add("telasDeMenu");
		gridPaneLogin.setAlignment(Pos.TOP_CENTER);
		
		labelTitulo.getStyleClass().add("tituloPrincipal");
		titulo = new Titulo(labelTitulo);
		titulo.getStyleClass().add("boxTituloPrincipal");
		
		labelTituloNavegacao.getStyleClass().add("tituloNavegacao");
		labelTituloNavegacao.setTranslateX(450);
		labelTituloNavegacao.setMaxSize(400, 25);
		
		labelCpf.setTranslateX(450);
		labelCpf.setMaxSize(70, 25);
		campoCpf.setTranslateX(550);
		campoCpf.setMaxSize(270, 30);
		
		labelSenha.setTranslateX(450);
		labelSenha.setMaxSize(70, 25);
		campoSenha.setTranslateX(550);
		campoSenha.setMaxSize(270, 30);
		
		botaoEntrar.setTranslateX(620);
		botaoEntrar.getStyleClass().add("botaoDeConfirmacao");
		botaoEntrar.setMaxSize(110, 30);
		
	}
	
	private void adicionarElementosNaTela() {
		gridPaneLogin.add(titulo, 0, 0);
		gridPaneLogin.add(labelTituloNavegacao, 0, 2);
		gridPaneLogin.add(labelCpf, 0, 4);
		gridPaneLogin.add(campoCpf, 0, 4);
		gridPaneLogin.add(labelSenha, 0, 6);
		gridPaneLogin.add(campoSenha, 0, 6);
		gridPaneLogin.add(botaoEntrar, 0, 8);
	}
	
	private void adicionarAcaoBotaoEntrar() {
		botaoEntrar.setOnAction(e -> {
			String cpf = campoCpf.getText();
			String senha = campoSenha.getText();
			DAO.iniciarConexao();
			boolean resultado = DAO.bibliotecarioExiste(cpf, senha);
			System.out.println(resultado);
			if(resultado) {
				DAO.fecharConexao();
				new TelaMenuPrincipal(stage);
			}
			else {
				DAO.fecharConexao();
			}	
		});
	}
	
	
	public void exibirCena() {
		cenaLogin = new Scene(gridPaneLogin, 1300, 700);
		cenaLogin.getStylesheets().add(CSS);
		stage.setScene(cenaLogin);
		stage.show();
	}
	
}

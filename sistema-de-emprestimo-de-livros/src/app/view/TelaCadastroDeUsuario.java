package app.view;

import app.model.entities.Usuario;
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

public class TelaCadastroDeUsuario {
	
	private Stage stage = new Stage();
	private Scene cenaCadastroDeUsuario;
	private String CSS = getClass().getResource("/app/view/estilo.css").toExternalForm();
	private Titulo titulo;
	private Label labelTitulo = new Label("Universidade Federal Fluminense");
	private GridPane gridPaneCadastroDeUsuario = new GridPane();
	
	private Label labelTituloDeNavegacao = new Label("Cadastrar Usuário");
	private TextField campoNome = new TextField();
	private TextField campoEmail = new TextField();
	private TextField campoCpf = new TextField();
	private TextField campoMatricula = new TextField();
	private PasswordField campoSenha = new PasswordField();
	private Label labelNome = new Label("Nome: ");
	private Label labelCpf = new Label("CPF: ");
	private Label labelMatricula = new Label("Matrícula: ");
	private Label labelEmail = new Label("E-mail: ");
	private Label labelSenha = new Label("Senha: ");
	private Button botaoCadastrar = new Button("Cadastrar");
	private Button botaoCancelar = new Button("Cancelar");
	
	public TelaCadastroDeUsuario(Stage stage) {
		this.stage = stage;
		criarGrid();
		configurarElementosVisuais();
		adicionarElementosNaTela();
		adicionarEventoBotaoCadastrar();
		adicionarEventoBotaoCancelar();
		exibirCena();
	}
	
	private void criarGrid() {
		gridPaneCadastroDeUsuario.getColumnConstraints().add(criarColuna(100));
		gridPaneCadastroDeUsuario.getRowConstraints()
			.addAll(criarLinha(9), criarLinha(6), criarLinha(9), criarLinha(6), criarLinha(6), 
				criarLinha(3), criarLinha(6), criarLinha(3), criarLinha(6), criarLinha(3), 
				criarLinha(6), criarLinha(3), criarLinha(6), criarLinha(6), criarLinha(6));
	}
	
	private RowConstraints criarLinha(double heigth) {
		RowConstraints linha = new RowConstraints();
		linha.setPercentHeight(heigth);
		linha.setFillHeight(true);
		return linha;
	}
	
	private ColumnConstraints criarColuna(double width) {
		ColumnConstraints coluna = new ColumnConstraints();
		coluna.setFillWidth(true);
		coluna.setPercentWidth(width);
		return coluna;
	}
	
	private void configurarElementosVisuais() {
		stage.setTitle("Empréstimos De Livros");
		stage.setResizable(false);
		gridPaneCadastroDeUsuario.setAlignment(Pos.TOP_CENTER);
		gridPaneCadastroDeUsuario.getStyleClass().add("telasDeMenu");
		
		labelTitulo.getStyleClass().add("tituloPrincipal");
		titulo = new Titulo(labelTitulo);
		titulo.getStyleClass().add("boxTituloPrincipal");
		
		labelTituloDeNavegacao.setTranslateX(550);
		labelTituloDeNavegacao.setMaxSize(230, 25);
		labelTituloDeNavegacao.getStyleClass().add("tituloNavegacao");
		
		labelNome.setTranslateX(450);
		labelNome.setMaxSize(70, 25);
		campoNome.setTranslateX(550);
		campoNome.setMaxSize(270, 30);
		
		labelMatricula.setTranslateX(450);
		labelMatricula.setMaxSize(110, 25);
		campoMatricula.setTranslateX(550);
		campoMatricula.setMaxSize(270, 30);
		
		labelEmail.setTranslateX(450);
		labelEmail.setMaxSize(70, 25);
		campoEmail.setTranslateX(550);
		campoEmail.setMaxSize(270, 30);
		
		labelCpf.setTranslateX(450);
		labelCpf.setMaxSize(70, 25);
		campoCpf.setTranslateX(550);
		campoCpf.setMaxSize(270, 30);
		
		labelSenha.setTranslateX(450);
		labelSenha.setMaxSize(70, 25);
		campoSenha.setTranslateX(550);
		campoSenha.setMaxSize(270, 30);
		
		botaoCancelar.setTranslateX(450);
		botaoCancelar.setMaxSize(110, 30);
		botaoCancelar.getStyleClass().add("botaoDeConfirmacao");
		botaoCadastrar.setTranslateX(770);
		botaoCadastrar.setMaxSize(110, 30);
		botaoCadastrar.getStyleClass().add("botaoDeConfirmacao");
		
	}
	
	private void adicionarElementosNaTela() {
		gridPaneCadastroDeUsuario.add(titulo, 0, 0);
		gridPaneCadastroDeUsuario.add(labelTituloDeNavegacao, 0, 2);
		gridPaneCadastroDeUsuario.add(labelNome, 0, 4);
		gridPaneCadastroDeUsuario.add(campoNome, 0, 4);
		gridPaneCadastroDeUsuario.add(labelMatricula, 0, 6);
		gridPaneCadastroDeUsuario.add(campoMatricula, 0, 6);
		gridPaneCadastroDeUsuario.add(labelEmail, 0, 8);
		gridPaneCadastroDeUsuario.add(campoEmail, 0, 8);
		gridPaneCadastroDeUsuario.add(labelCpf, 0, 10);
		gridPaneCadastroDeUsuario.add(campoCpf, 0, 10);
		gridPaneCadastroDeUsuario.add(labelSenha, 0, 12);
		gridPaneCadastroDeUsuario.add(campoSenha, 0, 12);
		gridPaneCadastroDeUsuario.add(botaoCancelar, 0, 14);
		gridPaneCadastroDeUsuario.add(botaoCadastrar, 0, 14);
	}
	
	private void adicionarEventoBotaoCadastrar() {
		botaoCadastrar.setOnAction(e -> {
			String nome = campoNome.getText();
			String matricula = campoMatricula.getText();
			String cpf = campoCpf.getText();
			String email = campoEmail.getText();
			String senha = campoSenha.getText();
			
			Usuario usuario = new Usuario(matricula, nome, cpf, email, senha);
			DAO.iniciarConexao();
			
			if(DAO.inserirUsuario(usuario)) {
				new JanelaDeConfirmacaoUsuario("Usuario cadastrado com sucesso!", stage);
			}
			else {
				//new JanelaDeExcecaoUsuario("Usuario nao cadastrado, tente novamente!", stage);
			}
			
			DAO.fecharConexao();
			
		});
	}
	
	private void adicionarEventoBotaoCancelar() {
		botaoCancelar.setOnAction(e -> {
			new TelaMenuUsuario(stage);
		});
	}
	
	private void exibirCena() {
		cenaCadastroDeUsuario = new Scene(gridPaneCadastroDeUsuario, 1300, 700);
		cenaCadastroDeUsuario.getStylesheets().add(CSS);
		stage.setScene(cenaCadastroDeUsuario);
	}
}

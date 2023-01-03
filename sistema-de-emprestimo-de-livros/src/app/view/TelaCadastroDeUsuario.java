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
import javafx.stage.Stage;

public class TelaCadastroDeUsuario {
	
	private Stage stage = new Stage();
	private Scene cenaCadastroDeUsuario;
	private String CSS = getClass().getResource("/app/view/estilo.css").toExternalForm();
	private Titulo titulo;
	private Label labelTitulo = new Label("Universidade Federal Fluminense");
	private GridPane gridPaneCadastroDeUsuario = new GridPane();
	
	private TextField campoNome = new TextField();
	private TextField campoEmail = new TextField();
	private TextField campoCpf = new TextField();
	private TextField campoMatricula = new TextField();
	private PasswordField campoSenha = new PasswordField();
	private Label labelNome = new Label("Nome: ");
	private Label labelCpf = new Label("CPF: ");
	private Label labelMatricula = new Label("Matricula: ");
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
			.addAll(criarLinha(9), criarLinha(13), criarLinha(6), criarLinha(2), 
				criarLinha(6), criarLinha(2), criarLinha(6), criarLinha(2), criarLinha(6),
				criarLinha(2), criarLinha(6), criarLinha(4), criarLinha(6));
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
		stage.setTitle("Emprestimos De Livros");
		stage.setResizable(false);
		gridPaneCadastroDeUsuario.setAlignment(Pos.TOP_CENTER);
		
		labelTitulo.getStyleClass().add("tituloPrincipal");
		titulo = new Titulo(labelTitulo);
		titulo.getStyleClass().add("boxTituloPrincipal");
		
		labelNome.setTranslateX(50);
		labelNome.setMaxSize(70, 25);
		campoNome.setTranslateX(130);
		
		labelMatricula.setTranslateX(50);
		labelMatricula.setMaxSize(110, 25);
		campoMatricula.setTranslateX(180);
		
		labelEmail.setTranslateX(50);
		campoEmail.setTranslateX(140);
		
		labelCpf.setTranslateX(50);
		campoCpf.setTranslateX(125);
		
		labelSenha.setTranslateX(50);
		campoSenha.setTranslateX(150);
		
		botaoCancelar.setTranslateX(50);
		botaoCadastrar.setTranslateX(800);
	}
	
	private void adicionarElementosNaTela() {
		gridPaneCadastroDeUsuario.add(titulo, 0, 0);
		gridPaneCadastroDeUsuario.add(labelNome, 0, 2);
		gridPaneCadastroDeUsuario.add(campoNome, 0, 2);
		gridPaneCadastroDeUsuario.add(labelMatricula, 0, 4);
		gridPaneCadastroDeUsuario.add(campoMatricula, 0, 4);
		gridPaneCadastroDeUsuario.add(labelEmail, 0, 6);
		gridPaneCadastroDeUsuario.add(campoEmail, 0, 6);
		gridPaneCadastroDeUsuario.add(labelCpf, 0, 8);
		gridPaneCadastroDeUsuario.add(campoCpf, 0, 8);
		gridPaneCadastroDeUsuario.add(labelSenha, 0, 10);
		gridPaneCadastroDeUsuario.add(campoSenha, 0, 10);
		gridPaneCadastroDeUsuario.add(botaoCancelar, 0, 12);
		gridPaneCadastroDeUsuario.add(botaoCadastrar, 0, 12);
	}
	
	private void adicionarEventoBotaoCadastrar() {
		
	}
	
	private void adicionarEventoBotaoCancelar() {
		
	}
	
	private void exibirCena() {
		cenaCadastroDeUsuario = new Scene(gridPaneCadastroDeUsuario, 1300, 700);
		cenaCadastroDeUsuario.getStylesheets().add(CSS);
		stage.setScene(cenaCadastroDeUsuario);
	}
}

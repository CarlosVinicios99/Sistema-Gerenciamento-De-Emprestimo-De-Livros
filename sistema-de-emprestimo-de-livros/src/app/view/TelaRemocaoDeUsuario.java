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

public class TelaRemocaoDeUsuario {
	
	private Stage stage = new Stage();
	private Scene cenaRemocaoDeUsuario;
	private String CSS = getClass().getResource("/app/view/estilo.css").toExternalForm();
	private Titulo titulo;
	private Label labelTitulo = new Label("Universidade Federal Fluminense");
	private GridPane gridPaneRemocaoDeUsuario = new GridPane();
	
	private Label labelTituloDeNavegacao = new Label("Remover Usuário");
	private TextField campoCpf = new TextField();
	private PasswordField campoSenha = new PasswordField();
	private Label labelCpf = new Label("CPF: ");
	private Label labelSenha = new Label("Senha: ");
	private Button botaoRemover = new Button("Remover");
	private Button botaoCancelar = new Button("Cancelar");
	
	public TelaRemocaoDeUsuario(Stage stage) {
		this.stage = stage;
		criarGrid();
		configurarElementosVisuais();
		adicionarElementosNaTela();
		adicionarEventoBotaoRemover();
		adicionarEventoBotaoCancelar();
		exibirCena();
	}
	
	private void criarGrid() {
		gridPaneRemocaoDeUsuario.getColumnConstraints().add(criarColuna(100));
		gridPaneRemocaoDeUsuario.getRowConstraints()
			.addAll(criarLinha(9), criarLinha(6), criarLinha(9), criarLinha(6), criarLinha(6),
				criarLinha(3), criarLinha(6), criarLinha(6), criarLinha(6));
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
		gridPaneRemocaoDeUsuario.setAlignment(Pos.TOP_CENTER);
		gridPaneRemocaoDeUsuario.getStyleClass().add("telasDeMenu");
		
		labelTitulo.getStyleClass().add("tituloPrincipal");
		titulo = new Titulo(labelTitulo);
		titulo.getStyleClass().add("boxTituloPrincipal");
		
		labelTituloDeNavegacao.setTranslateX(550);
		labelTituloDeNavegacao.setMaxSize(230, 25);
		labelTituloDeNavegacao.getStyleClass().add("tituloNavegacao");
		
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
		botaoRemover.setTranslateX(770);
		botaoRemover.setMaxSize(110, 30);
		botaoRemover.getStyleClass().add("botaoDeConfirmacao");

	}
	
	private void adicionarElementosNaTela() {
		gridPaneRemocaoDeUsuario.add(titulo, 0, 0);
		gridPaneRemocaoDeUsuario.add(labelTituloDeNavegacao, 0, 2);
		gridPaneRemocaoDeUsuario.add(labelCpf, 0, 4);
		gridPaneRemocaoDeUsuario.add(campoCpf, 0, 4);
		gridPaneRemocaoDeUsuario.add(labelSenha, 0, 6);
		gridPaneRemocaoDeUsuario.add(campoSenha, 0, 6);
		gridPaneRemocaoDeUsuario.add(botaoCancelar, 0, 8);
		gridPaneRemocaoDeUsuario.add(botaoRemover, 0, 8);
	}
	
	private void adicionarEventoBotaoRemover() {
		botaoRemover.setOnAction(e -> {
			String cpf = campoCpf.getText();
			String senha = campoSenha.getText();
			DAO.iniciarConexao();
			Usuario usuario = DAO.consultarUsuario(cpf, senha);
			
			if(usuario != null) {
				DAO.excluirUsuario(usuario);
			}
			
			DAO.fecharConexao();
			new TelaMenuUsuario(stage);
			
		});
	}
	
	private void adicionarEventoBotaoCancelar() {
		botaoCancelar.setOnAction(e -> {
			new TelaMenuUsuario(stage);
		});
	}
	
	private void exibirCena() {
		cenaRemocaoDeUsuario = new Scene(gridPaneRemocaoDeUsuario, 1300, 700);
		cenaRemocaoDeUsuario.getStylesheets().add(CSS);
		stage.setScene(cenaRemocaoDeUsuario);
	}
	
}

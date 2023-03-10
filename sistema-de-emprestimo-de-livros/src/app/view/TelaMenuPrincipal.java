package app.view;

import app.view.emprestimo.TelaMenuEmprestimo;
import app.view.livro.TelaMenuLivro;
import app.view.usuario.TelaMenuUsuario;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class TelaMenuPrincipal {
	
	private Stage stage = new Stage();
	private Scene cenaPrincipal;
	private GridPane gridPaneMenuPrincipal = new GridPane();
	private Titulo titulo;
	private String CSS = getClass().getResource("/app/view/estilo.css").toExternalForm();
	private Label labelTitulo = new Label("Universidade Federal Fluminense");
	
	private Label labelTituloDeNavegacao = new Label("Menu Principal");
	private Button botaoUsuarios = new Button("Usuários");
	private Button botaoLivros = new Button("Livros");
	private Button botaoEmprestimos = new Button("Empréstimos");
	private Button botaoSair = new Button("Sair");
	
	public TelaMenuPrincipal(Stage stage) {
		this.stage = stage;
		criarGrid();
		configurarElementosVisuais();
		adicionarElementosNaTela();
		adicionarEventoBotaoUsuarios();
		adicionarEventoBotaoLivros();
		adicionarEventoBotaoEmprestimos();
		adicionarEventoBotaoSair();
		exibirCena();
	}
	
	
	private void configurarElementosVisuais() {
		stage.setTitle("Empréstimos De Livros");
		stage.setResizable(false);
		gridPaneMenuPrincipal.setAlignment(Pos.TOP_CENTER);
		gridPaneMenuPrincipal.getStyleClass().add("telasDeMenu");
		
		labelTitulo.getStyleClass().add("tituloPrincipal");
		
		titulo = new Titulo(labelTitulo);
		titulo.getStyleClass().add("boxTituloPrincipal");
		
		labelTituloDeNavegacao.setTranslateX(550);
		labelTituloDeNavegacao.getStyleClass().add("tituloNavegacao");
		labelTituloDeNavegacao.setMaxSize(210, 25);
		
		botaoUsuarios.setTranslateX(490);
		botaoUsuarios.setMaxSize(300, 50);
		botaoUsuarios.getStyleClass().add("botoesMenuPrincipal");
		
		botaoLivros.setTranslateX(490);
		botaoLivros.setMaxSize(300, 50);
		botaoLivros.getStyleClass().add("botoesMenuPrincipal");
		
		botaoEmprestimos.setTranslateX(490);
		botaoEmprestimos.setMaxSize(300, 50);
		botaoEmprestimos.getStyleClass().add("botoesMenuPrincipal");
		
		botaoSair.setTranslateX(490);
		botaoSair.setMaxSize(300, 50);
		botaoSair.getStyleClass().add("botoesMenuPrincipal");
		
	}
	
	private void adicionarElementosNaTela() {
		gridPaneMenuPrincipal.add(titulo, 0, 0);
		gridPaneMenuPrincipal.add(labelTituloDeNavegacao, 0, 2);
		gridPaneMenuPrincipal.add(botaoUsuarios, 0, 4);
		gridPaneMenuPrincipal.add(botaoLivros, 0, 6);
		gridPaneMenuPrincipal.add(botaoEmprestimos, 0, 8);
		gridPaneMenuPrincipal.add(botaoSair, 0, 10);
	}
	
	private void criarGrid() {
		gridPaneMenuPrincipal.getColumnConstraints().add(criarColuna(100));
		gridPaneMenuPrincipal.getRowConstraints()
			.addAll(criarLinha(9), criarLinha(6), criarLinha(9), criarLinha(5), criarLinha(8), 
				criarLinha(10), criarLinha(8), criarLinha(10), criarLinha(8), criarLinha(10), criarLinha(8));
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
	
	private void exibirCena() {
		cenaPrincipal = new Scene(gridPaneMenuPrincipal, 1300, 700);
		cenaPrincipal.getStylesheets().add(CSS);
		stage.setScene(cenaPrincipal);
	}
	
	private void adicionarEventoBotaoUsuarios() {
		botaoUsuarios.setOnAction(e -> {
			new TelaMenuUsuario(stage);
		});
	}
	
	private void adicionarEventoBotaoLivros() {
		botaoLivros.setOnAction(e -> {
			new TelaMenuLivro(stage);
		});
	}
	
	private void adicionarEventoBotaoEmprestimos() {
		botaoEmprestimos.setOnAction(e -> {
			new TelaMenuEmprestimo(stage);
		});
	}
	
	private void adicionarEventoBotaoSair() {
		botaoSair.setOnAction(e -> {
			System.exit(0);
		});
	}
}

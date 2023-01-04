package app.view;

import app.model.entities.Livro;
import app.repositories.DAO;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class TelaRealizacaoDeEmprestimo {
	
	private Stage stage = new Stage();
	private GridPane gridPaneEmprestimo = new GridPane();
	private Scene cenaEmprestimo;
	private Titulo titulo;
	private String CSS = getClass().getResource("/app/view/estilo.css").toExternalForm();
	private Label labelTitulo = new Label("Universidade Federal Fluminense");
	
	private Label labelTituloDeNavegacao = new Label("Emprestimo De Livro");
	private Label labelLivro = new Label("Livro: ");
	private TextField campoLivro = new TextField();
	private Button botaoCancelar = new Button("Cancelar");
	private Button botaoAvancar = new Button("Avancar");
	
	public TelaRealizacaoDeEmprestimo(Stage stage) {
		this.stage = stage;
		criarGrid();
		configurarElementosVisuais();
		adicionarElementosNaTela();
		adicionarEventoBotaoAvancar();
		adicionarEventoBotaoCancelar();
		exibirCena();
	}
	
	private void criarGrid() {
		gridPaneEmprestimo.getColumnConstraints().add(criarColuna(100));
		gridPaneEmprestimo.getRowConstraints()
			.addAll(criarLinha(9), criarLinha(6), criarLinha(9), criarLinha(6), 
				criarLinha(6), criarLinha(6), criarLinha(6));
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
		gridPaneEmprestimo.setAlignment(Pos.TOP_CENTER);
		gridPaneEmprestimo.getStyleClass().add("telasDeMenu");
		
		labelTitulo.getStyleClass().add("tituloPrincipal");
		
		titulo = new Titulo(labelTitulo);
		titulo.getStyleClass().add("boxTituloPrincipal");
		
		labelTituloDeNavegacao.setTranslateX(550);
		labelTituloDeNavegacao.setMaxSize(320, 25);
		labelTituloDeNavegacao.getStyleClass().add("tituloNavegacao");
		
		labelLivro.setTranslateX(460);
		labelLivro.setMaxSize(70, 25);
		campoLivro.setTranslateX(550);
		campoLivro.setMaxSize(270, 30);
		
		botaoCancelar.setTranslateX(450);
		botaoCancelar.setMaxSize(110, 30);
		botaoCancelar.getStyleClass().add("botaoDeConfirmacao");
		botaoAvancar.setTranslateX(770);
		botaoAvancar.setMaxSize(110, 30);
		botaoAvancar.getStyleClass().add("botaoDeConfirmacao");
		
	}
	
	private void adicionarElementosNaTela() {
		gridPaneEmprestimo.add(titulo, 0, 0);
		gridPaneEmprestimo.add(labelTituloDeNavegacao, 0, 2);
		gridPaneEmprestimo.add(labelLivro, 0, 4);
		gridPaneEmprestimo.add(campoLivro, 0, 4);
		gridPaneEmprestimo.add(botaoCancelar, 0, 6);
		gridPaneEmprestimo.add(botaoAvancar, 0, 6);
	}
	
	private void adicionarEventoBotaoAvancar() {
		botaoAvancar.setOnAction(e -> {
			DAO.iniciarConexao();
			Livro livro = DAO.consultarLivroPorTitulo(labelLivro.getText());
			if(livro != null) {
				//new TelaLivroEmprestimo(livro);
			}
			else {
				//livro nao encontrado
			}
			DAO.fecharConexao();
		});
	}
	
	private void adicionarEventoBotaoCancelar() {
		botaoCancelar.setOnAction(e -> {
			new TelaMenuEmprestimo(stage);
		});
	}
	
	private void exibirCena() {
		cenaEmprestimo = new Scene(gridPaneEmprestimo, 1300, 700);
		cenaEmprestimo.getStylesheets().add(CSS);
		stage.setScene(cenaEmprestimo);
	}
	
}

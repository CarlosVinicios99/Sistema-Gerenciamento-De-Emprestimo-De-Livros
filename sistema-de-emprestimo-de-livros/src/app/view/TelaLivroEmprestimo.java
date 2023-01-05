package app.view;

import app.model.entities.Livro;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class TelaLivroEmprestimo {
	
	private Stage stage = new Stage();
	private GridPane gridPaneLivroEmprestimo = new GridPane();
	private Scene cenaLivroEmprestimo;
	private Titulo titulo;
	private String CSS = getClass().getResource("/app/view/estilo.css").toExternalForm();
	private Label labelTitulo = new Label("Universidade Federal Fluminense");
	
	private Label labelTituloDeNavegacao = new Label("Emprestimo De Livro");
	private Livro livro;
	
	private Label labelTituloLivro = new Label("Titulo: ");
	private Label labelAutor = new Label("Autor: ");
	private Label labelDescricao = new Label("Descricao: ");
	private Label labelCodigo = new Label("Codigo: ");
	private Label labelProprietario = new Label("Proprietario: ");
	
	private Button botaoCancelar = new Button("Cancelar");
	private Button botaoConfirmar = new Button("Confirmar");
	
	public TelaLivroEmprestimo(Stage stage, Livro livro) {
		this.stage = stage;
		this.livro = livro;
		criarGrid();
		configurarElementosVisuais();
		adicionarElementosNaTela();
		adicionarEventoBotaoConfirmar();
		adicionarEventoBotaoCancelar();
		exibirCena();
	}
	
	private void criarGrid() {
		gridPaneLivroEmprestimo.getColumnConstraints().add(criarColuna(100));
		gridPaneLivroEmprestimo.getRowConstraints()
			.addAll(criarLinha(9), criarLinha(6), criarLinha(9), criarLinha(6), 
				criarLinha(6), criarLinha(3), criarLinha(6), criarLinha(3), criarLinha(6),
				criarLinha(3), criarLinha(6), criarLinha(3), criarLinha(6), criarLinha(6), criarLinha(6));
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
		gridPaneLivroEmprestimo.setAlignment(Pos.TOP_CENTER);
		gridPaneLivroEmprestimo.getStyleClass().add("telasDeMenu");
		
		labelTitulo.getStyleClass().add("tituloPrincipal");
		
		titulo = new Titulo(labelTitulo);
		titulo.getStyleClass().add("boxTituloPrincipal");
		
		labelTituloDeNavegacao.setTranslateX(550);
		labelTituloDeNavegacao.setMaxSize(320, 25);
		labelTituloDeNavegacao.getStyleClass().add("tituloNavegacao");
		
		labelTituloLivro.setText(labelTituloLivro.getText() + livro.getTitulo());
		labelTituloLivro.setTranslateX(450);
		labelTituloLivro.setMaxSize(200, 25);
		
		labelAutor.setText(labelAutor.getText() + livro.getAutor());
		labelAutor.setTranslateX(450);
		labelAutor.setMaxSize(200, 25);
		
		labelDescricao.setText(labelDescricao.getText() + livro.getDescricao());
		labelDescricao.setTranslateX(450);
		labelDescricao.setMaxSize(200, 25);
		
		labelCodigo.setText(labelAutor.getText() + livro.getCodigo());
		labelCodigo.setTranslateX(450);
		labelCodigo.setMaxSize(200, 25);
		
		labelProprietario.setText(labelAutor.getText() + livro.getProprietario());
		labelProprietario.setTranslateX(450);
		labelProprietario.setMaxSize(200, 25);
		
		botaoCancelar.setTranslateX(450);
		botaoCancelar.setMaxSize(110, 30);
		botaoCancelar.getStyleClass().add("botaoDeConfirmacao");
		botaoConfirmar.setTranslateX(770);
		botaoConfirmar.setMaxSize(110, 30);
		botaoConfirmar.getStyleClass().add("botaoDeConfirmacao");
		
	}
	
	private void adicionarElementosNaTela() {
		gridPaneLivroEmprestimo.add(titulo, 0, 0);
		gridPaneLivroEmprestimo.add(labelTituloDeNavegacao, 0, 2);
		gridPaneLivroEmprestimo.add(labelTituloLivro, 0, 4);
		gridPaneLivroEmprestimo.add(labelAutor, 0, 6);
		gridPaneLivroEmprestimo.add(labelDescricao, 0, 8);
		gridPaneLivroEmprestimo.add(labelCodigo, 0, 10);
		gridPaneLivroEmprestimo.add(labelProprietario, 0, 12);
		gridPaneLivroEmprestimo.add(botaoCancelar, 0, 14);
		gridPaneLivroEmprestimo.add(botaoConfirmar, 0, 14);
	}
	
	private void adicionarEventoBotaoConfirmar() {
		botaoConfirmar.setOnAction(e -> {
			new TelaUsuarioEmprestimo(stage, livro);
		});
	}
	
	private void adicionarEventoBotaoCancelar() {
		botaoCancelar.setOnAction(e -> {
			new TelaRealizacaoDeEmprestimo(stage);
		});
	}
	
	private void exibirCena() {
		cenaLivroEmprestimo = new Scene(gridPaneLivroEmprestimo, 1300, 700);
		cenaLivroEmprestimo.getStylesheets().add(CSS);
		stage.setScene(cenaLivroEmprestimo);
	}
	
}

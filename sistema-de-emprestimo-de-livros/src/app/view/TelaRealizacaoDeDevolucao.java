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

public class TelaRealizacaoDeDevolucao {
	
	private Stage stage = new Stage();
	private GridPane gridPaneEmprestimo = new GridPane();
	private Scene cenaEmprestimo;
	private Titulo titulo;
	private String CSS = getClass().getResource("/app/view/estilo.css").toExternalForm();
	private Label labelTitulo = new Label("Universidade Federal Fluminense");
	
	private Label labelTituloDeNavegacao = new Label("Devolução De Livro");
	private Label labelCodigo = new Label("Código: ");
	private TextField campoCodigo = new TextField();
	private Button botaoCancelar = new Button("Cancelar");
	private Button botaoConfirmar = new Button("Confirmar");
	
	public TelaRealizacaoDeDevolucao(Stage stage) {
		this.stage = stage;
		criarGrid();
		configurarElementosVisuais();
		adicionarElementosNaTela();
		adicionarEventoBotaoConfirmar();
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
		stage.setTitle("Empréstimos De Livros");
		stage.setResizable(false);
		gridPaneEmprestimo.setAlignment(Pos.TOP_CENTER);
		gridPaneEmprestimo.getStyleClass().add("telasDeMenu");
		
		labelTitulo.getStyleClass().add("tituloPrincipal");
		
		titulo = new Titulo(labelTitulo);
		titulo.getStyleClass().add("boxTituloPrincipal");
		
		labelTituloDeNavegacao.setTranslateX(550);
		labelTituloDeNavegacao.setMaxSize(320, 25);
		labelTituloDeNavegacao.getStyleClass().add("tituloNavegacao");
		
		labelCodigo.setTranslateX(460);
		labelCodigo.setMaxSize(80, 25);
		campoCodigo.setTranslateX(550);
		campoCodigo.setMaxSize(270, 30);
		
		botaoCancelar.setTranslateX(450);
		botaoCancelar.setMaxSize(110, 30);
		botaoCancelar.getStyleClass().add("botaoDeConfirmacao");
		botaoConfirmar.setTranslateX(770);
		botaoConfirmar.setMaxSize(110, 30);
		botaoConfirmar.getStyleClass().add("botaoDeConfirmacao");
		
	}
	
	private void adicionarElementosNaTela() {
		gridPaneEmprestimo.add(titulo, 0, 0);
		gridPaneEmprestimo.add(labelTituloDeNavegacao, 0, 2);
		gridPaneEmprestimo.add(labelCodigo, 0, 4);
		gridPaneEmprestimo.add(campoCodigo, 0, 4);
		gridPaneEmprestimo.add(botaoCancelar, 0, 6);
		gridPaneEmprestimo.add(botaoConfirmar, 0, 6);
	}
	
	private void adicionarEventoBotaoConfirmar() {
		botaoConfirmar.setOnAction(e -> {
			DAO.iniciarConexao();
			Livro livro = DAO.consultarLivroPorCodigo(campoCodigo.getText());
			if(livro != null) {
				new TelaUsuarioDevolucao(stage, livro);
			}
			else {
				new JanelaDeExcecaoDevolucao("           Livro não encontrado!", stage);
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

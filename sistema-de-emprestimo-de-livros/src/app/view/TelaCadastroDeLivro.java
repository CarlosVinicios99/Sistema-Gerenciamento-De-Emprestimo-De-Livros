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

public class TelaCadastroDeLivro {
	
	private Stage stage = new Stage();
	private Scene cenaCadastroDeLivro;
	private String CSS = getClass().getResource("/app/view/estilo.css").toExternalForm();
	private Titulo titulo;
	private Label labelTitulo = new Label("Universidade Federal Fluminense");
	private GridPane gridPaneCadastroDeLivro = new GridPane();
	
	private Label labelTituloDeNavegacao = new Label("Cadastrar Livro");
	private TextField campoTitulo = new TextField();
	private TextField campoAutor = new TextField();
	private TextField campoDescricao = new TextField();
	private TextField campoCodigo = new TextField();
	private TextField campoProprietario = new TextField();
	private Label labelTituloLivro = new Label("Título: ");
	private Label labelAutor = new Label("Autor: ");
	private Label labelDescricao = new Label("Descrição: ");
	private Label labelCodigo = new Label("Código: ");
	private Label labelProprietario = new Label("Proprietário: ");
	private Button botaoCadastrar = new Button("Cadastrar");
	private Button botaoCancelar = new Button("Cancelar");
	
	public TelaCadastroDeLivro(Stage stage) {
		this.stage = stage;
		criarGrid();
		configurarElementosVisuais();
		adicionarElementosNaTela();
		adicionarEventoBotaoCadastrar();
		adicionarEventoBotaoCancelar();
		exibirCena();
	}
	
	private void criarGrid() {
		gridPaneCadastroDeLivro.getColumnConstraints().add(criarColuna(100));
		gridPaneCadastroDeLivro.getRowConstraints()
			.addAll(criarLinha(9), criarLinha(6), criarLinha(9), criarLinha(6), criarLinha(6), 
				criarLinha(3), criarLinha(6), criarLinha(3), criarLinha(6), criarLinha(3), criarLinha(6),
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
		gridPaneCadastroDeLivro.setAlignment(Pos.TOP_CENTER);
		gridPaneCadastroDeLivro.getStyleClass().add("telasDeMenu");
		
		labelTitulo.getStyleClass().add("tituloPrincipal");
		titulo = new Titulo(labelTitulo);
		titulo.getStyleClass().add("boxTituloPrincipal");
		
		labelTituloDeNavegacao.setTranslateX(570);
		labelTituloDeNavegacao.setMaxSize(200, 25);
		labelTituloDeNavegacao.getStyleClass().add("tituloNavegacao");
		
		labelTituloLivro.setTranslateX(450);
		labelTituloLivro.setMaxSize(70, 25);
		campoTitulo.setTranslateX(570);
		campoTitulo.setMaxSize(270, 30);
		
		labelAutor.setTranslateX(450);
		labelAutor.setMaxSize(110, 25);
		campoAutor.setTranslateX(570);
		campoAutor.setMaxSize(270, 30);
		
		labelDescricao.setTranslateX(450);
		labelDescricao.setMaxSize(100, 25);
		campoDescricao.setTranslateX(570);
		campoDescricao.setMaxSize(270, 30);
		
		labelCodigo.setTranslateX(450);
		labelCodigo.setMaxSize(80, 25);
		campoCodigo.setTranslateX(570);
		campoCodigo.setMaxSize(270, 30);
		
		labelProprietario.setTranslateX(450);
		labelProprietario.setMaxSize(115, 25);
		campoProprietario.setTranslateX(570);
		campoProprietario.setMaxSize(270, 30);
		
		botaoCancelar.setTranslateX(450);
		botaoCancelar.setMaxSize(110, 30);
		botaoCancelar.getStyleClass().add("botaoDeConfirmacao");
		botaoCadastrar.setTranslateX(770);
		botaoCadastrar.setMaxSize(110, 30);
		botaoCadastrar.getStyleClass().add("botaoDeConfirmacao");
		
	}
	
	private void adicionarElementosNaTela() {
		gridPaneCadastroDeLivro.add(titulo, 0, 0);
		gridPaneCadastroDeLivro.add(labelTituloDeNavegacao, 0, 2);
		gridPaneCadastroDeLivro.add(labelTituloLivro, 0, 4);
		gridPaneCadastroDeLivro.add(campoTitulo, 0, 4);
		gridPaneCadastroDeLivro.add(labelAutor, 0, 6);
		gridPaneCadastroDeLivro.add(campoAutor, 0, 6);
		gridPaneCadastroDeLivro.add(labelDescricao, 0, 8);
		gridPaneCadastroDeLivro.add(campoDescricao, 0, 8);
		gridPaneCadastroDeLivro.add(labelCodigo, 0, 10);
		gridPaneCadastroDeLivro.add(campoCodigo, 0, 10);
		gridPaneCadastroDeLivro.add(labelProprietario, 0, 12);
		gridPaneCadastroDeLivro.add(campoProprietario, 0, 12);
		gridPaneCadastroDeLivro.add(botaoCancelar, 0, 14);
		gridPaneCadastroDeLivro.add(botaoCadastrar, 0, 14);
	}
	
	private void adicionarEventoBotaoCadastrar() {
		botaoCadastrar.setOnAction(e -> {
			String tituloDoLivro = campoTitulo.getText();
			String autor = campoAutor.getText();
			String descricao = campoDescricao.getText();
			String codigo = campoCodigo.getText();
			String proprietario = campoProprietario.getText();
			
			Livro livro = new Livro(codigo, tituloDoLivro, descricao, autor, proprietario);
			DAO.iniciarConexao();
			DAO.inserirLivro(livro);
			DAO.fecharConexao();
			new TelaMenuLivro(stage);
		});
	}
	
	private void adicionarEventoBotaoCancelar() {
		botaoCancelar.setOnAction(e -> {
			new TelaMenuLivro(stage);
		});
	}
	
	private void exibirCena() {
		cenaCadastroDeLivro = new Scene(gridPaneCadastroDeLivro, 1300, 700);
		cenaCadastroDeLivro.getStylesheets().add(CSS);
		stage.setScene(cenaCadastroDeLivro);
	}
}

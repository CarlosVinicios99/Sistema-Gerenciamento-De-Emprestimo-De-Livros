package app.view.livro;

import app.model.entities.Livro;
import app.repositories.DAO;
import app.view.Titulo;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class TelaRemocaoDeLivro {
	
	private Stage stage = new Stage();
	private Scene cenaRemocaoDeLivro;
	private String CSS = getClass().getResource("/app/view/estilo.css").toExternalForm();
	private Titulo titulo;
	private Label labelTitulo = new Label("Universidade Federal Fluminense");
	private GridPane gridPaneRemocaoDeLivro = new GridPane();
	
	private Label labelTituloDeNavegacao = new Label("Remover Livro");
	private TextField campoCodigo = new TextField();;
	private Label labelCodigo = new Label("Código: ");
	private Button botaoRemover = new Button("Remover");
	private Button botaoCancelar = new Button("Cancelar");
	
	public TelaRemocaoDeLivro(Stage stage) {
		this.stage = stage;
		criarGrid();
		configurarElementosVisuais();
		adicionarElementosNaTela();
		adicionarEventoBotaoRemover();
		adicionarEventoBotaoCancelar();
		exibirCena();
	}
	
	private void criarGrid() {
		gridPaneRemocaoDeLivro.getColumnConstraints().add(criarColuna(100));
		gridPaneRemocaoDeLivro.getRowConstraints()
			.addAll(criarLinha(9), criarLinha(6), criarLinha(9), criarLinha(6), 
				criarLinha(6), criarLinha(6));
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
		gridPaneRemocaoDeLivro.setAlignment(Pos.TOP_CENTER);
		gridPaneRemocaoDeLivro.getStyleClass().add("telasDeMenu");
		
		labelTitulo.getStyleClass().add("tituloPrincipal");
		titulo = new Titulo(labelTitulo);
		titulo.getStyleClass().add("boxTituloPrincipal");
		
		labelTituloDeNavegacao.setTranslateX(570);
		labelTituloDeNavegacao.setMaxSize(200, 25);
		labelTituloDeNavegacao.getStyleClass().add("tituloNavegacao");
		
		labelCodigo.setTranslateX(450);
		labelCodigo.setMaxSize(80, 25);
		campoCodigo.setTranslateX(550);
		campoCodigo.setMaxSize(270, 30);
		
		botaoCancelar.setTranslateX(450);
		botaoCancelar.setMaxSize(110, 30);
		botaoCancelar.getStyleClass().add("botaoDeConfirmacao");
		botaoRemover.setTranslateX(770);
		botaoRemover.setMaxSize(110, 30);
		botaoRemover.getStyleClass().add("botaoDeConfirmacao");

	}
	
	private void adicionarElementosNaTela() {
		gridPaneRemocaoDeLivro.add(titulo, 0, 0);
		gridPaneRemocaoDeLivro.add(labelTituloDeNavegacao, 0, 2);
		gridPaneRemocaoDeLivro.add(labelCodigo, 0, 4);
		gridPaneRemocaoDeLivro.add(campoCodigo, 0, 4);
		gridPaneRemocaoDeLivro.add(botaoCancelar, 0, 6);
		gridPaneRemocaoDeLivro.add(botaoRemover, 0, 6);
	}
	
	private void adicionarEventoBotaoRemover() {
		botaoRemover.setOnAction(e -> {
			String codigo = campoCodigo.getText();
			DAO.iniciarConexao();
			Livro livro = DAO.consultarLivroPorCodigo(codigo);
			
			if(livro != null) {
				if(DAO.excluirLivro(livro)) {
					new JanelaDeConfirmacaoLivro("        Livro removido com sucesso!", stage);
				}
			}
			else {
				new JanelaDeExcecaoLivro("            Livro não cadastrado!", stage);
			}
			DAO.fecharConexao();
		});
	}
	
	private void adicionarEventoBotaoCancelar() {
		botaoCancelar.setOnAction(e -> {
			new TelaMenuLivro(stage);
		});
	}
	
	private void exibirCena() {
		cenaRemocaoDeLivro = new Scene(gridPaneRemocaoDeLivro, 1300, 700);
		cenaRemocaoDeLivro.getStylesheets().add(CSS);
		stage.setScene(cenaRemocaoDeLivro);
	}
	
}

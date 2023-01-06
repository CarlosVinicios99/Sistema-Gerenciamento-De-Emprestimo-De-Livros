package app.view.emprestimo;

import app.view.TelaMenuPrincipal;
import app.view.Titulo;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class TelaMenuEmprestimo {
	
	private Stage stage = new Stage();
	private GridPane gridPaneMenuEmprestimo = new GridPane();
	private Scene cenaMenuEmprestimo;
	private Titulo titulo;
	private String CSS = getClass().getResource("/app/view/estilo.css").toExternalForm();
	
	private Label labelTitulo = new Label("Universidade Federal Fluminense");
	private Label labelTituloDeNavegacao = new Label("Empréstimos");
	private Button botaoEmprestimo = new Button("Realizar Empréstimo");
	private Button botaoDevolucao = new Button("Realizar Devolução");
	private Button botaoVoltar = new Button("Voltar");
	
	public TelaMenuEmprestimo(Stage stage) {
		this.stage = stage;
		criarGrid();
		configurarElementosVisuais();
		adicionarElementosNaTela();
		adicionarEventoBotaoEmprestimo();
		adicionarEventoBotaoDevolucao();
		adicionarEventoBotaoVoltar();
		exibirCena();
	}
	
	private void criarGrid() {
		gridPaneMenuEmprestimo.getColumnConstraints().add(criarColuna(100));
		gridPaneMenuEmprestimo.getRowConstraints()
			.addAll(criarLinha(9), criarLinha(6), criarLinha(9), criarLinha(5), criarLinha(10), 
				criarLinha(8), criarLinha(10), criarLinha(8));
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
	
	private void configurarElementosVisuais(){
		stage.setTitle("Empréstimos De Livros");
		stage.setResizable(false);
		gridPaneMenuEmprestimo.setAlignment(Pos.TOP_CENTER);
		gridPaneMenuEmprestimo.getStyleClass().add("telasDeMenu");
		
		labelTitulo.getStyleClass().add("tituloPrincipal");
		
		titulo = new Titulo(labelTitulo);
		titulo.getStyleClass().add("boxTituloPrincipal");
		
		labelTituloDeNavegacao.setTranslateX(560);
		labelTituloDeNavegacao.getStyleClass().add("tituloNavegacao");
		labelTituloDeNavegacao.setMaxSize(210, 25);
		
		botaoEmprestimo.setTranslateX(490);
		botaoEmprestimo.setMaxSize(300, 50);
		botaoEmprestimo.getStyleClass().add("botaoDeSubMenu");
		
		botaoDevolucao.setTranslateX(490);
		botaoDevolucao.setMaxSize(300, 50);
		botaoDevolucao.getStyleClass().add("botaoDeSubMenu");
		
		botaoVoltar.setTranslateX(490);
		botaoVoltar.setMaxSize(300, 50);
		botaoVoltar.getStyleClass().add("botaoDeSubMenu");
		
	}
	
	private void adicionarElementosNaTela() {
		gridPaneMenuEmprestimo.add(titulo, 0, 0);
		gridPaneMenuEmprestimo.add(labelTituloDeNavegacao, 0, 2);
		gridPaneMenuEmprestimo.add(botaoEmprestimo, 0, 4);
		gridPaneMenuEmprestimo.add(botaoDevolucao, 0, 6);
		gridPaneMenuEmprestimo.add(botaoVoltar, 0, 8);
	}
	
	private void adicionarEventoBotaoEmprestimo() {
		botaoEmprestimo.setOnAction(e -> {
			new TelaRealizacaoDeEmprestimo(stage);
		});
	}
	
	private void adicionarEventoBotaoDevolucao() {
		botaoDevolucao.setOnAction(e -> {
			new TelaRealizacaoDeDevolucao(stage);
		});
	}
	
	private void adicionarEventoBotaoVoltar() {
		botaoVoltar.setOnAction(e -> {
			new TelaMenuPrincipal(stage);
		});
	}
	
	private void exibirCena() {
		cenaMenuEmprestimo = new Scene(gridPaneMenuEmprestimo, 1300, 700);
		cenaMenuEmprestimo.getStylesheets().add(CSS);
		stage.setScene(cenaMenuEmprestimo);
	}
	
}

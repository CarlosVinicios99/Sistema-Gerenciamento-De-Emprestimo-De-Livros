package app.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class TelaMenuUsuario {
	
	private Stage stage = new Stage();
	private GridPane gridPaneMenuUsuario = new GridPane();
	private Scene cenaMenuUsuario;
	private Titulo titulo;
	private String CSS = getClass().getResource("/app/view/estilo.css").toExternalForm();
	private Label labelTitulo = new Label("Universidade Federal Fluminense");
	private Button botaoCadastrar = new Button("Cadastrar Usuário");
	private Button botaoRemover = new Button("Remover Usuário");
	private Button botaoVoltar = new Button("Voltar");
	
	public TelaMenuUsuario(Stage stage) {
		this.stage = stage;
		criarGrid();
		configurarElementosVisuais();
		adicionarElementosNaTela();
		adicionarEventoBotaoCadastrar();
		adicionarEventoBotaoRemover();
		adicionarEventoBotaoVoltar();
		exibirCena();
	}
	
	private void criarGrid() {
		gridPaneMenuUsuario.getColumnConstraints().add(criarColuna(100));
		gridPaneMenuUsuario.getRowConstraints()
			.addAll(criarLinha(9), criarLinha(15), criarLinha(8), criarLinha(10), 
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
		gridPaneMenuUsuario.setAlignment(Pos.TOP_CENTER);
		gridPaneMenuUsuario.getStyleClass().add("telasDeMenu");
		
		labelTitulo.getStyleClass().add("tituloPrincipal");
		
		titulo = new Titulo(labelTitulo);
		titulo.getStyleClass().add("boxTituloPrincipal");
		
		botaoCadastrar.setTranslateX(490);
		botaoCadastrar.setMaxSize(300, 50);
		botaoCadastrar.getStyleClass().add("botaoDeSubMenu");
		
		botaoRemover.setTranslateX(490);
		botaoRemover.setMaxSize(300, 50);
		botaoRemover.getStyleClass().add("botaoDeSubMenu");
		
		botaoVoltar.setTranslateX(490);
		botaoVoltar.setMaxSize(300, 50);
		botaoVoltar.getStyleClass().add("botaoDeSubMenu");
		
	}
	
	private void adicionarElementosNaTela() {
		gridPaneMenuUsuario.add(titulo, 0, 0);
		gridPaneMenuUsuario.add(botaoCadastrar, 0, 2);
		gridPaneMenuUsuario.add(botaoRemover, 0, 4);
		gridPaneMenuUsuario.add(botaoVoltar, 0, 6);
	}
	
	private void adicionarEventoBotaoCadastrar() {
		botaoCadastrar.setOnAction(e -> {
			new TelaCadastroDeUsuario(stage);
		});
	}
	
	private void adicionarEventoBotaoRemover() {
		botaoRemover.setOnAction(e -> {
			new TelaRemocaoDeUsuario(stage);
		});
		
	}
	
	private void adicionarEventoBotaoVoltar() {
		botaoVoltar.setOnAction(e -> {
			new TelaMenuPrincipal(stage);
		});
	}
	
	private void exibirCena() {
		cenaMenuUsuario = new Scene(gridPaneMenuUsuario, 1300, 700);
		cenaMenuUsuario.getStylesheets().add(CSS);
		stage.setScene(cenaMenuUsuario);
	}

}

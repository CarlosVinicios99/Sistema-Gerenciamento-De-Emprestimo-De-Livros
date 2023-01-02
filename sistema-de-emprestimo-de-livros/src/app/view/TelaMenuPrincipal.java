package app.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class TelaMenuPrincipal {
	
	private Stage stage = new Stage();
	private Scene cenaPrincipal;
	private GridPane gridPaneMenuPrincipal = new GridPane();
	private String CSS = getClass().getResource("/app/view/estilo.css").toExternalForm();
	private Label labelTitulo = new Label("Universidade Federal Fluminense");
	private Button botaoOpcaoUsuarios = new Button("Usuarios");
	private Button botaoOpcaoLivros = new Button("Livros");
	private Button botaoOpcaoEmprestimos = new Button("Emprestimos");
	
	public TelaMenuPrincipal(Stage stage) {
		this.stage = stage;
		criarGrid();
		configurarElementosVisuais();
		adicionarElementosNaTela();
		adicionarEventosAosBotoes();
		exibirCena();
	}
	
	
	private void configurarElementosVisuais() {
		
		stage.setTitle("Emprestimos De Livros");
		stage.setResizable(false);
	}
	
	private void adicionarElementosNaTela() {
		gridPaneMenuPrincipal.add(labelTitulo, );
	}
	
	private void criarGrid() {
		gridPaneMenuPrincipal.getColumnConstraints().add(criarColuna(100));
		gridPaneMenuPrincipal.getRowConstraints()
			.addAll(criarLinha(8), criarLinha(15), criarLinha(8), criarLinha(8), 
				criarLinha(8), criarLinha(8), criarLinha(8));
		gridPaneMenuPrincipal.setGridLinesVisible(true);
		
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
	
	private void adicionarEventosAosBotoes() {
		
	}
}

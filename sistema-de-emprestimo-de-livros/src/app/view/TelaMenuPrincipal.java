package app.view;

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
	private String CSS = getClass().getResource("/app/view/estilo.css").toExternalForm();
	private Label labelTitulo = new Label("Universidade Federal Fluminense");
	private Button botaoUsuarios = new Button("Usuarios");
	private Button botaoLivros = new Button("Livros");
	private Button botaoEmprestimos = new Button("Emprestimos");
	
	public TelaMenuPrincipal(Stage stage) {
		this.stage = stage;
		criarGrid();
		configurarElementosVisuais();
		adicionarElementosNaTela();
		adicionarEventoBotaoUsuarios();
		adicionarEventoBotaoLivros();
		adicionarEventoBotaoEmprestimos();
		exibirCena();
	}
	
	
	private void configurarElementosVisuais() {
		botaoUsuarios.setAlignment(Pos.BASELINE_CENTER);
		stage.setTitle("Emprestimos De Livros");
		stage.setResizable(false);
	}
	
	private void adicionarElementosNaTela() {
		gridPaneMenuPrincipal.add(labelTitulo, 0, 0);
		gridPaneMenuPrincipal.add(botaoUsuarios, 0, 2);
		gridPaneMenuPrincipal.add(botaoLivros, 0, 4);
		gridPaneMenuPrincipal.add(botaoEmprestimos, 0, 6);

	}
	
	private void criarGrid() {
		gridPaneMenuPrincipal.getColumnConstraints().add(criarColuna(100));
		gridPaneMenuPrincipal.getRowConstraints()
			.addAll(criarLinha(8), criarLinha(15), criarLinha(8), criarLinha(10), 
				criarLinha(8), criarLinha(10), criarLinha(8));
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
	
	private void adicionarEventoBotaoUsuarios() {
		
	}
	
	private void adicionarEventoBotaoLivros() {
		
	}
	
	private void adicionarEventoBotaoEmprestimos() {
		
	}
}

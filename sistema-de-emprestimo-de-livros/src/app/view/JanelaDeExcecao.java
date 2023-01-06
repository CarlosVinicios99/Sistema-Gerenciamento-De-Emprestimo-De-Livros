package app.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public abstract class JanelaDeExcecao {
	
	protected Stage stageJanela = new Stage();
	protected Stage proximoStage = new Stage();
	private Scene cenaExcecao;
	private String CSS = getClass().getResource("/app/view/estilo.css").toExternalForm();
	private GridPane gridPaneJanelaDeExcecao = new GridPane();
	
	private Label labelMensagem = new Label();
	private Label simboloExcecao = new Label("X");
	protected Button botaoOk = new Button("OK");

	public JanelaDeExcecao(String mensagem, Stage stage) {
		this.proximoStage = stage;
		labelMensagem.setText(mensagem);
		criarGrid();
		configurarElementosVisuais();
		adicionarElementosNaTela();
		exibirCena();
	}
	
	private void criarGrid() {
		gridPaneJanelaDeExcecao.getColumnConstraints().add(criarColuna(100));
		gridPaneJanelaDeExcecao.getRowConstraints()
			.addAll(criarLinha(5), criarLinha(30), criarLinha(1), criarLinha(6), criarLinha(15), criarLinha(6));
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
		stageJanela.setTitle("Mensagem");
		stageJanela.setResizable(false);
		gridPaneJanelaDeExcecao.setAlignment(Pos.TOP_CENTER);
		gridPaneJanelaDeExcecao.getStyleClass().add("janelaDeExcecao");
	
		
		labelMensagem.setTranslateX(50);
		simboloExcecao.setTranslateX(195);
		simboloExcecao.getStyleClass().add("simboloExcecao");
		
		botaoOk.setTranslateX(165);
		botaoOk.setMaxSize(70, 30);
		botaoOk.getStyleClass().add("botaoDeConfirmacao");
	}
	
	private void adicionarElementosNaTela() {
		gridPaneJanelaDeExcecao.add(labelMensagem, 0, 1);
		gridPaneJanelaDeExcecao.add(simboloExcecao, 0, 3);
		gridPaneJanelaDeExcecao.add(botaoOk, 0, 5);
	}
	
	public abstract void adicionarEventoBotaoOk();
	
	private void exibirCena() {
		cenaExcecao = new Scene(gridPaneJanelaDeExcecao, 400, 200);
		cenaExcecao.getStylesheets().add(CSS);
		stageJanela.setScene(cenaExcecao);
		stageJanela.show();
	}
	
}

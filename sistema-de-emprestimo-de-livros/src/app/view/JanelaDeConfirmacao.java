package app.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class JanelaDeConfirmacao {
	
	private Stage stageJanela = new Stage();
	private Stage proximoStage = new Stage();
	private Scene cenaConfirmacao;
	private String CSS = getClass().getResource("/app/view/estilo.css").toExternalForm();
	private GridPane gridPaneJanelaDeConfirmacao = new GridPane();
	
	private Label labelMensagem = new Label();
	private Button botaoOk = new Button("Ok");

	public JanelaDeConfirmacao(String mensagem, Stage stage) {
		this.proximoStage = stage;
		labelMensagem.setText(mensagem);
		criarGrid();
		configurarElementosVisuais();
		adicionarElementosNaTela();
		adicionarEventoBotaoOk();
		exibirCena();
	}
	
	private void criarGrid() {
		gridPaneJanelaDeConfirmacao.getColumnConstraints().add(criarColuna(100));
		gridPaneJanelaDeConfirmacao.getRowConstraints()
			.addAll(criarLinha(5), criarLinha(30), criarLinha(5), criarLinha(6));
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
		gridPaneJanelaDeConfirmacao.setAlignment(Pos.TOP_CENTER);
		//gridPaneJanelaDeConfirmacao.getStyleClass().add();
	
		
		labelMensagem.setTranslateX(30);
		botaoOk.setTranslateX(265);
		botaoOk.setMaxSize(70, 30);
		botaoOk.getStyleClass().add("botaoDeConfirmacao");
	}
	
	private void adicionarElementosNaTela() {
		gridPaneJanelaDeConfirmacao.add(labelMensagem, 0, 1);
		gridPaneJanelaDeConfirmacao.add(botaoOk, 0, 3);
	}
	
	private void adicionarEventoBotaoOk() {
		botaoOk.setOnAction(e -> {
			stageJanela.close();
			new TelaMenuPrincipal(proximoStage);
		});
	}
	
	private void exibirCena() {
		cenaConfirmacao = new Scene(gridPaneJanelaDeConfirmacao, 600, 400);
		cenaConfirmacao.getStylesheets().add(CSS);
		stageJanela.setScene(cenaConfirmacao);
		stageJanela.show();
	}

	
}

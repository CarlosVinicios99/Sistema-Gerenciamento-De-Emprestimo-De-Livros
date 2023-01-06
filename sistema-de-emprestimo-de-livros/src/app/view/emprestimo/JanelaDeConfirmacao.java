package app.view.emprestimo;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public abstract class JanelaDeConfirmacao {
	
	protected Stage stageJanela = new Stage();
	protected Stage proximoStage = new Stage();
	private Scene cenaConfirmacao;
	private String CSS = getClass().getResource("/app/view/estilo.css").toExternalForm();
	private GridPane gridPaneJanelaDeConfirmacao = new GridPane();
	
	private Label labelMensagem = new Label();
	private Label simboloConfirmacao = new Label('\u2714' + "");
	protected Button botaoOk = new Button("OK");

	public JanelaDeConfirmacao(String mensagem, Stage stage) {
		this.proximoStage = stage;
		labelMensagem.setText(mensagem);
		criarGrid();
		configurarElementosVisuais();
		adicionarElementosNaTela();
		exibirCena();
	}
	
	private void criarGrid() {
		gridPaneJanelaDeConfirmacao.getColumnConstraints().add(criarColuna(100));
		gridPaneJanelaDeConfirmacao.getRowConstraints()
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
		gridPaneJanelaDeConfirmacao.setAlignment(Pos.TOP_CENTER);
		gridPaneJanelaDeConfirmacao.getStyleClass().add("janelaDeConfirmacao");
	
		
		labelMensagem.setTranslateX(50);
		simboloConfirmacao.setTranslateX(195);
		simboloConfirmacao.getStyleClass().add("simboloConfirmacao");
		
		botaoOk.setTranslateX(165);
		botaoOk.setMaxSize(70, 30);
		botaoOk.getStyleClass().add("botaoDeConfirmacao");
	}
	
	private void adicionarElementosNaTela() {
		gridPaneJanelaDeConfirmacao.add(labelMensagem, 0, 1);
		gridPaneJanelaDeConfirmacao.add(simboloConfirmacao, 0, 3);
		gridPaneJanelaDeConfirmacao.add(botaoOk, 0, 5);
	}
	
	public abstract void adicionarEventoBotaoOk();
	
	private void exibirCena() {
		cenaConfirmacao = new Scene(gridPaneJanelaDeConfirmacao, 400, 200);
		cenaConfirmacao.getStylesheets().add(CSS);
		stageJanela.setScene(cenaConfirmacao);
		stageJanela.show();
	}

}

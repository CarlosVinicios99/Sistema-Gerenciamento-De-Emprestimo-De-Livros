package app.view;

import javafx.stage.Stage;

public class JanelaDeConfirmacaoLivro extends JanelaDeConfirmacao{
	
	public JanelaDeConfirmacaoLivro(String mensagem, Stage proximoStage) {
		super(mensagem, proximoStage);
		adicionarEventoBotaoOk();
	}
	
	@Override
	public void adicionarEventoBotaoOk(){
		botaoOk.setOnAction(e -> {
			stageJanela.close();
			new TelaMenuLivro(proximoStage);
		});
	}
	
}

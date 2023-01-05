package app.view;

import javafx.stage.Stage;

public class JanelaDeExcecaoLivro extends JanelaDeExcecao{
	
	public JanelaDeExcecaoLivro(String mensagem, Stage proximoStage) {
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

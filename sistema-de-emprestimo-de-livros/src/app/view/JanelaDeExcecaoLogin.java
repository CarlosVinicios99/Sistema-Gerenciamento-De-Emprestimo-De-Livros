package app.view;

import javafx.stage.Stage;

public class JanelaDeExcecaoLogin extends JanelaDeExcecao{
	
	public JanelaDeExcecaoLogin(String mensagem, Stage proximoStage) {
		super(mensagem, proximoStage);
		adicionarEventoBotaoOk();
	}
	
	@Override
	public void adicionarEventoBotaoOk(){
		botaoOk.setOnAction(e -> {
			stageJanela.close();
			new TelaDeLogin(proximoStage);
		});
	}
	
}

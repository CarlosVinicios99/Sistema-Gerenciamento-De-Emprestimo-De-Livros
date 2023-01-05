package app.view;

import javafx.stage.Stage;

public class JanelaDeConfirmacaoUsuario extends JanelaDeConfirmacao{
	
	public JanelaDeConfirmacaoUsuario(String mensagem, Stage proximoStage) {
		super(mensagem, proximoStage);
		adicionarEventoBotaoOk();
	}
	
	@Override
	public void adicionarEventoBotaoOk(){
		botaoOk.setOnAction(e -> {
			stageJanela.close();
			new TelaMenuUsuario(proximoStage);
		});
	}
	
}

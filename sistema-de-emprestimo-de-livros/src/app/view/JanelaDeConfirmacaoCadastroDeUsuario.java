package app.view;

import javafx.stage.Stage;

public class JanelaDeConfirmacaoCadastroDeUsuario extends JanelaDeConfirmacao{
	
	public JanelaDeConfirmacaoCadastroDeUsuario(String mensagem, Stage proximoStage) {
		super(mensagem, proximoStage);
	}
	
	@Override
	public void adicionarEventoBotaoOk(){
		botaoOk.setOnAction(e -> {
			stageJanela.close();
			new TelaMenuUsuario(proximoStage);
		});
	}
	
}

package app.view.usuario;

import app.view.JanelaDeExcecao;
import javafx.stage.Stage;

public class JanelaDeExcecaoUsuario extends JanelaDeExcecao {
	
	public JanelaDeExcecaoUsuario(String mensagem, Stage proximoStage) {
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

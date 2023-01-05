package app.view;

import javafx.stage.Stage;

public class JanelaDeExcecaoEmprestimo extends JanelaDeExcecao{
	
	public JanelaDeExcecaoEmprestimo(String mensagem, Stage proximoStage) {
		super(mensagem, proximoStage);
		adicionarEventoBotaoOk();
	}
	
	@Override
	public void adicionarEventoBotaoOk(){
		botaoOk.setOnAction(e -> {
			stageJanela.close();
			new TelaMenuEmprestimo(proximoStage);
		});
	}
}

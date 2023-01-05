package app.view;

import javafx.stage.Stage;

public class JanelaDeExcecaoLivroEmprestimo extends JanelaDeExcecao {
	public JanelaDeExcecaoLivroEmprestimo(String mensagem, Stage proximoStage) {
		super(mensagem, proximoStage);
		adicionarEventoBotaoOk();
	}
	
	@Override
	public void adicionarEventoBotaoOk(){
		botaoOk.setOnAction(e -> {
			stageJanela.close();
			new TelaRealizacaoDeEmprestimo(proximoStage);
		});
	}
}

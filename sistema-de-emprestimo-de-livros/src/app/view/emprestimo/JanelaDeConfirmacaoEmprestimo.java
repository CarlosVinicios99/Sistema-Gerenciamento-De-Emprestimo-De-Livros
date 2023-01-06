package app.view.emprestimo;

import javafx.stage.Stage;

public class JanelaDeConfirmacaoEmprestimo extends JanelaDeConfirmacao {
	
	public JanelaDeConfirmacaoEmprestimo(String mensagem, Stage proximoStage) {
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

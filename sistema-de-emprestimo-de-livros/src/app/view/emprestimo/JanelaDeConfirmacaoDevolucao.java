package app.view.emprestimo;

import javafx.stage.Stage;

public class JanelaDeConfirmacaoDevolucao extends JanelaDeConfirmacao {
	
	public JanelaDeConfirmacaoDevolucao(String mensagem, Stage proximoStage) {
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

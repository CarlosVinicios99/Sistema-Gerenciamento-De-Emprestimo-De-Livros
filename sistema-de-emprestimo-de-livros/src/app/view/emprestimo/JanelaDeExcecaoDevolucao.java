package app.view.emprestimo;

import app.view.JanelaDeExcecao;
import javafx.stage.Stage;

public class JanelaDeExcecaoDevolucao extends JanelaDeExcecao{
	
	public JanelaDeExcecaoDevolucao(String mensagem, Stage proximoStage) {
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

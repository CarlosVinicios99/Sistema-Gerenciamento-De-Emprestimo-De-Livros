package app.view.emprestimo;

import app.model.entities.Livro;
import app.view.JanelaDeExcecao;
import javafx.stage.Stage;


public class JanelaDeExcecaoUsuarioEmprestimo extends JanelaDeExcecao{
	
	private Livro livro;
	
	public JanelaDeExcecaoUsuarioEmprestimo(String mensagem, Stage proximoStage, Livro livro) {
		super(mensagem, proximoStage);
		this.livro = livro;
		adicionarEventoBotaoOk();
	}
	
	@Override
	public void adicionarEventoBotaoOk(){
		botaoOk.setOnAction(e -> {
			stageJanela.close();
			new TelaUsuarioEmprestimo(proximoStage, livro);
		});
	}
}

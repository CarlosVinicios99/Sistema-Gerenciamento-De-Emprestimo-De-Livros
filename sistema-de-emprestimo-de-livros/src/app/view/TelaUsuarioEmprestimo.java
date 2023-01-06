package app.view;

import app.model.entities.Emprestimo;
import app.model.entities.Livro;
import app.model.entities.Usuario;
import app.repositories.DAO;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class TelaUsuarioEmprestimo {
	
	private Stage stage = new Stage();
	private Scene cenaUsuarioEmprestimo;
	private String CSS = getClass().getResource("/app/view/estilo.css").toExternalForm();
	private Titulo titulo;
	private Label labelTitulo = new Label("Universidade Federal Fluminense");
	private GridPane gridPaneUsuarioEmprestimo = new GridPane();
	
	private Label labelTituloDeNavegacao = new Label("Confirmar Usuário");
	private Livro livro;
	private TextField campoCpf = new TextField();
	private PasswordField campoSenha = new PasswordField();
	private Label labelCpf = new Label("CPF: ");
	private Label labelSenha = new Label("Senha: ");
	private Button botaoConfirmar = new Button("Confirmar");
	private Button botaoCancelar = new Button("Cancelar");
	
	public TelaUsuarioEmprestimo(Stage stage, Livro livro) {
		this.stage = stage;
		this.livro = livro;
		criarGrid();
		configurarElementosVisuais();
		adicionarElementosNaTela();
		adicionarEventoBotaoConfirmar();
		adicionarEventoBotaoCancelar();
		exibirCena();
	}
	
	private void criarGrid() {
		gridPaneUsuarioEmprestimo.getColumnConstraints().add(criarColuna(100));
		gridPaneUsuarioEmprestimo.getRowConstraints()
			.addAll(criarLinha(9), criarLinha(6), criarLinha(9), criarLinha(6), criarLinha(6),
				criarLinha(3), criarLinha(6), criarLinha(6), criarLinha(6));
	}
	
	private RowConstraints criarLinha(double heigth) {
		RowConstraints linha = new RowConstraints();
		linha.setPercentHeight(heigth);
		linha.setFillHeight(true);
		return linha;
	}
	
	private ColumnConstraints criarColuna(double width) {
		ColumnConstraints coluna = new ColumnConstraints();
		coluna.setFillWidth(true);
		coluna.setPercentWidth(width);
		return coluna;
	}
	
	private void configurarElementosVisuais() {
		stage.setTitle("Empréstimos De Livros");
		stage.setResizable(false);
		gridPaneUsuarioEmprestimo.setAlignment(Pos.TOP_CENTER);
		gridPaneUsuarioEmprestimo.getStyleClass().add("telasDeMenu");
		
		labelTitulo.getStyleClass().add("tituloPrincipal");
		titulo = new Titulo(labelTitulo);
		titulo.getStyleClass().add("boxTituloPrincipal");
		
		labelTituloDeNavegacao.setTranslateX(550);
		labelTituloDeNavegacao.setMaxSize(230, 25);
		labelTituloDeNavegacao.getStyleClass().add("tituloNavegacao");
		
		labelCpf.setTranslateX(450);
		labelCpf.setMaxSize(70, 25);
		campoCpf.setTranslateX(550);
		campoCpf.setMaxSize(270, 30);
		
		labelSenha.setTranslateX(450);
		labelSenha.setMaxSize(70, 25);
		campoSenha.setTranslateX(550);
		campoSenha.setMaxSize(270, 30);
		
		botaoCancelar.setTranslateX(450);
		botaoCancelar.setMaxSize(110, 30);
		botaoCancelar.getStyleClass().add("botaoDeConfirmacao");
		botaoConfirmar.setTranslateX(770);
		botaoConfirmar.setMaxSize(110, 30);
		botaoConfirmar.getStyleClass().add("botaoDeConfirmacao");

	}
	
	private void adicionarElementosNaTela() {
		gridPaneUsuarioEmprestimo.add(titulo, 0, 0);
		gridPaneUsuarioEmprestimo.add(labelTituloDeNavegacao, 0, 2);
		gridPaneUsuarioEmprestimo.add(labelCpf, 0, 4);
		gridPaneUsuarioEmprestimo.add(campoCpf, 0, 4);
		gridPaneUsuarioEmprestimo.add(labelSenha, 0, 6);
		gridPaneUsuarioEmprestimo.add(campoSenha, 0, 6);
		gridPaneUsuarioEmprestimo.add(botaoCancelar, 0, 8);
		gridPaneUsuarioEmprestimo.add(botaoConfirmar, 0, 8);
	}
	
	private void adicionarEventoBotaoConfirmar() {
		botaoConfirmar.setOnAction(e -> {
			DAO.iniciarConexao();
			Usuario usuario = DAO.consultarUsuario(campoCpf.getText(), campoSenha.getText());
			if(usuario != null) {
				Emprestimo emprestimo = new Emprestimo(livro);
				if(DAO.inserirEmprestimo(emprestimo, usuario.getId())) {
					new JanelaDeConfirmacaoEmprestimo("      Empréstimo registrado!", stage);
				}
				else {
					new JanelaDeExcecaoEmprestimo("    Empréstimo não registrado!", stage);
				}
			}
			else {
				new JanelaDeExcecaoUsuarioEmprestimo("        Usuário não cadastrado!", stage, livro);
			}
			DAO.fecharConexao();
		});
	}
	
	private void adicionarEventoBotaoCancelar() {
		botaoCancelar.setOnAction(e -> {
			new TelaRealizacaoDeEmprestimo(stage);
		});
	}
	
	private void exibirCena() {
		cenaUsuarioEmprestimo = new Scene(gridPaneUsuarioEmprestimo, 1300, 700);
		cenaUsuarioEmprestimo.getStylesheets().add(CSS);
		stage.setScene(cenaUsuarioEmprestimo);
	}
}

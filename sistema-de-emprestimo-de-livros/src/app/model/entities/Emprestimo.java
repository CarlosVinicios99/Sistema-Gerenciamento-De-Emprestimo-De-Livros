package app.model.entities;

import java.sql.Date;
import java.time.LocalDate;

public class Emprestimo {
	
	private int id;
	
	private Livro livro;
	
	private Date dataInicial;
	
	private Date dataFinal;
	
	
	public Emprestimo() {
		
	}
	
	public Emprestimo(Livro livro) {
		this.livro = livro;
		this.dataInicial = Date.valueOf(LocalDate.now());
		this.dataFinal = Date.valueOf(LocalDate.now().plusDays(7L));
	}
	
	public Emprestimo(Livro livro, Date dataInicial, Date dataFinal) {
		this.livro = livro;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}
	
	public Emprestimo(int id, Livro livro, Date dataInicial, Date dataFinal) {
		this.id = id;
		this.livro = livro;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	@Override
	public String toString() {
		return livro.toString() + "\nData inicio: " + dataInicial.toString()
		+ "\nData final: " + dataFinal.toString();
	}
}

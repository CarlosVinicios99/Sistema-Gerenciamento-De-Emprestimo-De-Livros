package app;

import java.util.ArrayList;
import java.util.Scanner;

import app.model.entities.Emprestimo;
import app.model.entities.Livro;
import app.model.entities.Usuario;

public class Principal {
	
	public static void main(String[] args) {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		ArrayList<Livro> livros = new ArrayList<>();
		Scanner entrada = new Scanner(System.in);

		int opcao = 0;
		
		while(opcao != 11) {
			System.out.println("(1)Cadastrar Livro\n(2)Remover Livro\n(3)Buscar Livro");
			System.out.println("(4)Cadastrar Usuario\n(5)Remover Usuario\n(6)Buscar Usuario");
			System.out.println("(7)Emprestimo de Livro\n(8)Devolucao De Livro\n(9)Listar Usuarios");
			System.out.println("(10)Listar livros\n(11)Sair");
			opcao = Integer.parseInt(entrada.nextLine());
			
			if(opcao == 1) {
				System.out.print("Digite o codigo: ");
				String codigo = entrada.nextLine();
				
				System.out.print("Digite o titulo: ");
				String titulo = entrada.nextLine();
				
				System.out.print("Digite a descricao: ");
				String descricao = entrada.nextLine();
				
				System.out.print("Digite o autor: ");
				String autor = entrada.nextLine();
				
				System.out.println("Digite o proprietario: ");
				String proprietario = entrada.nextLine();
				
				Livro livro = 
					new Livro(codigo, titulo, descricao, autor, proprietario, true);
				
				livros.add(livro);
			}
			
			else if(opcao == 2) {
				System.out.println("Digite o codigo: ");
				String codigo = entrada.nextLine();
				Livro livroParaRemover = null;
				
				for(Livro livro: livros) {
					if(livro.getCodigo().equals(codigo)) {
						livroParaRemover = livro;
					}
				}
				
				livros.remove(livroParaRemover);
			}
			
			else if(opcao == 3) {
				System.out.println("Digite o codigo: ");
				String codigo = entrada.nextLine();
				Livro livroBuscado = null;
				
				for(Livro livro: livros) {
					if(livro.getCodigo().equals(codigo)) {
						livroBuscado = livro;
					}
				}
				
				if(livroBuscado == null) {
					System.out.println("Livro nao encontrado");
				}
				else {
					System.out.println(livroBuscado);
				}
			}
			
			else if(opcao == 4) {
				System.out.print("Digite a matricula: ");
				String matricula = entrada.nextLine();
				
				System.out.print("Digite o nome: ");
				String nome = entrada.nextLine();
				
				System.out.print("Digite o cpf: ");
				String cpf = entrada.nextLine();
				
				System.out.print("Digite o email: ");
				String email = entrada.nextLine();
				
				System.out.println("Digite a senha: ");
				String senha = entrada.nextLine();
				
				Usuario usuario 
					= new Usuario(matricula, nome, cpf, email, senha);
				
				usuarios.add(usuario);
			}
			
			else if(opcao == 5) {
				System.out.println("Digite a matricula: ");
				String matricula = entrada.nextLine();
				Usuario usuarioParaRemover = null;
				
				for(Usuario usuario: usuarios) {
					if(usuario.getMatricula().equals(matricula)) {
						usuarioParaRemover = usuario;
					}
				}
				
				usuarios.remove(usuarioParaRemover);
			}
			
			else if(opcao == 6) {
				System.out.println("Digite a matricula: ");
				String matricula = entrada.nextLine();
				Usuario usuarioBuscado = null;
				
				for(Usuario usuario: usuarios) {
					if(usuario.getMatricula().equals(matricula)) {
						usuarioBuscado = usuario;
					}
				}
				
				if(usuarioBuscado == null) {
					System.out.println("Usuario nao encontrado");
				}
				else {
					System.out.println(usuarioBuscado);
				}
			}
			
			else if(opcao == 7) {
				System.out.println("Digite a matricula do usuario: ");
				String matricula = entrada.nextLine();
				Usuario usuarioEmprestimo = null;
				
				for(Usuario usuario: usuarios) {
					if(usuario.getMatricula().equals(matricula)) {
						usuarioEmprestimo = usuario;
					}
				}
				
				if(usuarioEmprestimo != null) {
					if(usuarioEmprestimo.emprestimoPermitido()) {
						System.out.println("Digite o titulo do livro: ");
						String titulo = entrada.nextLine();
						
						Livro livroEmprestimo = null;
						
						for(Livro livro: livros) {
							if(livro.getTitulo().contains(titulo) && livro.getDisponibilidade()) {
								livroEmprestimo = livro;
							}
						}
						
						if(livroEmprestimo != null) {
							livroEmprestimo.setDisponibilidade(false);
							Emprestimo novoEmprestimo = new Emprestimo(livroEmprestimo);
							usuarioEmprestimo.adicionarEmprestimo(novoEmprestimo);
						}
						else {
							System.out.println("Livro nao encontrado");
						}
					}
					
					else {
						System.out.println("Usuario ja possui 3 livros emprestados");
					}		
				}
				
			}
			
			else if(opcao == 8) {
				System.out.println("Digite a matricula do usuario: ");
				String matricula = entrada.nextLine();
				Usuario usuarioDevolucao = null;
				
				for(Usuario usuario: usuarios) {
					if(usuario.getMatricula().equals(matricula)) {
						usuarioDevolucao = usuario;
					}
				}
				
				if(usuarioDevolucao != null) {
					System.out.println("Digite o codigo do livro: ");
					String codigo = entrada.nextLine();
		
					Livro livroDevolucao = null;
						
					for(Livro livro: livros) {
						if(livro.getCodigo().equals(codigo)) {
							livroDevolucao = livro;
						}
					}
					
					if(livroDevolucao != null) {
						livroDevolucao.setDisponibilidade(true);
						usuarioDevolucao.removerEmprestimo(livroDevolucao);
					}
					
					else {
						System.out.println("Livro nao encontrado");
					}
				}
				
				else {
					System.out.println("Usuario nao encontrado");
				}
			}
			
			else if(opcao == 9) {
				for(Usuario usuario: usuarios) {
					System.out.println(usuario);
				}
			}
			
			else if(opcao == 10) {	
				for(Livro livro: livros) {
					System.out.println(livro);
				}
			}
			
			else if(opcao == 11) {
				System.out.println("Saindo");
			}
			
			else {
				System.out.println("Opcao invalidade\nTente Novamente");
			}
			
			System.out.println("\n");
		}
		entrada.close();
	}
	
}

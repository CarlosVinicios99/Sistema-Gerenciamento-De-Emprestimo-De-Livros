package app;

import app.model.entities.Usuario;

public class Principal {
	
	public static void main(String[] args) {
		
		Usuario usuario = 
			new Usuario("119060025", "Carlos", "183.983.847-78", "carlosvinicios@id.uff.br", "122");
		
		System.out.println(usuario);
		
	}
	
}

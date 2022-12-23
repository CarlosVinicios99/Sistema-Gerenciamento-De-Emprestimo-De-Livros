package repositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DAO<E> {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("sistema-de-emprestimos-de-livros");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		em = emf.createEntityManager();
		this.classe = classe;
	}
	
	private void abrirTransacao(){
		em.getTransaction().begin();
	}
	
	public void fecharTransacao(){
		em.getTransaction().commit();
	}
	
	public void fecharConexao() {
		em.close();
	}
	
	public void limparContextoTransacional(E entidade) {
		em.detach(entidade);
	}
	
	public void inserir(E entidade){
		abrirTransacao();
		em.persist(entidade);
		fecharTransacao();
	}
	
	
	public Query criarConsulta(String codigo, String sql) {
		return em.createNativeQuery(sql, classe);
	}
	
	public void alterar(E entidade) {
		if(entidade != null) {
			abrirTransacao();
			em.merge(entidade);
			fecharTransacao();
		}
	}
	
	public void remover(E entidade) {
		if(entidade != null) {
			abrirTransacao();
			em.remove(em.contains(entidade) ? entidade : em.merge(entidade));
			fecharTransacao();
		}
	}
		
}

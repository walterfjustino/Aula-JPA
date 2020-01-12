package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {
	
	public static void main(String[] args) {
		
	/*------------INSERINDO DADOS NA TABELA-------------*/
	/*	Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");         */
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
	/*-------LOCALIZANDO UMA PESSOA NO BANCO DE DADOS----------*/	
	
	/* Pessoa p = em.find(Pessoa.class, 2);
	   System.out.println(p);  */
		
	/*--------REMOVENDO/APAGANDO UMA PESSOA NO BANCO DE DADOS----------*/	
	/*Para remover, a entidade deve ser MONITORADA, no caso acabou de ser INSERIDA
	 *  ou acabou de ser RECUPERADA/PESQUISADA no Banco de dados*/
		
		Pessoa p = em.find(Pessoa.class, 2); 
		em.getTransaction().begin();			
		em.remove(p);
		em.getTransaction().commit();
	
	/*-----PERSISTE/SALVA OS DADOS NO BANCO DE DADOS-------*/	
	/*	em.getTransaction().begin();
	    em.persist(p1);
		em.persist(p2);
		em.persist(p3);  
		em.getTransaction().commit();  */
		
			
		
		System.out.println("Pronto!");
		em.close();
		emf.close();
		
	
	}

}

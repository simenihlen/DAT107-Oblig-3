package no.hvl.dat107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProsjektDAO {
	
	private static EntityManagerFactory emf;
	
	public ProsjektDAO() {
		emf = Persistence.createEntityManagerFactory("persistence");
	}
	
	public void leggTil(Prosjekt leggTil) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
            tx.begin();
            em.persist(leggTil);
            tx.commit();
        
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        
        }
	}
	
	public Prosjekt finnProsjekt(int id) {
		EntityManager em = emf.createEntityManager();
		Prosjekt prosjekt = null;
		
		try {
			prosjekt = em.find(Prosjekt.class, id);
		} finally {
			em.close();
		}
		return prosjekt;
	}
}
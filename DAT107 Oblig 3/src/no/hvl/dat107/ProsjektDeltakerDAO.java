package no.hvl.dat107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProsjektDeltakerDAO {
	private static EntityManagerFactory emf;
	
	public ProsjektDeltakerDAO() {
		emf = Persistence.createEntityManagerFactory("persitence");
	}
	
	public void leggTilAnsattTilProsjekt(int id, ProsjektDeltaker deltaker) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Prosjekt prosjekt = em.find(Prosjekt.class, id);
		
		try {
            tx.begin();
            deltaker.setProsjektId(prosjekt);
            deltaker.getId().leggTil(deltaker);
        
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        
        }
	}
}

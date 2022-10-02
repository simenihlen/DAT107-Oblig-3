package no.hvl.dat107;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AvdelingDAO {
	private static EntityManagerFactory emf;
	
	public AvdelingDAO() {
		emf = Persistence.createEntityManagerFactory("persistence");
	}
	
	public Avdeling finnAvdelingMedId(int id) {
		EntityManager em = emf.createEntityManager();
		Avdeling avdeling = null;
		
		try {
			avdeling = em.find(Avdeling.class, id);
		} finally {
			em.close();
		}
		return avdeling;
	}
	
	public void skrivUtAlle(int id) {
		EntityManager em = emf.createEntityManager();
		Avdeling avdeling = em.find(Avdeling.class, id);
		String query = "SELECT a FROM Ansatt a" + "WHERE a.avdeling = :avdeling";
		List<Ansatt> ansatte = null;
		
		try {
			TypedQuery<Ansatt> queryString = em.createQuery(query, Ansatt.class);
			queryString.setParameter("avdeling", avdeling);
			avdeling = (Avdeling) queryString.getResultList();
			
			for (Ansatt a : ansatte) {
				if (a == avdeling.getSjef()) {
					System.out.println("Sjefen er: " + a.toString());
				} else {
					System.out.println(a.toString());
				}
			}
			
		} finally {
			em.close();
		}
	}
	
	public void leggTil(Avdeling avdeling, Ansatt sjef) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
            tx.begin();
            em.persist(avdeling);
//            sjef.setAvdeling(avdeling);
//            em.merge(sjef);
            tx.commit();
        
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
	}
}

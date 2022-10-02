package no.hvl.dat107;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AnsattDAO {
	
	public static EntityManagerFactory emf;
	
	public AnsattDAO() {
		emf = Persistence.createEntityManagerFactory("persistence");
	}
	
	public Ansatt finnAnsattMedId (int id) {
		EntityManager em = emf.createEntityManager();
		Ansatt ansatt = null;
		
		try {
			ansatt = em.find(Ansatt.class, id);
		} finally {
			em.close();
		}
		return ansatt;
	}
	
	public Ansatt finnAnsattMedBrukernavn (String brukernavn) {
		Ansatt ansatt = null;
		EntityManager em = emf.createEntityManager();
		String query = "SELECT a FROM Ansatt a " + "WHERE a.brukernavn = :brukernavn";
		
		try {
			TypedQuery<Ansatt> queryString = em.createQuery(query, Ansatt.class);
			queryString.setParameter("brukernavn", brukernavn);
			ansatt = queryString.getSingleResult();
		} finally {
			em.close();
		}
		return ansatt;
	}
	
	public void skrivUtAlle() {
		  EntityManager em = emf.createEntityManager();

	        List<Ansatt> ansatte = null;
	        try {
	            String queryString = "SELECT p FROM Ansatt p ORDER BY p.id";
	            TypedQuery<Ansatt> query = em.createQuery(queryString, Ansatt.class);
	            ansatte = query.getResultList();
	            for (Ansatt a : ansatte) {
	            	System.out.println(a.toString());
	            }
	        } finally {
	            em.close();
	        }
	        
	}
	
	public void oppdaterStilling (String stilling, int ansattId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

        try {
           Ansatt ansatt = em.find(Ansatt.class, ansattId);
           tx.begin();
           if (ansatt != null) {
        	   ansatt.setStilling(stilling);
        	   em.merge(ansatt);
           }
        } catch (Throwable e) {
        	e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
        	em.close();
        }
	}
	
	public void leggTil(Ansatt leggTil) {
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
	
}

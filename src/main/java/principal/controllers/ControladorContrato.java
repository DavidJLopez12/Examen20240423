package principal.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



import principal.entities.Contrato;
import principal.entities.Usuario;

public class ControladorContrato {

	public static ControladorContrato instance = null;
	private static EntityManager em = getEntityManager();
	private static String nombreTabla = "contrato";
	private Class tipoEntidad;
	
	public static ControladorContrato getInstance() {
		if (instance == null) {
			instance = new ControladorContrato();
		}
		return instance;
	}
	
	private static EntityManager getEntityManager () {
		return Persistence.createEntityManagerFactory("Bankonter").createEntityManager();
	}
	
	public Contrato obtenerContratoPorId(int id) {
        return (Contrato) getEntityManager().createNativeQuery("SELECT * FROM contrato where id = " + id, Contrato.class).getSingleResult();

    }
	
	public static void insert (Contrato o) {
		
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	
	public static void delete(int id) {
	    // Utilizamos named parameters para evitar vulnerabilidades de inyección de SQL
	    TypedQuery<Contrato> q = em.createQuery("SELECT a FROM contrato a WHERE a.id = :id", Contrato.class);
	    q.setParameter("id", id);
	    
	    List <Contrato> contratos = q.getResultList();
	    
	    em.getTransaction().begin();
	    for (Contrato Contrato : contratos) {
	        em.remove(Contrato);
	    }
	    em.getTransaction().commit();
	}

	
	public static void update(Contrato e) {
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
	
	public static void delete(Contrato e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
	}
	

	public static Contrato findArtById(int id) {
		try {
			Contrato entidad = (Contrato) em.find(Contrato.class, id);
			return entidad;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	private void modificacionEntidad (Contrato m) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
			em.merge(m);
		em.getTransaction().commit();
	}
	
	public static Contrato getPrimero() {
        Query q  = em.createNativeQuery("Select min(id) from "  + nombreTabla);
        int primerId = (int) q.getSingleResult();
        Contrato c = em.find(Contrato.class, primerId);
        return c;
    }
	
	 public static Contrato getUltimo() {
	        Query q  = em.createNativeQuery("Select max(id) from "  + nombreTabla);
	        int primerId = (int) q.getSingleResult();
	        Contrato c = em.find(Contrato.class, primerId);
	        return c;
	    }
	 
	 public static Contrato getSiguiente(int id) {
		    Contrato c = null;
		    Query q = em.createNativeQuery("SELECT MIN(id) FROM " + nombreTabla + " WHERE id > ?id");
		    q.setParameter("id", id);
		    Integer siguienteId = (Integer) q.getSingleResult();
		    
		    if (siguienteId != null) {
		        c = em.find(Contrato.class, siguienteId);
		    } else {
		        c = getPrimero();
		    }
		    
		    return c;
		}
	 
	 public static Contrato getAnterior(int id) {
	        Contrato c = null;
	        Query q = em.createNativeQuery("SELECT MAX(id) FROM " + nombreTabla + " WHERE id < ?id");
	        q.setParameter("id", id);
	        Integer anteriorId = (Integer) q.getSingleResult();

	        if (anteriorId != null) {
	            c = em.find(Contrato.class, anteriorId);
	        } else {
	            c = getUltimo();
	        }

	        return c;
	    }
	 
	 public static List<Contrato> findAll() {
			return (List<Contrato>) em.createNativeQuery("SELECT * FROM " + nombreTabla, Contrato.class)
					.getResultList();
		}
	 
}

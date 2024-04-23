package principal.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import principal.entities.Usuario;

public class ControladorUsuario {

	public static ControladorUsuario instance = null;
	private static EntityManager em = getEntityManager();
	private static String nombreTabla = "usuario";
	private Class tipoEntidad;
	
	public static ControladorUsuario getInstance() {
		if (instance == null) {
			instance = new ControladorUsuario();
		}
		return instance;
	}
	
	private static EntityManager getEntityManager () {
		return Persistence.createEntityManagerFactory("Bankonter").createEntityManager();
	}
	
	public Usuario obtenerEstudiantePorId(int id) {
        return  (Usuario) getEntityManager().createNativeQuery("SELECT * FROM usuario where id = " + id, Usuario.class).getSingleResult();

    }
	
	public static void insert (Usuario o) {
		
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	
	public static void delete(int id) {
	    // Utilizamos named parameters para evitar vulnerabilidades de inyección de SQL
	    TypedQuery<Usuario> q = em.createQuery("SELECT a FROM usuario a WHERE a.id = :id", Usuario.class);
	    q.setParameter("id", id);
	    
	    List <Usuario> Usuarios = q.getResultList();
	    
	    em.getTransaction().begin();
	    for (Usuario Usuario : Usuarios) {
	        em.remove(Usuario);
	    }
	    em.getTransaction().commit();
	}

	
	public static void update(Usuario e) {
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
	
	public static void delete(Usuario e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
	}
	

	public static Usuario findArtById(int id) {
		try {
			Usuario entidad = (Usuario) em.find(Usuario.class, id);
			return entidad;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	private void modificacionEntidad (Usuario m) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
			em.merge(m);
		em.getTransaction().commit();
	}
	
	public static Usuario getPrimero() {
        Query q  = em.createNativeQuery("Select min(id) from "  + nombreTabla);
        int primerId = (int) q.getSingleResult();
        Usuario c = em.find(Usuario.class, primerId);
        return c;
    }
	
	 public static Usuario getUltimo() {
	        Query q  = em.createNativeQuery("Select max(id) from "  + nombreTabla);
	        int primerId = (int) q.getSingleResult();
	        Usuario c = em.find(Usuario.class, primerId);
	        return c;
	    }
	 
	 public static Usuario getSiguiente(int id) {
		    Usuario c = null;
		    Query q = em.createNativeQuery("SELECT MIN(id) FROM " + nombreTabla + " WHERE id > ?id");
		    q.setParameter("id", id);
		    Integer siguienteId = (Integer) q.getSingleResult();
		    
		    if (siguienteId != null) {
		        c = em.find(Usuario.class, siguienteId);
		    } else {
		        c = getPrimero();
		    }
		    
		    return c;
		}
	 
	 public static Usuario getAnterior(int id) {
	        Usuario c = null;
	        Query q = em.createNativeQuery("SELECT MAX(id) FROM " + nombreTabla + " WHERE id < ?id");
	        q.setParameter("id", id);
	        Integer anteriorId = (Integer) q.getSingleResult();

	        if (anteriorId != null) {
	            c = em.find(Usuario.class, anteriorId);
	        } else {
	            c = getUltimo();
	        }

	        return c;
	    }
	 
	 public static List<Usuario> findAll() {
			return (List<Usuario>) em.createNativeQuery("SELECT * FROM " + nombreTabla, Usuario.class)
					.getResultList();
			
			

		}
	 
}

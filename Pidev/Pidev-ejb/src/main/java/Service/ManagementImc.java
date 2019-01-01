package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.*;

/**
 * Session Bean implementation class ManagementImc
 */
@Stateless
@LocalBean
public class ManagementImc implements ManagementImcRemote, ManagementImcLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public ManagementImc() {
        // TODO Auto-generated constructor stub
		
    }

	@Override
	public void addImc(Imc imc) {
		// TODO Auto-generated method stub
		em.persist(imc);
	}

	@Override
	public Imc findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Imc.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Imc> findByAll() {
		// TODO Auto-generated method stub
		Query query=em.createQuery("select e from Imc e");
		return query.getResultList();
	}
	//imcRecomendation
	//ToImc

	public String ToImc() {
		
		return "Imc?faces-redirect=true";

	}

}

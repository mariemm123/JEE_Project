package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Appointment;
import entity.Review;


/**
 * Session Bean implementation class RdvManagement
 */
@Stateless
@LocalBean
public class RdvManagement implements RdvManagementRemote, RdvManagementLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	EntityManager em ;
    public RdvManagement() {
        // TODO Auto-generated constructor stub
    }
    
  
    
	@Override
	public List<Appointment> getAllRDV() {
		List<Appointment> query=em.createQuery("select e from Appointment e",
				Appointment.class).getResultList();
		return query ;
	}
	/*@Override
	public Appointment getRDV(int id) {
		Query query=em.createQuery("select e from Rendez_Vous e where e.id='"+id+"' ");
		return (Appointment) query.getSingleResult();
	}*/

  
	@Override
	public Appointment getRDV(int id) {
		Query query=em.createQuery("select e from Appointment e where e.id='"+id+"' ");
		return (Appointment) query.getSingleResult();
	}
	
	

}

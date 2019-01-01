package Service;



import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Appointment;

/**
 * Session Bean implementation class ManagementAppointment
 */
@Stateless
@LocalBean
public class ManagementAppointment implements ManagementAppointmentRemote, ManagementAppointmentLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public ManagementAppointment() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addAppointment(Appointment apt) {
		// TODO Auto-generated method stub
		em.persist(apt);
	}

	@Override
	public Appointment findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Appointment.class, id);
	}

	@Override
	public void updateAppointment(Appointment apt) {
		// TODO Auto-generated method stub
		em.merge(apt);
	}

	@Override
	public void deleteappointment(Appointment apt) {
		// TODO Auto-generated method stub
		em.remove(apt);
	}



}

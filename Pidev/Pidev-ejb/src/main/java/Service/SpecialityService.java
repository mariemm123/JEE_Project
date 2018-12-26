package Service;



import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



/**
 * Session Bean implementation class SpecialityService
 */
@Stateless
@LocalBean
public class SpecialityService implements SpecialityServiceRemote, SpecialityServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public SpecialityService() {
        // TODO Auto-generated constructor stub
    }

	
}

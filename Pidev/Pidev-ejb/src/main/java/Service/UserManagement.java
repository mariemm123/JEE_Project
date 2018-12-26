package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.AspNetUser;



/**
 * Session Bean implementation class UserManagement
 */
@Stateless
@LocalBean
public class UserManagement implements UserManagementRemote, UserManagementLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	EntityManager em ;
    public UserManagement() {
        // TODO Auto-generated constructor stub
    	
    	
    }
    
    public void addUser(AspNetUser user){
    	em.persist(user);
    }
    public AspNetUser findById(int id)
    {
    	return em.find(AspNetUser.class, id);
    }
    public void updateUser(AspNetUser user)
    {
    	em.merge(user);
   
    }
    public void deleteUser(AspNetUser user)
    {
    	em.remove(user);
    }
	@Override
	public AspNetUser login(String email, String passwordHash) {
		Query query=em.createQuery("select e from AspNetUser e where e.email='"+email+"' AND e.passwordHash='"+passwordHash+"'");
		return (AspNetUser) query.getSingleResult();
	}
	
	@Override
	public List<AspNetUser> getAllUsers() {
		List<AspNetUser> query=em.createQuery("select e from AspNetUser e",
				AspNetUser.class).getResultList();
		return query ;
	}


	

	
	

}

package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Review;



/**
 * Session Bean implementation class ReviewManagement
 */
@Stateless
@LocalBean
public class ReviewManagement implements ReviewManagementRemote, ReviewManagementLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	EntityManager em ;
    public ReviewManagement() {
        // TODO Auto-generated constructor stub
    }
    
    public void addReview(Review review){
    	em.persist(review);
    }
    public void updateReview(Review review)
    {
    	em.merge(review);
    }
    
    
	@Override 
	public List<Review> getAllReview() {
		List<Review> query=em.createQuery("select e from Review e",
				Review.class).getResultList();
		return query ;
	}
	
	
	@Override 
	public List<Review> getReviewById(int id) {
		List<Review> query=em.createQuery("select e from Review e Where e.id='"+id+"'",
				Review.class).getResultList();
		return query ;
	}
	
	  @Override
	    public void deleteReviewbyid(int ReviewId)
	    {
	      Review e =em.find(Review.class,ReviewId )	;
	      em.remove(e);
	      System.out.println("supprimee1"+e); 
		 
	    }


}

package managerbean;



import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

//import org.primefaces.event.RateEvent;

import Service.ReviewManagement;
import entity.Review;




/**
 * Session Bean implementation class RdvBean
 */
@ManagedBean
@SessionScoped
public class ReviewBean {
	private Review review= new Review();
	@EJB
	private ReviewManagement ReviewManagementLocal;
    /**
     * Default constructor. 
     */
    public ReviewBean() {
        // TODO Auto-generated constructor stub
    }
    private Integer rating3;
   /* public void onrate(RateEvent rateEvent) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "You rated:" + ((Integer) rateEvent.getRating()).intValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }*/
     
    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "Rate Reset");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public Integer getRating3() {
		return rating3;
	}

	public void setRating3(Integer rating3) {
		this.rating3 = rating3;
	}

	public String doAdd(){
    	ReviewManagementLocal.addReview(review);
    	return "/listReview.xhtml?faces-redirect=true";
    }

	public Review getReview() {
		return review;
	}
	
	 private List<Review> Reviews;
	    public List<Review> displayAllReview(){
	    	Reviews =ReviewManagementLocal.getAllReview();
	    	return Reviews;
	    }
	    
	    
	    
	   public void MAJReview()
	    {
		   ReviewManagementLocal.updateReview(new Review(Content,DatePost,rating));
	    }
	    
	    public List<Review> displayReviewById(int id){
	    	Reviews =ReviewManagementLocal.getReviewById(id);
	    	return Reviews;
	    }
	    private String Content;
	    private Date DatePost;
	    private float rating;
	    
	    public List<Review> getReviews() {
			return Reviews;
		}

		public void setReviews(List<Review> reviews) {
			Reviews = reviews;
		}

		public Date getDatePost() {
			return DatePost;
		}

		public void setDatePost(Date datePost) {
			DatePost = datePost;
		}

		public float getRating() {
			return rating;
		}

		public void setRating(float rating) {
			this.rating = rating;
		}

		public String getContent() {
			return Content;
		}

		public void setContent(String content) {
			this.Content = content;
		}

		public void editReview (Review review)
	    {
	    	this.setContent(review.getContent());
	    	this.setDatePost(review.getDatePost());
	    	this.setRating(review.getRating());
	    }
	    
	    
	    
	    public int removeReview (int ReviewId)
	    {
	    	ReviewManagementLocal.deleteReviewbyid(ReviewId);
	    	System.out.println("supprimee2");
	    	return ReviewId;
	    }

	public void setReview(Review review) {
		this.review = review;
	}

	public ReviewManagement getReviewManagementLocal() {
		return ReviewManagementLocal;
	}

	public void setReviewManagementLocal(ReviewManagement reviewManagementLocal) {
		ReviewManagementLocal = reviewManagementLocal;
	}
    
    

}

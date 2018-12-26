package Service;

import java.util.List;

import javax.ejb.Local;

import entity.Review;



@Local
public interface ReviewManagementLocal {
	public void addReview(Review review);

	List<Review> getAllReview();
	public void deleteReviewbyid(int ReviewId);
	public List<Review> getReviewById(int id );
}

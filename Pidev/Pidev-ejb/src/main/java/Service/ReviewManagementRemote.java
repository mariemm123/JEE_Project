package Service;

import java.util.List;

import javax.ejb.Remote;

import entity.Review;

@Remote
public interface ReviewManagementRemote {
	public void addReview(Review review);
	public void deleteReviewbyid(int ReviewId);
	public List<Review> getReviewById(int id);
}

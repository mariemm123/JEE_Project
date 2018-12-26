package entity;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Review
 *
 */
@Entity

public class Review implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String Content;
	private Date DatePost;
	private float rating;
	@ManyToOne
	private AspNetUser AspNetUser ;
	@OneToOne
	private Appointment Appointment ;
	private static final long serialVersionUID = 1L;


	public AspNetUser getAspNetUser() {
		return AspNetUser;
	}
	public void setAspNetUser(AspNetUser aspNetUser) {
		AspNetUser = aspNetUser;
	}
	public Appointment getAppointment() {
		return Appointment;
	}
	public void setAppointment(Appointment appointment) {
		Appointment = appointment;
	}
	public Review() {
		super();
	}   
	
	public Review(int id, String content, Date datePost, float rating) {
		super();
		this.id = id;
		Content = content;
		DatePost = datePost;
		this.rating = rating;
	}
	public Review(String content, Date datePost, float rating) {
		super();
		Content = content;
		DatePost = datePost;
		this.rating = rating;
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getContent() {
		return this.Content;
	}

	public void setContent(String Content) {
		this.Content = Content;
	}   
	public Date getDatePost() {
		return this.DatePost;
	}

	public void setDatePost(Date DatePost) {
		this.DatePost = DatePost;
	}   
	public float getRating() {
		return this.rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
   
}

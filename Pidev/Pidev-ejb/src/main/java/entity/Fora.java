package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Fora database table.
 * 
 */
@Entity
@Table(name="Fora")
@NamedQuery(name="Fora.findAll", query="SELECT f FROM Fora f")
public class Fora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ForumId", unique=true, nullable=false)
	private int forumId;

	@Column(nullable=false)
	private Timestamp sentAt;

	@Column(length=2147483647)
	private String subject;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="subjectCreater_Id", referencedColumnName="Id")
	private AspNetUser aspNetUser;

	public Fora() {
	}

	public int getForumId() {
		return this.forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public Timestamp getSentAt() {
		return this.sentAt;
	}

	public void setSentAt(Timestamp sentAt) {
		this.sentAt = sentAt;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

}
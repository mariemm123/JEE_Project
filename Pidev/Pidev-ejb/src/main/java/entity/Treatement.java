package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the Treatements database table.
 * 
 */
@Entity
@Table(name="Treatements")
@NamedQuery(name="Treatement.findAll", query="SELECT t FROM Treatement t")
public class Treatement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TreatementId", unique=true, nullable=false)
	private int treatementId;

	@Column(name="DateTretement", nullable=false)
	private Date DateTretement;

	@Column(nullable=false, length=50)
	private String description;

	@Column(name="DuréeTretement", nullable=false, length=2147483647)
	private String DuréeTretement;

	@Column(name="Validation", nullable=false)
	private boolean Validation;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="UserId", referencedColumnName="Id")
	private AspNetUser aspNetUser;

	public Treatement() {
	}

	public int getTreatementId() {
		return this.treatementId;
	}

	public void setTreatementId(int treatementId) {
		this.treatementId = treatementId;
	}

	public Date getDateTretement() {
		return this.DateTretement;
	}

	public void setDateTretement(Timestamp dateTretement) {
		this.DateTretement = dateTretement;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuréeTretement() {
		return this.DuréeTretement;
	}

	public void setDuréeTretement(String duréeTretement) {
		this.DuréeTretement = duréeTretement;
	}

	public boolean getValidation() {
		return this.Validation;
	}

	public void setValidation(boolean validation) {
		this.Validation = validation;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

	public Treatement(Date dateTretement, String description, String duréeTretement, boolean validation) {
		super();
		DateTretement = dateTretement;
		this.description = description;
		DuréeTretement = duréeTretement;
		Validation = validation;
	}
	

}
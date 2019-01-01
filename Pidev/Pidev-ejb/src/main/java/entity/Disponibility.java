package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the Disponibilities database table.
 * 
 */
@Entity
@Table(name="Disponibilities")
@NamedQuery(name="Disponibility.findAll", query="SELECT d FROM Disponibility d")
public class Disponibility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DisponibilityId", unique=true, nullable=false)
	private int disponibilityId;

	@Column(nullable=false)
	private Date endTimeOfDisponibility;

	@Column(nullable=false)
	private Date startTimeOfDisponibility;

	@Column(name="State", nullable=false)
	private boolean state;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="doctor_Id", referencedColumnName="Id")
	private AspNetUser aspNetUser;

	public Disponibility() {
	}

	public int getDisponibilityId() {
		return this.disponibilityId;
	}

	public void setDisponibilityId(int disponibilityId) {
		this.disponibilityId = disponibilityId;
	}

	public Date getEndTimeOfDisponibility() {
		return this.endTimeOfDisponibility;
	}

	public void setEndTimeOfDisponibility(Date endTimeOfDisponibility) {
		this.endTimeOfDisponibility = endTimeOfDisponibility;
	}

	public Date getStartTimeOfDisponibility() {
		return this.startTimeOfDisponibility;
	}

	public void setStartTimeOfDisponibility(Date startTimeOfDisponibility) {
		this.startTimeOfDisponibility = startTimeOfDisponibility;
	}

	public boolean getState() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

}
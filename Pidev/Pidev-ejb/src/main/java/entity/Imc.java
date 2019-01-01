package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the imcs database table.
 * 
 */
@Entity
@Table(name="imcs")
@NamedQuery(name="Imc.findAll", query="SELECT i FROM Imc i")
public class Imc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ImcId")
	private int imcId;

	private float height;

	@Column(name="ImcDate")
	private Date imcDate;

	private float weight;
	 @Transient
	 private float imcValue;
	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="patient_Id")
	private AspNetUser aspNetUser;

	public Imc() {
	}
	

	public float getImcValue() {
		return imcValue;
	}


	public void setImcValue(float imcValue) {
		this.imcValue = imcValue;
	}


	public int getImcId() {
		return this.imcId;
	}

	public void setImcId(int imcId) {
		this.imcId = imcId;
	}

	public float getHeight() {
		return this.height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Date getImcDate() {
		return this.imcDate;
	}

	public void setImcDate(Date date) {
		this.imcDate = date;
	}

	public float getWeight() {
		return this.weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}


	@Override
	public String toString() {
		return "Imc [imcId=" + imcId + ", height=" + height + ", imcDate=" + imcDate + ", weight=" + weight
				+ ", imcValue=" + imcValue  + "]";
	}

}
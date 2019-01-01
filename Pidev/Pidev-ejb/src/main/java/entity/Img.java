package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the imgs database table.
 * 
 */
@Entity
@Table(name="imgs")
@NamedQuery(name="Img.findAll", query="SELECT i FROM Img i")
public class Img implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ImgId")
	private int imgId;

	@Column(name="ImcDate")
	private Date imcDate;

	private float imgValue;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="patient_Id")
	private AspNetUser aspNetUser;

	public Img() {
	}

	public int getImgId() {
		return this.imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public Date getImcDate() {
		return this.imcDate;
	}

	public void setImcDate(Date imcDate) {
		this.imcDate = imcDate;
	}

	public float getImgValue() {
		return imgValue;
	}

	public void setImgValue(float imgValue) {
		this.imgValue = imgValue;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser patient_Id) {
		this.aspNetUser= patient_Id;
	}

	@Override
	public String toString() {
		return "Img [imgId=" + imgId + ", imcDate=" + imcDate + ", imgValue=" + imgValue + "]";
	}

}
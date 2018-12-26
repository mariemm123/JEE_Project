package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the MedicalPaths database table.
 * 
 */
@Entity
@Table(name="MedicalPaths")
@NamedQuery(name="MedicalPath.findAll", query="SELECT m FROM MedicalPath m")
public class MedicalPath implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MedicalPathId", unique=true, nullable=false)
	private int MedicalPathId;

	@Column(name="DateParcour", nullable=false)
	private Date DateParcour;
	
	
	private String DoctorName;
	private String DoctorAdress;

	//private Timestamp dateParcour;

	@Column(name="Description", nullable=false, length=50)
	private String Description;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="DoctorId", referencedColumnName="Id")
	private AspNetUser AspNetUser1;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="UserId", referencedColumnName="Id")
	private AspNetUser AspNetUser2;

	//bi-directional many-to-one association to Speciality
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="SpecialityId")
	private Speciality Speciality;

	public MedicalPath() {
	}

	public int getMedicalPathId() {
		return MedicalPathId;
	}

	public void setMedicalPathId(int medicalPathId) {
		MedicalPathId = medicalPathId;
	}

	public Date getDateParcour() {
		return DateParcour;
	}

	public void setDateParcour(Date dateParcour) {
		DateParcour = dateParcour;
	}

	public String getDoctorName() {
		return DoctorName;
	}

	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}

	public String getDoctorAdress() {
		return DoctorAdress;
	}

	public void setDoctorAdress(String doctorAdress) {
		DoctorAdress = doctorAdress;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public AspNetUser getAspNetUser1() {
		return AspNetUser1;
	}

	public void setAspNetUser1(AspNetUser aspNetUser1) {
		AspNetUser1 = aspNetUser1;
	}

	public AspNetUser getAspNetUser2() {
		return AspNetUser2;
	}

	public void setAspNetUser2(AspNetUser aspNetUser2) {
		AspNetUser2 = aspNetUser2;
	}

	public Speciality getSpeciality() {
		return Speciality;
	}

	public void setSpeciality(Speciality speciality) {
		Speciality = speciality;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public MedicalPath(Date dateParcour, String doctorName, String description) {
		super();
		DateParcour = dateParcour;
		DoctorName = doctorName;
		Description = description;
	}

	public MedicalPath(Date dateParcour, String description) {
		super();
		DateParcour = dateParcour;
		Description = description;
	}

	@Override
	public String toString() {
		return "MedicalPath [MedicalPathId=" + MedicalPathId + ", DateParcour=" + DateParcour + ", DoctorName="
				+ DoctorName + ", DoctorAdress=" + DoctorAdress + ", Description=" + Description + ", AspNetUser1="
				+ AspNetUser1 + ", AspNetUser2=" + AspNetUser2 + ", Speciality=" + Speciality + ", getMedicalPathId()="
				+ getMedicalPathId() + ", getDateParcour()=" + getDateParcour() + ", getDoctorName()=" + getDoctorName()
				+ ", getDoctorAdress()=" + getDoctorAdress() + ", getDescription()=" + getDescription()
				+ ", getAspNetUser1()=" + getAspNetUser1() + ", getAspNetUser2()=" + getAspNetUser2()
				+ ", getSpeciality()=" + getSpeciality() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	

	
	

	

}
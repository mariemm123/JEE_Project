package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Specialities database table.
 * 
 */
@Entity
@Table(name="Specialities")
@NamedQuery(name="Speciality.findAll", query="SELECT s FROM Speciality s")
public class Speciality implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SpecialityId", unique=true, nullable=false)
	private int specialityId;

	@Column(length=2147483647)
	private String nomSpecialite;

	//bi-directional many-to-one association to AspNetUser
	@OneToMany(mappedBy="speciality")
	private List<AspNetUser> aspNetUsers;

	//bi-directional many-to-one association to MedicalPath
	@OneToMany(mappedBy="Speciality", cascade=CascadeType.PERSIST)
	private List<MedicalPath> medicalPaths;

	public Speciality() {
	}

	public int getSpecialityId() {
		return this.specialityId;
	}

	public void setSpecialityId(int specialityId) {
		this.specialityId = specialityId;
	}

	public String getNomSpecialite() {
		return this.nomSpecialite;
	}

	public void setNomSpecialite(String nomSpecialite) {
		this.nomSpecialite = nomSpecialite;
	}

	public List<AspNetUser> getAspNetUsers() {
		return this.aspNetUsers;
	}

	public void setAspNetUsers(List<AspNetUser> aspNetUsers) {
		this.aspNetUsers = aspNetUsers;
	}

	public AspNetUser addAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().add(aspNetUser);
		aspNetUser.setSpeciality(this);

		return aspNetUser;
	}

	public AspNetUser removeAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().remove(aspNetUser);
		aspNetUser.setSpeciality(null);

		return aspNetUser;
	}

	public List<MedicalPath> getMedicalPaths() {
		return this.medicalPaths;
	}

	public void setMedicalPaths(List<MedicalPath> medicalPaths) {
		this.medicalPaths = medicalPaths;
	}

	public MedicalPath addMedicalPath(MedicalPath medicalPath) {
		getMedicalPaths().add(medicalPath);
		medicalPath.setSpeciality(this);

		return medicalPath;
	}

	public MedicalPath removeMedicalPath(MedicalPath medicalPath) {
		getMedicalPaths().remove(medicalPath);
		medicalPath.setSpeciality(null);

		return medicalPath;
	}

	public Speciality(String nomSpecialite) {
		super();
		this.nomSpecialite = nomSpecialite;
	}

	@Override
	public String toString() {
		return nomSpecialite;
	}
	

}
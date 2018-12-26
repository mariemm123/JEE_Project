package entity;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Report
 *
 */
@Entity
@Table(name="Reports")
@NamedQuery(name="Report.findAll", query="SELECT p FROM Report p")

public class Report implements Serializable {

	
	private String Description;   
	@Id
	private int ReportId;
	private String photo;
	private static final long serialVersionUID = 1L;

	
	@ManyToOne
	private Appointment appointment;
	
	public Report() {
		super();
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}   
	public int getReportId() {
		return this.ReportId;
	}

	public void setReportId(int ReportId) {
		this.ReportId = ReportId;
	}   
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
   
}

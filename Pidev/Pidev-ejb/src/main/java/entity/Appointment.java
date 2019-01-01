package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the Appointments database table.
 * 
 */
@Entity
@Table(name = "Appointments")
@NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a")
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "AppointmentId")
	private int appointmentId;

	private Date appointementDate;

	private String reason;

	private int state;

	// bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name = "User_Id")
	private AspNetUser aspNetUser1;

	// bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name = "doctor_Id")
	private AspNetUser aspNetUser2;

	// bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name = "patient_Id")
	private AspNetUser aspNetUser3;

	// bi-directional many-to-one association to Report
	@OneToMany(mappedBy = "appointment")
	private List<Report> reports;

	public Appointment() {
	}

	public int getAppointmentId() {
		return this.appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Date getAppointementDate() {
		return this.appointementDate;
	}

	public void setAppointementDate(Date d) {
		this.appointementDate = d;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public AspNetUser getAspNetUser1() {
		return this.aspNetUser1;
	}

	public void setAspNetUser1(AspNetUser aspNetUser1) {
		this.aspNetUser1 = aspNetUser1;
	}

	public AspNetUser getAspNetUser2() {
		return this.aspNetUser2;
	}

	public void setAspNetUser2(AspNetUser aspNetUser2) {
		this.aspNetUser2 = aspNetUser2;
	}

	public AspNetUser getAspNetUser3() {
		return this.aspNetUser3;
	}

	public void setAspNetUser3(AspNetUser aspNetUser3) {
		this.aspNetUser3 = aspNetUser3;
	}

	public List<Report> getReports() {
		return this.reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public Report addReport(Report report) {
		getReports().add(report);
		report.setAppointment(this);

		return report;
	}

	public Report removeReport(Report report) {
		getReports().remove(report);
		report.setAppointment(null);

		return report;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointementDate=" + appointementDate + ", reason="
				+ reason + ", state=" + state + ", aspNetUser1=" + aspNetUser1 + ", aspNetUser2=" + aspNetUser2
				+ ", aspNetUser3=" + aspNetUser3 + ", reports=" + reports + "]";
	}
	

}
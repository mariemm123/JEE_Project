package Service;

import java.util.List;

import javax.ejb.Local;

import entity.Appointment;

@Local
public interface ManagementAppointmentLocal {
	  public void addAppointment(Appointment apt);
	    public Appointment findById(int id);
	    public void updateAppointment(Appointment apt);
	    public void deleteappointment(Appointment apt);

}
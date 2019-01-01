package Service;

import java.text.ParseException;
import java.util.List;

import javax.ejb.Remote;

import entity.Appointment;


@Remote
public interface ManagementAppointmentRemote {
	  public void addAppointment(Appointment apt);
	    public Appointment findById(int id);
	    public void updateAppointment(Appointment apt);
	    public void deleteappointment(Appointment apt);

}

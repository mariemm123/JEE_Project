package Service;

import java.util.List;

import javax.ejb.Remote;

import entity.Appointment;

@Remote
public interface RdvManagementRemote {
	public List<Appointment> getAllRDV();
	
}

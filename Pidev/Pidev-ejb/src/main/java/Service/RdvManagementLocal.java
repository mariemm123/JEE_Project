package Service;

import java.util.List;

import javax.ejb.Local;

import entity.Appointment;


@Local
public interface RdvManagementLocal {
	public List<Appointment> getAllRDV();
	public Appointment getRDV(int id);
}

package managerbean;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Service.RdvManagement;
import entity.Appointment;
import entity.Review;




/**
 * Session Bean implementation class RdvBean
 */
@ManagedBean
@SessionScoped
public class RdvBean {
	private Appointment  RV= new Appointment();
	@EJB
	private RdvManagement RdvManagementLocal;
    /**
     * Default constructor. 
     */
    public RdvBean() {
        // TODO Auto-generated constructor stub
    }
    
    private List<Appointment> Appointments;
    public List<Appointment> displayAllRDV(){
    	Appointments =RdvManagementLocal.getAllRDV();
    	return Appointments;
    }
    
    public  String detailRDV(int id){
    	Appointment Rendez_Vous = RdvManagementLocal.getRDV(id);
    	// return Rendez_Vous; 	
    	 return "/listRV.xhtml?faces-redirect=true";
    }
    
    

    
    
    
    
    public Appointment getRV() {
		return RV;
	}

	public void setRV(Appointment rV) {
		RV = rV;
	}

	public RdvManagement getRdvManagementLocal() {
		return RdvManagementLocal;
	}

	public void setRdvManagementLocal(RdvManagement rdvManagementLocal) {
		RdvManagementLocal = rdvManagementLocal;
	}

	public List<Appointment> getAppointments() {
		return Appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		Appointments = appointments;
	}

	public  String detailredirect(){
    	return "/voyageur.xhtml?faces-redirect=true";
   	  	
   }

}

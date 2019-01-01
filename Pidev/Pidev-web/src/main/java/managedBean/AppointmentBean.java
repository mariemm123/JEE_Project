package managedBean;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.jws.WebService;
import javax.swing.JSpinner.ListEditor;

import entity.Appointment;
import entity.AspNetUser;
import entity.Disponibility;
import entity.Imc;
import entity.Img;
import patientServices.WebServiceClient;
import Service.ManagementAppointmentLocal;


@ManagedBean
@ApplicationScoped
public class AppointmentBean {
	
	//imc img public static intitialization
	
    public static Img ImgToShow =new Img();
    
    public static String recomandation= "";
	public static String Commentaire="";
   // presonal declaration 
	public static List <Imc> ListImc=new ArrayList<>();
	public static List<AspNetUser> ListPatient =new ArrayList();
	public static Imc imc= new Imc();
	
	
	
	
private List<AspNetUser>ListDoctors=new ArrayList();
private Appointment appointment=new Appointment();
private List<Appointment> ListAppointment= new ArrayList<>();
private AspNetUser SelectedDoctor= new AspNetUser();
private List<Disponibility> Disponibilities= new ArrayList<>();
private String appointmentDescription;
private Appointment aptToEdit=new Appointment();
@EJB
private ManagementAppointmentLocal AppointmentManagementLocal;
@PostConstruct
public void init(){
	System.out.println("dlkesdclq,");
	ListAppointment = new ArrayList<>();
	WebServiceClient WSC=new WebServiceClient();
try {
	ListAppointment=WSC.getAllAppointments();
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
//listdoctors
try {
	ListDoctors= WSC.getAllUsers();
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
	Disponibilities=WSC.getAllDisponibilities();
	for (Disponibility disponibility : Disponibilities) {
		for (AspNetUser doctor : ListDoctors) {
			if (disponibility.getAspNetUser().getId().equals(doctor.getId()))
			{disponibility.setAspNetUser(doctor);}
		}
	}
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}
public AppointmentBean() {
	ListAppointment = new ArrayList<>();
}
public Appointment getAppointment() {
	return appointment;
}
public void setAppointment(Appointment appointment) {
	this.appointment = appointment;
}
public List<Appointment> getListAppointment() {
	//For Connected user 
	try {WebServiceClient wsc=new WebServiceClient();
		ListAppointment=wsc.getAllAppointments();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//listdoctors
	return  ListAppointment;
}
public void setListAppointment(List<Appointment> listAppointment) {
	ListAppointment = listAppointment;
}
public List<AspNetUser> getListDoctors() {
	return ListDoctors;
}
public void setListDoctors(List<AspNetUser> listDoctors) {
	ListDoctors = listDoctors;
}
//GoToDisponibilities
public String GoToDisponibilities(AspNetUser Doctor) {
	SelectedDoctor=Doctor;
	//FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	
	return "AddPatientAppointmentDisponibility?faces-redirect=true";

}
//doAddAppointment(dis)
public String doAddAppointment(Disponibility dis) {
	System.out.println("dlkesdclq,");
		System.err.println("aa"+SelectedDoctor);
	System.err.println("bb"+dis);
	System.err.println("aaaa"+"malek");
	//FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	Appointment apt= new Appointment();
	apt.setAppointementDate(dis.getStartTimeOfDisponibility());
	apt.setReason("malek");
	apt.setState(0);
	//Connected Users
	apt.setAspNetUser2(SelectedDoctor);
	apt.setAspNetUser3(SelectedDoctor);
	AppointmentManagementLocal.addAppointment(apt);
	return "PatientAppointements?faces-redirect=true";

}
public AspNetUser getSelectedDoctor() {
	return SelectedDoctor;
}
//doRemoveAppointment
public String doRemoveAppointment(Appointment apt) {
	AppointmentManagementLocal.deleteappointment(apt);
	return "PatientAppointements?faces-redirect=true";
}
//doUpdateAppointment
public String doUpdateAppointment(Disponibility dis) {
	aptToEdit.setAppointementDate(dis.getStartTimeOfDisponibility());
	aptToEdit.setReason("samir");
	AppointmentManagementLocal.updateAppointment(aptToEdit);
	return "PatientAppointements?faces-redirect=true";

}
//redirectToEdit Form
public String toUpdateAppointment(Appointment apt) {
	aptToEdit=apt;
	return "UpdatePatientAppointmentDisponibility?faces-redirect=true";

}
public void setSelectedDoctor(AspNetUser selectedDoctor) {
	SelectedDoctor = selectedDoctor;
}
public List<Disponibility> getDisponibilities() {
	//for selected doctor
	return Disponibilities;
}
public void setDisponibilities(List<Disponibility> disponibilities) {
	Disponibilities = disponibilities;
}
public String getAppointmentDescription() {
	return appointmentDescription;
}
public void setAppointmentDescription(String appointmentDescription) {
	this.appointmentDescription = appointmentDescription;
}
public Appointment getAptToEdit() {
	return aptToEdit;
}
public void setAptToEdit(Appointment aptToEdit) {
	this.aptToEdit = aptToEdit;
}
public  Img getImgToShow() {
	return ImgToShow;
}
public  void setImgToShow(Img imgToShow) {
	ImgToShow = imgToShow;
}
public  String getRecomandation() {
	return recomandation;
}
public void setRecomandation(String recomandation) {
	AppointmentBean.recomandation = recomandation;
}
public  String getCommentaire() {
	return Commentaire;
}
public  void setCommentaire(String commentaire) {
	Commentaire = commentaire;
}
public List<Imc> getListImc() {
	return ListImc;
}
public  void setListImc(List<Imc> listImc) {
	ListImc = listImc;
}
public  Imc getImc() {
	return imc;
}
public  void setImc(Imc imc) {
	AppointmentBean.imc = imc;
}


}

package managerbean;

import java.sql.Date;
import java.text.SimpleDateFormat;


import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

//import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
public class CalendarView {

 

      
   
    private java.util.Date date3;
   
     
    public CalendarView() {
		super();
	}

	public java.util.Date getDate3() {
		return date3;
	}

	public void setDate3(java.util.Date date3) {
		this.date3 = date3;
	}

	

	/*public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }*/
     
   /* public void click() {
        PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }*/
 
   
 
   
 
   
 
   
}
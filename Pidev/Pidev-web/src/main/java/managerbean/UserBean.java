package managerbean;

import java.util.List;

import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Service.UserManagementLocal;
import entity.AspNetUser;


@ManagedBean
@SessionScoped

public class UserBean {
	private boolean isLogged = false;
	private Boolean loggedInAsUser = false;
private AspNetUser user= new AspNetUser();
@EJB
private Service.UserManagementLocal userManagementLocal;


public String doAdd(){
	userManagementLocal.addUser(user);
	return "/EspacePatient.xhtml?faces-redirect=true";
}



public List<AspNetUser> getUsers() {
	return Users;
}



public void setUsers(List<AspNetUser> users) {
	Users = users;
}



private List<AspNetUser> Users;
public List<AspNetUser> displayAll(){
	Users =userManagementLocal.getAllUsers();
	return Users;
}



public String logout() {
	isLogged = false;
	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	return "/Welecom?faces-redirect=true";
}
public String doLogin(){


	String navigateTo = "";
	AspNetUser userLoggedIn = userManagementLocal.login(user.getEmail(), user.getPasswordHash());
	if (userLoggedIn != null) {
		isLogged = true;
		user = userLoggedIn;
	/*	if (userLoggedIn instanceof Voyageur) {
			navigateTo = "voyageur.xhtml?faces-redirect=true";
		} else if (userLoggedIn instanceof Staff) {
			navigateTo = "staff.xhtml?faces-redirect=true";
		} else {
			loggedInAsUser = true;
			navigateTo = "user.xhtml?faces-redirect=true";
		}*/
	} else {
		System.err.println("not");
	}
	//return navigateTo;
	 return"EspacePatient.xhtml?faces-redirect=true" ;
	
	
	
	

// return"welcome.xhtml?faces-redirect=true" ;  
}


public boolean isLogged() {
	return isLogged;
}
public void setLogged(boolean isLogged) {
	this.isLogged = isLogged;
}
public Boolean getLoggedInAsUser() {
	return loggedInAsUser;
}
public void setLoggedInAsUser(Boolean loggedInAsUser) {
	this.loggedInAsUser = loggedInAsUser;
}
public UserManagementLocal getUserManagementLocal() {
	return userManagementLocal;
}
public void setUserManagementLocal(UserManagementLocal userManagementLocal) {
	this.userManagementLocal = userManagementLocal;
}
public AspNetUser getUser() {
	return user;
}
public void setUser(AspNetUser user) {
	this.user = user;
}
}

package Service;

import java.util.List;

import javax.ejb.Local;

import entity.AspNetUser;


@Local
public interface UserManagementLocal {

	public AspNetUser login(String email, String passwordHash);

	List<AspNetUser> getAllUsers();
	  public void addUser(AspNetUser user);



}

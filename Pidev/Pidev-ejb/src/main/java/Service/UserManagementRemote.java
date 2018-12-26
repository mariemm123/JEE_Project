package Service;

import java.util.List;

import javax.ejb.Remote;

import entity.AspNetUser;



@Remote
public interface UserManagementRemote {

	public AspNetUser login(String email, String passwordHash);

	List<AspNetUser> getAllUsers();
	  public void addUser(AspNetUser user);
	  
}

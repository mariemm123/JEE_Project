package Test;

import java.sql.Timestamp;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import Service.MedicalPathServiceRemote;
import entity.MedicalPath;
import entity.Speciality;



public class MedicalPathService {
	public static void main(String[] args) throws NamingException {
		
		
		MedicalPath m=new MedicalPath(new Timestamp(2),"medPathamine5");
		
		//Context context=new InitialContext();
		InitialContext context = new InitialContext();

	


	String jndiName="Pidev-ear/Pidev-ejb/MedicalPathService!Service.MedicalPathServiceRemote";
	MedicalPathServiceRemote proxy=(MedicalPathServiceRemote)context.lookup(jndiName);
	proxy.addMedicalPath(m,2);


	System.out.println("fffffffffffffffffff");
	
}
}

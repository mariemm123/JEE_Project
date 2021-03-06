package Service;

import java.io.IOException;
import java.util.List;

import javax.ejb.Remote;

import entity.MedicalPath;
import entity.ProposedDoc;
import entity.Speciality;
import entity.Treatement;

@Remote
public interface MedicalPathServiceRemote {
	  public void addMedicalPath(MedicalPath m , int SpecId) ;
	  public List<MedicalPath> getAllMedicalPath();
	    public void addSpeciality(Speciality sp);
		   public List<Speciality>  ListSpeciality() ;
		   public String getSpecById(int id ) ;
		public	List<ProposedDoc> DocProposed();
	   //public void deletMedicalPath(int MedicalPathid);
	    public void addtetement(Treatement t ) ;
	    
	    public void deleteMedicalPathid(int id);
	   // public void removetretbyid(int id);
	    public void removetretbyid(Treatement t);

	     public void updateTretement(Treatement t);
	   
}

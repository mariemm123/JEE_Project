package Service;

import java.io.IOException;
import java.util.List;

import javax.ejb.Local;

import entity.MedicalPath;
import entity.ProposedDoc;
import entity.Speciality;
import entity.Treatement;

@Local
public interface MedicalPathServiceLocal {
	  public void addMedicalPath(MedicalPath m , int SpecId) ;
	  public List<MedicalPath> getAllMedicalPath();
	    public void addSpeciality(Speciality sp);
		   public List<Speciality>  ListSpeciality() ;
		   public String getSpecById(int id ) ;
	public	List<ProposedDoc> DocProposed();
    //public void deletMedicalPath(int MedicalPathid);
    public void addtetement(Treatement t ) ;
 
   public void deleteMedicalPathid(int id);

   public void removetretbyid(Treatement t);
   public void updateTretement(Treatement t);
}
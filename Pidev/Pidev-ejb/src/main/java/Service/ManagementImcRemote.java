package Service;

import java.util.List;

import javax.ejb.Remote;

import entity.Imc;

@Remote
public interface ManagementImcRemote {
	 public void addImc(Imc imc);
	    public Imc findById(int id);
	    public List <Imc> findByAll();
}

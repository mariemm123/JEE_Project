package Service;

import java.util.List;

import javax.ejb.Local;


import entity.Imc;

@Local
public interface ManagementImcLocal {
	 public void addImc(Imc imc);
	    public Imc findById(int id);
	    public List <Imc> findByAll();
}

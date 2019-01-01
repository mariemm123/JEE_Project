package Service;

import java.util.List;

import javax.ejb.Local;
import entity.Img;
@Local
public interface ManagementImgLocal {
	 public void addImg(Img img);
	    public Img findById(int id);
	    public List <Img> findByAll();
}

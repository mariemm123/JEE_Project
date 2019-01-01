package Service;

import java.util.List;

import javax.ejb.Remote;

import entity.Img;

@Remote
public interface ManagementImgRemote {
	 public void addImg(Img img);
	    public Img findById(int id);
	    public List <Img> findByAll();
}

package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Img;

/**
 * Session Bean implementation class ManagementImg
 */
@Stateless
@LocalBean
public class ManagementImg implements ManagementImgRemote, ManagementImgLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public ManagementImg() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addImg(Img img) {
		// TODO Auto-generated method stub
		em.persist(img);
	}

	@Override
	public Img findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Img.class, id);
	}

	@Override
	public List<Img> findByAll() {
		Query query=em.createQuery("select e from Img e");
		return query.getResultList();	}

}

package Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import WebService.clientamine;
import entity.MedicalPath;
import entity.ProposedDoc;
import entity.Speciality;




@Stateless
@LocalBean
public  class MedicalPathService implements MedicalPathServiceRemote, MedicalPathServiceLocal {

  
	@PersistenceContext
	EntityManager em;
    public MedicalPathService() {
    
    }
    
    
    public void addSpeciality(Speciality sp)
    {
    em.persist(sp);	
    	
    	
    
    }
    public void addMedicalPath(MedicalPath m , int SpecId) 
    {
		Speciality sp = em.find(Speciality.class, SpecId) ;
		m.setSpeciality(sp);
		em.persist(m);
	} 
	public List<MedicalPath> getAllMedicalPath() 
	{System.out.println("ok");
	 TypedQuery<MedicalPath> query= em.createNamedQuery("MedicalPath.findAll", MedicalPath.class);
	 
	
    	System.out.println("ok2");
		return query.getResultList();
	
	}
	   public List<Speciality>  ListSpeciality() 
	    {
	    	  
	        	Query query=em.createQuery("select a from Speciality a");
	    		List<Speciality> liste= query.getResultList();
	    		
	    
			return liste;
		}


	@Override
	public String getSpecById(int id) {
		if(id>0)
		return em.find(Speciality.class, id).getNomSpecialite();
		else {
			return null ;
		}
	} 
	
	@Override
	public List<ProposedDoc> DocProposed()
	{try {
		List<ProposedDoc> listP = new ArrayList<ProposedDoc>();
		/*String spec = mdpselo.getSpecById(id);
		String url ="https://www.doctolib.fr/"+spec;*/
		String url ="https://www.doctolib.fr/vertige";
		Document doc;
		
			doc = Jsoup.connect(url).userAgent("Opera").get();

		Elements elements=doc.getElementsByClass("dl-search-result-presentation");
		System.out.println("jjjj");
		for (Element e : elements)
		{
			String name = e.select(".dl-search-result-name").text();
			String speciality = e.select(".dl-search-result-subtitle").text();
			String adresse = e.select("div.dl-search-result-content > div.dl-text.dl-text-body").text() ;

			ProposedDoc pd = new ProposedDoc();
			pd.setAdresse(adresse);pd.setNom(name); pd.setSpecialite(speciality);
			listP.add(pd);
			System.out.println("naùe : " + name + " and speciality : "+speciality +" and Adress : "+adresse);
		}
		return listP ;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null ;
		}
	}


	
	
	
	
	
	
	

}


package managerbean;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import entity.Speciality;
import entity.Treatement;

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

import Service.MedicalPathServiceLocal;
import WebService.clientamine;
import entity.AspNetUser;
import entity.MedicalPath;
import entity.ProposedDoc;


@ManagedBean(name="mp")
@ViewScoped
public class MedicalPathBean {
	
	private int idtretement;

	private Treatement treatement=new Treatement(); 
	

	private Date dateTretement;
	private String Dsec;
	
	private String duréeTretement;
	
	private Boolean validation;
	
	
	
	
	private String description; 
	private Date dateParcour; 
	private String nomdoc;
	private String spec;  
    private List<Speciality> specs;
   private List<MedicalPath> pls;
   
   private int MedicalPathid;
   private List<MedicalPath> Lismppppp;
   private List<AspNetUser>  listpatients;
    private int id ;
 
    private ProposedDoc pro ;

	@EJB
	private MedicalPathServiceLocal mdpselo;
	
	public Treatement getTreatement() {
		return treatement;
	}


	public void setTreatement(Treatement treatement) {
		this.treatement = treatement;
	}

	public int getIdtretement() {
		return idtretement;
	}


	public void setIdtretement(int idtretement) {
		this.idtretement = idtretement;
	}


	public MedicalPathServiceLocal getMdpselo() {
		return mdpselo;
	}


	public void setMdpselo(MedicalPathServiceLocal mdpselo) {
		this.mdpselo = mdpselo;
	}


	
	
	
	
	
	
	public String doAdd()
	{
		mdpselo.addMedicalPath(new MedicalPath(dateParcour,nomdoc,description),id);
		
		return "addmedpath.xhtml?faces-redirect=true";
		
	
	}
	
	
	public void addTretement()
	{
		mdpselo.addtetement(new Treatement(dateTretement,Dsec,duréeTretement,validation));
	}

	
	public String mettreAjourTreatement()
	{
		
		mdpselo.updateTretement(new Treatement(dateTretement,Dsec,duréeTretement,validation));
		return "AfficherListTretement?faces-redirect=true";
	}
	
	
	//doUpdateAppointment c bn mriguela 
	
	public String modifier(Treatement t)
	{
	/*	this.setDateTretement(t.getDateTretement());
		this.setDsec(t.getDescription());
		this.setDuréeTretement(t.getDuréeTretement());
		this.setValidation(t.getValidation());
        this.setIdtretement(t.getTreatementId());*/
		
		dateTretement=t.getDateTretement();
		Dsec=t.getDescription();
		duréeTretement=t.getDuréeTretement();
		validation=t.getValidation();
		idtretement=t.getTreatementId();
		//login=user.getLogin();
		// password=user.getPassword();
		// userIdToBeUpdated=user.getId();
	
        return "UpdateTretement?faces-redirect=true";
	}
	
	public MedicalPathBean()
	{
		
	}
	
	/**/
	  public void removeMedicalPath (int MedicalPathid)
    {
    	mdpselo.deleteMedicalPathid(MedicalPathid);
    }
	  public void removetertbyid (Treatement t)
	    {
	    	mdpselo.removetretbyid(t);
	    }



	public List<Speciality> ListSpeciality()
	{
		
		List<Speciality> Specialitys=mdpselo.ListSpeciality();
	
               return Specialitys;
	}

	public void onChange()
	{
		System.out.println("changes");
	}

	public List<ProposedDoc> doProposed()
	{
		return DocProposed();
	}
	public List<ProposedDoc> DocProposed()
	{
		//if(mdpselo.getSpecById(id)!=null){
		try {
		List<ProposedDoc> listP = new ArrayList<ProposedDoc>();
		
		String spec = mdpselo.getSpecById(id);
		String url ="https://www.doctolib.fr/"+spec;
		//String url ="https://www.doctolib.fr/vertige";
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
		//}
		}
		//else return null ;
	}





@PostConstruct
	    public void init() throws IOException {
		
	
	List<MedicalPath> list = new ArrayList<MedicalPath>();
	Type listType = new TypeToken<ArrayList<MedicalPath>>(){}.getType();
	
	
	String webPage = "http://localhost:54774/api/mdp";

    String data = Jsoup.connect(webPage).ignoreContentType(true).execute().body();
    
    System.out.println(data);
    
    Gson gson = new Gson();
    Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
    

    ArrayList<MedicalPath> pls = g.fromJson(data, listType);
    System.out.println(pls);
	        
 

	    }



	
  public List<MedicalPath> Lismppppp() throws IOException
{
	
	
List<MedicalPath> list = new ArrayList<MedicalPath>();
Type listType = new TypeToken<ArrayList<MedicalPath>>(){}.getType();


String webPage = "http://localhost:54774/api/mdp";

String data = Jsoup.connect(webPage).ignoreContentType(true).execute().body();

System.out.println(data);

Gson gson = new Gson();
Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

// Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
//Date date=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(string);
//mp.setDateParcour(date);




//list=gson.fromJson(data, new TypeToken<List<MedicalPath>>(){}.getType());
//
//System.out.println(list);



List<MedicalPath> pls = g.fromJson(data, listType);
System.out.println(pls);
        
  return pls;

    }


	
  public List<AspNetUser> listpatients() throws IOException
  {
		
	 // List<AspNetUser> listpatient = new ArrayList<AspNetUser>();
	  Type listType = new TypeToken<ArrayList<AspNetUser>>(){}.getType();


	  String webPage = "http://localhost:54774/api/patient";

	  String data = Jsoup.connect(webPage).ignoreContentType(true).execute().body();

	  System.out.println(data);

	  Gson gson = new Gson();
	  Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

	  // Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
	  //Date date=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(string);
	  //mp.setDateParcour(date);




	  List<AspNetUser>  listpatients=gson.fromJson(data, new TypeToken<List<AspNetUser>>(){}.getType());
	  //
	  //System.out.println(list);



	  //List<AspNetUser> lip = g.fromJson(data, listType);
	  System.out.println(listpatients);
	          
	    return listpatients; 
	  
	  
	  
  }
	
  
  public List<Treatement> ListTretments() throws IOException
{
	
	
List<Treatement> list = new ArrayList<Treatement>();
Type listType = new TypeToken<ArrayList<Treatement>>(){}.getType();


String webPage = "http://localhost:54774/api/tretements";

String data = Jsoup.connect(webPage).ignoreContentType(true).execute().body();

System.out.println(data);




Gson gson = new Gson();
Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

// Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
//Date date=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(string);
//mp.setDateParcour(date);




//list=gson.fromJson(data, new TypeToken<List<MedicalPath>>(){}.getType());
//
//System.out.println(list);



		List<Treatement> listTretement = g.fromJson(data, listType);
	
		System.out.println(pls);
		return listTretement;
    }
  
  

	public Date getDateTretement() {
	return dateTretement;
}


public void setDateTretement(Date dateTretement) {
	this.dateTretement = dateTretement;
}


public String getDsec() {
	return Dsec;
}


public void setDsec(String dsec) {
	Dsec = dsec;
}


public String getDuréeTretement() {
	return duréeTretement;
}


public void setDuréeTretement(String duréeTretement) {
	this.duréeTretement = duréeTretement;
}


public Boolean getValidation() {
	return validation;
}


public void setValidation(Boolean validation) {
	this.validation = validation;
}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public List<Speciality> getSpecs() {
		return specs;
	}

	public void setSpecs(List<Speciality> specs) {
		this.specs = specs;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateParcour() {
		return dateParcour;
	}
	public void setDateParcour(Date dateParcour) {
		this.dateParcour = dateParcour;
	}
	public ProposedDoc getPro() {
		return pro;
	}
	public void setPro(ProposedDoc pro) {
		this.pro = pro;
	}
	public String getNomdoc() {
		return nomdoc;
	}
	public void setNomdoc(String nomdoc) {
		this.nomdoc = nomdoc;
	}


	public List<MedicalPath> getPls() {
		return pls;
	}


	public void setPls(List<MedicalPath> pls) {
		this.pls = pls;
	}


	public List<MedicalPath> getLismppppp() {
		return Lismppppp;
	}


	public void setLismppppp(List<MedicalPath> lismppppp) {
		Lismppppp = lismppppp;
	}


	public List<AspNetUser> getListpatients() {
		return listpatients;
	}


	public void setListpatients(List<AspNetUser> listpatients) {
		this.listpatients = listpatients;
	}
	public int getMedicalPathid() {
		return MedicalPathid;
	}
	public void setMedicalPathid(int medicalPathid) {
		MedicalPathid = medicalPathid;
	}


	public String GotoPageListeTraitement()
	{
		
		return "AfficherListTretement?faces-redirect=true";
	}
	public String GotoPageListeMedicalPath()
	{
		
		return "AffichageMediPath?faces-redirect=true";
	}
	public String GotoPageAddMedicalPath()
	{
		
		return "AjouterMedicalPathwithtemp?faces-redirect=true";
	}
	public String GotoPageAddTraitement()
	{
		
		return "AddTreatement?faces-redirect=true";
	}
	public String Gotolistpatient()
	{
		
		return "AfficherListPatient?faces-redirect=true";
	}
}
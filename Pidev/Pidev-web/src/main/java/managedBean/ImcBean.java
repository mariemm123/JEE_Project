package managedBean;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.OptionalDouble;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import entity.Appointment;
import entity.AspNetUser;
import entity.Imc;
import entity.Img;
import patientServices.WebServiceClient;
import Service.ManagementAppointmentLocal;
import Service.ManagementImcLocal;
import Service.ManagementImgLocal;

@ManagedBean
@ViewScoped
public class ImcBean {
	//chart declaration 
	
	private LineChartModel lineModel1;
	private LineChartModel lineModel2;
    private LineChartModel lineModel3;
    private LineChartModel zoomModel;
	private OptionalDouble moyenneimg;
	private float minimg;
	private float maximg;
	private float moyenneimc;
	private float minimc;
	private float maximc;
    private Img imgg= new Img();
    private int sexe=0;
    private float age=0;
/*    public static Img ImgToShow =new Img();
    public static List<Img> ListImg=new ArrayList();
    public static String recomandation= "";
	public static String Commentaire="";
   // presonal declaration 
	public static List <Imc> ListImc=new ArrayList<>();
	public static List<AspNetUser> ListPatient =new ArrayList();
	public static Imc imc= new Imc();*/
    private   List<Img> ListImg=new ArrayList();
	private String insuffisance_ponderale="Votre poids apparaît trop faible par rapport à votre taille. Ce faible indice de masse corporel (IMC) est peut-être la conséquence d'une pathologie, mais elle-même peut exposer à un certain nombre de risques pour votre santé (carences, anémie, ostéoporose...). Parlez-en avec votre médecin traitant. Il pourra rechercher la cause de cette maigreur et vous conseiller.";
	 private String poids_normal="Votre poids est adapté à votre taille. Gardez vos habitudes alimentaires pour conserver un indice de masse corporel (IMC) idéal et un poids qui vous assure un état de santé optimal. Une alimentation équilibrée, sans excès de matières grasses, associée à une activité physique régulière vous aideront à maintenir votre poids idéal.";
	 private String surpoids="Votre poids commence à devenir élevé par rapport à votre taille. A long terme, un indice de masse corporel (IMC) élevé a des conséquences sur la santé. L'excès de poids entraîne un risque accru de maladies métaboliques (diabète), cardiaques, respiratoires, articulaires et de cancer. Si vous souhaitez commencer un régime pour perdre du poids, parlez-en au préalable avec votre médecin traitant.";
	private String obesite="Votre poids est trop élevé par rapport à votre taille. Du point de vue médical, l'obésité est un excès de masse grasse ayant des conséquences sur la santé. L'excès de poids entraîne un risque accru de maladies métaboliques (diabète), cardiaques, respiratoires, articulaires et de cancer. Si vous souhaitez commencer un régime pour perdre du poids, parlez-en au préalable avec votre médecin traitant. A noter que la sévérité de l'obésité dépend de l'indice de masse corporelle (IMC) : elle est dite 'modérée' pour un IMC compris entre 30 et 34,9, 'sévère' lorsque l'IMC est compris entre 35 et 39,9 et 'massive' pour un IMC au-dessus de 40.";
	private String com1= "insuffisance pondérale";
	private String com2="poids normal";
	private String com3="surpoids";
	private String com4="obésité";
	private  Imc imc= new Imc();
	//IMG
	 
	@EJB
	private ManagementImcLocal ManagementImcLocal;
	@EJB
 private ManagementImgLocal ManagementImgLocal; 
	public ImcBean() {
		
	}
	@PostConstruct
	void init(){
		
	//chart init
		createLineModels();
     
	
		//presonnal init
		imc=new Imc();
		WebServiceClient WSC=new WebServiceClient();
		try {
			AppointmentBean.ListPatient= WSC.getAllUsers();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("mm"+AppointmentBean.ListPatient);
		AppointmentBean.ListImc= ManagementImcLocal.findByAll();
		for (Imc imc : AppointmentBean.ListImc) {
			imc.setImcValue(imc.getWeight()/(imc.getHeight()*imc.getHeight()));
}       System.out.println("3imed");
		ListImg=ManagementImgLocal.findByAll();
		
		 
		// min max avg IMG
		Comparator<Img> comparator = Comparator.comparing( Img::getImgValue);
		Img minImg = ListImg.stream().min(comparator).get();
		minimg=minImg.getImgValue();
		Img maxImg = ListImg.stream().max(comparator).get();
		maximg=maxImg.getImgValue();
		 moyenneimg = ListImg.stream().mapToDouble(Img::getImgValue).average();
		System.out.println("lobna"+ListImg);
	}
	//ToImc
	public String ToImc() {
		//ConnectedPatient
				return "Imc?faces-redirect=true";
	}
	//doAddImc()
	public String doAddImc() {
		System.out.println("mm"+AppointmentBean.ListPatient);
		//ConnectedPatient
		AppointmentBean.imc=new Imc();
		AppointmentBean.imc.setHeight(this.imc.getHeight());
		AppointmentBean.imc.setWeight(this.imc.getWeight());
		AppointmentBean.imc.setAspNetUser(AppointmentBean.ListPatient.get(0));
		AppointmentBean.imc.setImcDate(new Date());
		ManagementImcLocal.addImc(AppointmentBean.imc);
		
	
		AppointmentBean.imc.setImcValue(AppointmentBean.imc.getWeight()/(AppointmentBean.imc.getHeight()*AppointmentBean.imc.getHeight()));
		System.out.println("kkk"+AppointmentBean.imc.getImcValue());
		if (AppointmentBean.imc.getImcValue()<18.5){
			AppointmentBean.recomandation=insuffisance_ponderale;
			AppointmentBean.Commentaire=com1;
		}else if ((AppointmentBean.imc.getImcValue()<24.9)&&(18.5<=AppointmentBean.imc.getImcValue())){
			AppointmentBean.recomandation=poids_normal;
			AppointmentBean.Commentaire=com2;
		}else if ((AppointmentBean.imc.getImcValue()<29.9)&&(25<=AppointmentBean.imc.getImcValue())){
			AppointmentBean.recomandation=surpoids;
			AppointmentBean.Commentaire=com3;
		}else if (AppointmentBean.imc.getImcValue()>=30){
			AppointmentBean.recomandation=obesite;
			AppointmentBean.Commentaire=com4;
		}
		System.out.println("faouzi"+AppointmentBean.Commentaire+AppointmentBean.recomandation+AppointmentBean.imc);
		return "ImcAdvices?faces-redirect=true";
	}
	public List<Imc> getListImc() {
		return AppointmentBean.ListImc;
	}
	public void setListImc(List<Imc> listImc) {
		AppointmentBean.ListImc = listImc;
	}
	public Imc getImc() {
		return imc;
	}
	public void setImc(Imc imc) {
		this.imc = imc;
	}
	public String getInsuffisance_pondérale() {
		return insuffisance_ponderale;
	}
	public void setInsuffisance_pondérale(String insuffisance_ponderale) {
		this.insuffisance_ponderale = insuffisance_ponderale;
	}
	public String getPoids_normal() {
		return poids_normal;
	}
	public void setPoids_normal(String poids_normal) {
		this.poids_normal = poids_normal;
	}
	public String getSurpoids() {
		return surpoids;
	}
	public void setSurpoids(String surpoids) {
		this.surpoids = surpoids;
	}
	public String getObésité() {
		return obesite;
	}
	public void setObésité(String obesite) {
		this.obesite = obesite;
	}
	public String getInsuffisance_ponderale() {
		return insuffisance_ponderale;
	}
	public void setInsuffisance_ponderale(String insuffisance_ponderale) {
		this.insuffisance_ponderale = insuffisance_ponderale;
	}
	public String getObesite() {
		return obesite;
	}
	public void setObesite(String obesite) {
		this.obesite = obesite;
	}
	public String getCom1() {
		return com1;
	}
	public void setCom1(String com1) {
		this.com1 = com1;
	}
	public String getCom2() {
		return com2;
	}
	public void setCom2(String com2) {
		this.com2 = com2;
	}
	public String getCom3() {
		return com3;
	}
	public void setCom3(String com3) {
		this.com3 = com3;
	}
	public String getCom4() {
		return com4;
	}
	public void setCom4(String com4) {
		this.com4 = com4;
	}
	public String getRecomandation() {
		return AppointmentBean.recomandation;
	}
	public void setRecomandation(String recomandation) {
	}
	public String getCommentaire() {
		return AppointmentBean.Commentaire;
	}
	public void setCommentaire(String commentaire) {
		AppointmentBean.Commentaire = commentaire;
	}
	
	
	
	public LineChartModel getLineModel3() {
		return lineModel3;
	}
	public void setLineModel3(LineChartModel lineModel3) {
		this.lineModel3 = lineModel3;
	}
	public LineChartModel getZoomModel() {
		return zoomModel;
	}
	public void setZoomModel(LineChartModel zoomModel) {
		this.zoomModel = zoomModel;
	}
	public void setLineModel1(LineChartModel lineModel1) {
		this.lineModel1 = lineModel1;
	}
	public void setLineModel2(LineChartModel lineModel2) {
		this.lineModel2 = lineModel2;
	}
	//chart methods 
	public LineChartModel getLineModel1() {
        return lineModel1;
    }
 
    public LineChartModel getLineModel2() {
        return lineModel2;
    }
 
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Poids");
 int compteur =0;
    	for (Imc imc : AppointmentBean.ListImc) {
    		compteur=compteur+1;
    		System.out.println("samir"+imc);
    		 series1.set(compteur,imc.getWeight());
}
       
       
 

      
 
        model.addSeries(series1);
       
 
        return model;
    }
    private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();
 
        
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Taille");
 int compteur=0;
    	for (Imc imc : AppointmentBean.ListImc) {
    		compteur=compteur+1;
   		 series2.set(compteur,imc.getHeight() );
}
        model.addSeries(series2);
 
        return model;
    }
    private LineChartModel initCategoryModel1() {
        LineChartModel model = new LineChartModel();
 
        
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("IMC");
 int compteur=0;
    	for (Imc imc :AppointmentBean.ListImc) {
    		compteur=compteur+1;
   		 series2.set(compteur,imc.getImcValue() );
}
        model.addSeries(series2);
 
        return model;
    }
 
    private void createLineModels() {
        lineModel1 = initLinearModel();
        lineModel1.setTitle("Evolution de la Taille");
        lineModel1.setLegendPosition("e");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setLabel("Taille");
        yAxis.setMin(0);
        yAxis.setMax(200);
        Axis xAxis = lineModel1.getAxis(AxisType.X);
        xAxis.setLabel("N° de prise de mesure");
        xAxis.setMin(0);
        xAxis.setMax(20);
 
        lineModel2 = initCategoryModel();
        lineModel2.setTitle("Evolution du Poids");
        lineModel2.setLegendPosition("e");
        Axis yAxiss = lineModel2.getAxis(AxisType.Y);
        yAxiss.setLabel("Poids");
        yAxiss.setMin(0);
        yAxiss.setMax(200);
        Axis xAxiss = lineModel2.getAxis(AxisType.X);
        xAxiss.setLabel("N° de prise de mesure");
        xAxiss.setMin(0);
        xAxiss.setMax(20);
        
        lineModel3 = initCategoryModel1();
        lineModel3.setTitle("Evolution de l'Imc");
        lineModel3.setLegendPosition("e");
        Axis yAxisss = lineModel3.getAxis(AxisType.Y);
        yAxisss.setLabel("Valeur de IMC");
        yAxisss.setMin(0);
        yAxisss.setMax(200);
        Axis xAxisss = lineModel3.getAxis(AxisType.X);
        xAxisss.setLabel("N° de prise de mesure");
        xAxisss.setMin(0);
        xAxisss.setMax(20);
        
        zoomModel = initLinearModel();
        zoomModel.setTitle("Zoom");
        zoomModel.setZoom(true);
        zoomModel.setLegendPosition("e");
        yAxis = zoomModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
        
 
     
    }
	
    
    
    ////////////img
    

	public int getSexe() {
	return sexe;
}
public void setSexe(int sexe) {
	this.sexe = sexe;
}
public float getAge() {
	return age;
}
public void setAge(float age) {
	this.age = age;
}
	
public List<Img> getListImg() {
		return this.ListImg;
	}
	public void setListImg(List<Img> listImg) {
	this.ListImg = listImg;
	}
public  Img getImgToShow() {
		return AppointmentBean.ImgToShow;
	}
	public void setImgToShow(Img imgToShow) {
		AppointmentBean.ImgToShow = imgToShow;
	}

public OptionalDouble getMoyenneimg() {
		return moyenneimg;
	}
	public void setMoyenneimg(OptionalDouble moyenneimg) {
		this.moyenneimg = moyenneimg;
	}
	public float getMinimg() {
		return minimg;
	}
	public void setMinimg(float minimg) {
		this.minimg = minimg;
	}
	public float getMaximg() {
		return maximg;
	}
	public void setMaximg(float maximg) {
		this.maximg = maximg;
	}
	public float getMoyenneimc() {
		return moyenneimc;
	}
	public void setMoyenneimc(float moyenneimc) {
		this.moyenneimc = moyenneimc;
	}
	public float getMinimc() {
		return minimc;
	}
	public void setMinimc(float minimc) {
		this.minimc = minimc;
	}
	public float getMaximc() {
		return maximc;
	}
	public void setMaximc(float maximc) {
		this.maximc = maximc;
	}
public String toImgAdvice(){
	//IMG (%) = (1.46∗IMC) + (0.14∗Age) − (11.6∗Sexe) − 10.0
	imgg.setImgValue((float) ((1.46*AppointmentBean.imc.getImcValue())+(0.14*age)-(11.6*sexe)-10.0));
	imgg.setImcDate(new Date());
	imgg.setAspNetUser(AppointmentBean.ListPatient.get(0));
	AppointmentBean.ImgToShow=imgg;
	ManagementImgLocal.addImg(imgg);
	return  "ImgAdvices?faces-redirect=true";
   }
    
    
    
    
}

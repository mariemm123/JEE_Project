package parse;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import entity.MedicalPath;

public abstract class TestGsoup {

	public static void main(String[] args) throws IOException {
	
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
	    
	    
	    
	    
//    list=gson.fromJson(data, new TypeToken<List<MedicalPath>>(){}.getType());
//	    
//    System.out.println(list);
    
    
	    
	    ArrayList<MedicalPath> pls = g.fromJson(data, listType);
	    System.out.println(pls);
	}
	
	

}

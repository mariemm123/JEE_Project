
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import WebService.clientamine;
import entity.MedicalPath;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		clientamine c = new clientamine(2);
		try {
			JSONArray json = c.readJsonFromUrl("http://localhost:54774/api/mdp");
			ArrayList<MedicalPath> mps = new  ArrayList<>();
				for (int i = 0, count = json.length(); i < count; i++) {        
					MedicalPath mp = new  MedicalPath();  
					JSONObject obj = (JSONObject)json.get(i);
					mp.setDescription(obj.get("Description").toString());
					String string =obj.get("DateParcour").toString();
					Date date=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(string);
					mp.setDateParcour(date);
					//System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010
					// patient.setCours1(obj.get("course").toString());
					mps.add(mp);
				}
			
				for (MedicalPath medicalPath : mps) {
					System.out.println(medicalPath.getDescription());
					System.out.println(medicalPath.getDateParcour());

					
				}
				System.out.println(mps);
		
   } catch (IOException e) {
         
   e.printStackTrace();
        } catch (JSONException e) {
    
        e.printStackTrace();
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}



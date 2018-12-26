
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import WebService.clientamine;
import entity.AspNetUser;


public class test2 {

	public static void main(String[] args) throws JSONException {

		// TODO Auto-generated method stub
clientamine c = new clientamine(2);

try {
   
         JSONArray json = c.readJsonFromUrl("http://localhost:54774/api/patient");
   
         ArrayList<AspNetUser> listePatient = new  ArrayList<>();
       
     for (int i = 0, count = json.length(); i < count; i++) {
            
	AspNetUser patient = new  AspNetUser();
            
            
  
        JSONObject obj = (JSONObject)json.get(i);
          
        patient.setFirstName(obj.get("firstName").toString());
        
        patient.setLastName(obj.getString("lastName"));
        patient.setEmail(obj.getString("Email"));
      
        // patient.setCours1(obj.get("course").toString());
        
        listePatient.add(patient);

         }
       
     System.out.println(listePatient);
     
   } catch (IOException e) {
         
   e.printStackTrace();

        }
	}

}



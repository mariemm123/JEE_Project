package patientServices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.codehaus.jackson.annotate.JsonTypeInfo.As;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


import entity.Address;
import entity.Appointment;
import entity.AspNetUser;
import entity.Disponibility;

public class WebServiceClient {


	public static String readAll(Reader rd) throws IOException {
	        StringBuilder sb = new StringBuilder();
	        int cp;
	        while ((cp = rd.read()) != -1) {
	            sb.append((char) cp);
	        }
	        return sb.toString();
	    }

	public static JSONArray readJsonFromUrl(String url) throws IOException {
	        // String s = URLEncoder.encode(url, "UTF-8");
	        // URL url = new URL(s);
	        InputStream is = new URL(url).openStream();
	        JSONArray json = null;
	        try {
	            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	            String jsonText = readAll(rd);
	            json = new JSONArray(jsonText);	
	        } catch (JSONException e) {
	            e.printStackTrace();
	        } finally {
	            is.close();
	        }
	        return json;
	    }
	public List<Appointment> getAllAppointments() throws ParseException
	{ArrayList<Appointment> listeAppointment= new  ArrayList<>();
		try {
        JSONArray json = readJsonFromUrl("http://localhost:54774/api/APIAppointment");
        
        for (int i = 0, count = json.length(); i < count; i++) {
        	AspNetUser patient = new  AspNetUser();
        	AspNetUser doctor = new  AspNetUser();
        	Appointment apt=new Appointment();
        	Address adrpatient =new Address();
        	Address adrdoctor=new Address();
        	
        
        	
        JSONObject obj = (JSONObject)json.get(i);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = (Date) sdf.parse((obj.get("appointementDate").toString()));
        String formattedTime = output.format(d);
        List <AspNetUser>doctorsaddresses= new ArrayList<>(); 
        List <AspNetUser>patientsaddresses= new ArrayList<>(); 
        
        //appointment
        apt.setAppointmentId((obj.getInt(("AppointmentId").toString())));
        apt.setAppointementDate(d);
        apt.setReason(("reason").toString());
        apt.setReason(("state").toString());
      //patient
        JSONObject  pat= obj.getJSONObject("patient");
        patient.setFirstName(pat.getString("firstName"));
        patient.setLastName(pat.getString("lastName"));
        patient.setEmail(pat.getString("Email"));
        patient.setId(pat.getString("Id"));
        //patient  adresse
        JSONObject  patadr= pat.getJSONObject("address");
        adrpatient.setAddressId((patadr.getInt(("AddressId").toString())));
        adrpatient.setCountry(patadr.getString("country"));
        adrpatient.setCity((patadr.getString("city")));
        adrpatient.setStreet((patadr.getString("Street")));
        patient.setAddress(adrpatient);
        
        //doctor
        JSONObject  doc= obj.getJSONObject("patient");
        doctor.setFirstName(doc.getString("firstName"));
        doctor.setLastName(doc.getString("lastName"));
        doctor.setEmail(doc.getString("Email"));
        doctor.setId(doc.getString("Id"));
        //doctor address
        JSONObject  docadr= doc.getJSONObject("address");
        adrdoctor.setAddressId((docadr.getInt(("AddressId").toString())));
        adrdoctor.setCountry(docadr.getString("country"));
        adrdoctor.setCity((docadr.getString("city")));
        adrdoctor.setStreet((docadr.getString("Street")));
        doctor.setAddress(adrdoctor);;
       
       //add patient to appointment
     apt.setAspNetUser2(patient);
     //add doctor to appointment
     apt.setAspNetUser3(doctor);
       // patient.setCours1(obj.get("course").toString());
        listeAppointment.add(apt);
     }
        System.out.println(listeAppointment);
        return listeAppointment;
    } catch (IOException e) {
        e.printStackTrace();
    } catch (JSONException e) {
        e.printStackTrace();
    }
    return listeAppointment;
}
	
	
	
	public List<AspNetUser> getAllUsers() throws ParseException
	{try {
        JSONArray json = readJsonFromUrl("http://localhost:54774/api/API");
        ArrayList<AspNetUser> listePatients= new  ArrayList<>();
        ArrayList<AspNetUser> listeDoctors= new  ArrayList<>();
        for (int i = 0, count = json.length(); i < count; i++) {
        	AspNetUser patient = new  AspNetUser();
        	AspNetUser doctor = new  AspNetUser();
        	Appointment apt=new Appointment();
        	Address adrpatient =new Address();
        	Address adrdoctor=new Address();
        	Boolean isDoctor= true;
        
        	
        JSONObject obj = (JSONObject)json.get(i);
     
        

        patient.setFirstName(obj.getString("firstName"));
        patient.setLastName(obj.getString("lastName"));
        patient.setEmail(obj.getString("Email"));
        patient.setId(obj.getString("Id"));
        //patient  adresse
        JSONObject  patadr= obj.getJSONObject("address");
        adrpatient.setAddressId((patadr.getInt(("AddressId").toString())));
        adrpatient.setCountry(patadr.getString("country"));
        adrpatient.setCity((patadr.getString("city")));
        adrpatient.setStreet((patadr.getString("Street")));
        patient.setAddress(adrpatient);
        if(obj.has("Speciality")){
        	patient.setDiscriminator("Doctor");
        	listePatients.add(patient);
        }else patient.setDiscriminator("Patient");
        listeDoctors.add(patient);
      
       

     }
        System.out.println(listeDoctors);
 System.err.println(listePatients);
 listeDoctors.addAll(listePatients);
 return listeDoctors;
    } catch (IOException e) {
        e.printStackTrace();
    } catch (JSONException e) {
        e.printStackTrace();
    }
	//provisoir
	return null;
}
	
	public static List<Disponibility> getAllDisponibilities() throws ParseException
	{    ArrayList<Disponibility> listeDiponibilities= new  ArrayList<>();
		try {
        JSONArray json = readJsonFromUrl("http://localhost:54774/api/APIDisponibility");
    
        ArrayList<AspNetUser> listeDoctors= new  ArrayList<>();
        for (int i = 0, count = json.length(); i < count; i++) {
        	Disponibility disp = new  Disponibility();
    	
        JSONObject obj = (JSONObject)json.get(i);
     
        //patient  adresse
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = (Date) sdf.parse((obj.get("startTimeOfDisponibility").toString()));
        Date d1 = (Date) sdf.parse((obj.get("endTimeOfDisponibility").toString()));
        String formattedTime = output.format(d);
        disp.setDisponibilityId((obj.getInt(("DisponibilityId"))));
        disp.setStartTimeOfDisponibility(d);
        disp.setEndTimeOfDisponibility(d1);
        disp.setState((obj.getBoolean(("State"))));
        JSONObject  doctorid= obj.getJSONObject("doctor");
        AspNetUser auxuser=new AspNetUser();
        auxuser.setId(doctorid.getString(("Id")));
        disp.setAspNetUser(auxuser);
        listeDiponibilities.add(disp);
      
      
       

     }
        System.out.println(listeDiponibilities);
 return listeDiponibilities;
    } catch (IOException e) {
        e.printStackTrace();
    } catch (JSONException e) {
        e.printStackTrace();
    }
	//provisoir
	return null;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	System.out.println(getAllDisponibilities());
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
	

}
	
	
	


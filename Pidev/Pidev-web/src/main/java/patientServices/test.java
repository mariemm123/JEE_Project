package patientServices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import entity.AspNetUser;
import entity.Disponibility;

public class test {
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
        disp.setStartTimeOfDisponibility( d);
        disp.setEndTimeOfDisponibility( d1);
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

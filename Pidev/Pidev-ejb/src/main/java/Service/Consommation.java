package Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;


@Stateless
@LocalBean
public class Consommation implements ConsommationRemote, ConsommationLocal {

    /**
     * Default constructor. 
     */
    public Consommation() {
        // TODO Auto-generated constructor stub
    }
    public void ConsommationMedPath()
    {
    	
    	
       Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://localhost:54774/api/mdp"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	System.out.println(result);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	//Client client=ClientBuilder.newClient();
    	//WebTarget target=client.target("http://localhost:54774/api/mdp");
    	//WebTarget hello=target.path("amin");
    	//Response response=hello.request().get();
    	//String  result=response.readEntity(String.class);
    	//System.out.println(result);
    	//response.close();
   
    }
    

}

package Test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class testDoctolib {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String spec = "vertige" ;
String url ="https://www.doctolib.fr/"+spec;
Document doc=Jsoup.connect(url).userAgent("Opera").get();
Elements elements=doc.getElementsByClass("dl-search-result-presentation");
System.out.println("jjjj");
for (Element e : elements)
{
	String name = e.select(".dl-search-result-name").text();
	String speciality = e.select(".dl-search-result-subtitle").text();
	String adresse = e.select("div.dl-search-result-content > div.dl-text.dl-text-body").text() ;

	System.out.println("naùe : " + name + " and speciality : "+speciality +" and Adress : "+adresse);
	
	
}
	}

}

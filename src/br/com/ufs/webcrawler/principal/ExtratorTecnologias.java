package br.com.ufs.webcrawler.principal;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Classe responsável por identificar quais são as tecnologias utilizadas pelos sites
 * @author Anne
 *
 */
public class ExtratorTecnologias {

	Document doc;
	
	public void extrairTecnologias(String url) {

		try {
			// http://builtwith.com site utilizado para verificar quais são as tecnologias utilizadas pelos websites
			doc = Jsoup.connect("http://builtwith.com/?" + url).get();
			// Capturando os elementos
			Elements resultLinks = doc.select("h3 > a"); // direct a after h3

			for (Element element : resultLinks) {
				
				//Frameworks
				if (element.outerHtml().matches(".*(?i)framework.*")) {
					String tec1 = element.text();
					System.out.println(tec1);
				}
				
				//Web Server
				if (element.outerHtml().matches(".*(?i)Web-Server.*")) {
					String tec1 = element.text();
					System.out.println(tec1);
				}
				
				// Bibliotecas Javascript
				if (element.outerHtml().matches(".*(?i)javascript.*")) {
					String tec1 = element.text();
					System.out.println(tec1);
				}
				
				//Content Management Systems
				if (element.outerHtml().matches(".*(?i)cms.*")) {
					String tec1 = element.text();
					System.out.println(tec1);
				}
				
				//Documentation Information
				if (element.outerHtml().matches(".*(?i)docinfo/html.*")) {
					String tec1 = element.text();
					System.out.println(tec1);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

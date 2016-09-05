package br.com.ufs.webcrawler.principal;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.ufs.webcrawler.dao.TecnologiaDAO;
import br.com.ufs.webcrawler.interfaces.ExtratorInterface;

/**
 * Classe responsável por identificar quais são as tecnologias utilizadas pelos sites
 * @author Anne
 *
 */
public class ExtratorTecnologias implements ExtratorInterface {

	TecnologiaDAO tecnologia = new TecnologiaDAO();
	Document doc;
	
	public void extrairTecnologias(String url) {

		try {
			// http://builtwith.com site utilizado para verificar quais são as tecnologias utilizadas pelos websites
			doc = Jsoup.connect("http://builtwith.com/?" + url).get();
			// Capturando os elementos
			Elements resultLinks = doc.select("h3 > a"); // direct a after h3

			for (Element element : resultLinks) {
				
				//Frameworks
				if (element.outerHtml().matches(".*(?i)framework.*") && !element.text().equals("")) {
					String tec1 = element.text();
					System.out.println(tec1);
					tecnologia.criartecnologia(tec1);
				}
				
				//Web Server
				if (element.outerHtml().matches(".*(?i)Web-Server.*") && !element.text().equals("")) {
					
					String tec1 = element.text();
					System.out.println(tec1);
					tecnologia.criartecnologia(tec1);

				}
				
				// Bibliotecas Javascript
				if (element.outerHtml().matches(".*(?i)javascript.*") && !element.text().equals("")) {
					String tec1 = element.text();
					System.out.println(tec1);
					tecnologia.criartecnologia(tec1);
				}
				
				//Content Management Systems
				if (element.outerHtml().matches(".*(?i)cms.*") && !element.text().equals("")) {
					String tec1 = element.text();
					System.out.println(tec1);
					tecnologia.criartecnologia(tec1);
				}
				
				//Documentation Information
				if (element.outerHtml().matches(".*(?i)docinfo/html.*") && !element.text().equals("")) {
					String tec1 = element.text();
					System.out.println(tec1);
					tecnologia.criartecnologia(tec1);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void extrairInformacoesHospital(String url) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void extrairAcessibilidade(String url) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void extrairRedesSociais(String url) {
		// TODO Auto-generated method stub
		
	}

}

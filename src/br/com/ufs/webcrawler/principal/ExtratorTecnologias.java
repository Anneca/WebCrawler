package br.com.ufs.webcrawler.principal;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ExtratorTecnologias {

	Document doc;

	public void extrairTecnologias(String url) {

		try {
			doc = Jsoup.connect("http://builtwith.com/?" + url).get();
			Elements resultLinks = doc.select("h3 > a"); // direct a after h3

			for (Element element_a : resultLinks) {

				if (element_a.outerHtml().matches(".*(?i)framework.*")) {
					String tec1 = element_a.text();
					System.out.println(tec1);
				}

				if (element_a.outerHtml().matches(".*(?i)Web-Server.*")) {
					String tec1 = element_a.text();
					System.out.println(tec1);
				}
				
				if (element_a.outerHtml().matches(".*(?i)javascript.*")) {
					String tec1 = element_a.text();
					System.out.println(tec1);
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

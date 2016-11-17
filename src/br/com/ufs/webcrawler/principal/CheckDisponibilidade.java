package br.com.ufs.webcrawler.principal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.ufs.webcrawler.model.Formulario;

/**
 * 
 * @author Anne Caroline Melo Santos
 *
 */
public class CheckDisponibilidade {

	Document doc;
	boolean disponibilidade;

	public boolean verificarDisponibilidadeSite(String url) {

		disponibilidade = false;

		try {
			// https://foradoar.org/ site utilizado para verificar
			// disponibilidade do site
			doc = Jsoup.connect("http://downforeveryoneorjustme.com/" + url).timeout(10000)
					.userAgent(
							"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
					.get();
			// Capturando os elementos
			Elements resultLinks = doc.select("div");

			for (Element element : resultLinks) {
				
				if (element.text().matches(".*(?i)looks down from here.*") && !element.text().equals("")) {
					System.out.println("Site fora do AR");
				}

				if (element.text().matches(".*(?i)is up.*") && !element.text().equals("")) {
					System.out.println("Este site está no AR");
					disponibilidade = true;

				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return disponibilidade;

	}
}

package br.com.ufs.webcrawler.principal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.ufs.webcrawler.enumeration.Tags;
import br.com.ufs.webcrawler.interfaces.ExtratorInterface;

public class ExtratorRedesSociais implements ExtratorInterface {

	Document doc;
	boolean redesSociais;

	public void extrairRedesSociais(String url) {

		try {
			doc = Jsoup.connect(url)
					.userAgent(
							"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
					.get();
			redesSociais = false;

			for (Tags tag : Tags.values()) {

				Elements newsHeadlines = doc.select(tag.nome);

				for (Element element : newsHeadlines) {

					if (element.outerHtml().matches(".*(?i)facebook.*")) {

					}
					if (element.outerHtml().matches(".*(?i)twitter.*")) {

					}
					if (element.outerHtml().matches(".*(?i)youtube.*")) {

					}

					if (element.outerHtml().matches(".*(?i)linkedin.*")) {

					}
					if (element.outerHtml().matches(".*(?i)pinterest.*")) {

					}
					if (element.outerHtml().matches(".*(?i)foursquare.*")) {

					}
					if (element.outerHtml().matches(".*(?i)instagram.*")) {

					}

					if (element.outerHtml().matches(".*(?i)blogger.*")) {

					}
					if (element.outerHtml().matches(".*(?i)snapchat.*")) {

					}
					if (element.outerHtml().matches(".*(?i)google+.*")) {

					}
					if (element.outerHtml().matches(".*(?i)flickr.*")) {

					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void extrairTecnologias(String url) {
		// TODO Auto-generated method stub

	}

	@Override
	public void extrairInformacoesHospital(String url) {
		// TODO Auto-generated method stub

	}

	@Override
	public void extrairAcessibilidade(String url) {
		// TODO Auto-generated method stub

	}

}

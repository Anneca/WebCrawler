package br.com.ufs.webcrawler.principal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.ufs.webcrawler.dao.FormularioRedeSocialDAO;
import br.com.ufs.webcrawler.dao.RedeSocialDAO;
import br.com.ufs.webcrawler.dao.TecnologiaDAO;
import br.com.ufs.webcrawler.enumeration.Tags;
import br.com.ufs.webcrawler.interfaces.ExtratorInterface;
import br.com.ufs.webcrawler.model.Formulario;
import br.com.ufs.webcrawler.model.RedeSocial;
/**
 * 
 * @author Anne Caroline Melo Santos
 *
 */
public class ExtratorRedesSociais implements ExtratorInterface {

	Document doc;
	boolean redesSociais;
	RedeSocial redeSocial;
	RedeSocialDAO redeSocialDAO = new RedeSocialDAO();
	FormularioRedeSocialDAO formularioRedeSocialDAO = new FormularioRedeSocialDAO();

	public void extrairRedesSociais(String url, Formulario form) {

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
						String nomeRedeSocial = "Facebook";
						System.out.println(nomeRedeSocial);
						redeSocial = redeSocialDAO.consultarRedeSocialByNome(nomeRedeSocial);
						formularioRedeSocialDAO.criarFormularioRedeSocial(redeSocial.getCodigo(), form.getCodigo());

					}
					if (element.outerHtml().matches(".*(?i)twitter.*")) {
						String nomeRedeSocial = "Twitter";
						System.out.println(nomeRedeSocial);
						redeSocial = redeSocialDAO.consultarRedeSocialByNome(nomeRedeSocial);
						formularioRedeSocialDAO.criarFormularioRedeSocial(redeSocial.getCodigo(), form.getCodigo());

					}
					if (element.outerHtml().matches(".*(?i)youtube.*")) {
						String nomeRedeSocial = "Youtube";
						System.out.println(nomeRedeSocial);
						redeSocial = redeSocialDAO.consultarRedeSocialByNome(nomeRedeSocial);
						formularioRedeSocialDAO.criarFormularioRedeSocial(redeSocial.getCodigo(), form.getCodigo());

					}

					if (element.outerHtml().matches(".*(?i)linkedin.*")) {
						String nomeRedeSocial = "Linkedin";
						System.out.println(nomeRedeSocial);
						redeSocial = redeSocialDAO.consultarRedeSocialByNome(nomeRedeSocial);
						formularioRedeSocialDAO.criarFormularioRedeSocial(redeSocial.getCodigo(), form.getCodigo());


					}
					if (element.outerHtml().matches(".*(?i)pinterest.*")) {
						String nomeRedeSocial = "Pinterest";
						System.out.println(nomeRedeSocial);
						redeSocial = redeSocialDAO.consultarRedeSocialByNome(nomeRedeSocial);
						formularioRedeSocialDAO.criarFormularioRedeSocial(redeSocial.getCodigo(), form.getCodigo());

					}
					if (element.outerHtml().matches(".*(?i)foursquare.*")) {
						String nomeRedeSocial = "Foursquare";
						System.out.println(nomeRedeSocial);
						redeSocial = redeSocialDAO.consultarRedeSocialByNome(nomeRedeSocial);
						formularioRedeSocialDAO.criarFormularioRedeSocial(redeSocial.getCodigo(), form.getCodigo());

					}
					if (element.outerHtml().matches(".*(?i)instagram.*")) {
						String nomeRedeSocial = "Instagram";
						System.out.println(nomeRedeSocial);
						redeSocial = redeSocialDAO.consultarRedeSocialByNome(nomeRedeSocial);
						formularioRedeSocialDAO.criarFormularioRedeSocial(redeSocial.getCodigo(), form.getCodigo());

					}

					if (element.outerHtml().matches(".*(?i)blogger.*")) {
						String nomeRedeSocial = "Blogger";
						System.out.println(nomeRedeSocial);
						redeSocial = redeSocialDAO.consultarRedeSocialByNome(nomeRedeSocial);
						formularioRedeSocialDAO.criarFormularioRedeSocial(redeSocial.getCodigo(), form.getCodigo());

					}
					if (element.outerHtml().matches(".*(?i)snapchat.*")) {
						String nomeRedeSocial = "Snapchat";
						System.out.println(nomeRedeSocial);
						redeSocial = redeSocialDAO.consultarRedeSocialByNome(nomeRedeSocial);
						formularioRedeSocialDAO.criarFormularioRedeSocial(redeSocial.getCodigo(), form.getCodigo());

					}
					if (element.outerHtml().matches(".*(?i)google+.*")) {
						String nomeRedeSocial = "Google+";
						System.out.println(nomeRedeSocial);
						redeSocial = redeSocialDAO.consultarRedeSocialByNome(nomeRedeSocial);
						formularioRedeSocialDAO.criarFormularioRedeSocial(redeSocial.getCodigo(), form.getCodigo());

					}
					if (element.outerHtml().matches(".*(?i)flickr.*")) {
						String nomeRedeSocial = "Flickr";
						System.out.println(nomeRedeSocial);
						redeSocial = redeSocialDAO.consultarRedeSocialByNome(nomeRedeSocial);
						formularioRedeSocialDAO.criarFormularioRedeSocial(redeSocial.getCodigo(), form.getCodigo());


					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void extrairTecnologias(String url) {
		// TODO Auto-generated method stub

	}

	@Override
	public Formulario extrairInformacoesHospital(String url) {
		// TODO Auto-generated method stub
		return null;
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

package br.com.ufs.webcrawler.principal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.ufs.webcrawler.dao.FormularioDAO;
import br.com.ufs.webcrawler.dao.FormularioHospitalDAO;
import br.com.ufs.webcrawler.dao.FormularioTecnologiaDAO;
import br.com.ufs.webcrawler.dao.TecnologiaDAO;
import br.com.ufs.webcrawler.interfaces.ExtratorInterface;
import br.com.ufs.webcrawler.model.Formulario;
import br.com.ufs.webcrawler.model.Tecnologia;

/**
 * 
 * @author Anne Caroline Melo Santos
 *
 */
public class ExtratorTecnologias implements ExtratorInterface {

	TecnologiaDAO tecnologiaDAO = new TecnologiaDAO();
	FormularioDAO FormularioDAO = new FormularioDAO();
	FormularioTecnologiaDAO formularioTecnologia = new FormularioTecnologiaDAO();
	Document doc;
	Tecnologia tecnologia = new Tecnologia();
	Formulario formulario = new Formulario();
	
	public void extrairTecnologias(String url, Formulario form) {

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
					tecnologiaDAO.criartecnologia(tec1);
					tecnologia = tecnologiaDAO.consultarTecnologiaByNome(tec1);
					formularioTecnologia.criarFormularioTecnologia(tecnologia.getCodigo(), form.getCodigo());

				}
				
				//Web Server
				if (element.outerHtml().matches(".*(?i)Web-Server.*") && !element.text().equals("")) {
					
					String tec1 = element.text();
					System.out.println(tec1);
					tecnologiaDAO.criartecnologia(tec1);
					tecnologia = tecnologiaDAO.consultarTecnologiaByNome(tec1);
					formularioTecnologia.criarFormularioTecnologia(tecnologia.getCodigo(), form.getCodigo());

				}
				
				// Bibliotecas Javascript
				if (element.outerHtml().matches(".*(?i)javascript.*") && !element.text().equals("")) {
					String tec1 = element.text();
					System.out.println(tec1);
					tecnologiaDAO.criartecnologia(tec1);
					tecnologia = tecnologiaDAO.consultarTecnologiaByNome(tec1);
					formularioTecnologia.criarFormularioTecnologia(tecnologia.getCodigo(), form.getCodigo());

				}
				
				//Content Management Systems
				if (element.outerHtml().matches(".*(?i)cms.*") && !element.text().equals("")) {
					String tec1 = element.text();
					System.out.println(tec1);
					tecnologiaDAO.criartecnologia(tec1);
					tecnologia = tecnologiaDAO.consultarTecnologiaByNome(tec1);
					formularioTecnologia.criarFormularioTecnologia(tecnologia.getCodigo(), form.getCodigo());

				}
				
				//Documentation Information
				if (element.outerHtml().matches(".*(?i)docinfo/html.*") && !element.text().equals("")) {
					String tec1 = element.text();
					System.out.println(tec1);
					tecnologiaDAO.criartecnologia(tec1);
					tecnologia = tecnologiaDAO.consultarTecnologiaByNome(tec1);
					formularioTecnologia.criarFormularioTecnologia(tecnologia.getCodigo(), form.getCodigo());

				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

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

	@Override
	public void extrairTecnologias(String url) {
		// TODO Auto-generated method stub
		
	}

}

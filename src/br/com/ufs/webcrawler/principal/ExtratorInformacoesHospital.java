package br.com.ufs.webcrawler.principal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.ufs.webcrawler.dao.FormularioDAO;
import br.com.ufs.webcrawler.dao.FormularioHospitalDAO;
import br.com.ufs.webcrawler.dao.HospitalDAO;
import br.com.ufs.webcrawler.enumeration.Tags;
import br.com.ufs.webcrawler.interfaces.ExtratorInterface;
import br.com.ufs.webcrawler.model.Formulario;
import br.com.ufs.webcrawler.model.Hospital;

/**
 * 
 * @author Anne Caroline Melo Santos
 *
 */
public class ExtratorInformacoesHospital implements ExtratorInterface {

	Document doc;
	boolean servicos;
	boolean informacoesInstitucionais;
	boolean redesSociais;
	boolean comentarios;
	boolean corpoClinico;
	String temServicos;
	String temInfoInstitucional;
	String temComentario;
	String temCorpoClinico;
	FormularioDAO formularioDAO = new FormularioDAO();
	HospitalDAO hospitalDAO = new HospitalDAO();
	FormularioHospitalDAO formularioHospitalDAO = new FormularioHospitalDAO();

	public Formulario extrairInformacoesHospital(String url) {

		try {

			doc = Jsoup.connect(url)
					.userAgent(
							"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
					.get();
			servicos = false;
			informacoesInstitucionais = false;
			redesSociais = false;
			comentarios = false;
			corpoClinico = false;
			temServicos = "Não";
			temInfoInstitucional = "Não";
			temComentario = "Não";
			temCorpoClinico = "Não";

			for (Tags tag : Tags.values()) {

				Elements newsHeadlines = doc.select(tag.nome);

				for (Element element : newsHeadlines) {

					if (element.outerHtml().matches(".*(?i)servico.*")
							|| element.outerHtml().matches(".*(?i)procedimento.*")
							|| element.outerHtml().matches(".*(?i)exame.*")
							|| element.outerHtml().matches(".*(?i)especialidade.*")
							|| element.outerHtml().matches(".*(?i)cirurgia.*")
							|| element.outerHtml().matches(".*(?i)tratamento.*")
							|| element.outerHtml().matches(".*(?i)service.*")
							|| element.outerHtml().matches(".*(?i)exam.*")
							|| element.outerHtml().matches(".*(?i)treatment.*")
							|| element.outerHtml().matches(".*(?i)handling.*")
							|| element.outerHtml().matches(".*(?i)specialt.*")
							|| element.outerHtml().matches(".*(?i)patient.*")) {

						servicos = true;
						temServicos = "Sim";
					}

					if (element.outerHtml().matches(".*(?i)sobre.*")
							|| element.outerHtml().matches(".*(?i)institucional.*")
							|| element.outerHtml().matches(".*(?i)valor.*")
							|| element.outerHtml().matches(".*(?i)missao.*")
							|| element.outerHtml().matches(".*(?i)visao.*")
							|| element.outerHtml().matches(".*(?i)missão.*")
							|| element.outerHtml().matches(".*(?i)visão.*")
							|| element.outerHtml().matches(".*(?i)institucionais.*")
							|| element.outerHtml().matches(".*(?i)informaç.*")
							|| element.outerHtml().matches(".*(?i)informac.*")
							|| element.outerHtml().matches(".*(?i)Quem Somos.*")
							|| element.outerHtml().matches(".*(?i)hospital.*")
							|| element.outerHtml().matches(".*(?i)about.*")
							|| element.outerHtml().matches(".*(?i)hospital.*")
							|| element.outerHtml().matches(".*(?i)overview.*")) {

						informacoesInstitucionais = true;
						temInfoInstitucional = "Sim";
					}

					if (element.outerHtml().matches(".*(?i)facebook.*")
							|| element.outerHtml().matches(".*(?i)twitter.*")
							|| element.outerHtml().matches(".*(?i)youtube.*")
							|| element.outerHtml().matches(".*(?i)redes-sociais.*")
							|| element.outerHtml().matches(".*(?i)Redes Sociais.*")
							|| element.outerHtml().matches(".*(?i)linkedin.*")
							|| element.outerHtml().matches(".*(?i)instagram.*")
							|| element.outerHtml().matches(".*(?i)blogger.*")
							|| element.outerHtml().matches(".*(?i)snapchat.*")) {

						redesSociais = true;

					}

					if (element.outerHtml().matches(".*(?i)fale-conosco.*")
							|| element.outerHtml().matches(".*(?i)Fale Conosco.*")
							|| element.outerHtml().matches(".*(?i)email.*")
							|| element.outerHtml().matches(".*(?i)e-mail.*")
							|| element.outerHtml().matches(".*(?i)contato.*")
							|| element.outerHtml().matches(".*(?i)contact.*")) {

						comentarios = true;
						temComentario = "Sim";
					}

					if (element.outerHtml().matches(".*(?i)corpo-clinico.*")
							|| element.outerHtml().matches(".*(?i)Corpo Clínico.*")
							|| element.outerHtml().matches(".*(?i)Equipe Médica.*")
							|| element.outerHtml().matches(".*(?i)equipe-medica.*")
							|| element.outerHtml().matches(".*(?i)funcionario.*")
							|| element.outerHtml().matches(".*(?i)doctor.*")
							|| element.outerHtml().matches(".*(?i)professional.*")
							|| element.outerHtml().matches(".*(?i)staff.*")
							|| element.outerHtml().matches(".*(?i)surgeon.*")
							|| element.outerHtml().matches(".*(?i)physicians.*")) {

						corpoClinico = true;
						temCorpoClinico = "Sim";
					}
				}

			}

			System.out.println();
			System.out.println("Hospital na posição " + url.replaceAll("http://", ""));

			// Verificando se o site disponibiliza informações referentes
			// aos serviços
			if (servicos) {
				System.out.println("Informações sobre serviços: SIM");
			}

			// Verificando se o site disponibiliza informações
			// institucionais
			if (informacoesInstitucionais) {
				System.out.println("Informações Institucionais: SIM");
			}

			// Verificando se o site disponibiliza informações referentes
			// as redes sociais
			if (redesSociais) {
				System.out.println("Redes Sociais: SIM");
			}

			// Verificando se o site disponibiliza endereço eletrônico para
			// feedback
			if (comentarios) {
				System.out.println("Endereço eletrônico para realização de comentários, sugestões e reclamações: SIM ");
			}

			// Verificando se o site disponibiliza informações sobre o corpo
			// clínico
			if (corpoClinico) {
				System.out.println("Corpo Clínico: SIM ");
			}

			// Criando um formulário
			Formulario form = formularioDAO.criarFormulario(temServicos, temInfoInstitucional, temComentario,
					temCorpoClinico, "Sem Observações!");
			Hospital hospital = hospitalDAO.getHospitalByURLs(url);
			formularioHospitalDAO.criarFormularioHospital(hospital.getCodigo(), form.getCodigo());
			return form;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void extrairTecnologias(String url) {
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

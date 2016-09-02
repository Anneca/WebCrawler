package br.com.ufs.webcrawler.principal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.ufs.webcrawler.enumeration.Tags;
import br.com.ufs.webcrawler.interfaces.ExtratorInterface;

public class ExtratorInformacoesHospital implements ExtratorInterface {

	Document doc;
	boolean servicos;
	boolean informacoesInstitucionais;
	boolean redesSociais;
	boolean comentarios;
	boolean corpoClinico;

	public void extrairInformacoesHospital(String url) {

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

			for (Tags tag : Tags.values()) {

				Elements newsHeadlines = doc.select(tag.nome);

				for (Element element : newsHeadlines) {

					if (element.outerHtml().matches(".*(?i)servico.*")
							|| element.outerHtml().matches(".*(?i)procedimento.*")
							|| element.outerHtml().matches(".*(?i)exame.*")
							|| element.outerHtml().matches(".*(?i)especialidade.*")
							|| element.outerHtml().matches(".*(?i)cirurgia.*")) {

						servicos = true;
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
							|| element.outerHtml().matches(".*(?i)Quem Somos.*")) {

						informacoesInstitucionais = true;
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
							|| element.outerHtml().matches(".*(?i)contato.*")) {

						comentarios = true;
					}

					if (element.outerHtml().matches(".*(?i)corpo-clinico.*")
							|| element.outerHtml().matches(".*(?i)Corpo Clínico.*")
							|| element.outerHtml().matches(".*(?i)Equipe Médica.*")
							|| element.outerHtml().matches(".*(?i)equipe-medica.*")
							|| element.outerHtml().matches(".*(?i)funcionario.*")) {

						corpoClinico = true;
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

			// Verificando se o site disponibiliza informações sobre o corpo clínico
			if (corpoClinico) {
				System.out.println("Corpo Clínico: SIM ");
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
	public void extrairAcessibilidade(String url) {
		// TODO Auto-generated method stub
		
	}
}
